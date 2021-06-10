package warriors;

import java.util.PriorityQueue;

public class Army extends MilitaryUnit {
	
	private PriorityQueue<MilitaryUnit> army;
	
	public void addMilitaryUnit(MilitaryUnit other) {
		this.army.add(other);
	}
	
	@Override
	public void attack(Warrior anotherWarrior) {
		//TODO
	}

	@Override
	public void receiveAttack(double damage) {
		//TODO
	}

	@Override
	public void rest() {
		//TODO
	}
}
