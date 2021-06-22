package warriors;

import java.util.PriorityQueue;

import map.Alignment;

public class Troop extends MilitaryUnit {

	private PriorityQueue<Warrior> troop;

	/**
	 * Instantiates a new Empty Troop
	 */
	public Troop(Alignment alignment) {
		this.troop = new PriorityQueue<Warrior>();
		super.alignment = alignment;
	}

	/**
	 * Instantiates a new Troop with the given warriors
	 */
	public Troop(PriorityQueue<Warrior> warriors, Alignment alignment) {
		this.troop = warriors;
		super.alignment = alignment;
	}

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

		if (this.troop.peek().getHealthPoints() <= 0)
			troop.poll();
		else
			this.troop.peek().attack(anotherWarrior);
	}

	/**
	 * @post Every Warrior of this troop rests
	 */
	// Ojo que es una cola de prioridad, no sé si es iterable como tal.
	@Override
	public void rest() {

		for (Warrior warrior : this.troop)
			warrior.rest();
	}

	@Override
	public boolean isStillAlive() {

		return this.troop.peek() != null;
	}

	/**
	 * 
	 * @return total HP of this troop
	 */
	public double getHealthPoints() {

		double healthPoints = 0;

		for (Warrior warrior : this.troop)
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

	public Warrior deleteFirstSoldier() {

		return troop.poll();
	}

	public int getSize() {
		return troop.size();
	}

	@Override
	public String toString() {
		String out = "";

		out += this.getSize() + " " + getFirstSoldier().getClass().getSimpleName() + " " + getAlignment().toString();

		return out;
	}
}
