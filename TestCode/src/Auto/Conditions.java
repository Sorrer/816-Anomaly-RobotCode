package Auto;

import java.util.ArrayList;

public class Conditions {

public Conditions() {
		
	}
	
//	ArrayList<PositionState> starting_positions = new ArrayList<PositionState>();
//	
//	
//	public void setStartingPos(PositionState... states) {
//		for (PositionState state : states) {
//			starting_positions.add(state);
//			
//		}
//	}
//
//	public ArrayList<PositionState> getStartPos() {
//		return starting_positions;
//	}
	

	
	
	public boolean compareList(Conditions conditions2) {
		
		
		if (!this.getStartPos().containsAll(conditions2.getStartPos()) ||
			(!conditions2.getStartPos().containsAll(this.getStartPos()))) { 
				return false;
			}
		
		return true;
	}




	
	
	
	
	

}
	