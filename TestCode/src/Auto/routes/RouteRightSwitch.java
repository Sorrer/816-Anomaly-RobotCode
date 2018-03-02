package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

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
