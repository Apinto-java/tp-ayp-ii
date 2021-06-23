package battleTest;

import static org.junit.Assert.*;

import org.junit.Test;

import map.Alignment;
import warriors.Troop;
import warriors.Warrior;
import warriors.Wrives;

public class TroopTest {

	@Test
	public void testHP() {
		Warrior wrives = new Wrives();
		
		try {
			Troop troop = new Troop("Wrives", 85, Alignment.PROPIO);
			
			Troop enemyTroop = new Troop("Wrives", 1, Alignment.ENEMIGO);
			
			Warrior ownWarrior = troop.queue.peek();
			enemyTroop.attack(ownWarrior);
			
			for(Warrior w : troop.queue) {
				System.out.println("HP: " + w.getHealthPoints());
			}
		} catch(Exception e) {
			System.err.println(e);
		}
		
		
		
	}

}
