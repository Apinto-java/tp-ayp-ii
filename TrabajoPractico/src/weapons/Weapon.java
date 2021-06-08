package weapons;

public abstract class Weapon {

	private int damage;
	
	public Weapon(int damage) {
		
		this.damage = damage;
	}
	
	public int use() {
		
		return damage;
	}
}
