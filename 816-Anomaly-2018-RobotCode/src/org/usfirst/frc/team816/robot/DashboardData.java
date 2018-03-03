package org.usfirst.frc.team816.robot;

import org.usfirst.frc.team816.robot.auto.Goal;
import org.usfirst.frc.team816.robot.auto.PositionState;
import org.usfirst.frc.team816.robot.config.DashboardConfig;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DashboardData {
	
	private SendableChooser<PositionState> position_chooser = new SendableChooser<>();
	private SendableChooser<Goal> goal_chooser = new SendableChooser<>();
	
	
	
	boolean inited = false;
	
	public DashboardData() { init(); }
	
	public void init() {
		if(!inited) { inited = true; } else { System.out.println("Can not inited DashboardData twice!"); return; }

		position_chooser.addDefault(DashboardConfig.START_POSITION_NONE, PositionState.NONE);
		position_chooser.addObject(DashboardConfig.START_POSITION_LEFT, PositionState.LEFT);
		position_chooser.addObject(DashboardConfig.START_POSITION_LEFT_SWITCH, PositionState.LEFT_SWITCH);
		position_chooser.addObject(DashboardConfig.START_POSITION_CENTER, PositionState.CENTER);
		position_chooser.addObject(DashboardConfig.START_POSITION_RIGHT_SWITCH, PositionState.RIGHT_SWITCH);
		position_chooser.addObject(DashboardConfig.START_POSITION_RIGHT, PositionState.RIGHT);
		
		SmartDashboard.putData(position_chooser);

		goal_chooser.addDefault(DashboardConfig.GOAL_NONE, Goal.NONE);
		goal_chooser.addObject(DashboardConfig.GOAL_AUTOLINE, Goal.LINE);
		goal_chooser.addObject(DashboardConfig.GOAL_SWITCH, Goal.SWITCH);
		
		SmartDashboard.putData(goal_chooser);

		SmartDashboard.putNumber(DashboardConfig.AUTO_LINE_SPEED, 0.4);
		SmartDashboard.putNumber(DashboardConfig.AUTO_LINE_TIME, 5);
		
		SmartDashboard.putNumber(DashboardConfig.AUTO_SWITCH_INTAKE_OUTPUT_SPEED, 0.3);
		SmartDashboard.putNumber(DashboardConfig.AUTO_SWITCH_LIFT_HALT_SPEED, -0.2);
		SmartDashboard.putNumber(DashboardConfig.AUTO_SWITCH_LIFT_MOVING_SPEED, -0.5);
		SmartDashboard.putNumber(DashboardConfig.AUTO_SWITCH_LIFT_TIME, 3);
		SmartDashboard.putNumber(DashboardConfig.AUTO_SWITCH_MOVING_SPEED, 0.4);
		SmartDashboard.putNumber(DashboardConfig.AUTO_SWITCH_MOVING_TIME, 5);
		
		SmartDashboard.putBoolean(DashboardConfig.AUTO_ACTIVATED, true);
	}
	
	
	public PositionState getStartPosition() {
		return position_chooser.getSelected();
	}
	
	public Goal getGoal() {
		return goal_chooser.getSelected();
	}
	
	public boolean getAutoActivated() {
		return SmartDashboard.getBoolean(DashboardConfig.AUTO_ACTIVATED, true);
	}
	
	//AUTOLINE
	
	public double getAutoLineSpeed() {
		return SmartDashboard.getNumber(DashboardConfig.AUTO_LINE_SPEED, 0.4);
	}
	
	public double getAutoLineTime() {
		return SmartDashboard.getNumber(DashboardConfig.AUTO_LINE_TIME, 5);
	}
	
	//AUTO_SWITCH
	
	public double getAutoSwitchIntakeOutputSpeed() {
		return SmartDashboard.getNumber(DashboardConfig.AUTO_SWITCH_INTAKE_OUTPUT_SPEED, 0);
	}
	public double getAutoSwitchLiftHaltSpeed() {
		return SmartDashboard.getNumber(DashboardConfig.AUTO_SWITCH_LIFT_HALT_SPEED, 0);
	}
	public double getAutoSwitchLiftMovingSpeed() {
		return SmartDashboard.getNumber(DashboardConfig.AUTO_SWITCH_LIFT_MOVING_SPEED, 0);
	}
	public double getAutoSwitchLiftTime() {
		return SmartDashboard.getNumber(DashboardConfig.AUTO_SWITCH_LIFT_TIME, 0);
	}
	public double getAutoSwitchMovingSpeed() {
		return SmartDashboard.getNumber(DashboardConfig.AUTO_SWITCH_MOVING_SPEED, 0);
	}
	public double getAutoSwitchMovingTime() {
		return SmartDashboard.getNumber(DashboardConfig.AUTO_SWITCH_MOVING_TIME, 0);
	}

	//Gyro Heading
	
	public void setGyroHeading(double heading) {
		SmartDashboard.putNumber(DashboardConfig.GYRO_HEADING, heading);
	}
	
}
