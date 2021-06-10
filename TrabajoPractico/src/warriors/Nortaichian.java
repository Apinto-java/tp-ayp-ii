package warriors;

import weapons.Bow;

public class Nortaichian extends Warrior {

	private double maxHP;
	private int doubleDamage;
	private int stoned = 0;

	public Nortaichian() {

		super(66, new Bow());
		this.maxHP = this.getHP();
		this.doubleDamage = 0;
	}

	@Override
	public void attack(Warrior anotherWarrior) {

		double damage = super.getWeapon().use();

		if (stoned >= 1) {

			stoned--;
			damage = 0;
			
		} else if (doubleDamage >= 1) {

			doubleDamage--;
			damage *= 2;
			
		}

		anotherWarrior.receiveAttack(damage);
		
		if(damage > 0)
			addHP();
	}

	@Override
	public void receiveAttack(double damage) {

		if (this.doubleDamage == 0)
			this.doubleDamage = 2;

		if (this.stoned >= 1)
			super.reduceHP(damage / 2);
		else
			super.reduceHP(damage);
	}

	@Override
	public void rest() {

		if (this.stoned == 0)
			this.stoned = 2;

		// max HP - lo que tiene = todo el HP que le bajaron
		double HpTaken = 66 - super.getHP();
		super.increaseHP(HpTaken);
	}
	
	private void addHP() {
		
		double additionalHP = this.maxHP * 0.04;

		if (this.getHP() + additionalHP <= this.maxHP)
			this.increaseHP(additionalHP);
	}
}