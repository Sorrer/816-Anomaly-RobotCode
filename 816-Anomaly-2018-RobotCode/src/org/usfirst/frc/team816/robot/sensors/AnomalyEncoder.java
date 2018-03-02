package org.usfirst.frc.team816.robot.sensors;

import org.usfirst.frc.team816.robot.config.SensorConfig;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;

public class AnomalyEncoder extends Sensor{
	
	Encoder encoder;
	
	//CPR OF MAG SRX ENCODERS AT 1024, WHICH IN PPR IS 256
	
	public AnomalyEncoder(SensorID EncoderID, int portA, int portB) {
		this.setSensorID(EncoderID);
		
		encoder = new Encoder(portA, portB, false, EncodingType.k1X);
		
		switch(this.getSensorID()) {
		case ENCODER1:
			encoder.setDistancePerPulse(SensorConfig.ENCODER_DISTANCE_PER_PULSE_1);
			break;
		default:
			encoder.setDistancePerPulse(SensorConfig.ENCODER_DISTANCE_PER_PULSE_1);
			break;
		}
		
	}
	
	public double getDistance() {
		return this.encoder.getDistance();
	}
	
	public void resetPosition() {
		this.encoder.reset();
	}
	
}
