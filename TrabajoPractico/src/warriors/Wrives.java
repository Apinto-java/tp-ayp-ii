package warriors;

import weapons.Magic;

public class Wrives extends Warrior {

	private boolean doubleAttack = true;
	private boolean peaceful = false;

	public Wrives() {
		
		super(108, new Magic());
	}

	@Override
	public int attack() {
		
		if (this.peaceful)
			return 0;

		this.doubleAttack = ! this.doubleAttack;

		int damage = super.getWeapon().use();

		if (doubleAttack)
			damage *= 2;
		
		return damage;
	}

	@Override
	public void receiveAttackFrom(Warrior anotherWarrior) {

		super.reduceHP(anotherWarrior.attack() * 2);

		peaceful = false;
	}

	@Override
	public void rest() {
		
		peaceful = true;

		super.increaseHP(50);
	}
}
