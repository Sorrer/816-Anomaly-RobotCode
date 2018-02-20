package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

public class RouteLineMidLeft extends Route {

	


	
	public RouteLineMidLeft() {
		
	}

	@Override
	public void init() {
		c.setFieldState("NNN");
		c.setStartinPosition(PositionState.CENTER);
		c.setGoal(Goal.LEFT_LINE);
		
		this.setRouteID(RouteID.RouteLineMidLeft);		
	}
	
}
