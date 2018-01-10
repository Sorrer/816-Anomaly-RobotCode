package org.usfirst.frc.team816.robot;

public class AnomalyMaths {
	
	public static boolean withIn(double value, double target, double range) {
		if(value > (target - range) && value < (target + range)) {
			return true;
		}else {
			return false;
		}
	}
}
