package warriors;

import weapons.Shuriken;

public class Radaiteran extends Warrior {

	private int amountOfAttacks = 0;
	
	public Radaiteran() {
		
		super(36, new Shuriken());
	}

	@Override
	public int attack() {
		
		return super.getWeapon().use() + (3 * amountOfAttacks++);
	}

	@Override
	public void receiveAttackFrom(Warrior anotherWarrior) {
		
		if (this.getHP() >= 0)
			super.reduceHP(anotherWarrior.attack());
	}

	// No ocurre nada en un Radaiteran.
	@Override
	public void rest() {}
}
