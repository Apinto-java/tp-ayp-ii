package factory;

import warriors.Radaiteran;
import warriors.Warrior;

public class RadaiteranFactory extends WarriorFactory{
	
	public Warrior getNewWarrior() {
		return new Radaiteran();
	}
	
}
