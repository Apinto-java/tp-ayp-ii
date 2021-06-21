package map;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Grafo {

	private HashMap<String, Vertice> towns;
	private static Grafo grafo = null;

	private Grafo() {

		this.towns = new HashMap<String, Vertice>();
	}

	public static Grafo getInstance() {

		if (grafo == null)
			grafo = new Grafo();

		return grafo;
	}

	public void addPath(Vertice townA, Vertice townB, int duration) {

		if (!towns.containsKey(townA.getName())) {
			String newTownA = townA.getName();
			towns.put(newTownA, townA);
		}

		if (!towns.containsKey(townB.getName())) {
			String newTownB = townB.getName();
			towns.put(newTownB, townB);
		}

		Arista newPath = new Arista(townA, townB, duration);

		townA.addConnection(newPath);
		townB.addConnection(newPath);
	}

//	public void addPath(String townA, String townB, int duration) {
//		
//		if (!towns.containsKey(townA)) {
//			Vertice newTownA = new Vertice(townA);
//			towns.put(townA, newTownA);
//		}
//
//		if (!towns.containsKey(townB)) {
//			Vertice newTownB = new Vertice(townB);
//			towns.put(townB, newTownB);
//		}
//
//		Arista newPath = new Arista(towns.get(townA), towns.get(townB), duration);
//
//		towns.get(townA).addConnection(newPath);
//		towns.get(townB).addConnection(newPath);
//	}

	@Override
	public String toString() {

		String out = towns.keySet().toString();
		out += "\n";

		for (HashMap.Entry<String, Vertice> town : towns.entrySet()) {
			out += town.getValue().toString();
		}

		return out;
	}

	public ArrayList<String> obtenerCaminoMasCortoDesde(String townA, String townB) {

		HashMap<String, String> mapa = this.dijkstra(townA);

		ArrayList<String> out = obtenerCaminoMasCortoDesde(mapa, townA, townB);

		return out;
	}

	private ArrayList<String> obtenerCaminoMasCortoDesde(HashMap<String, String> mapa, String townA, String townB) {

		ArrayList<String> arreglo = new ArrayList<>();

		if (townB != townA)
			arreglo = this.obtenerCaminoMasCortoDesde(mapa, townA, mapa.get(townB));

		arreglo.add(townB);

		return arreglo;
	}

	public HashMap<String, String> dijkstra(String firstTown) {

		PriorityQueue<Distance> priorityQ = new PriorityQueue<>();
		HashMap<String, String> precursors = new HashMap<>();
		HashMap<String, Double> distances = new HashMap<>();
		HashMap<String, Boolean> visited = new HashMap<>();

		for (String town : towns.keySet()) {
			distances.put(town, Double.MAX_VALUE);
			precursors.put(town, null);
			visited.put(town, false);
		}

		distances.put(firstTown, 0.0);

		priorityQ.add(new Distance(firstTown, 0.0));

		while (!priorityQ.isEmpty()) {

			Distance aDistance = priorityQ.poll();
			String aTown = aDistance.getTown();

			if (!visited.get(aTown)) {
				visited.put(aTown, true);

				for (HashMap.Entry<String, Arista> path : towns.get(aTown).getConnectionList().entrySet()) {

					String nextTown = path.getKey();
					Arista nextPath = path.getValue();

					if (!visited.get(nextTown)) {

						if (aDistance.getValue() + nextPath.getDays() < distances.put(nextTown,
								aDistance.getValue() + nextPath.getDays())) {

							distances.put(nextTown, aDistance.getValue() + nextPath.getDays());
							precursors.put(nextTown, aTown);
							priorityQ.add(new Distance(nextTown, distances.get(nextTown)));
						}
					}
				}
			}
		}

		return precursors;
	}

	public Vertice getTown(String townName) {
		return towns.get(townName);
	}
}
