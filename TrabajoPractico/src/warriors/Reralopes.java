package warriors;

import weapons.Catapult;

public class Reralopes extends Warrior {

	private int misses = 0;
	private int hits = 0;
	private int buff = 0;

	public Reralopes() {
		
		super(53, new Catapult());
	}

	@Override
	public void attack(Warrior anotherWarrior) {
		
		// resets the iterators
		if(misses == 2 && hits == 2) {
			misses = 0;
			hits = 0;
		}
		
		double damage;
		
		// every 4, it misses 2 and hits other 2
		if (misses < 2 && hits < 2) {
			
			if( (int)(Math.random() * 4) <= 1 ) {
				// attack missed!
				misses++;
				damage = 0;
				
			} else {
				
				// attack hit!
				hits++;
				damage = calculateDamage();
			}
			
		} else if (misses < 2) {
			// attack missed!
			misses++;
			damage = 0;
			
		} else {
			// attack hit!
			hits++;
			damage = calculateDamage();
		}
		
		anotherWarrior.receiveAttack(damage);
	}

	@Override
	public void receiveAttack(double damage) {

		super.reduceHP(damage);

		buff = 0;
	}

	@Override
	public void rest() {
		// just a buff
		if (buff == 0) {
			buff = 3;
		}
	}

	private int calculateDamage() {
		// just to calculate damage, and reduce buff
		if (buff > 0) {
			buff--;
			return super.getWeapon().use() * 2;
		} else {
			return super.getWeapon().use();
		}
	}
}
