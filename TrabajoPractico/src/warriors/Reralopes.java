package warriors;

import weapons.Catapult;

public class Reralopes extends Warrior implements Concentrable {

	private int amountOfAttacks;

	public Reralopes() {
		
		super(53, new Catapult());
		
		this.amountOfAttacks = 0;
	}

	@Override
	public int attack(Warrior anotherWarrior) {
		
		int damage = super.getWeapon().use();
		
		if (this.amountOfAttacks < 0)
			damage *= 2;
		else if (this.amountOfAttacks % 2 != 0)
			damage = 0;
		
		amountOfAttacks++;
		
		anotherWarrior.receiveAttack(damage);
		
		return damage;
	}

//	public void randomAttack(Warrior anotherWarrior) {
//		
//		// resets the iterators
//		if (misses == 2 && hits == 2) {
//			misses = 0;
//			hits = 0;
//		}
//
//		double damage;
//
//		// every 4, it misses 2 and hits other 2
//		if (misses < 2 && hits < 2) {
//
//			if ((int) (Math.random() * 4) <= 1) {
//				// attack missed!
//				misses++;
//				damage = 0;
//
//			} else {
//
//				// attack hit!
//				hits++;
//				damage = calculateDamage();
//			}
//
//		} else if (misses < 2) {
//			// attack missed!
//			misses++;
//			damage = 0;
//
//		} else {
//			// attack hit!
//			hits++;
//			damage = calculateDamage();
//		}
//	}
	
	@Override
	public void receiveAttack(double damage) {

		super.reduceHealthPoints(damage);

		this.amountOfAttacks = 0;
	}

	@Override
	public void rest() {
		
		this.concentrate();
	}
	
	public void concentrate() {
		
		if (this.amountOfAttacks >= 0)
			this.amountOfAttacks = -3;
	}
}
