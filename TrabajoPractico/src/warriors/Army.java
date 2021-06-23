package warriors;

import java.util.PriorityQueue;

public class Army extends MilitaryUnit {

	private PriorityQueue<MilitaryUnit> queue;
	
	public Army(MilitaryUnit unit) {
		
		this.queue = new PriorityQueue<MilitaryUnit>();
		this.queue.add(unit);
	}
	
//	public Army() {
//		
//		this(null);
//	}
	
	/**
	 * 
	 * @param unit MilitaryUnit to add
	 * @post Adds 'other' to this army
	 */
	public void addMilitaryUnit(MilitaryUnit unit) {

		this.queue.add(unit);
	}

	/**
	 * @post This Army attacks another warrior
	 */
	@Override
	public void attack(Warrior anotherWarrior) {
		
		if (this.getFirstUnit().getHealthPoints() <= 0.0)
			this.queue.poll();
		
		this.getFirstUnit().attack(anotherWarrior);
	}

	/**
	 * @post Every Military unit rests
	 */
	@Override
	public void rest() {

		for (MilitaryUnit militaryUnit : queue)
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
	
	public MilitaryUnit getFirstUnit() {
		
		return this.queue.peek();
	}
	
	/**
	 * @return First Warrior that is going to battle in this Army
	 */
	@Override
	public Warrior getFirstWarrior() {

		return this.queue.peek().getFirstWarrior();
	}
	
	/**
	 * @return Total Health Points of this Army
	 */
	@Override
	public double getHealthPoints() {
		
		double healthPoints = 0.0;
		
		for(MilitaryUnit unit : this.queue)
			healthPoints += unit.getHealthPoints();
		
		return healthPoints;
	}

	@Override
	public String toString() {
		
		String message = "";
		
		for (MilitaryUnit militaryUnit : queue)
			message += militaryUnit.toString() + "\n";
		
		return message;
	}
}
