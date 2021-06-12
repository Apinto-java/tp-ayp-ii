package warriors;

public abstract class MilitaryUnit {
	
	public abstract void attack(Warrior anotherWarrior);
	
	public abstract void receiveAttack(double damage);
	
	public abstract void rest();
}
