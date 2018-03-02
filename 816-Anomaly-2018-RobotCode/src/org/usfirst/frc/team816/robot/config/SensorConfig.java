package org.usfirst.frc.team816.robot.config;

public class SensorConfig {

	public static int SRX_MAG_ENCODER_CPR = 1024;
	public static int SRX_MAG_ENCODER_PPR = SRX_MAG_ENCODER_CPR / 4;

	public static double DRIVE_WHEEL_DIAMETER = 6.0;
	public static double DRIVE_WHEEL_CIRCUMFERENCE = 6 * Math.PI;
	
	public static double ENCODER_GEAR_RATIO = 1/1;
	
	public static double ENCODER_DISTANCE_PER_PULSE_1 = SRX_MAG_ENCODER_PPR * (DRIVE_WHEEL_DIAMETER * ENCODER_GEAR_RATIO);
}
