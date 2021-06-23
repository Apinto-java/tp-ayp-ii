package map;

public class Edge {

	private Vertex townA;
	private Vertex townB;
	private int days;

	public Edge(Vertex a, Vertex b, int days) {
		this.townA = a;
		this.townB = b;
		this.days = days;
	}

	public Vertex getTownA() {
		return this.townA;
	}

	public Vertex getTownB() {
		return this.townB;
	}

	public int getDays() {
		return this.days;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((townB == null) ? 0 : townB.hashCode());
		return result;
	}
}