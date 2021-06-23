package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import warriors.MilitaryUnit;
import warriors.Troop;

public class Vertex {

	//	String	-> Name of the Town
	//	Path	-> Path to the Town
	private Map<String, Edge> connections = new HashMap<String, Edge>();
	private String name;
	private Troop troop;
	
	public Vertex(String name, Troop troop) {
		this.name = name;
		this.troop = troop;
	}
	
	public String getName() {
		return name;
	}
	
	// Adds a @param newPat to the connections list, using the other town's name as a reference
	public void addConnection(Edge newPath) {
		
		if(name.equals(newPath.getTownA().getName())) {
			connections.put(newPath.getTownB().getName(), newPath);
		} else {
			connections.put(newPath.getTownA().getName(), newPath);
		}
	}
	
	public Map<String, Edge> getConnectionList() {
		return Collections.unmodifiableMap(connections);
	}
	
	/*
	 * returns all the connections this vertex has
	 */
	public HashSet<Edge> getNearPathsList(){
		HashSet<Edge> out = new HashSet<>();
		
		for (String path : connections.keySet()) {
			out.add(connections.get(path));
		}
		
		return out;
	}
	
	public int getDaysToTown(String destination) {
		int duration = 0;
		
		// Returns the Edge associated with the destination Vertex
		if(connections.containsKey(destination)) {
			Edge travelToTown = connections.get(destination);
			duration = travelToTown.getDays();
		}
		
		return duration;
	}
	
	@Override
	public String toString() {
		String out = "";
		
		out += name + "\n";
		
		for (Map.Entry<String, Edge> path : connections.entrySet()) {
			out += "\t" + path.getKey() + " " + path.getValue().getDays() + " " + this.troop.getAlignment().toString() + "\n"
					+ "\t\t" + this.troop.getSize() + " " + this.troop.getFirstWarrior().getClass().getSimpleName() + "\n";
		}
		
		return out;
	}

	public boolean isAlly() {
		return troop.getAlignment().equals(Alignment.ALIADO);
	}
	
	public boolean isOwn() {
		return troop.getAlignment().equals(Alignment.PROPIO);
	}
	
	public boolean isEnemy() {
		return troop.getAlignment().equals(Alignment.ENEMIGO);
	}

	// returns half of the population, in order to be added to an ally army
	public Troop giveTroop() {
		
		int size = this.troop.getSize() / 2;
		
		for (int i = 0; i < size; i++) {

			this.troop.deleteFirstSoldier();
		}
			
		return this.troop;
	}

	public MilitaryUnit getArmy() {
		return troop;
	}
}
