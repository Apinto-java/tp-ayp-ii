package factory;

import warriors.Nortaichian;
import warriors.Warrior;

public class NortaichianFactory extends WarriorFactory {

	@Override
	public Warrior getNewWarrior() {
		return new Nortaichian();
	}
	
}
