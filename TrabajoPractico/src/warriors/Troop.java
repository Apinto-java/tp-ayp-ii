package warriors;

import java.util.PriorityQueue;

public class Troop extends MilitaryUnit {
	
	private PriorityQueue<Warrior> troop;
	
	/**
	 * 
	 * @param warrior The Warrior to add to this Troop
	 * @post Adds 'warrior' to this Troop
	 */
	public void addWarrior(Warrior warrior) {
		
		this.troop.add(warrior);
	}
	
	/**
	 * @param anotherWarrior The Warrior that will receive the attack
	 * @post The first Warrior of this troop attacks 'anotherWarrior'
	 */
	@Override
	public void attack(Warrior anotherWarrior) {
		
		Warrior firstWarrior = this.troop.peek();
		
		firstWarrior.attack(anotherWarrior);
	}
	
	/**
	 * @param damage Damage receive by the first Warrior of this Troop
	 */
	@Override
	public void receiveAttack(double damage) {
		
		Warrior firstWarrior = this.troop.peek();
		
		firstWarrior.receiveAttack(damage);
		
		if(firstWarrior.getHealthPoints() == 0)
			this.troop.poll();
	}
	
	
	/**
	 * @post Every Warrior of this troop rests
	 */
	// Ojo que es una cola de prioridad, no sé si es iterable como tal.
	@Override
	public void rest() {
		
		for(Warrior warrior : this.troop)
			warrior.rest();
	}
	
	/**
	 * 
	 * @return total HP of this troop
	 */
	public double getHealthPoints() {
		
		double healthPoints = 0;
		
		for(Warrior warrior : this.troop)
			healthPoints += warrior.getHealthPoints();
		
		return healthPoints;
	}
	
	/**
	 * @return The first Warrior ready for battle
	 */
	@Override
	public Warrior getFirstSoldier() {
		return troop.peek();
	}
}
