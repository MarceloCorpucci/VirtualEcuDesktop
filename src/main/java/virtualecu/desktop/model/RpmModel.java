package virtualecu.desktop.model;

import virtualecu.core.interfaces.Pluggable;
import virtualecu.core.interfaces.USBConnector;

public class RpmModel {
	private Pluggable usbConnector;
	private float tpsAngle;
	
	public RpmModel() {
		this.usbConnector = new USBConnector();
		this.usbConnector.connectToInputBus();
		this.usbConnector.connectToMainBus();
	}
	
	public void setTpsAngle(int value) {
		 this.tpsAngle = value;
	}
	
	public double showGaugePointerRpms() {
//		String[] message = usbConnector.informRpms(this.tpsAngle);
//		double formatedRpm = Float.parseFloat(message[3]) / 1000.0f;
		double rpms = Double.parseDouble(getRpmCalculation()) / 1000;
		return rpms;
	}
	
	public double showGaugeLcdRpms() {
		return Double.parseDouble(getRpmCalculation());
	}
	
	private String getRpmCalculation() {
		String[] message = usbConnector.informRpms(this.tpsAngle);
		return message[3];
	}
}
