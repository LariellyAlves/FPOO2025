package semaphore.light.e27;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import semaphore.util.TurnOnOff;


class E27LightBulbTest {
	
	@Test
	void test() {
	fail("Not yet implemented");
	}
	
	
	

	@Test
	void shouldTurnOn() { 
		
		//given
		TurnOnOff light = new E27LightBulb();
		
	
		
		//do action
		light.turnOff();
		light.turnOn();
		
		
		//check
		
	assertTrue(light.isOn());
	}
	
	
	
	
	
	@Test
	void shouldTurnOff() { 
		
		//given
		TurnOnOff light = new E27LightBulb();
		
	
		
		//do action
		light.turnOn();
		light.turnOff();
		
		
		//check
		
	assertTrue(light.isOff());
	}

}
