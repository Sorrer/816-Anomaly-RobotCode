package org.usfirst.frc.team816.robot.config;

import org.usfirst.frc.team816.robot.controlling.ControllingType;
import org.usfirst.frc.team816.robot.drive.DriveType;
import org.usfirst.frc.team816.robot.drive.InvertState;
import org.usfirst.frc.team816.robot.drive.MotorType;

public class Config {

	public static DriveType MOTORS_CONFIG = DriveType.TWO_DRIVE;

	public static MotorType DRIVE_CONTROLLERS = MotorType.TALON;
	
	//PWM
	
	public static int DRIVETRAIN_LEFT_1 		= 0;
	public static InvertState DT_STATE_LEFT_1 	= InvertState.NORMAL; 
	
	public static int DRIVETRAIN_LEFT_2 		= 1;
	public static InvertState DT_STATE_LEFT_2	= InvertState.NORMAL; 
	
	public static int DRIVETRAIN_RIGHT_1 		= 2;
	public static InvertState DT_STATE_RIGHT_1 	= InvertState.NORMAL; 
	
	public static int DRIVETRAIN_RIGHT_2 		= 3;
	public static InvertState DT_STATE_RIGHT_2 	= InvertState.NORMAL; 
	
		
	
	
	//CONTROLLERS

	public static int JOYSTICK_LEFT 			= 0;
	public static int JOYSTICK_RIGHT 			= 1;

	public static double JOYSTICK_LEFT_DEADZONE 	= 0.05;
	public static double JOYSTICK_RIGHT_DEADZONE 	= 0.05;
	
	public static ControllingType DRIVE_TYPE 	= ControllingType.DOUBLE_JOYSTICK_TANK;
	
	public static int CONTROLLER 				= 2;
}
