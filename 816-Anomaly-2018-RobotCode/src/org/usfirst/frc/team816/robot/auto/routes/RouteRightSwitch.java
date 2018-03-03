package org.usfirst.frc.team816.robot.auto.routes;

import org.usfirst.frc.team816.robot.auto.Conditions;
import org.usfirst.frc.team816.robot.auto.Goal;
import org.usfirst.frc.team816.robot.auto.PositionState;

public class RouteRightSwitch extends Route {


	
	public RouteRightSwitch() {
		
	}


	@Override
	public void init() {
		c = new Conditions();
		c.setFieldState("RNN");
		c.setStartinPosition(PositionState.RIGHT);
		c.setGoal(Goal.SWITCH);
		
		this.setRouteID(RouteID.RouteRightSwitch);
	}
	

}
