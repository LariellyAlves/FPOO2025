package semaphore.light;

public class SimpleLight implements Light {

	private OnOff state = OnOff.OFF;
	
	@Override
	public void turnOn() {
		this.state = OnOff.ON;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnOff() {
		this.state = OnOff.OFF;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOn() {
		return this.state == OnOff.ON;
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOff() {
		// TODO Auto-generated method stub
		return this.state == OnOff.OFF;
	}

}
