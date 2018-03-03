package Auto;

import java.util.ArrayList;

import conditions.Condition;
import conditions.FieldStateCondition;
import conditions.GoalCondition;
import conditions.StartingPositionCondition;

public class Conditions {

//	CurrentConditions cc;
	
	ArrayList<Condition> conditions_list = new ArrayList<Condition>();
	
	public Goal g;
	GoalCondition goal_condition;
	FieldStateCondition fieldstate_condition;
	StartingPositionCondition starting_condition;
	FieldState fs;
	PositionState sp;
	String fp;
	
	public Conditions() {
	
	}

	
	
	
	public void initCurrent() {
		
		g = Goal.NONE;
		
		fp = "NNN";
		fs = new FieldState(fp);
		
		sp = PositionState.NONE;
		fs.setStartinPosition(sp);
		
		goal_condition = new GoalCondition(g);
		fieldstate_condition = new FieldStateCondition(fs);
		starting_condition = new StartingPositionCondition(fs);
		
		
		conditions_list.add(goal_condition);
		conditions_list.add(fieldstate_condition);
		conditions_list.add(starting_condition);
		
	}
	
	// init conditions after goal
	// when setting set goal update condition

	public void setGoal(Goal goal) {
		g = goal;
		goal_condition.setValue(g);
	}
	
	
	public void setFieldState(String positions) {
		fp = positions;
		fieldstate_condition.setValue(fs);
	}
	
	public void setStartinPosition(PositionState state) {
		sp = state;
		starting_condition.setValue(fs);
	}
	
	public ArrayList<Condition> getConditionsList() {
		return this.conditions_list;
	}
	
	

	public boolean compareConditionsList(Conditions conditions) {
		
		for(Condition con1 : this.getConditionsList()) {
			boolean correct = false;
			
			for(Condition con2 : conditions.getConditionsList()) {
<<<<<<< HEAD
				if(con1.compareCondition(con2)) {
=======
				System.out.println(con1.getValue() + " " + con2.getValue() + " " + con1.compareCondition(con2));
				if(con1.compareCondition(con2)) {  // always equaling true stops at first var?
>>>>>>> branch 'master' of https://github.com/Sorrer/816-Anomaly-RobotCode-2018
					correct = true;
					break;
				}
				
			}
			
			if(!correct) {
				return false;
			}
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
