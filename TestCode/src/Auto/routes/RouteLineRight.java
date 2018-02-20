package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

public class RouteLineRight extends Route {

	public RouteLineRight() {
		
	}

	@Override
	public void init() {
		c.setFieldState("NNN");
		c.setStartinPosition(PositionState.RIGHT);
		c.setGoal(Goal.RIGHT_LINE);
		
		this.setRouteID(RouteID.RouteLineRight);		
	}
	
	
}
