package Auto.routes;

import Auto.Conditions;

public abstract class Route {
	
	protected Conditions conditions;
	
	public Conditions getConditions() {
		return this.conditions;
	}
	
}
