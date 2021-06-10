package warriors;

import weapons.Shuriken;

public class Radaiteran extends Warrior {

	private int amountOfAttacks = 0;
	
	public Radaiteran() {
		
		super(36, new Shuriken());
	}

	@Override
	public void attack(Warrior anotherWarrior) {
		
		double damage = super.getWeapon().use() + (3 * amountOfAttacks++);
		
		anotherWarrior.receiveAttack(damage);
	}

	@Override
	public void receiveAttack(double damage) {
		
		super.reduceHP(damage);
	}

	// No ocurre nada en un Radaiteran.
	@Override
	public void rest() {
	}
}
