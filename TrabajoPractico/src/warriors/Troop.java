package warriors;

import java.util.PriorityQueue;

public class Troop extends MilitaryUnit {
	
	private PriorityQueue<Warrior> tropa;
	
	public void addWarrior(Warrior warrior) {
		tropa.add(warrior);
	}
	
	@Override
	public void attack(Warrior anotherWarrior) {
		Warrior attacker = tropa.peek();
		attacker.attack(anotherWarrior);
	}

	@Override
	public void receiveAttack(double damage) {
		
		Warrior defender = tropa.peek();
		defender.receiveAttack(damage);
		
		if(defender.getHP() == 0)
			tropa.poll();
	}

	@Override
	public void rest() {
		//TODO @return nuevaColaPrioridad
	}
	
	/**
	 * 
	 * @return total HP of this troop
	 */
	public double getTroopHP() {
		double hp = 0;
		
		for(Warrior warrior : tropa) {
			hp += warrior.getHP();
		}
		
		return hp;
	}
	
}
