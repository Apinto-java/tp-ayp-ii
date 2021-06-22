package warriors;

import java.util.PriorityQueue;

import map.Alignment;

public class Troop extends MilitaryUnit {

	private PriorityQueue<Warrior> queue;

	/**
	 * Instantiates a new Empty Troop
	 */
	public Troop(Alignment alignment) {
		
		this(new PriorityQueue<Warrior>(), alignment);
	}
	
	/**
	 * Instantiates a new Troop with the given warriors.
	 */
	public Troop(PriorityQueue<Warrior> warriors, Alignment alignment) {
		
		this.queue = warriors;
		super.alignment = alignment;
	}

	/**
	 * 
	 * @param warrior The Warrior to add to this Troop
	 * @post Adds 'warrior' to this Troop
	 */
	public void addWarrior(Warrior warrior) {

		this.queue.add(warrior);
	}

	/**
	 * @param anotherWarrior The Warrior that will receive the attack
	 * @post The first Warrior of this troop attacks 'anotherWarrior'
	 */
	@Override
	public void attack(Warrior anotherWarrior) {

		Warrior firstWarrior = this.queue.peek();
		
		if (firstWarrior.getHealthPoints() <= 0)
			this.queue.poll();
		else
			firstWarrior.attack(anotherWarrior);
	}

	/**
	 * @post Every Warrior of this troop rests
	 */
	// Ojo que es una cola de prioridad, no sé si es iterable como tal.
	@Override
	public void rest() {

		for (Warrior warrior : this.queue)
			warrior.rest();
	}

	@Override
	public boolean isStillAlive() {

		return this.getHealthPoints() > 0;
	}

	/**
	 * 
	 * @return total HP of this troop
	 */
	public double getHealthPoints() {

		double healthPoints = 0;

		for (Warrior warrior : this.queue)
			healthPoints += warrior.getHealthPoints();

		return healthPoints;
	}

	/**
	 * @return The first Warrior ready for battle
	 */
	@Override
	public Warrior getFirstSoldier() {
		
		return this.queue.peek();
	}

	public Warrior deleteFirstSoldier() {

		return this.queue.poll();
	}

	public int getSize() {
		
		return this.queue.size();
	}

	@Override
	public String toString() {
		
		String message = "";

		message += this.getSize() + " " + getFirstSoldier().getClass().getSimpleName() + " " + getAlignment().toString();

		return message;
	}
}
