package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;


public class RouteLineMidRight extends Route {


	public RouteLineMidRight() {
		
	}

	@Override
	public void init() {
		c.setFieldState("NNN");
		c.setStartinPosition(PositionState.CENTER);
		c.setGoal(Goal.RIGHT_LINE);
		
		this.setRouteID(RouteID.RouteLineMidRight);
	}
	
	
}
