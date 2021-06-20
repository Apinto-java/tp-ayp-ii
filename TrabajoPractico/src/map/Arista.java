package map;

public class Arista {

	private Vertice townA;
	private Vertice townB;
	private int days;

	public Arista(Vertice a, Vertice b, int days) {
		this.townA = a;
		this.townB = b;
		this.days = days;
	}

	public Vertice getTownA() {
		return this.townA;
	}

	public Vertice getTownB() {
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