package map;

public class Path {

	private Town townA;
	private Town townB;
	private int days;

	public Path(Town a, Town b, int days) {
		this.townA = a;
		this.townB = b;
		this.days = days;
	}

	public Town getTownA() {
		return this.townA;
	}

	public Town getTownB() {
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