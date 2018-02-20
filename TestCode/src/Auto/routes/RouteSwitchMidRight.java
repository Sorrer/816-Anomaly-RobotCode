package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

public class RouteSwitchMidRight extends Route {

	
	public RouteSwitchMidRight() {
		
	}

	@Override
	public void init() {
		c = new Conditions();
		c.setFieldState("NLN");
		c.setStartinPosition(PositionState.LEFT);
		c.setGoal(Goal.SCALE);
		
		this.setRouteID(RouteID.RouteSwitchMidRight);		
	}
	

}
