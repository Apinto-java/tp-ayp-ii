package warriors;

import weapons.Weapon;

public abstract class Warrior {

	private double hp;
	private Weapon weapon;
	
	protected Warrior(int hp, Weapon weapon) {
		
		this.hp = hp;
		this.weapon = weapon;
	}
	
	public abstract int attack();
	
	public abstract void receiveAttackFrom(Warrior anotherWarrior);
	
	public abstract void rest();
	
	public double getHP(){
		
		return this.hp;
	}
	
	public void reduceHP(double damage) {
		
		if (this.hp - damage >= 0)
			this.hp -= damage;
	}
	
	public void increaseHP(double d) {
		
		this.hp += d;
	}
	
	public Weapon getWeapon(){
		
		return this.weapon;
	}
}