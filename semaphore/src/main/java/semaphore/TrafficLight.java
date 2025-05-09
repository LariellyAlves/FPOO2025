package semaphore;

import semaphore.util.TurnOnOff;

public interface TrafficLight {

	TurnOnOff spotGreen();
	TurnOnOff spotYellow();
	TurnOnOff spotRed();
	
	
}
