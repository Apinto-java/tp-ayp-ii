package warriors;

import weapons.Bow;

public class Nortaichian extends Warrior implements Curable {

	private double maxHealthPoints;
	private int timesDoubleDamage;
	private int timesPetrified;

	public Nortaichian() {

		super(66, new Bow());
		
		this.maxHealthPoints = this.getHealthPoints();
		this.timesDoubleDamage = 0;
		this.timesPetrified = 0;
	}

	@Override
	public int attack(Warrior anotherWarrior) {

		int damage = super.getWeapon().use();

		if (timesPetrified > 0) {

			damage = 0;
			timesPetrified--;
			
		} else if (timesDoubleDamage > 0) {

			damage *= 2;
			timesDoubleDamage--;	
		}

		anotherWarrior.receiveAttack(damage);
		
		if (damage > 0)
			super.increaseHealthPoints(this.extraHealthPoints());
		
		return damage;
	}

	private double extraHealthPoints() {
		
		double extra = this.maxHealthPoints * 0.04;

		if ((this.getHealthPoints() + extra) > this.maxHealthPoints)
			extra = 0;
		
		return extra;
	}
	
	@Override
	public void receiveAttack(double damage) {

		if (this.timesPetrified > 0)
			super.reduceHealthPoints(damage / 2);
		else
			super.reduceHealthPoints(damage);
		
		if (this.timesDoubleDamage == 0) // En duda.
			this.timesDoubleDamage = 2;
	}
	
	@Override
	public void rest() {

		this.cure();
		this.timesPetrified = 2;
	}
	
	@Override
	public void cure() {
		
		double pointsToCompleteHealth = this.maxHealthPoints - super.getHealthPoints();
		super.increaseHealthPoints(pointsToCompleteHealth);
	}
}