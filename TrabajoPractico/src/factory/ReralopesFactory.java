package factory;

import warriors.Reralopes;
import warriors.Warrior;

public class ReralopesFactory extends WarriorFactory {

	@Override
	public Warrior getNewWarrior() {
		return new Reralopes();
	}
	
}
