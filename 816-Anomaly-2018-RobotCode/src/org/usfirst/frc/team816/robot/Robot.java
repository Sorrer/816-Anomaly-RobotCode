package org.usfirst.frc.team816.robot;

import org.usfirst.frc.team816.robot.auto.FieldState;
import org.usfirst.frc.team816.robot.config.Config;
import org.usfirst.frc.team816.robot.controlling.Controllers;
import org.usfirst.frc.team816.robot.controlling.ControllingType;
import org.usfirst.frc.team816.robot.drive.AnomalyDrive;
import org.usfirst.frc.team816.robot.parts.Intake;
import org.usfirst.frc.team816.robot.parts.Lift;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	public NetworkTableInstance nTableInstance;
	public NetworkTable t_conf;
	public NetworkTableEntry entry_vision_start;
	
	public FieldState field_state;
	AnomalyDrive aDrive;
	
	/**
	 * Safety trigger for auto
	 */
	boolean autoEnabled = true;
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	
//	Spark lift;
	
//	Spark intake1, intake2;
	
//	Joystick controller;
	
	Lift lift;
	Intake intake;
	
	@Override
	public void robotInit() {
		nTableInstance = NetworkTableInstance.getDefault();
		
		field_state = new FieldState();
		
		Controllers controllers = new Controllers(ControllingType.DOUBLE_JOYSTICK_TANK);
		aDrive = new AnomalyDrive(Config.MOTORS_CONFIG, controllers);
		aDrive.initSpeedControllers();
		aDrive.init();
		
		lift = new Lift();
		intake = new Intake();
		
		lift.initMech(controllers);
		intake.initMech(controllers);
		
//		lift = new Spark(6);
		
//		lift.disable();
		
//		intake1 = new Spark(3);
//		intake2 = new Spark(4);
//		
//		
//		controller = new Joystick(2);
	}

	@Override
	public void autonomousInit() {
		
		String data = DriverStation.getInstance().getGameSpecificMessage();
		if(field_state.setFieldState(data) == false) {
			
		}
		
		
		
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
	
	}

	@Override
	public void teleopInit() {
		System.out.println("Teleop Init");
	}
	
	@Override
	public void teleopPeriodic() {
		
		aDrive.run();		
		intake.teleop();
		lift.teleop();
		
		
//		double vLeft = controller.getRawAxis(1);
//		
//		if(AnomalyMaths.withIn(vLeft, 0, Config.JOYSTICK_LEFT_DEADZONE)) {
//			vLeft = 0;
//		}
//
//		double iLeft = controller.getRawAxis(2);
//		double iRight = controller.getRawAxis(3);
//		
//		iLeft = -((iLeft - 0.5) *2);
//		iRight = (iRight - 0.5) *2;
//		
//		intake1.set(iLeft + iRight);
//		intake2.set(-(iLeft + iRight));
//		
//		
//		
//		lift.set(vLeft/2);
//		
	}
	
	@Override
	public void testInit() {
	}
	
	@Override
	public void testPeriodic() {
		aDrive.run();		
		intake.teleop();
		lift.teleop();
	}
}
