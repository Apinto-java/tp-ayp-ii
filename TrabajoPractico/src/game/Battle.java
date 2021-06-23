package game;

import warriors.MilitaryUnit;

public class Battle {

	public static MilitaryUnit between(MilitaryUnit unitA, MilitaryUnit unitB) {
		
		while (unitA.isStillAlive() && unitB.isStillAlive()) {
			
			unitA.attack(unitB.getFirstWarrior());
			
			// The enemy army may not be alive after the attack
			if (unitB.isStillAlive()) {
				
				unitB.attack(unitA.getFirstWarrior());
			}
		}
		
		MilitaryUnit winner = unitA;
		
		if (unitB.isStillAlive())
			winner = unitB;
		
		return winner;	
	}
	
}
