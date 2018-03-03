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
	}
	
	
	public PositionState getStartPosition() {
		return position_chooser.getSelected();
	}
	
	public Goal getGoal() {
		return goal_chooser.getSelected();
	}
	
}
