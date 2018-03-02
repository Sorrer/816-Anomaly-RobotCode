package org.usfirst.frc.team816.robot.config;

import org.usfirst.frc.team816.robot.controlling.ControllingType;
import org.usfirst.frc.team816.robot.drive.DriveType;
import org.usfirst.frc.team816.robot.drive.InvertState;
import org.usfirst.frc.team816.robot.drive.MotorType;

public class Config {

	public static DriveType MOTORS_CONFIG = DriveType.TWO_DRIVE;

	public static MotorType DRIVE_CONTROLLERS = MotorType.TALON;
	
	//PWM
	
	public static int DRIVETRAIN_LEFT_1 		= 1;
	public static InvertState DT_STATE_LEFT_1 	= InvertState.INVERTED; 
	
	public static int DRIVETRAIN_LEFT_2 		= -1;
	public static InvertState DT_STATE_LEFT_2	= InvertState.INVERTED; 
	
	public static int DRIVETRAIN_RIGHT_1 		= 0;
	public static InvertState DT_STATE_RIGHT_1 	= InvertState.INVERTED; 
	
	public static int DRIVETRAIN_RIGHT_2 		= -1;
	public static InvertState DT_STATE_RIGHT_2 	= InvertState.INVERTED; 
	
		
	
	
	//CONTROLLERS

	public static int JOYSTICK_LEFT 			= 0;
	public static int JOYSTICK_RIGHT 			= 1;

	public static double JOYSTICK_LEFT_DEADZONE 	= 0.01;
	public static double JOYSTICK_RIGHT_DEADZONE 	= 0.01;
	
	public static ControllingType DRIVE_TYPE 	= ControllingType.DOUBLE_JOYSTICK_TANK;
	
	public static int CONTROLLER 				= 2;
	
	public static int DRIVING_PERCISION_MODE_BUTTON = 1;
	
	//DRIVE
	
	//Calculate Required CurveTimings
	
		//Time to get from 0% - 100% in MilliSeconds
	private static int fullPowerTargetTiming = 400;
	
	//Curve variables
		
	//Amount of progression per increment
public static float CURVE_INCREMENTS_AMOUNT = 0.01f;

	//MS Between the curve
public static int CURVE_INCREMENTS_TIMING =  (int) ( fullPowerTargetTiming/(1 / CURVE_INCREMENTS_AMOUNT));

	//How the curve should be using exponents
public static float CURVE_AMOUNT = 2f;
	
}
