package org.usfirst.frc.team816.robot.auto.routes;

import org.usfirst.frc.team816.robot.auto.Conditions;
import org.usfirst.frc.team816.robot.auto.Goal;
import org.usfirst.frc.team816.robot.auto.PositionState;

public class RouteLineLeft extends Route {

	
	
	

	public RouteLineLeft() {
		
	}


	
	@Override
	public void init() {
		c = new Conditions();
		c.initCurrent();
		c.setFieldState("NNN");
		c.setStartinPosition(PositionState.LEFT);
		c.setGoal(Goal.LINE);
		
		this.setRouteID(RouteID.RouteLeftSwitch);		
	}
	
}
