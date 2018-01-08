package org.usfirst.frc.team816.robot.auto;

import org.usfirst.frc.team816.robot.drive.AnomalyDrive;

/**
 *
 */
public class Auton {
	
	AnomalyDrive drive;
	FieldState fieldState;
	
	public Auton(AnomalyDrive drive, FieldState field) {
		this.drive = drive;
		this.fieldState = field;
		
	}
	
	
	/**
	 * Loop through to run auto
	 */
	public void run() {
		
	}
}
