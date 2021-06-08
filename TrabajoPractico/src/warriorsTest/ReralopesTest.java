package warriorsTest;

import org.junit.Assert;
import org.junit.Test;

import warriors.Reralopes;
import warriors.Warrior;
import weapons.Weapon;
import weapons.Catapult;

public class ReralopesTest {

    Warrior reralopes = new Reralopes();

    @Test
    public void unReralopesComienzaCon53DeVidaYUnaCatapulta() {
    	
        Assert.assertEquals(53, reralopes.getHP(), 0.0);
		
		Class<? extends Catapult> catapult = new Catapult().getClass();
		Class<? extends Weapon> esUnArmaDeReralopes = reralopes.getWeapon().getClass();
		
		Assert.assertEquals(catapult, esUnArmaDeReralopes);
    }

    @Test
	public void unReralopesOcasiona27DeDanioBase() {
		
		Assert.assertEquals(27, reralopes.attack());
	}

    // 27 por cada ataque
    // dsps de 4 hace 54

    @Test
    public void unReralopesErra2DeCada4AtaquesAUnNortaichian(){
        
    }
}