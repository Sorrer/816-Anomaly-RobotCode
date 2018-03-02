package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

public class RouteSwitchMidLeft extends Route{


	
	public RouteSwitchMidLeft() {
		
	}
	


	@Override
	public void init() {
		c = new Conditions();
		c.setFieldState("LNN");
		c.setStartinPosition(PositionState.CENTER);
		c.setGoal(Goal.SWITCH);
		
		this.setRouteID(RouteID.RouteSwitchMidLeft);		
	}
	

}
