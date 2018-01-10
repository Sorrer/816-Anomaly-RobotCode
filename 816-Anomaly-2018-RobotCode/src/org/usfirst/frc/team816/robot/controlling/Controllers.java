package org.usfirst.frc.team816.robot.controlling;

import org.usfirst.frc.team816.robot.config.Config;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Used to allow easier passing of controllers
 */
public class Controllers{
	
	Joystick joy_1; // Left drive
	Joystick joy_2; // Right Drive

	
	ControllingType drivingType = ControllingType.DOUBLE_JOYSTICK_TANK;
	
	
	public Controllers(ControllingType driveType) {
		init();
	}
	
	private void init() {
		switch(drivingType) {
		
		case DOUBLE_JOYSTICK_TANK:
			joy_1 = new Joystick(Config.JOYSTICK_LEFT);
			joy_2 = new Joystick(Config.JOYSTICK_RIGHT);
			break;
		
		}
	}
	

	public GenericHID getDriveStickLeft() {
		switch(drivingType) {
		case DOUBLE_JOYSTICK_TANK:
			return joy_1;
		case NONE:
				return null;
		}
		return null;
	}
	
	public GenericHID getDriveStickRight() {
		switch(drivingType) {
		case DOUBLE_JOYSTICK_TANK:
			return joy_2;
		case NONE:
				return null;
		}
		
		return null;
	}
	
	
}
