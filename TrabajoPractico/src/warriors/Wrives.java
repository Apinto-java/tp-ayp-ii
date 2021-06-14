package warriors;

import weapons.Magic;

public class Wrives extends Warrior implements Meditator {

	private boolean hasDoubleDamage;
	private boolean isPeaceful;

	public Wrives() {

		super(108, new Magic());
		
		this.hasDoubleDamage = false;
		this.isPeaceful = false;
	}

	@Override
	public int attack(Warrior anotherWarrior) {

		int damage = 0;

		if (!this.isPeaceful) {
			
			damage = super.getWeapon().use();
		
			if (this.hasDoubleDamage)
				damage *= 2;
			
			this.hasDoubleDamage = !this.hasDoubleDamage;	
		}
		
		anotherWarrior.receiveAttack(damage);
		
		return damage;
	}

	@Override
	public void receiveAttack(double damage) {

		this.isPeaceful = false;
		
		super.reduceHealthPoints(damage * 2);
	}

	@Override
	public void rest() {

		this.meditate();

		super.increaseHealthPoints(50);
	}

	@Override
	public void meditate() {
		
		this.isPeaceful = true;
	}
}
