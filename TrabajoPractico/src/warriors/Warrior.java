package warriors;

import weapons.Weapon;

public abstract class Warrior {

	private double healthPoints;
	private Weapon weapon;
	
	protected Warrior(int healthPoints, Weapon weapon) {
		
		this.healthPoints = healthPoints;
		this.weapon = weapon;
	}
	
	public abstract void attack(Warrior anotherWarrior);
	
	public abstract void receiveAttack(double damage);
	
	public abstract void rest();
	
	public double getHealthPoints(){
		
		return this.healthPoints;
	}
	
	public void reduceHP(double damage) {
		
		this.healthPoints -= damage;
		
		if(this.healthPoints < 0)
			this.healthPoints = 0;
	}
	
	public void increaseHealthPoints(double healing) {
		
		this.healthPoints += healing;
	}
	
	public Weapon getWeapon(){
		
		return this.weapon;
	}
}