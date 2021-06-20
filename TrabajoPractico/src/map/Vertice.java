package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import warriors.Army;
import warriors.MilitaryUnit;
import warriors.Troop;
import warriors.Warrior;

public class Vertice {

	//	String	-> Name of the Town
	//	Path	-> Path to the Town
	private Map<String, Arista> connections = new HashMap<String, Arista>();
	private String name;
	
	public Vertice(String name) {
		this.name = name;
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
	
	@Override
	public String toString() {
		String out = "";
		
		out += name + "\n";
		
		for (Map.Entry<String, Arista> path : connections.entrySet()) {
			out += "\t" + path.getKey() + " " + path.getValue().getDays() + "\n";
		}
		
		return out;
	}

	public boolean isAlly() {
		// TODO Auto-generated method stub
		return false;
	}

	public Troop giveTroop() {
		// es para llenar las lineas aliadas
		return null;
	}

	public MilitaryUnit getArmy() {
		// enemigos a atacar
		return null;
	}
}
