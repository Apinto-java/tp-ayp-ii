package factory;

import warriors.Warrior;
import warriors.Wrives;

public class WrivesFactory extends WarriorFactory {

	@Override
	public Warrior getNewWarrior() {
		return new Wrives();
	}	
	
}
