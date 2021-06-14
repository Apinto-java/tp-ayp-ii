package warriorsTest;

import org.junit.Assert;
import org.junit.Test;

import warriors.Nortaichian;
import warriors.Warrior;
import weapons.Bow;
import weapons.Weapon;

public class NortaichianTest {

	Warrior nortaichian = new Nortaichian();
	Warrior testBuddy = new TestBuddy();

	@Test
	public void unNortaichianComienzaCon66DeVidaYUnBow() {

		Assert.assertEquals(66, nortaichian.getHealthPoints(), 0.01);

		Class<? extends Bow> bow = new Bow().getClass();
		Class<? extends Weapon> esUnArmaDeNortaichian = nortaichian.getWeapon().getClass();

		Assert.assertEquals(bow, esUnArmaDeNortaichian);
	}

	@Test
	public void unNortaichianOcasiona18DeDanioBase() {

		// HP testBuddy = 500
		// 500 - 18 = 482
		nortaichian.attack(testBuddy);

		Assert.assertEquals(482, testBuddy.getHealthPoints(), 0.01);
	}

	@Test
	public void unNortaichianRecuperaSaludAlAtacar() {

		// Queda con 10 de vida.
		nortaichian.receiveAttack(56);

		Assert.assertEquals(10, nortaichian.getHealthPoints(), 0.01);

		nortaichian.attack(testBuddy);

		Assert.assertEquals(12.64, nortaichian.getHealthPoints(), 0.01);
	}

	@Test
	public void unNortaichianSeRecuperaCompletamenteAtacando() {

		// Queda con 10 de vida.
		nortaichian.receiveAttack(56);

		Assert.assertEquals(10, nortaichian.getHealthPoints(), 0.0);

		while (nortaichian.getHealthPoints() <= 65.0) {

			if (testBuddy.getHealthPoints() <= 0)
				testBuddy = new TestBuddy();

			nortaichian.attack(testBuddy);
		}
		Assert.assertEquals(66, nortaichian.getHealthPoints(), 1.00);
	}

	@Test
	public void unNortaichianAlSerAtacadoMultiplicaPorDosSuDanioDe18() {

		// Queda con 10 de vida.
		nortaichian.receiveAttack(56);

		Assert.assertEquals(10, nortaichian.getHealthPoints(), 0.0);

		nortaichian.attack(testBuddy);

		// 500 - 18*2 = 500 - 36 = 464
		Assert.assertEquals(464, testBuddy.getHealthPoints(), 0.00);
	}

	@Test
	public void elDanioDobleDelNortaichianSoloDuraDosTurnos() {

		nortaichian.receiveAttack(10);

		nortaichian.attack(testBuddy);

		Assert.assertEquals(464, testBuddy.getHealthPoints(), 0.00);

		nortaichian.attack(testBuddy);

		// 464 - 36 = 428
		Assert.assertEquals(428, testBuddy.getHealthPoints(), 0.00);

		nortaichian.attack(testBuddy);

		// 428 - 18 = 410
		Assert.assertEquals(410, testBuddy.getHealthPoints(), 0.00);
	}

	@Test
	public void recuperaTodaSuVidaAlDescansar() {

		nortaichian.receiveAttack(10);

		nortaichian.rest();

		Assert.assertEquals(66, nortaichian.getHealthPoints(), 0.00);
	}

	@Test
	public void alDescansarSeVuelvePiedraYRecibeMenosDanio() {

		nortaichian.rest();

		nortaichian.receiveAttack(10);

		// 66 - 10/2 = 66 - 5 = 61
		Assert.assertEquals(61, nortaichian.getHealthPoints(), 0.00);
	}

	@Test
	public void alDescansarSeVuelvePiedraYNoAtaca() {

		nortaichian.rest();

		nortaichian.attack(testBuddy);

		Assert.assertEquals(500, testBuddy.getHealthPoints(), 0.00);
	}

	@Test
	public void elDanioDobleDelNortaichianNoSeRecuperaSiNoSeAgoto() {

		nortaichian.receiveAttack(10);

		nortaichian.attack(testBuddy);

		Assert.assertEquals(464, testBuddy.getHealthPoints(), 0.00);

		nortaichian.receiveAttack(10);

		nortaichian.attack(testBuddy);

		// 464 - 36 = 428
		Assert.assertEquals(428, testBuddy.getHealthPoints(), 0.00);

		nortaichian.attack(testBuddy);

		// 428 - 18 = 410
		Assert.assertEquals(410, testBuddy.getHealthPoints(), 0.00);
	}

	@Test
	public void elNortaichianDePiedraDuraSoloDosTurnos() {

		nortaichian.rest();

		nortaichian.receiveAttack(10);

		// recibe mitad del da�o
		Assert.assertEquals(61, nortaichian.getHealthPoints(), 0.00);

		nortaichian.attack(testBuddy);

		// no recibe ataque
		Assert.assertEquals(500, testBuddy.getHealthPoints(), 0.01);

		nortaichian.receiveAttack(10);

		// recibe mitad del da�o
		Assert.assertEquals(56, nortaichian.getHealthPoints(), 0.00);

		nortaichian.attack(testBuddy);

		// no recibe ataque, termina el estado de piedra
		Assert.assertEquals(500, testBuddy.getHealthPoints(), 0.01);
		
		nortaichian.receiveAttack(10);

		// recibe el da�o completo
		Assert.assertEquals(46, nortaichian.getHealthPoints(), 0.00);

		nortaichian.attack(testBuddy);

		// al recibir da�o, activa su poder de da�ar doble
		Assert.assertEquals(464, testBuddy.getHealthPoints(), 0.01);
	}

	// falta ataque de otras razas
}
