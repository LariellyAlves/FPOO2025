package semaphore.control.simple;

import java.time.LocalTime;
import java.util.Arrays;

import semaphore.trafficLight.control.TrafficLightControl;
import semaphore.util.TurnOnOff;

public interface SemaphoreControl extends TurnOnOff{
	
	void setGreenSeconds(int seconds);
	void setYellowseconds(int seconds);
	void setRedseconds(int seconds);
	
	void setAlertPeriod(LocalTime start, LocalTime end);

}




