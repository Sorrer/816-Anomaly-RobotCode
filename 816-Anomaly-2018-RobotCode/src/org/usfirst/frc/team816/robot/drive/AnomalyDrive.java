package org.usfirst.frc.team816.robot.drive;

import org.usfirst.frc.team816.robot.AnomalyMaths;
import org.usfirst.frc.team816.robot.config.Config;
import org.usfirst.frc.team816.robot.controlling.Controllers;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class AnomalyDrive {
	private DriveType type = Config.MOTORS_CONFIG;
	
	DifferentialDrive dDrive;

	SpeedControllerGroup talons_left;
	SpeedControllerGroup talons_right;
	
	SpeedControllerGroup sparks_left;
	SpeedControllerGroup sparks_right;
	
	SpeedControllerGroup maxs_left;
	SpeedControllerGroup maxs_right;

	Talon T_LEFT;
	Talon T_RIGHT;
	Talon T_LEFT_2;
	Talon T_RIGHT_2;
	
	Spark S_LEFT;
	Spark S_RIGHT;
	Spark S_LEFT_2;
	Spark S_RIGHT_2;

	CANSparkMax SM_LEFT;
	CANSparkMax SM_RIGHT;
	CANSparkMax SM_LEFT_2;
	CANSparkMax SM_RIGHT_2;
	
	boolean inited = false;
	
	Controllers controllers;
	
	/**
	 * Used to make our robot drive how we want it to drive
	 */
	public AnomalyDrive(DriveType type, Controllers controllers) {
		this.type = type;
		
		this.controllers = controllers;
	}
	
	public boolean init() {
		
		if(!inited) { inited = true; } else { System.err.println("Init already executed, shouldn't call twice;");return false;}
		
		switch(type) {
		case TANK_DRIVE:
			switch(Config.DRIVE_CONTROLLERS) {
			case TALON:
				dDrive = new DifferentialDrive(talons_left, talons_right);
				dDrive.setSafetyEnabled(false);
				break;
			
			case SPARK:
				dDrive = new DifferentialDrive(sparks_left, sparks_right);
				dDrive.setSafetyEnabled(false);
				break;
			case SPARKMAX:
				dDrive = new DifferentialDrive(maxs_left, maxs_right);
				dDrive.setSafetyEnabled(false);
				break;
			}
			return true;
		case TWO_DRIVE:
			switch(Config.DRIVE_CONTROLLERS) {
			case TALON:
				dDrive = new DifferentialDrive(talons_left, talons_right);
				dDrive.setSafetyEnabled(false);
				break;
			case SPARK:
				dDrive = new DifferentialDrive(sparks_left, sparks_right);
				dDrive.setSafetyEnabled(false);
				break;
			case SPARKMAX:
				dDrive = new DifferentialDrive(maxs_left, maxs_right);
				dDrive.setSafetyEnabled(false);
				break;
			}
			return true;
		case CUSTOM:
			
			break;
		}
		
		return false;
	}
	
	public void initSpeedControllers() {
			switch(Config.MOTORS_CONFIG) {
			
			case TWO_DRIVE:
				
				switch(Config.DRIVE_CONTROLLERS) {
					
				case TALON:
					T_LEFT = MotorUtils.createTalon(Config.DRIVETRAIN_LEFT_1, Config.DT_STATE_LEFT_1);
					T_RIGHT = MotorUtils.createTalon(Config.DRIVETRAIN_RIGHT_1, Config.DT_STATE_RIGHT_1);
					
					talons_left = new SpeedControllerGroup(T_LEFT);
					talons_right = new SpeedControllerGroup(T_RIGHT);
					break;
					
				case SPARK:
					S_LEFT = MotorUtils.createSpark(Config.DRIVETRAIN_LEFT_1, Config.DT_STATE_LEFT_1);
					S_RIGHT = MotorUtils.createSpark(Config.DRIVETRAIN_RIGHT_1, Config.DT_STATE_RIGHT_1);

					sparks_left = new SpeedControllerGroup(S_LEFT);
					sparks_right = new SpeedControllerGroup(S_RIGHT);					
					break;

				case SPARKMAX:
					maxs_left  = new SpeedControllerGroup(SM_LEFT, SM_LEFT_2);
					maxs_right  = new SpeedControllerGroup(SM_RIGHT, SM_RIGHT_2);
					break;
				}
				
				return;
				
			case FOUR_DRIVE:

				switch(Config.DRIVE_CONTROLLERS) {
					
				case TALON:
					
					T_LEFT = MotorUtils.createTalon(Config.DRIVETRAIN_LEFT_1, Config.DT_STATE_LEFT_1);
					T_LEFT_2 = MotorUtils.createTalon(Config.DRIVETRAIN_LEFT_2, Config.DT_STATE_LEFT_2);
					
					T_RIGHT = MotorUtils.createTalon(Config.DRIVETRAIN_RIGHT_1, Config.DT_STATE_RIGHT_1);
					T_RIGHT_2 = MotorUtils.createTalon(Config.DRIVETRAIN_RIGHT_2, Config.DT_STATE_RIGHT_2);

					talons_left = new SpeedControllerGroup(T_LEFT, T_LEFT_2);
					talons_right = new SpeedControllerGroup(T_RIGHT, T_RIGHT_2);
					break;
					
				case SPARK:
					S_LEFT = MotorUtils.createSpark(Config.DRIVETRAIN_LEFT_1, Config.DT_STATE_LEFT_1);
					S_LEFT_2 = MotorUtils.createSpark(Config.DRIVETRAIN_LEFT_2, Config.DT_STATE_LEFT_2);
					
					S_RIGHT = MotorUtils.createSpark(Config.DRIVETRAIN_RIGHT_1, Config.DT_STATE_RIGHT_1);
					S_RIGHT_2 = MotorUtils.createSpark(Config.DRIVETRAIN_RIGHT_2, Config.DT_STATE_RIGHT_2);

					sparks_left = new SpeedControllerGroup(S_LEFT, S_LEFT_2);
					sparks_right = new SpeedControllerGroup(S_RIGHT, S_RIGHT_2);					
					break;
					
				case SPARKMAX:
					SM_LEFT = MotorUtils.createMax(1, MotorType.kBrushless, Config.DT_STATE_LEFT_1);
					SM_LEFT_2 = MotorUtils.createMax(2, MotorType.kBrushless, Config.DT_STATE_LEFT_2);
					
					SM_RIGHT = MotorUtils.createMax(3, MotorType.kBrushless, Config.DT_STATE_RIGHT_1);
					SM_RIGHT_2 = MotorUtils.createMax(4, MotorType.kBrushless, Config.DT_STATE_RIGHT_2);

					maxs_left  = new SpeedControllerGroup(SM_LEFT, SM_LEFT_2);
					maxs_right  = new SpeedControllerGroup(SM_RIGHT, SM_RIGHT_2);
				}

				
				return;
			}
			
	}
	

	
	public boolean run() {
		switch(type) {
		case TANK_DRIVE:
			return tank();
		case TWO_DRIVE:
			return tank();
		case CUSTOM:
			return custom();
		}
		
		return false;
	}
	
	/**
	 * Used for auto
	 * @return DifferentialDrive Drive
	 */
	public DifferentialDrive getDrive() {
		if(this.dDrive == null) {
			System.err.println("AnomalyDrive class is not init");
		}
		return this.dDrive;
	}
	
	
	private boolean tank() {
		
		GenericHID leftStick = controllers.getDriveStickLeft();
		GenericHID rightStick = controllers.getDriveStickRight();
		
		
		double vLeft = leftStick.getY();
		double vRight = rightStick.getY();
		
		if(leftStick.getRawButton(Config.DRIVING_TURBO_MODE_BUTTON) || 
			rightStick.getRawButton(Config.DRIVING_TURBO_MODE_BUTTON)) {
			
			vLeft = leftStick.getY();
			vRight = rightStick.getY();
			
			if(AnomalyMaths.withIn(vLeft, 0, Config.JOYSTICK_LEFT_DEADZONE)) {
				vLeft = 0;
			}
			if(AnomalyMaths.withIn(vRight, 0, Config.JOYSTICK_RIGHT_DEADZONE)) {
				vRight = 0;
			}
			

			vLeft *= 0.75;
			vRight *= 0.75;
			
		}else {
		
		vLeft = leftStick.getY();
		vRight = rightStick.getY();
		
		//vLeft = curveLeftDrive.convert(vLeft);
		//vRight = curveRightDrive.convert(vRight);
		
		
		if(AnomalyMaths.withIn(vLeft, 0, Config.JOYSTICK_LEFT_DEADZONE)) {
			vLeft = 0;
		}
		
		if(AnomalyMaths.withIn(vRight, 0, Config.JOYSTICK_RIGHT_DEADZONE)) {
			vRight = 0;
		}
		
//		vLeft *= 0.75;
//		vRight *= 0.75;
		
		}
		
		dDrive.tankDrive(-vLeft, -vRight);
		
		return true;
	}
	
	public void manualTank(double left, double right) {
		if(this.dDrive == null) {
			System.err.println("Can't manual drive, TANK DRIVE is not inited OR AnomalyDrive is in use!");
			return;
		}else {
			dDrive.tankDrive(-left, -right);
		}
	}
	
	private boolean custom() {
		return false;
	}
	
}
