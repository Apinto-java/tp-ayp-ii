package warriors;

import java.util.PriorityQueue;

public class Army extends MilitaryUnit {

	private PriorityQueue<MilitaryUnit> army = new PriorityQueue<MilitaryUnit>();
	
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

		if(army.peek().getHealthPoints() <= 0.0)
			army.poll();
		else
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

		//return this.army.peek() != null;
		return this.getHealthPoints() > 0.0;
	}
	
	/**
	 * @return First Warrior that is going to battle in this Army
	 */
	@Override
	public Warrior getFirstWarrior() {

		return army.peek().getFirstWarrior();
	}
	
	/**
	 * @return Total Health Points of this Army
	 */
	@Override
	public double getHealthPoints() {
		
		double healthPoints = 0.0;
		
		for(MilitaryUnit unit : this.army)
			healthPoints += unit.getHealthPoints();
		
		return healthPoints;
	}

	@Override
	public String toString() {
		String out = "";
		
		for (MilitaryUnit militaryUnit : army) {
			out += militaryUnit.toString() + "\n";
		}
		
		return out;
	}
}
