package org.usfirst.frc.team816.robot.auto.condition;

import org.usfirst.frc.team816.robot.auto.FieldState;

public class StartingPositionCondition extends Condition {


	FieldState condition;
	
	public StartingPositionCondition(FieldState state) {
		condition = state;
	}
	
	@Override
	public Object getValue() {
		return condition;
	}

	@Override
	public void setValue(Object obj) {
		if(obj.getClass() == FieldState.class) {
			this.condition = (FieldState) obj;
		}
	}

	@Override
	public boolean compareCondition(Condition condition) {

		if (condition.getClass().equals(this.getClass())) {
			if(this.condition.compareStartingPosition((FieldState) condition.getValue())) {
				return true;
			}
		}
		
		return false;
	}


}
