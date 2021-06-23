package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import warriors.MilitaryUnit;
import warriors.Troop;

public class Vertice {

	//	String	-> Name of the Town
	//	Path	-> Path to the Town
	private Map<String, Arista> connections = new HashMap<String, Arista>();
	private String name;
	private Troop troop;
	
	public Vertice(String name, Troop troop) {
		this.name = name;
		this.troop = troop;
	}
	
	public String getName() {
		return name;
	}
	
	public void addConnection(Arista newPath) {
		
		if(name.equals(newPath.getTownA().getName())) {
			connections.put(newPath.getTownB().getName(), newPath);
		} else {
			connections.put(newPath.getTownA().getName(), newPath);
		}
	}
	
	public Map<String, Arista> getConnectionList() {
		return Collections.unmodifiableMap(connections);
	}
	
	public HashSet<Arista> getNearPathsList(){
		HashSet<Arista> out = new HashSet<>();
		
		for (String path : connections.keySet()) {
			out.add(connections.get(path));
		}
		
		return out;
	}
	
	public int getDaysToTown(String destination) {
		int duration = 0;
		
		// Returns the Edge associated with the destination Vertex
		if(connections.containsKey(destination)) {
			Arista travelToTown = connections.get(destination);
			duration = travelToTown.getDays();
		}
		
		return duration;
	}
	
	@Override
	public String toString() {
		String out = "";
		
		out += name + "\n";
		
		for (Map.Entry<String, Arista> path : connections.entrySet()) {
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
