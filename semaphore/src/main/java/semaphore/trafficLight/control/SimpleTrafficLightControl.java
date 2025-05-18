package semaphore.trafficLight.control;

import java.util.Timer;
import java.util.TimerTask;

import semaphore.TrafficLight;
import semaphore.util.TurnOnOff;

public class SimpleTrafficLightControl implements TrafficLightControl {

	private final TrafficLight trafficLight;
	private State state = State.OFF;
	private Timer timer = null;
	private final TurnOnOff green, red, yellow;
	
	
	public SimpleTrafficLightControl(TrafficLight trafficLight) {
		this.trafficLight = trafficLight;
		
		this.green = trafficLight.spotGreen();
		this.red = trafficLight.spotRed();
		this.yellow = trafficLight.spotYellow();
	}
	
	private void configureAlert() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask( ) {
			@Override
			public void run() {
				trafficLight.spotRed().turnOff();
				trafficLight.spotGreen().turnOff();
				
				if(trafficLight.spotYellow().isOn())
					trafficLight.spotRed().turnOff();
				else
					trafficLight.spotRed().turnOn();
			}
		}, 0, 1_000);
	}
	
	public void reset () {
		if (state == State.ALERT)
			stopAlert();
		
		green.turnOff(); 
		red.turnOff();
		yellow.turnOff();
		
		state = State.OFF;
	}
	
	private void stopAlert() {
		if(timer != null)
			timer.cancel();
		
		trafficLight.spotYellow().turnOff();
	}


	@Override
    public void turnAlert() {
        if(state == State.ALERT)
        	return;
		
        this.reset();
		this.configureAlert();
		state = State.ALERT;
    }



	@Override
	public void turnGreen() {
		if(state == State.ALERT)
        	stopAlert();
        
		this.reset();
		trafficLight.spotGreen().turnOn();
		state = State.GREEN;
		
	}


	@Override
	public void turnYellow() {
		
		if(state == State.ALERT)
        	stopAlert();
        
		this.reset();
		trafficLight.spotYellow().turnOn();
		state = State.YELLOW;
	
	}


	@Override
	public void turnRed() {
		
		if(state == State.ALERT)
        	stopAlert();
        
		this.reset();
        trafficLight.spotRed().turnOn();
		state = State.RED;
		
	}


	@Override
	public void turnOff() {
		this.reset();
		
	}
	
	
}


