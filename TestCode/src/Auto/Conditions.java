package Auto;

import java.util.ArrayList;

import conditions.Condition;
import conditions.FieldStateCondition;
import conditions.GoalCondition;

public class Conditions {

//	CurrentConditions cc;
	
	ArrayList<Condition> conditions_list = new ArrayList<Condition>();
	
	Goal g;
	GoalCondition goal_condition;
	FieldStateCondition fieldstate_condition;
	FieldState fs;
	
	public Conditions() {
	
	}

	
	
	
	public void InitCurrent() {
		
		g = Goal.NONE;
		goal_condition = new GoalCondition(g);
		
		fs = new FieldState("NNN");
		fs.setStartinPosition(PositionState.NONE);
		
		fieldstate_condition = new FieldStateCondition(fs);
		
		conditions_list.add(goal_condition);
		conditions_list.add(fieldstate_condition);
		
	}

	public void setGoal(Goal goal) {
		g = goal;
	}
	
	
	public void setFieldState(String positions) {
		fs.setFieldState(positions);
	}
	
	public void setStartinPosition(PositionState state) {
		fs.setStartinPosition(state);
	}
	
	public ArrayList<Condition> getConditionsList() {
		return this.conditions_list;
	}

	public boolean compareConditionsList(Conditions conditions) {

		for(Condition con1 : this.getConditionsList()) {
			boolean correct = false;
			
			for(Condition con2 : conditions.getConditionsList()) {
				if(con1.compareCondition(con2)) {
					correct = true;
				}
			}
			
			if(!correct) return false;
		}
		
		return true;
		
		
		

//		condition = tr.conditions_list;
//		if (this.getConditionsList() == condition) {
//
//			return true;
//		}
//		return false;
	}

	// ArrayList<PositionState> starting_positions = new ArrayList<PositionState>();
	//
	//
	// public void setStartingPos(PositionState... states) {
	// for (PositionState state : states) {
	// starting_positions.add(state);
	//
	// }
	// }
	//
	// public ArrayList<PositionState> getStartPos() {
	// return starting_positions;
	// }

	// public boolean compareList(Conditions conditions2) {

	// if (!this.getStartPos().containsAll(conditions2.getStartPos()) ||
	// (!conditions2.getStartPos().containsAll(this.getStartPos()))) {
	// return false;
	// }

	// return true;
	// }
	// useless don't bother

}
