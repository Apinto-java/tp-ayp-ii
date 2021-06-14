package warriors;

import weapons.Shuriken;

public class Radaiteran extends Warrior {

	private int amountOfAttacks;
	
	public Radaiteran() {
		
		super(36, new Shuriken());
		
		this.amountOfAttacks = 0;
	}

	@Override
	public int attack(Warrior anotherWarrior) {
		
		int damage = super.getWeapon().use() + (3 * this.amountOfAttacks);
		
		anotherWarrior.receiveAttack(damage);
		
		this.amountOfAttacks++;
		
		return damage;
	}

	@Override
	public void receiveAttack(double damage) {
		
		super.reduceHealthPoints(damage);
	}

	// No ocurre nada en un Radaiteran.
	@Override
	public void rest() {}
}
