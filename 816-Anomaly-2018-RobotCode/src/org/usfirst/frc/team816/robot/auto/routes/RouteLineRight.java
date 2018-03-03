package org.usfirst.frc.team816.robot.auto.routes;

import org.usfirst.frc.team816.robot.auto.Conditions;
import org.usfirst.frc.team816.robot.auto.Goal;
import org.usfirst.frc.team816.robot.auto.PositionState;

public class RouteLineRight extends Route {

	public RouteLineRight() {
		
	}

	

	@Override
	public void init() {
		c = new Conditions();
		c.initCurrent();
		c.setFieldState("NNN");
		c.setStartinPosition(PositionState.RIGHT);
		c.setGoal(Goal.RIGHT_LINE);
		
		this.setRouteID(RouteID.RouteLineRight);		
	}
	
	
}
