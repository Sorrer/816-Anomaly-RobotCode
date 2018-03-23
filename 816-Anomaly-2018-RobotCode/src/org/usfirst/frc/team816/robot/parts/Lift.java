package org.usfirst.frc.team816.robot.parts;

import org.usfirst.frc.team816.robot.AnomalyMaths;
import org.usfirst.frc.team816.robot.AnomalyTime;
import org.usfirst.frc.team816.robot.config.Config;
import org.usfirst.frc.team816.robot.controlling.Controllers;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Spark;

public class Lift extends Part{
	Spark motor;
	DoubleSolenoid sBreak;
	Controllers c;
	AnomalyTime breakDelay;
	
	@Override
	public void initMech(Controllers c) {
		this.c = c;
		sBreak = new DoubleSolenoid(0,1);
		sBreak.set(Value.kForward);
		motor = new Spark(Config.LIFT_SPARK_CONTROLLER);
		breakDelay = new AnomalyTime((int) Config.LIFT_BREAK_DELAY * 1000);
	}
	
	boolean waitingToOpen = false;
	
	@Override
	public void teleop() {
		double vLeft = c.getOperatorController().getRawAxis(Config.OC_LIFT);
		
		if(AnomalyMaths.withIn(vLeft, 0, Config.LIFT_BREAK_DEADZONE)) {
			vLeft = 0;
		}
		
		this.move(vLeft);
	}
	
	public void move(double speed) {
		if(sBreak.get() == DoubleSolenoid.Value.kForward && !waitingToOpen && speed != 0) {
			waitingToOpen = true;
			breakDelay.start();
		}
		
		if(sBreak.get() == DoubleSolenoid.Value.kForward && waitingToOpen && speed != 0) {
			sBreak.set(Value.kReverse);
			breakDelay.update();
			
			if(breakDelay.isDone()) {
				waitingToOpen = false;
			}
		}
		
		if(speed == 0) {
			sBreak.set(Value.kForward);
		}
		
		if(sBreak.get() == Value.kReverse && !waitingToOpen) {
			this.motor.set(speed);
		}
	}
	
	
}
