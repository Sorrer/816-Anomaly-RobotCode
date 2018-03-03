package org.usfirst.frc.team816.robot.auto;

import java.util.ArrayList;

import org.usfirst.frc.team816.robot.auto.routes.Route;
import org.usfirst.frc.team816.robot.auto.routes.RouteID;
import org.usfirst.frc.team816.robot.auto.routes.RouteLeftSwitch;
import org.usfirst.frc.team816.robot.auto.routes.RouteLineLeft;
import org.usfirst.frc.team816.robot.auto.routes.RouteLineRight;
import org.usfirst.frc.team816.robot.auto.routes.RouteRightSwitch;


public class AutoPath {
	
	Route route;
//	RouteLeftScale route_left_scale;
	RouteLeftSwitch route_left_switch;
	RouteLineLeft route_line_left;
//	RouteLineMidLeft route_line_mid_left;
//	RouteLineMidRight route_line_mid_right;
	RouteLineRight route_line_right;
//	RouteRightScale route_right_scale;
	RouteRightSwitch route_right_switch;
//	RouteScaleMidLeft route_scale_mid_left;
//	RouteScaleMidRight route_scale_mid_right;
//	RouteSwitchMidLeft route_switch_mid_left;
//	RouteScaleMidLeft route_switch_mid_right;
	
	ArrayList<Route> routes = new ArrayList<Route>();
	
	public AutoPath() {
		
	}
	
	public void init() {
		
		route_left_switch = new RouteLeftSwitch();
		route_line_left = new RouteLineLeft();
		route_right_switch = new RouteRightSwitch();
		route_line_right = new RouteLineRight();
//		route_left_scale = new RouteLeftScale();
//		route_line_mid_left = new RouteLineMidLeft();
//		route_line_mid_right = new RouteLineMidRight();
//		route_right_scale = new RouteRightScale();
//		route_scale_mid_left = new RouteScaleMidLeft();
//		route_scale_mid_right = new RouteScaleMidRight();
//		route_switch_mid_left = new RouteSwitchMidLeft();
//		route_switch_mid_right = new RouteScaleMidLeft();
		
	

	}
	
	public void setRouteList() {
		
		routes.add(route_left_switch);
		routes.add(route_right_switch);
		routes.add(route_line_left);
		routes.add(route_line_right);
//		routes.add(route_left_scale);
//		routes.add(route_line_mid_left);
//		routes.add(route_line_mid_right);
//		routes.add(route_scale_mid_left);
//		routes.add(route_scale_mid_right);
//		routes.add(route_switch_mid_left);
//		routes.add(route_switch_mid_right);
//		routes.add(route_right_scale);
	}
	
	
	
	
	public RouteID pathfind(Conditions currentC) {
		
		for(Route route : routes) {
			route.init();
			if (currentC.compareConditionsList(route.getConditions())) {
				return route.getID();
			}
		}
			if ((currentC.sp == PositionState.LEFT || currentC.sp == PositionState.RIGHT) && currentC.g != Goal.NONE)
			{
				return RouteID.RouteAutoLine;
			}
		return RouteID.NONE;
		
	}

	
}




// true RouteID.NONE
/* false null
*
*
*
*
*
*
*
*
*
*
*/








/*
* 
		 * NOT OPTImIZE BUT WE CAN OPTIMIZE LATER, IS FINE
		 * 
		 * for(ItemType itemVar1 : listOfItems){
		 * 	boolean correct = false;
		 * 	for(ItemType itemVar2 : listOffItems){
		 * 		if(itemVar1.compareConditions(itemVar2)){
		 * 			correct = true;
		 * 			break;
		 * 		}
		 * 	}
		 * 	
		 * if(correct){
		 * }else{
		 * return false;
		 * }
		 * 	return true;
		 * }
*/