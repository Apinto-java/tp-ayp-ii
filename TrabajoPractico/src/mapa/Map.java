package mapa;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Map {

	private HashMap<String, Town> towns = new HashMap<String, Town>();

	public void addPath(String townA, String townB, int duration) {
		
		if (!towns.containsKey(townA)) {
			Town newTownA = new Town(townA);
			towns.put(townA, newTownA);
		}

		if (!towns.containsKey(townB)) {
			Town newTownB = new Town(townB);
			towns.put(townB, newTownB);
		}

		Path newPath = new Path(towns.get(townA), towns.get(townB), duration);

		towns.get(townA).addConnection(newPath);
		towns.get(townB).addConnection(newPath);
	}

	public static void main(String[] args) {

		Map map = new Map();
		
		map.addPath("A", "B", 10);
		map.addPath("C", "D", 15);
		map.addPath("A", "C", 12);
		map.addPath("A", "D", 3);
		map.addPath("A", "E", 3);
		map.addPath("E", "D", 1);
		map.addPath("B", "C", 19);
		map.addPath("B", "D", 9);
		map.addPath("A", "D", 3);
		map.addPath("B", "E", 2);
		
		System.out.println(map.toString());

		System.out.println("------------");

		System.out.println(map.dijkstra("C"));

		System.out.println("------------");

		System.out.println(map.obtenerCaminoMasCortoDesde("C", "E"));
	}

	@Override
	public String toString() {

		String out = towns.keySet().toString();
		out += "\n";

		for (HashMap.Entry<String, Town> town : towns.entrySet()) {
			out += town.getValue().toString();
		}

		return out;
	}

	public String obtenerCaminoMasCortoDesde(String townA, String townB) {

		HashMap<String, String> mapa = this.dijkstra(townA);

		ArrayList<String> out = obtenerCaminoMasCortoDesde(mapa, townA, townB);
		
		return out.toString();
	}

	private ArrayList<String> obtenerCaminoMasCortoDesde(HashMap<String, String> mapa, String townA, String townB) {

		ArrayList<String> arreglo = new ArrayList<>();

		if (townB != townA)	
			arreglo = this.obtenerCaminoMasCortoDesde(mapa, townA, mapa.get(townB));

		arreglo.add(townB);

		return arreglo;
	}

	private HashMap<String, String> dijkstra(String firstTown) {

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

				for (HashMap.Entry<String, Path> path : towns.get(aTown).getConnectionList().entrySet()) {

					String nextTown = path.getKey();
					Path nextPath = path.getValue();

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
}
