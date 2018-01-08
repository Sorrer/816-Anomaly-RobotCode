package org.usfirst.frc.team816.robot;

import org.usfirst.frc.team816.robot.config.PortConfig;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class AnomalyDrive {
	private DriveType type = DriveType.TANK_DRIVE;
	
	DifferentialDrive dDrive;

	SpeedControllerGroup talons_left;
	SpeedControllerGroup talons_right;
	
	SpeedControllerGroup sparks_left;
	SpeedControllerGroup sparks_right;
	
	Talon T_LEFT;
	Talon T_RIGHT;
	Talon T_LEFT_2;
	Talon T_RIGHT_2;
	
	Spark S_LEFT;
	Spark S_RIGHT;
	Spark S_LEFT_2;
	Spark S_RIGHT_2;
	
	
	/**
	 * Used to make our robot drive how we want it to drive
	 */
	public AnomalyDrive(DriveType type, Controllers controllers) {
		this.type = type;
	}
	
	public boolean init() {
		switch(type) {
		case TANK_DRIVE:
			switch(PortConfig.DRIVE_CONTROLLERS) {
			case TALON:
				dDrive = new DifferentialDrive(talons_left, talons_right);
				break;
			
			case SPARK:
				dDrive = new DifferentialDrive(sparks_left, sparks_right);
				break;
			}
			return true;
		case CUSTOM:
			
			break;
		}
		
		return false;
	}
	
	public void initSpeedControllers() {
			switch(PortConfig.MOTORS_CONFIG) {
			
			case TWO_DRIVE:
				
				switch(PortConfig.DRIVE_CONTROLLERS) {
					
				case TALON:
					T_LEFT = MotorUtils.createTalon(PortConfig.DRIVETRAIN_LEFT_1, PortConfig.DT_STATE_LEFT_1);
					T_RIGHT = MotorUtils.createTalon(PortConfig.DRIVETRAIN_RIGHT_1, PortConfig.DT_STATE_RIGHT_1);
					
					talons_left = new SpeedControllerGroup(T_LEFT);
					talons_right = new SpeedControllerGroup(T_RIGHT);
					break;
					
				case SPARK:
					S_LEFT = MotorUtils.createSpark(PortConfig.DRIVETRAIN_LEFT_1, PortConfig.DT_STATE_LEFT_1);
					S_RIGHT = MotorUtils.createSpark(PortConfig.DRIVETRAIN_RIGHT_1, PortConfig.DT_STATE_RIGHT_1);

					sparks_left = new SpeedControllerGroup(S_LEFT);
					sparks_right = new SpeedControllerGroup(S_RIGHT);					
					break;
					
				}
				
				return;
				
			case FOUR_DRIVE:

				switch(PortConfig.DRIVE_CONTROLLERS) {
					
				case TALON:
					
					T_LEFT = MotorUtils.createTalon(PortConfig.DRIVETRAIN_LEFT_1, PortConfig.DT_STATE_LEFT_1);
					T_LEFT_2 = MotorUtils.createTalon(PortConfig.DRIVETRAIN_LEFT_2, PortConfig.DT_STATE_LEFT_2);
					
					T_RIGHT = MotorUtils.createTalon(PortConfig.DRIVETRAIN_RIGHT_1, PortConfig.DT_STATE_RIGHT_1);
					T_RIGHT_2 = MotorUtils.createTalon(PortConfig.DRIVETRAIN_RIGHT_2, PortConfig.DT_STATE_RIGHT_2);

					talons_left = new SpeedControllerGroup(T_LEFT, T_LEFT_2);
					talons_right = new SpeedControllerGroup(T_RIGHT, T_RIGHT_2);
					break;
					
				case SPARK:
					S_LEFT = MotorUtils.createSpark(PortConfig.DRIVETRAIN_LEFT_1, PortConfig.DT_STATE_LEFT_1);
					S_LEFT_2 = MotorUtils.createSpark(PortConfig.DRIVETRAIN_LEFT_2, PortConfig.DT_STATE_LEFT_2);
					
					S_RIGHT = MotorUtils.createSpark(PortConfig.DRIVETRAIN_RIGHT_1, PortConfig.DT_STATE_RIGHT_1);
					S_RIGHT_2 = MotorUtils.createSpark(PortConfig.DRIVETRAIN_RIGHT_2, PortConfig.DT_STATE_RIGHT_2);

					sparks_left = new SpeedControllerGroup(S_LEFT, S_LEFT_2);
					sparks_right = new SpeedControllerGroup(S_RIGHT, S_RIGHT_2);					
					break;
					
				}
				return;
			}
			
	}
	

	
	public boolean run() {
		switch(type) {
		case TANK_DRIVE:
			return tank();
		case CUSTOM:
			return custom();
		}
		
		return false;
	}
	
	private boolean tank() {
		return false;
	}
	
	private boolean custom() {
		return false;
	}
	
}
