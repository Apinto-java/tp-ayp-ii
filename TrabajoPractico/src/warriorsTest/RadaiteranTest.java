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
	
	@Test
	public void unRadaiteranComienzaCon36DeVidaYUnShuriken() {
		
		Assert.assertEquals(36, radaiteran.getHP(), 0.0);
		
		Class<? extends Shuriken> shuriken = new Shuriken().getClass();
		Class<? extends Weapon> esUnArmaDeRadaiteran = radaiteran.getWeapon().getClass();
		
		Assert.assertEquals(shuriken, esUnArmaDeRadaiteran);
	}
	
	@Test
	public void unRadaiteranOcasiona56DeDanioBase() {
		
		Assert.assertEquals(56, radaiteran.attack());
	}
	
	@Test
	public void atacar4VecesElevaDanioDeRadaiteranA68Puntos() {
		
		for (int i = 1; i <= 4; i++)
			radaiteran.attack();
		
		Assert.assertEquals(68, radaiteran.attack());
	}
	
	@Test
	public void radaiteranRecibeAtaqueDeWrivesYMuere() {
		
		radaiteran.receiveAttackFrom(new Wrives());
		
		Assert.assertEquals(0, radaiteran.getHP(), 0.0);
	}
	
	@Test
	public void radaiteranRecibeAtaqueDeNortaichianYQuedaEn18() {
		
		radaiteran.receiveAttackFrom(new Nortaichian());
		
		Assert.assertEquals(18, radaiteran.getHP(), 0.0);
	}
	
	@Test
	public void radaiteranRecibeAtaqueDeReralopesYQuedaEn9() {
		
		radaiteran.receiveAttackFrom(new Reralopes());
		
		Assert.assertEquals(9, radaiteran.getHP(), 0.0);
	}
}
