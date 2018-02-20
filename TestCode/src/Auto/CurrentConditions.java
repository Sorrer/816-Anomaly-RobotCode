package Auto;

import java.util.ArrayList;

import conditions.Condition;
import conditions.FieldStateCondition;
import conditions.GoalCondition;
import conditions.StartingPositionCondition;

public class CurrentConditions {

	FieldState fs;
	Goal g;
	FieldStateCondition fsc = new FieldStateCondition(fs);
	StartingPositionCondition spc;
	GoalCondition gc = new GoalCondition(g);

	ArrayList<Condition> conditions_list;

	public CurrentConditions() {
		
	}

	public void setStates() {
		fs.setFieldState("NNN");
		fs.setStartinPosition(PositionState.NONE);
		g = Goal.NONE;
	}
	
	public void AddStartCondition(StartingPositionCondition... startconditions) {
		for(StartingPositionCondition startcondition: startconditions) {
			conditions_list.add(startcondition);
		
		}
		
	}

	public void AddFieldCondition(FieldStateCondition... fieldconditions) {
		for(FieldStateCondition fieldcondition: fieldconditions) {
			conditions_list.add(fieldcondition);
		
		}
		
	}

	public void AddGoalCondition(GoalCondition... goalconditions) {
		for(GoalCondition goalcondition: goalconditions) {
			conditions_list.add(goalcondition);
		}
		
	}

	
}
