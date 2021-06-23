package factory;

import warriors.Warrior;
import warriorsTest.TestBuddy;

public class TestBuddyFactory extends WarriorFactory {

	@Override
	public Warrior getNewWarrior() {
		return new TestBuddy();
	}

}
