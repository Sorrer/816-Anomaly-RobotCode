package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

public class RouteLineLeft extends Route {

	
	
	

	public RouteLineLeft() {
		
	}


	
	@Override
	public void init() {
		c = new Conditions();
		c.setFieldState("NNN");
		c.setStartinPosition(PositionState.LEFT);
		c.setGoal(Goal.LINE);
		
		this.setRouteID(RouteID.RouteLeftSwitch);		
	}
	
}
