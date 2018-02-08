package org.usfirst.frc.team816.robot.auto;

import java.util.ArrayList;

public class AutoPath {
	FieldState fieldState;
	PositionState allySwitch = fieldState.getAllySwitch();
	PositionState scale = fieldState.getScale();
	PositionState robotStart = fieldState.getStartingPosition();
	boolean autoLine;
	
	public AutoPath() {
		
	}
	
	public void init(FieldState field) {
		this.fieldState = field;
	}
	

	public void route() {
		if(autoLine) {
			if (robotStart == PositionState.LEFT) {
				 
			}
			else if (robotStart == PositionState.CENTER) {
				
			}
			else {
				
			}
		}
		/*
		 * Route: Left Scale Start Pos Left
		 * Pre Req: 
		 * 	-AutoLine = false
		 *  -Scale = Ours
		 *  -Startinposition = GOod
		 *  ..
		 *  
		 *  
		 */
		
		
		/*_____ROUTEEE
		 * 
		 * Conditions conditions;
		 * 
		 * 
		 * public route(){
		 * 
		 * }
		 * 
		 * public void initConditions(){
		 * 		conditions = new Conditions();
		 * 
		 * 		conditions.setStartingPos(PositionState.START1, PositionState.START2);
		 * }
		 * 
		 * 
		 *______THIS IS A ConditionClass (Can be used to define required conditions or current value conditons
		 * 
		 * ArrayList<PositionState> starting_positions = new ArrayList<PositionState>();
		 * 
		 * public conditions(){
		 * 
		 * }
		 * 
		 * public void setStartingPos(PositionState... states){
		 * 		for(PositionState state : states){
		 * 			starting_positions.add(state);
		 * 		}
		 * }
		 * 
		 * public ArrayList<PositionState> getStartingPos(){
		 * 		return starting_positions;
		 * }
		 * 
		 * public void compareWith(Conditions conditions2){
		 * 		if(!this.getStartingPos.containsAll(conditions2.getStartingPos) ||  ##FUNCTIONAL BUT NOT EFFICENT
		 * 			(!conditions2.getStartingPos.containsAll(this.getStartingPos);){ 
		 * 			return false;
		 * 		}
		 * 
		 * 		return true;	
		 * }
		 * 
		 */
	}
	
	/*ArrayList<Integer> testtt = new ArrayList<Integer>();
	
	public void wiwananndndnd() {
		arggh(1, 2, 3, 4);
		arggh(1, 2, 3, 4, 5, 6);
	}
	
	public void arggh(int... arggg) {
		for(int i : arggg) {
			testtt.add(i);
			
		}
		
		testtt.containsAll(testtt);
	} */
} 
