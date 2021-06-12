package warriors;

import weapons.Magic;

public class Wrives extends Warrior {

	private boolean doubleDamage;
	private boolean isPeaceful;

	public Wrives() {

		super(108, new Magic());
		
		this.doubleDamage = true;
		this.isPeaceful = false;
	}

	@Override
	public void attack(Warrior anotherWarrior) {

		double damage;

		if (this.isPeaceful)
			damage = 0;
		else {
			
			this.doubleDamage = !this.doubleDamage;

			damage = super.getWeapon().use();

			if (doubleDamage)
				damage *= 2;
		}
		
		anotherWarrior.receiveAttack(damage);
	}

	@Override
	public void receiveAttack(double damage) {

		super.reduceHP(damage * 2);

		isPeaceful = false;
	}

	@Override
	public void rest() {

		isPeaceful = true;

		super.increaseHealthPoints(50);
	}
}
