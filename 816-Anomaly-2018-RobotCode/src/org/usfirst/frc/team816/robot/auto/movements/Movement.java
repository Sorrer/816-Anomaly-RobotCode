package org.usfirst.frc.team816.robot.auto.movements;

import org.usfirst.frc.team816.robot.drive.AnomalyDrive;
import org.usfirst.frc.team816.robot.parts.Intake;
import org.usfirst.frc.team816.robot.parts.Lift;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public abstract class Movement {
	
	AnomalyDrive drive;
	Lift lift;
	Intake intake;
	ADXRS450_Gyro gyro;
	
	
	public void setParts(AnomalyDrive drive, Lift lift, Intake intake, ADXRS450_Gyro gyro) {
		this.drive = drive;
		this.lift = lift;
		this.intake = intake;
		this.gyro = gyro;
	}
	
	public Lift getLift() {
		return this.lift;
	}
	
	public Intake getIntake() {
		return this.intake;
	}
	
	public AnomalyDrive getDrive() {
		return this.drive;
	}

	public abstract void init();
	public abstract void update();
}
