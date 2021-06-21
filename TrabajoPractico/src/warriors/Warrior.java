package warriors;

import weapons.Weapon;

public abstract class Warrior implements Comparable<Warrior>{

	private double healthPoints;
	private Weapon weapon;
	
	public Warrior(int healthPoints, Weapon weapon) {
		
		this.healthPoints = healthPoints;
		this.weapon = weapon;
	}
	
	public abstract int attack(Warrior anotherWarrior);
	
	public abstract void receiveAttack(double damage);
	
	public abstract void rest();
	
	public Double getHealthPoints(){
		
		return this.healthPoints;
	}
	
	public void reduceHealthPoints(double damage) {
		
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
	
	public int compareTo(Warrior o) {
		return this.getHealthPoints().compareTo(o.getHealthPoints());
	}
}