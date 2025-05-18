package semaphore.app;

import java.io.IOException;
import java.time.LocalTime;

import semaphore.control.simple.OneWaySemaphoreControl;
import semaphore.control.simple.SemaphoreControl;
import semaphore.trafficLight.simple.SimpleTrafficLight;
import semaphore.util.gui.MyWindow;
import semaphore.trafficLight.control.TrafficLightControl;
import semaphore.trafficLight.control.SimpleTrafficLightControl;

public class AppOneWaySimpleSemaphoreControlTest {

	static private
	void oneWaySimpleSemaphoreTest() throws IOException {
		
		SimpleTrafficLight defaultOne = new SimpleTrafficLight();
		TrafficLightControl trafficLightControl = new SimpleTrafficLightControl(defaultOne);
		SemaphoreControl semaphoreControl = new OneWaySemaphoreControl(trafficLightControl);
		
		semaphoreControl.setAlertPeriod(LocalTime.now(),
				                        LocalTime.now().plusSeconds(30));
		
		semaphoreControl.turnOn();
		
		MyWindow window = new MyWindow();
		window.add(defaultOne);
	}
	
	static public
	void main(String[] args) throws IOException {
		
		oneWaySimpleSemaphoreTest();
	}
	
}


