package org.usfirst.frc.team816.robot.auto.movements;

import org.usfirst.frc.team816.robot.AnomalyTime;

public class Switch extends Movement{
	
	double lift_time, intake_output_speed, move_time, halt_lift_speed, move_lift_speed, move_speed;
	AnomalyTime timer_lift;
	AnomalyTime timer_move;
	
	public Switch(double lift_time, double intake_output_speed, double move_time, double halt_lift_speed, double move_lift_up_speed, double move_speed) {
		this.lift_time = lift_time;
		this.intake_output_speed = intake_output_speed;
		this.move_time = move_time;
		
		this.halt_lift_speed = halt_lift_speed;
		this.move_lift_speed = move_lift_up_speed;
		this.move_speed = move_speed;
	}
	
	@Override
	public void init() {
		timer_lift = new AnomalyTime((int)(lift_time * 1000)); //Seconds to MilliSeconds
		timer_move = new AnomalyTime((int)(move_time * 1000));
		gyro.reset();
	}

	@Override
	public void update() {
		if(!timer_lift.isDone()) {
			timer_lift.update();
			this.getLift().move(this.move_lift_speed);
		}else {
			this.getLift().move(this.halt_lift_speed);
		}
		
		if(!timer_move.isDone()) {
			timer_move.update();
			this.getDrive().getDrive().arcadeDrive(this.move_speed, this.gyro.getAngle()/360.0);
		}else {
			this.getIntake().move(this.intake_output_speed);
		}
		
		
		
		
	}
	
}
