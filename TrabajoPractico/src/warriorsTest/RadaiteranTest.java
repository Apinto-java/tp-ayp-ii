package warriorsTest;

import org.junit.Assert;
import org.junit.Test;

import warriors.Nortaichian;
import warriors.Radaiteran;
import warriors.Reralopes;
import warriors.Warrior;
import warriors.Wrives;
import weapons.Shuriken;
import weapons.Weapon;

public class RadaiteranTest {

	Warrior radaiteran = new Radaiteran();
	Warrior testBuddy = new TestBuddy();

	@Test
	public void unRadaiteranComienzaCon36DeVidaYUnShuriken() {

		Assert.assertEquals(36, radaiteran.getHealthPoints(), 0.0);

		Class<? extends Shuriken> shuriken = new Shuriken().getClass();
		Class<? extends Weapon> esUnArmaDeRadaiteran = radaiteran.getWeapon().getClass();

		Assert.assertEquals(shuriken, esUnArmaDeRadaiteran);
	}

	@Test
	public void unRadaiteranOcasiona56DeDanioBase() {

		radaiteran.attack(testBuddy);

		// 500 - 56 = 444
		Assert.assertEquals(444, testBuddy.getHealthPoints(), 0.01);
	}

	@Test
	public void atacar4VecesElevaDanioDeRadaiteranA65Puntos() {

		for (int i = 1; i <= 4; i++)
			radaiteran.attack(testBuddy);
		
		// (1) 56 + 3 * 0 = 56
		// (2) 56 + 3 * 1 = 59
		// (3) 56 + 3 * 2 = 62
		// (4) 56 + 3 * 3 = 65
		
		// 500 - 242 = 258
		Assert.assertEquals(258, testBuddy.getHealthPoints(), 0.01);
	}

	@Test
	public void radaiteranRecibeAtaqueDeWrivesYMuere() {
		
		new Wrives().attack(radaiteran);

		Assert.assertEquals(0, radaiteran.getHealthPoints(), 0.0);
	}

	@Test
	public void radaiteranRecibeAtaqueDeNortaichianYQuedaEn18() {

		new Nortaichian().attack(radaiteran);
		
		Assert.assertEquals(18, radaiteran.getHealthPoints(), 0.0);
	}

	@Test
	public void radaiteranRecibeAtaqueDeReralopesYQuedaEn9() {

		new Reralopes().attack(radaiteran);

		Assert.assertEquals(9, radaiteran.getHealthPoints(), 0.0);
	}
}
