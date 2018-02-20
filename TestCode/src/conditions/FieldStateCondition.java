package conditions;

import Auto.FieldState;

public class FieldStateCondition extends Condition{


	FieldState condition;
	
	public FieldStateCondition(FieldState state) {
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
		
		if(condition.getClass() == this.getClass()) {
			if(this.condition.compare((FieldState) condition.getValue())) {
				return true;
			}
		}
		
		return false;
	}

}
