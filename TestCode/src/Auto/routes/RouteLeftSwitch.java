package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

public class RouteLeftSwitch extends Route{

	public RouteLeftSwitch() {
		
	}


	
	@Override
	public void init() {
	c = new Conditions();
	c.setFieldState("LNN");
	c.setStartinPosition(PositionState.LEFT);
	c.setGoal(Goal.SWITCH);
	
	this.setRouteID(RouteID.RouteLeftSwitch);
	}
	

}
