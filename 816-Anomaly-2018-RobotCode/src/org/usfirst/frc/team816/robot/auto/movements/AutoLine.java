package org.usfirst.frc.team816.robot.auto.movements;

import org.usfirst.frc.team816.robot.AnomalyTime;

public class AutoLine extends Movement{
	double moveTime, moveSpeed;
	AnomalyTime timer_move;
	
	public AutoLine(double moveSpeed, double moveTime) {
		this.moveTime = moveTime;
		this.moveSpeed = moveSpeed;
	}
	
	@Override
	public void init() {
		timer_move = new AnomalyTime((int)(this.moveTime * 1000));
		gyro.reset();
	}
	@Override
	public void update() {
		if(!timer_move.isDone()) {
			timer_move.update();
			this.getDrive().getDrive().arcadeDrive(this.moveSpeed, gyro.getAngle()/360.0);
		}
	}
	
}
