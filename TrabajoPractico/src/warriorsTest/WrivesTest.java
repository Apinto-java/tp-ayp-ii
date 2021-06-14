package warriorsTest;

import org.junit.Assert;
import org.junit.Test;

import warriors.Warrior;
import warriors.Wrives;
import weapons.Magic;
import weapons.Weapon;

public class WrivesTest {

	Warrior wrives = new Wrives();
	Warrior testBuddy = new TestBuddy();

	@Test
	public void unWrivesComienzaCon108DeVidaYUnMagic() {

		Assert.assertEquals(108, wrives.getHealthPoints(), 0.0);

		Class<? extends Magic> magic = new Magic().getClass();
		Class<? extends Weapon> esUnArmaDeWrives = wrives.getWeapon().getClass();

		Assert.assertEquals(magic, esUnArmaDeWrives);
	}

	@Test
	public void unWrivesOcasiona113PuntosDeDanioBase() {

		wrives.attack(testBuddy);

		// 500 - 113 = 387
		Assert.assertEquals(387, testBuddy.getHealthPoints(), 0.01);
	}

	@Test
	public void unWrivesOcasiona226DeDanioCadaDosAtaques() {

		testBuddy = new TestBuddy(1000);
		
		wrives.attack(testBuddy);

		// 1000 - 113 = 887
		Assert.assertEquals(887, testBuddy.getHealthPoints(), 0.01);

		wrives.attack(testBuddy);

		// 887 - 226 = 661
		Assert.assertEquals(661, testBuddy.getHealthPoints(), 0.01);

		wrives.attack(testBuddy);
		
		// 661 - 113 = 548
		Assert.assertEquals(548, testBuddy.getHealthPoints(), 0.01);

		wrives.attack(testBuddy);
		
		// 548 - 226 = 322
		Assert.assertEquals(322, testBuddy.getHealthPoints(), 0.01);
	}

	@Test
	public void unWrivesNoAtacaCuandoMeditaYSiEsAtacadoLoHaceNormalmente() {
		
		wrives.rest();
		
		wrives.attack(testBuddy);
		
		Assert.assertEquals(500, testBuddy.getHealthPoints(), 0.01);
		
		wrives.receiveAttack(10);
		
		wrives.attack(testBuddy);
		
		Assert.assertEquals(387, testBuddy.getHealthPoints(), 0.01);
	}

	@Test
	public void unWrivesRecibeElDobleDeDanio() {

		wrives.receiveAttack(10);

		// 108 - 10*2 = 108 - 20 = 88
		Assert.assertEquals(88, wrives.getHealthPoints(), 0.01);
	}
}
