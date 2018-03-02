/**
 * Class that is the base of all sensors, provides required methods
 */

package org.usfirst.frc.team816.robot.sensors;

public abstract class Sensor {
	
	private SensorID sensorID = SensorID.UNKNOWN;
	
	
	public SensorID getSensorID() {
		return sensorID;
	}
	
	protected void setSensorID(SensorID id) {
		this.sensorID = id;
	}
}
