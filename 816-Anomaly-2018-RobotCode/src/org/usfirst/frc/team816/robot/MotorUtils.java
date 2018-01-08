package org.usfirst.frc.team816.robot;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Talon;

public class MotorUtils {
	public static Talon createTalon(int port, InvertState state) {
		Talon temp_talon = new Talon(port);
		
		switch(state) {
		case INVERTED:
			temp_talon.setInverted(true);
			break;
			
		case NORMAL:
			temp_talon.setInverted(false);
			break;
		
		case DISABLED:
			//ERROR HANDLER HERE
			return null;
		}
		
		return temp_talon;
	}
	
	public static Spark createSpark(int port, InvertState state) {
		Spark temp_spark = new Spark(port);
		
		switch(state) {
		case INVERTED:
			temp_spark.setInverted(true);
			break;
			
		case NORMAL:
			temp_spark.setInverted(false);
			break;
		
		case DISABLED:
			//ERROR HANDLER HERE
			return null;
		}
		
		return temp_spark;
	}
}
