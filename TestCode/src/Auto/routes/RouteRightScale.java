package Auto.routes;

import Auto.Conditions;
import Auto.Goal;
import Auto.PositionState;

public class RouteRightScale extends Route {

	

	
	public RouteRightScale() {
		
	}
	


	@Override
	public void init() {
		c.initCurrent();
		c = new Conditions();
		c.setFieldState("NRN");
		c.setStartinPosition(PositionState.RIGHT);
		c.setGoal(Goal.SCALE);
		
		this.setRouteID(RouteID.RouteRightScale);
	}
	
	
}
