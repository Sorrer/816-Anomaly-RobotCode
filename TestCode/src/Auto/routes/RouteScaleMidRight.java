package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

public class RouteScaleMidRight extends Route {
	

	
	public RouteScaleMidRight() {
		
	}


	@Override
	public void init() {
		c = new Conditions();
		c.initCurrent();
		c.setFieldState("NRN");
		c.setStartinPosition(PositionState.CENTER);
		c.setGoal(Goal.SCALE);
		
		this.setRouteID(RouteID.RouteScaleMidRight);		
	}
	


}
