package org.usfirst.frc.team816.robot.parts;

import org.usfirst.frc.team816.robot.AnomalyMaths;
import org.usfirst.frc.team816.robot.config.Config;
import org.usfirst.frc.team816.robot.controlling.Controllers;

import edu.wpi.first.wpilibj.Spark;

public class Lift extends Part{
	Spark motor;
	Controllers c;
	
	@Override
	public void initMech(Controllers c) {
		this.c = c;
		motor = new Spark(Config.LIFT_SPARK_CONTROLLER);
	}

	@Override
	public void teleop() {
		double vLeft = c.getOperatorController().getRawAxis(Config.OC_LIFT);
		
		if(AnomalyMaths.withIn(vLeft, 0, Config.JOYSTICK_LEFT_DEADZONE)) {
			vLeft = 0;
		}
		
		vLeft /= 2;
		
		this.motor.set(vLeft);
	}
	
	public void move(double speed) {
		this.motor.set(speed);
	}
	
	
}
