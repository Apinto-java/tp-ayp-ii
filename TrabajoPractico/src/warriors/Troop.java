package warriors;

import java.util.PriorityQueue;

public class Troop extends MilitaryUnit {
	
	PriorityQueue<Warrior> tropa;
	
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
			tropa.remove();
	}

	@Override
	public void rest() {
		tropa.peek().rest();
	}
	
}
