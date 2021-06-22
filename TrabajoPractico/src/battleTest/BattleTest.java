package battleTest;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import game.Battle;
import map.Alignment;
import warriors.Army;
import warriors.Troop;
import warriors.Wrives;

public class BattleTest {

	@Test
	public void ownWrivesWinsAgainsEnemyWrives() {
		
		// Instantiation of the warriors
		Wrives own = new Wrives();
		Wrives enemy = new Wrives();
		
		// Instantiation of the Troops
		Troop ownTroop = new Troop(Alignment.Propio);
		ownTroop.addWarrior(own);
		
		Troop enemyTroop = new Troop(Alignment.Enemigo);
		enemyTroop.addWarrior(enemy);
		
		//Instantiation of the Armies
		Army ownArmy = new Army();
		ownArmy.addMilitaryUnit(ownTroop);
		
		Army enemyArmy = new Army();
		enemyArmy.addMilitaryUnit(enemyTroop);
		
		//Battle
		Assert.assertTrue(Battle.between(ownArmy, enemyArmy));
	}
	
	@Test
	public void ownWrivesAgainsTwoEnemyWrivesLoses() {
		
		//Instantiation of the Warriors
		Wrives ownWrives = new Wrives();
		Wrives enemyWrives1 = new Wrives();
		Wrives enemyWrives2 = new Wrives();
		
		//Instantiation of the Troops
		Troop ownTroop = new Troop(Alignment.Propio);
		ownTroop.addWarrior(ownWrives);
		
		Troop enemyTroop = new Troop(Alignment.Enemigo);
		enemyTroop.addWarrior(enemyWrives1);
		enemyTroop.addWarrior(enemyWrives2);
		
		//Instantiation of the Armies
		Army ownArmy = new Army();
		ownArmy.addMilitaryUnit(ownTroop);
		
		Army enemyArmy = new Army();
		enemyArmy.addMilitaryUnit(enemyTroop);
		
		//Battle
		Assert.assertFalse(Battle.between(ownArmy, enemyArmy));
	}

}
