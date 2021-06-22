package game;

import map.Alignment;
import warriors.Army;
import warriors.Radaiteran;
import warriors.Reralopes;
import warriors.Troop;
import warriors.Wrives;

@SuppressWarnings("unused")
public class BattleDemo {

	public static void main(String[] args) {
		
		Army ownArmy = new Army();
		Troop ownTroop = new Troop(Alignment.PROPIO);
		Troop allyTroop = new Troop(Alignment.ALIADO);
		Troop enemyTroop = new Troop(Alignment.ENEMIGO);
		Army enemyArmy = new Army();
		Troop firstEnemyTroop = new Troop(Alignment.ENEMIGO);
		Troop secondEnemyTroop = new Troop(Alignment.ENEMIGO);
		
		for(int i = 0; i < 75; i++) {
			ownTroop.addWarrior(new Wrives());
		}
		
		for(int i = 0; i < 50; i++) {
			allyTroop.addWarrior(new Reralopes());
		}
		
		for(int i = 0; i < 1; i++) {
			enemyTroop.addWarrior(new Radaiteran());
		}
		
		for(int i = 0; i < 40; i++) {
			firstEnemyTroop.addWarrior(new Radaiteran());
		}
		
		for(int i = 0; i < 25; i++) {
			secondEnemyTroop.addWarrior(new Radaiteran());
		}
		
		ownArmy.addMilitaryUnit(ownTroop);
		ownArmy.addMilitaryUnit(allyTroop);
		
		enemyArmy.addMilitaryUnit(firstEnemyTroop);
		enemyArmy.addMilitaryUnit(secondEnemyTroop);
		
		System.out.println(ownTroop.toString());
		System.out.println("----------------");
		System.out.println(ownArmy.toString());
		System.out.println("----------------");
		System.out.println(enemyArmy.toString());
		System.out.println("----------------");
		
		Battle.between(ownArmy, enemyTroop);
	}
}
