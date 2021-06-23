package warriors;

import java.lang.reflect.InvocationTargetException;
import java.util.PriorityQueue;

import exceptions.NoSuchWarriorException;
import factory.Factory;
import map.Alignment;

public class Troop extends MilitaryUnit {

	private PriorityQueue<Warrior> queue;
	
	/**
	 * Instantiates a new Troop with the given warriors.
	 */
	public Troop(PriorityQueue<Warrior> warriors, Alignment alignment) {
		
		this.queue = warriors;
		super.alignment = alignment;
	}
	
	/**
	 * Instantiates a new Empty Troop
	 */
	public Troop(Alignment alignment) {
		
		this(new PriorityQueue<Warrior>(), alignment);
	}

	public Troop(String warrior, int amount, Alignment alignment) throws NoSuchWarriorException {
		
		this(alignment);
		
		for(int i = 0; i < amount; i++) {
			this.queue.add(Factory.getInstance().getNewWarrior(warrior));
		}
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
		
		if (this.getFirstWarrior().getHealthPoints() <= 0)
			this.deleteFirstSoldier();
		
		this.getFirstWarrior().attack(anotherWarrior);
	}

	/**
	 * @post Every Warrior of this troop rests
	 */
	@Override
	public void rest() {

		for (Warrior warrior : this.queue)
			warrior.rest();
	}

	@Override
	public boolean isStillAlive() {

		//return this.troop.peek() != null;
		return this.getHealthPoints() > 0.0;
	}

	/**
	 * 
	 * @return total HP of this troop
	 */
	public double getHealthPoints() {

		double healthPoints = 0.0;

		for (Warrior warrior : this.queue)
			healthPoints += warrior.getHealthPoints();

		return healthPoints;
	}

	/**
	 * @return The first Warrior ready for battle
	 */
	@Override
	public Warrior getFirstWarrior() {
		
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

		for (Warrior warrior : this.queue)
			message += warrior.getClass().getSimpleName() + " "+ warrior.getHealthPoints() + "\n";

		return message;
	}
}
