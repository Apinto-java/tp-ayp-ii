package warriors;

public class TestBuddy extends Warrior{

	// solo util para las pruebas
	public TestBuddy() {
		super(500, null);
	}

	public TestBuddy(int hp){
		super(hp, null);
	}

	@Override
	public void attack(Warrior anotherWarrior) {
		anotherWarrior.receiveAttack(10);
	}

	@Override
	public void receiveAttack(double damage) {
		super.reduceHP(damage);
	}

	@Override
	public void rest() {
	}
}
