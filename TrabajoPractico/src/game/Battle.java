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
	
/*
	public static void between(MilitaryUnit thisArmy, MilitaryUnit anotherArmy) {
		
		while (thisArmy.isStillAlive() && anotherArmy.isStillAlive()) {

			thisArmy.attack(anotherArmy.getFirstSoldier());
			
			if (anotherArmy.isStillAlive())
				anotherArmy.attack(thisArmy.getFirstSoldier());
		}
		
		if(thisArmy.isStillAlive()) {
			victory(thisArmy);
		} else
			lose();
	}


	public static void between(MilitaryUnit thisArmy, MilitaryUnit anotherArmy) {
		boolean ourTurn = true;

		while (thisArmy.isStillAlive() && anotherArmy.isStillAlive()) {
			if (ourTurn) {
				fight(thisArmy, anotherArmy);
				ourTurn = !ourTurn;
			} else {
				fight(anotherArmy, thisArmy);
				ourTurn = !ourTurn;
			}
		}

		if (thisArmy.isStillAlive()) {
			victory(thisArmy);
		} else
			lose();
	}

	private static void lose() {
		System.err.println("You lost");
	}

	private static void fight(MilitaryUnit thisArmy, MilitaryUnit anotherArmy) {
		thisArmy.attack(anotherArmy.getFirstSoldier());
	}

	private static void victory(MilitaryUnit thisArmy) {
		System.out.println("Battle won! With : " + "\n" + thisArmy.toString());
	}
*/
}
