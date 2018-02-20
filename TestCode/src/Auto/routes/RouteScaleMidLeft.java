package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

public class RouteScaleMidLeft extends Route {


	
	public RouteScaleMidLeft() {
		
	}

	@Override
	public void init() {
		c = new Conditions();
		c.setFieldState("NLN");
		c.setStartinPosition(PositionState.CENTER);
		c.setGoal(Goal.SCALE);
		
		this.setRouteID(RouteID.RouteScaleMidLeft);		
	}
	

}
