package warriorsTest;

import warriors.Warrior;

public class TestBuddy extends Warrior{
	
	/**
	 * Muñeco de pruebas para evaluar el comportamiento de las razas.
	 */
	public TestBuddy(int healthPoints){
		
		super(healthPoints, null);
	}

	public TestBuddy() {
		
		this(500);
	}

	@Override
	public int attack(Warrior anotherWarrior) {
		
		anotherWarrior.receiveAttack(10);
		
		return 10;
	}

	@Override
	public void receiveAttack(double damage) {
		
		super.reduceHealthPoints(damage);
	}

	@Override
	public void rest() {}
}
