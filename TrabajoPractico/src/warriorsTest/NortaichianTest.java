package warriorsTest;

import org.junit.Assert;
import org.junit.Test;

import warriors.Nortaichian;
import warriors.Radaiteran;
import warriors.Warrior;
import weapons.Bow;
import weapons.Weapon;

public class NortaichianTest {

	Warrior nortaichian = new Nortaichian();
	
	@Test
	public void unNortaichianComienzaCon66DeVidaYUnBow() {
		
		Assert.assertEquals(66, nortaichian.getHP(), 0.01);
		
		Class<? extends Bow> bow = new Bow().getClass();
		Class<? extends Weapon> esUnArmaDeNortaichian = nortaichian.getWeapon().getClass();
		
		Assert.assertEquals(bow, esUnArmaDeNortaichian);
	}
	
	@Test
	public void unNortaichianOcasiona18DeDanioBase() {
		
		Assert.assertEquals(18, nortaichian.attack());
	}
	
	@Test
	public void unNortaichianRecuperaSaludAlAtacar() {
		
		// Queda con 10 de vida.
		nortaichian.receiveAttackFrom(new Radaiteran());
		
		Assert.assertEquals(10, nortaichian.getHP(), 0.0);
		
		nortaichian.attack();
		
		Assert.assertEquals(12.64, nortaichian.getHP(), 0.01);
	}
	
	@Test
	public void unNortaichianSeRecuperaCompletamenteAtacando() {
		
		// Queda con 10 de vida.
		nortaichian.receiveAttackFrom(new Radaiteran());
		
		Assert.assertEquals(10, nortaichian.getHP(), 0.0);
		
		while (nortaichian.getHP() <= 65.0)
			nortaichian.attack();
		
		Assert.assertEquals(66, nortaichian.getHP(), 1.00);
	}
	
	@Test
	public void unNortaichianAlSerAtacadoMultiplicaPorDosSuDanioDe18() {
		
		// Queda con 10 de vida.
		nortaichian.receiveAttackFrom(new Radaiteran());
		
		Assert.assertEquals(10, nortaichian.getHP(), 0.0);
		
		Assert.assertEquals(36, nortaichian.attack(), 0.00);
	}
	
	@Test 
	public void elDanioDobleDelNortaichianSoloDuraDosTurnos() {
		
		Warrior radaiteran = new Radaiteran();
		
		nortaichian.receiveAttackFrom(radaiteran);
		
		Assert.assertEquals(36, nortaichian.attack(), 0.00);
		Assert.assertEquals(36, nortaichian.attack(), 0.00);
		
		Assert.assertEquals(18, nortaichian.attack(), 0.00);
	}
	
	@Test
	public void recuperaTodaSuVidaAlDescansar(){

		nortaichian.receiveAttackFrom(new Radaiteran());

		nortaichian.rest();

		Assert.assertEquals(66, nortaichian.getHP(), 0.00);
	}
	
	@Test
	public void alDescansarSeVuelvePiedraYRecibeMenosDanio() {
		
		nortaichian.rest();
		
		nortaichian.receiveAttackFrom(new Radaiteran());
		
		Assert.assertEquals(38, nortaichian.getHP(), 0.00);
	}
	
	@Test
	public void alDescansarSeVuelvePiedraYNoAtaca(){
		
		nortaichian.rest();
		
		Assert.assertEquals(0, nortaichian.attack(), 0.00);
	}
	
	// falta ataque de otras razas
}
