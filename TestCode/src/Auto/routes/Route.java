package Auto.routes;

import Auto.Conditions;

public abstract class Route {

	Conditions c;
	RouteID id = RouteID.NONE;
	
	
	public abstract void init();
	
	public Conditions getConditions() {
		return c;
	}
	
	public void setConditions(Conditions c) {
		this.c = c;
	}
	
	public RouteID getID() {
		return id;
	}
	
	public void setRouteID(RouteID id) {
		this.id = id;
	}
}
	

