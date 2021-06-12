package warriorsTest;

import org.junit.Assert;
import org.junit.Test;

import warriors.Reralopes;
import warriors.TestBuddy;
import warriors.Warrior;
import weapons.Weapon;
import weapons.Catapult;

public class ReralopesTest {

	Warrior reralopes = new Reralopes();
	Warrior testBuddy = new TestBuddy();

	@Test
	public void unReralopesComienzaCon53DeVidaYUnaCatapulta() {

		Assert.assertEquals(53, reralopes.getHealthPoints(), 0.01);

		Class<? extends Catapult> catapult = new Catapult().getClass();
		Class<? extends Weapon> esUnArmaDeReralopes = reralopes.getWeapon().getClass();

		Assert.assertEquals(catapult, esUnArmaDeReralopes);
	}

	// 27 por cada ataque
	// dsps de 4 hace 54

	@Test
	public void unReralopesErra2DeCada4AtaquesAUnNortaichianHaciendo54DeDanio() {

		for (int i = 0; i < 4; i++)
			reralopes.attack(testBuddy);

		// 500 - 54 = 446
		Assert.assertEquals(446, testBuddy.getHealthPoints(), 0.01);
	}

	@Test
	public void unReralopesDespuesDeDescanzarHaceDanioDoblePorTresTurnos() {

		// 27 * 2 = 54
		// para probarlo de manera correcta, hacemos que ataque 8 veces, haciendo un
		// "hit" normal despues de haber hecho 3 con mas poder, haciendo un total de
		// (27*2)*3+27 = 189

		reralopes.rest();

		for (int i = 0; i < 8; i++)
			reralopes.attack(testBuddy);

		// 500 - 189 = 311
		Assert.assertEquals(311, testBuddy.getHealthPoints(), 0.01);
	}

	@Test
	public void unReralopesNoHaceDanioDobleSiEsAtacado() {

		// para probar esto, primero confirmaremos que ataque dos veces con da�o doble,
		// despues sera atacado y no hara da�o doble, sino que sus proximos dos ataques
		// seran normales
		
		reralopes.rest();
		
		for(int i = 0; i < 4; i++)
			reralopes.attack(testBuddy);
		
		// 500 - (27*2)*2 = 500 - 108 = 392
		Assert.assertEquals(392, testBuddy.getHealthPoints(), 0.01);
		
		reralopes.receiveAttack(10);
		
		for(int i = 0; i < 4; i++)
			reralopes.attack(testBuddy);
		
		// ahora debe atacar con da�o normal
		// 392 - 27*2 = 392 - 54 = 338
		Assert.assertEquals(338, testBuddy.getHealthPoints(), 0.01);
	}
	
	@Test
	public void siUnReralopesEsAtacadoAntesDeHacerDanioDobleHaceDanioNormal() {
		
		reralopes.rest();
		
		reralopes.receiveAttack(10);
		
		for(int i = 0; i < 4; i++)
			reralopes.attack(testBuddy);
		
		Assert.assertEquals(446, testBuddy.getHealthPoints(), 0.01);
	}
}