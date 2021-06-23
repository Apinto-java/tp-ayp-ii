package battleTest;

import org.junit.Assert;
import org.junit.Test;

import game.Battle;
import map.Alignment;
import warriors.Army;
import warriors.MilitaryUnit;
import warriors.Troop;
import warriors.Wrives;

public class BattleTest {

	@Test
	public void ownWrivesWinsAgainsEnemyWrives() {
		
		// Instantiation of the Troops
		Troop ownTroop = new Troop(new Wrives(), 1, Alignment.PROPIO);
		Troop enemyTroop = new Troop(new Wrives(), 1, Alignment.ENEMIGO);
		
		//Instantiation of the Armies
		Army ownArmy = new Army(ownTroop);
		Army enemyArmy = new Army(enemyTroop);
		
		//Battle
		MilitaryUnit isWinner = Battle.between(ownArmy, enemyArmy);
		
		Assert.assertEquals(ownArmy, isWinner);
	}
	
	@Test
	public void ownWrivesAgainsTwoEnemyWrivesLoses() {
		
		// Instantiation of the Troops
		Troop ownTroop = new Troop(new Wrives(), 1, Alignment.PROPIO);
		Troop enemyTroop = new Troop(new Wrives(), 2, Alignment.ENEMIGO);
		
		//Instantiation of the Armies
		Army ownArmy = new Army(ownTroop);
		Army enemyArmy = new Army(enemyTroop);
		
		//Battle
		MilitaryUnit isWinner = Battle.between(ownArmy, enemyArmy);
		
		Assert.assertEquals(enemyArmy, isWinner);
	}

}
