package org.usfirst.frc.team816.robot.auto.routes;

import org.usfirst.frc.team816.robot.auto.Conditions;
import org.usfirst.frc.team816.robot.auto.Goal;
import org.usfirst.frc.team816.robot.auto.PositionState;

public class RouteLeftSwitch extends Route{

	public RouteLeftSwitch() {
		
	}


	
	@Override
	public void init() {
	c = new Conditions();
	c.initCurrent();
	c.setFieldState("LNN");
	c.setStartinPosition(PositionState.LEFT);
	c.setGoal(Goal.SWITCH);
	
	this.setRouteID(RouteID.RouteLeftSwitch);
	}
	

}
