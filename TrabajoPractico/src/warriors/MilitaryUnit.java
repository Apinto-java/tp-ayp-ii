package warriors;

public abstract class MilitaryUnit {
	
	public abstract void attack(Warrior anotherWarrior);
	
	public abstract void receiveAttack(double damage);
	
	public abstract void rest();

	public abstract Warrior getFirstSoldier();
	
	public abstract double getHealthPoints();
}
