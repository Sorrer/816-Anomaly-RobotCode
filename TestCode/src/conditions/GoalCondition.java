package conditions;

import Auto.Goal;

public class GoalCondition extends Condition {

	Goal condition;
	
	
	public GoalCondition(Goal goal) {
		condition = goal;
	}

	private boolean compareGoal(Goal goal) {
		if (this.condition == Goal.NONE || goal == Goal.NONE) {
			return true;
		}
		else if (this.condition == goal) {
			return true;
		}
		return false;
	}
	
	@Override
	public Object getValue() {
		return condition;
	}

	@Override
	public void setValue(Object obj) {
		if(obj.getClass() == Goal.class) { 
			this.condition = (Goal) obj;
		}
		
	}

	@Override
	public boolean compareCondition(Condition condition) {
		if (condition.getClass().equals(this.getClass())) {
			if (compareGoal((Goal) condition.getValue())) {
				return true;
			}
		}
		return false;
	}

}
