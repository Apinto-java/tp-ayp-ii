package map;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Graph {

	private HashMap<String, Vertex> towns;
	private static Graph grafo = null;

	private Graph() {

		this.towns = new HashMap<String, Vertex>();
	}

	public static Graph getInstance() {

		if (grafo == null)
			grafo = new Graph();

		return grafo;
	}
	
	/**
	 * 
	 * @param town The Town to add to this map. If it already exists, nothing happens
	 * @post Adds 'town' to this Map
	 */
	public void addVertex(Vertex town) {
		
		if(!towns.containsKey(town.getName())) {
			String name = town.getName();
			towns.put(name, town);
		}
		
	}
	
	public void addPath(String townA, String townB, int duration) {

		if (!towns.containsKey(townA)) {
			Vertex newTownA = new Vertex(townA, null);
			towns.put(townA, newTownA);
		}

		if (!towns.containsKey(townB)) {
			Vertex newTownB = new Vertex(townB, null);
			towns.put(townB, newTownB);
		}

		Edge newPath = new Edge(towns.get(townA), towns.get(townB), duration);

		towns.get(townA).addConnection(newPath);
		towns.get(townB).addConnection(newPath);
	}

	@Override
	public String toString() {

		String out = towns.keySet().toString();
		out += "\n";

		for (HashMap.Entry<String, Vertex> town : towns.entrySet()) {
			out += town.getValue().toString();
		}

		return out;
	}

	public ArrayList<String> getShortestPathFrom(String townA, String townB) {

		HashMap<String, String> mapa = this.dijkstra(townA);

		ArrayList<String> out = getShortestPathFrom(mapa, townA, townB);

		return out;
	}

	private ArrayList<String> getShortestPathFrom(HashMap<String, String> mapa, String townA, String townB) {

		ArrayList<String> arreglo = new ArrayList<>();

		if (townB != townA)
			arreglo = this.getShortestPathFrom(mapa, townA, mapa.get(townB));

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

				for (HashMap.Entry<String, Edge> path : towns.get(aTown).getConnectionList().entrySet()) {

					String nextTown = path.getKey();
					Edge nextPath = path.getValue();

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

	public Vertex getTown(String townName) {
		return towns.get(townName);
	}
}
