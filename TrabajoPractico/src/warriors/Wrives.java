package warriors;

import weapons.Magic;

public class Wrives extends Warrior {

	private boolean doubleAttack = true;
	private boolean peaceful = false;

	public Wrives() {

		super(108, new Magic());
	}

	@Override
	public void attack(Warrior anotherWarrior) {

		double damage;

		if (this.peaceful)
			damage = 0;
		else {
			
			this.doubleAttack = !this.doubleAttack;

			damage = super.getWeapon().use();

			if (doubleAttack)
				damage *= 2;
		}
		
		anotherWarrior.receiveAttack(damage);
	}

	@Override
	public void receiveAttack(double damage) {

		super.reduceHP(damage * 2);

		peaceful = false;
	}

	@Override
	public void rest() {

		peaceful = true;

		super.increaseHP(50);
	}
}
