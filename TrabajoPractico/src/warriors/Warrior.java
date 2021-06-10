package warriors;

import weapons.Weapon;

public abstract class Warrior extends MilitaryUnit{

	private double hp;
	private Weapon weapon;
	
	protected Warrior(int hp, Weapon weapon) {
		
		this.hp = hp;
		this.weapon = weapon;
	}
	
	public abstract void attack(Warrior anotherWarrior);
	
	public abstract void receiveAttack(double damage);
	
	public abstract void rest();
	
	public double getHP(){
		
		return this.hp;
	}
	
	public void reduceHP(double damage) {
		
		this.hp -= damage;
		
		if(this.hp < 0)
			this.hp = 0;
	}
	
	public void increaseHP(double healing) {
		
		this.hp += healing;
	}
	
	public Weapon getWeapon(){
		
		return this.weapon;
	}
}