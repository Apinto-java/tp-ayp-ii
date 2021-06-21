package warriors;

import java.util.PriorityQueue;

public class Troop extends MilitaryUnit {
	
	private PriorityQueue<Warrior> troop;
	
	public void addWarrior(Warrior warrior) {
		
		this.troop.add(warrior);
	}
	
	@Override
	public void attack(Warrior anotherWarrior) {
		
		Warrior firstWarrior = this.troop.peek();
		
		firstWarrior.attack(anotherWarrior);
	}

	@Override
	public void receiveAttack(double damage) {
		
		Warrior firstWarrior = this.troop.peek();
		
		firstWarrior.receiveAttack(damage);
		
		if(firstWarrior.getHealthPoints() == 0)
			this.troop.poll();
	}

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

	@Override
	public Warrior getFirstSoldier() {
		return troop.peek();
	}
}
