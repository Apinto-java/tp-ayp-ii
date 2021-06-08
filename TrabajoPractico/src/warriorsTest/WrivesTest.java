package warriorsTest;

import org.junit.Assert;
import org.junit.Test;

import warriors.Nortaichian;
import warriors.Radaiteran;
import warriors.Warrior;
import warriors.Wrives;
import weapons.Magic;
import weapons.Weapon;

public class WrivesTest {

	Wrives wrives = new Wrives();

	@Test
	public void unWrivesComienzaCon108DeVidaYUnMagic() {

		Assert.assertEquals(108, wrives.getHP(), 0.0);

		Class<? extends Magic> magic = new Magic().getClass();
		Class<? extends Weapon> esUnArmaDeWrives = wrives.getWeapon().getClass();

		Assert.assertEquals(magic, esUnArmaDeWrives);
	}

	@Test
	public void unWrivesOcasiona113PuntosDeDanioBase() {

		Assert.assertEquals(113, wrives.attack());
	}

	@Test
	public void unWrivesOcasiona226DeDanioCadaDosAtaques() {

		Assert.assertEquals(113, wrives.attack());

		Assert.assertEquals(226, wrives.attack());

		Assert.assertEquals(113, wrives.attack());
		
		Assert.assertEquals(226, wrives.attack());
	}

    @Test
    public void unWrivesNoAtacaCuandoMeditaYSiEsAtacadoLoHaceNormalmente() {

        Warrior radaiteran = new Radaiteran();

        wrives.rest();

        Assert.assertEquals(0, wrives.attack(), 0.00);

        wrives.receiveAttackFrom(radaiteran);

        Assert.assertEquals(113, wrives.attack(), 0.00);
    }

    @Test
    public void unWrivesRecibeElDobleDeDanio() {

        Warrior nortaichian = new Nortaichian();

        wrives.receiveAttackFrom(nortaichian);

        Assert.assertEquals(72, wrives.getHP(), 0.00);
    }
}
