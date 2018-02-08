package Auto;

import java.util.ArrayList;

import Auto.routes.TempRoute;

public class Route {
	Conditions conditions;
	Conditions route_conditions;
	
	
		
	
	public Route(){
		
	}
	
	public void	initConditions() {
		conditions = new Conditions();
		conditions.setStartingPos(); // note to self : should set the pos for robot start, switch, and scale
									// ask if there is way to change class on fly
		
		
	}
	
	
	public void getRoute() {
		if (conditions.compareList(route_conditions)) {  // null = route conditions
			
		}
		
	}
	
	
	
	
}
