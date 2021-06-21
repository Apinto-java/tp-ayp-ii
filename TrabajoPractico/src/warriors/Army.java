package warriors;

import java.util.PriorityQueue;

public class Army extends MilitaryUnit {

	private PriorityQueue<MilitaryUnit> army;
	
	/**
	 * 
	 * @param other MilitaryUnit to add
	 * @post Adds 'other' to this army
	 */
	public void addMilitaryUnit(MilitaryUnit other) {

		this.army.add(other);
	}

	/**
	 * @post This Army attacks another warrior
	 */
	@Override
	public void attack(Warrior anotherWarrior) {

		this.army.peek().attack(anotherWarrior);
	}
	
	/**
	 * @post Every Military unit rests
	 */
	@Override
	public void rest() {

		for (MilitaryUnit militaryUnit : army)
			militaryUnit.rest();
	}
	
	/**
	 * 
	 * @return Whether this army has any warrior still alive
	 */
	public boolean isStillAlive() {

		return this.army.peek() != null;
	}
	
	/**
	 * @return First Warrior that is going to battle in this Army
	 */
	@Override
	public Warrior getFirstSoldier() {

		return army.peek().getFirstSoldier();
	}
	
	/**
	 * @return Total Health Points of this Army
	 */
	@Override
	public double getHealthPoints() {
		
		double healthPoints = 0;
		
		for(MilitaryUnit unit : this.army)
			healthPoints += unit.getHealthPoints();
		
		return healthPoints;
	}
}
