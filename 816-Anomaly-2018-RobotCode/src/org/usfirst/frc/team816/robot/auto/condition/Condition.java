package org.usfirst.frc.team816.robot.auto.condition;

public abstract class Condition {
	
	protected String key;
	
	public String getKey() {
		return this.key;
	}
	
	public abstract Object getValue();
	
	public abstract void setValue(Object obj);
	
	//Should only be comparing the same class, EX TestCondition compares TestCondition, not TestConditon compares SomeCondition
	public abstract boolean compareCondition(Condition condition);
}
