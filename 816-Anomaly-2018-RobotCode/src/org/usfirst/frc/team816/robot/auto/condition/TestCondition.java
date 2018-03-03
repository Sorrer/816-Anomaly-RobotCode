package org.usfirst.frc.team816.robot.auto.condition;

public class TestCondition extends Condition{
	
	//AnyTypeOfObject
	boolean value = false;
	
	public TestCondition(boolean t) {
		this.key = "test";
		this.value = t;
	}

	@Override
	public Object getValue() {
		return value;
	}

	@Override
	public void setValue(Object obj) {
		if(obj.getClass() == boolean.class){ 
			this.value = (boolean) obj;
		}
	}

	@Override
	public boolean compareCondition(Condition condition) {

		if (condition.getClass().equals(this.getClass())) {
			if(((boolean) condition.getValue()) == ( this.value)) {
				return true;
			}else {
				return false;
			}
		}
		
		return false;
	}
	
}
