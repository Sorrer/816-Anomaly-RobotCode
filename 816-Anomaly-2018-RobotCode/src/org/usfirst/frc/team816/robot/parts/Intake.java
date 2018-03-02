package org.usfirst.frc.team816.robot.parts;

import org.usfirst.frc.team816.robot.config.Config;
import org.usfirst.frc.team816.robot.controlling.Controllers;

import edu.wpi.first.wpilibj.Spark;

public class Intake extends Part{
	Spark motor_left, motor_right;
	Controllers c;
	
	@Override
	public void initMech(Controllers c) {
		this.c = c;
		motor_left = new Spark(Config.INTAKE_LEFT_SPARK_CONTROLLER);
		motor_right = new Spark(Config.INTAKE_RIGHT_SPARK_CONTROLLER);
	}

	@Override
	public void teleop() {
		double iLeft = c.getOperatorController().getRawAxis(Config.OC_INTAKE_OUT);
		double iRight = c.getOperatorController().getRawAxis(Config.OC_INTAKE_IN);
		
		iLeft = -((iLeft - 0.5) *2);
		iRight = (iRight - 0.5) *2;
		
		motor_left.set(iLeft + iRight);
		motor_right.set(-(iLeft + iRight));
	}
	
	public void move(double speed) {
		this.motor_left.set(speed);
		this.motor_right.set(speed);
	}
	
	
}
