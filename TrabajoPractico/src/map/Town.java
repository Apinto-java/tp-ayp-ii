package map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Town {

	//	String	-> Name of the Town
	//	Path	-> Path to the Town
	private Map<String, Path> connections = new HashMap<String, Path>();
	private String name;
	
	public Town(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addConnection(Path newPath) {
		
		if(name.equals(newPath.getTownA().getName())) {
			connections.put(newPath.getTownB().getName(), newPath);
		} else {
			connections.put(newPath.getTownA().getName(), newPath);
		}
	}
	
	public Map<String, Path> getConnectionList() {
		return Collections.unmodifiableMap(connections);
	}
	
	public HashSet<Path> getNearPathsList(){
		HashSet<Path> out = new HashSet<>();
		
		for (String path : connections.keySet()) {
			out.add(connections.get(path));
		}
		
		return out;
	}
	
	@Override
	public String toString() {
		String out = "";
		
		out += name + "\n";
		
		for (Map.Entry<String, Path> path : connections.entrySet()) {
			out += "\t" + path.getKey() + " " + path.getValue().getDays() + "\n";
		}
		
		return out;
	}
	
//	public Collection<Army> getArmyOfTown(){
//		return this.army;
//	}
}
