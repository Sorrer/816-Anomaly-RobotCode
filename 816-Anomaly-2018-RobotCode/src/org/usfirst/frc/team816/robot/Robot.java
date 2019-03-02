package org.usfirst.frc.team816.robot;

import org.usfirst.frc.team816.robot.auto.AutoPath;
import org.usfirst.frc.team816.robot.auto.Conditions;
import org.usfirst.frc.team816.robot.auto.FieldState;
import org.usfirst.frc.team816.robot.auto.movements.AutoLine;
import org.usfirst.frc.team816.robot.auto.movements.Movement;
import org.usfirst.frc.team816.robot.auto.movements.Switch;
import org.usfirst.frc.team816.robot.auto.routes.RouteID;
import org.usfirst.frc.team816.robot.config.Config;
import org.usfirst.frc.team816.robot.controlling.Controllers;
import org.usfirst.frc.team816.robot.controlling.ControllingType;
import org.usfirst.frc.team816.robot.drive.AnomalyDrive;
import org.usfirst.frc.team816.robot.parts.Intake;
import org.usfirst.frc.team816.robot.parts.Lift;
import org.usfirst.frc.team816.robot.parts.Elevator;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	public NetworkTableInstance nTableInstance;
	public NetworkTable t_conf;
	public NetworkTableEntry entry_vision_start;
	
	public FieldState field_state;
	AnomalyDrive aDrive;
	
	Compressor compressor;
	
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
	Elevator elevator;
	
	DashboardData ds;
	
	ADXRS450_Gyro gyro;
	
	@Override
	public void robotInit() {
		compressor = new Compressor(0);
		compressor.setClosedLoopControl(true);
		compressor.stop();
		
		nTableInstance = NetworkTableInstance.getDefault();
		
		field_state = new FieldState();
		
		Controllers controllers = new Controllers(ControllingType.DOUBLE_JOYSTICK_TANK);
		aDrive = new AnomalyDrive(Config.MOTORS_CONFIG, controllers);
		aDrive.initSpeedControllers();
		aDrive.init();
		
		lift = new Lift();
		intake = new Intake();
		
		//lift.initMech(controllers);
		//intake.initMech(controllers);
		
		ds = new DashboardData();
		ds.init();
		
		gyro = new ADXRS450_Gyro();
		gyro.calibrate();
		
		elevator = new Elevator();
//		lift = new Spark(6);
		
//		lift.disable();
		
//		intake1 = new Spark(3);
//		intake2 = new Spark(4);
//		
//		
//		controller = new Joystick(2);
		
		lineTime = new AnomalyTime(7000);
	}
	
	RouteID pathFound = RouteID.NONE;
	Movement autoMove;
	
	AnomalyTime lineTime;
	
	@Override
	public void autonomousInit() {
		intake.move(0);
		lift.move(0);
		if(!ds.getAutoActivated()) return;
		
		String data = DriverStation.getInstance().getGameSpecificMessage();
		if(field_state.setFieldState(data) == false) {
			field_state.setFieldState("UUU");
		}
		
		field_state.setStartinPosition(ds.getStartPosition());
		
		Conditions current_conditions = new Conditions();
		current_conditions.initCurrent();
		
		current_conditions.setGoal(ds.getGoal());
		current_conditions.setFieldState(field_state.getData());
		current_conditions.setStartinPosition(ds.getStartPosition());
		
		System.out.println(ds.getGoal() + " " + field_state.getData() + " " + ds.getStartPosition());
		
				
		AutoPath ap = new AutoPath();
		
		ap.init();
		RouteID path = ap.pathfind(current_conditions);
		this.pathFound = path;
		System.out.println(pathFound);
		
		if(path.equals(RouteID.RouteLeftSwitch) || path.equals(RouteID.RouteRightSwitch)) {
			SmartDashboard.putString("Auto mode: ", "Switch");
			this.autoMove = new Switch(ds.getAutoSwitchIntakeOutputSpeed(), ds.getAutoSwitchLiftMovingSpeed(), ds.getAutoSwitchLiftTime(), ds.getAutoSwitchMovingSpeed(), ds.getAutoSwitchMovingTime());
		}else if(path.equals(RouteID.RouteLineLeft) || path.equals(RouteID.RouteLineRight) || path.equals(RouteID.RouteAutoLine)) {
			SmartDashboard.putString("Auto mode: ", "AutoLine")	;
			System.out.println(ds.getAutoLineTime() + " " + ds.getAutoLineSpeed());
			this.autoMove = new AutoLine(ds.getAutoLineSpeed() , ds.getAutoLineTime());
		}else {
			SmartDashboard.putString("Auto mode: ", "NONE");
			this.pathFound = RouteID.NONE;
			return;
		}
		
		
		autoMove.setParts(aDrive, lift, intake, gyro);
		autoMove.init();
		
		
		
		
//		this.lineTime.setTimer((int)(ds.getAutoLineTime() * 1000));
//		this.lineTime.start();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
		
		
		if(!ds.getAutoActivated()) return;
		
		if(pathFound.equals(RouteID.RouteLeftSwitch) || pathFound.equals(RouteID.RouteRightSwitch)) {
			this.autoMove.update();
		}else if(pathFound.equals(RouteID.RouteLineLeft) || pathFound.equals(RouteID.RouteLineRight) || pathFound.equals(RouteID.RouteAutoLine)) {
			this.autoMove.update();
		}
		
//		lineTime.update();
//		if(lineTime.isDone()) return;
//		if(ds.getGoal() == Goal.LINE) {
//			this.aDrive.getDrive().arcadeDrive(ds.getAutoLineSpeed(), this.gyro.getAngle()/360);
//		}                                              
		
		
		
	}

	@Override
	public void teleopInit() {
		System.out.println("Teleop Init");
	}
	
	@Override
	public void teleopPeriodic() {
		
		aDrive.run();	
		elevator.teleop();	
	//	intake.teleop();
	//	lift.teleop();
		
		
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
	//	intake.teleop();
	//	lift.teleop();
	}
}
