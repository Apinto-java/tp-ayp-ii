package mapa;

public class Distance implements Comparable<Distance>{

	private String name;
	private Double distance;
	
	public Distance(String name, Double distance) {
		
		this.name = name;
		this.distance = distance;
	}

	public String getTown() {
		
		return this.name;
	}
	
	public Double getValue() {
		
		return this.distance;
	}
	
	@Override
	public int compareTo(Distance o) {
		return this.distance.compareTo(o.distance);
	}
}
