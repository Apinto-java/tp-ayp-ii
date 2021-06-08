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
	public int attack() {
		
		double additionalHP = this.maxHP * 0.04;
		
		if (this.getHP() + additionalHP <= this.maxHP)
			this.increaseHP(additionalHP);
		
		int damage = super.getWeapon().use();
		
		if (doubleDamage >= 1) {
			
			doubleDamage--;
			damage *= 2;
		}

		if (stoned >= 1){

			stoned--;
			damage = 0;
		}
		
		return damage;
	}

	@Override
	public void receiveAttackFrom(Warrior anotherWarrior) {
		
		if (this.doubleDamage == 0)
			this.doubleDamage = 2;
		
		if (this.stoned >= 1)
			super.reduceHP(anotherWarrior.attack() / 2);
		else
			super.reduceHP(anotherWarrior.attack());
	}

	@Override
	public void rest() {
		
		if (this.stoned == 0)
			this.stoned = 2;
		
		// max HP - lo que tiene = todo el HP que le bajaron
		double HpTaken = 66 - super.getHP();
		super.increaseHP(HpTaken);
	}
}