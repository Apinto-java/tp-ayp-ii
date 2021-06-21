package game;

import warriors.MilitaryUnit;

public class Battle {

	public static void between(MilitaryUnit thisArmy, MilitaryUnit anotherArmy) {
		
		while (thisArmy.isStillAlive() || anotherArmy.isStillAlive()) {

			thisArmy.attack(anotherArmy.getFirstSoldier());
			
			anotherArmy.attack(thisArmy.getFirstSoldier());
		}
		
		if(thisArmy.isStillAlive()) {
			victory(thisArmy);
		}
	}
	
	private static void victory(MilitaryUnit thisArmy) {
		// TODO
		System.out.println("Battle won! With : ");
	}
}
