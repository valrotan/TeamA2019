package org.usfirst.frc.team972;

import org.usfirst.frc.team972.executor.TaskExecutor;
import org.usfirst.frc.team972.executor.teleop.TeleopTankDriveTask;
import org.usfirst.frc.team972.motors.MainDriveTrain;
import org.usfirst.frc.team972.motors.MechanismActuators;
import org.usfirst.frc.team972.ui.Sensors;
import org.usfirst.frc.team972.ui.UserInputGamepad;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {
	
	public static final double WHEEL_BASE_WIDTH = 0.838;
	public static final double REAL_TIME_LOOP_HZ = 200;
	
	TaskExecutor taskExecutor = new TaskExecutor();
	MainDriveTrain driveTrain = new MainDriveTrain();
	MechanismActuators mechanismMotors = new MechanismActuators();
	Sensors sensors = new Sensors();
	
	UserInputGamepad uig = new UserInputGamepad(0, 1);
	
	boolean firstTimeTeleop = false;
	double realStartTime = 0;
	double lastTime = 0;
	
	long controlLoopCycle = 0;
	long moduloUpdateCycle = 200;
	
	public void robotInit() {
		System.out.println("Robot Init");
		
		sensors.setupEncoderDriveTrain(2, 3, 0, 1);
		

		driveTrain.SetupProcedure(1, 2, 3, 4);

		driveTrain.setTalonsPWM_follow();
						
	}
	
	public void autonomousInit() {
		System.out.println("Auto Init");
		
		sensors.resetDriveEncoders();
		
		driveTrain.diagnosis();
		driveTrain.setTalonsBrake();
		driveTrain.shiftSolenoidDown();
		 	
		realStartTime = Timer.getFPGATimestamp();
		
		autoRealTimeControlLoop();
	}

	public void autonomousPeriodic() {
		// do nothing because all of our auto is done in the real time control loop
	}

	public void teleopInit() {
		// in a real match, we do not want to zero in teleop
		//sensors.resetElevatorEncoder();
		//sensors.resetFlopEncoder();
		
		System.out.println("Teleop Init");
		
		sensors.resetDriveEncoders();
		
		driveTrain.setTalonsPWM_follow();
		driveTrain.diagnosis();
		driveTrain.shiftSolenoidDown();
		driveTrain.setTalonsBrake();
		
		taskExecutor.addTask(new TeleopTankDriveTask(0, uig, driveTrain));
		
		taskExecutor.teleopStart(); //prepare for startup!
		
		realStartTime = Timer.getFPGATimestamp();
		
		teleopRealTimeController(); //begin 200hz control loop
	}

	public void disabledPeriodic() {
		taskExecutor.stop();
		taskExecutor.forceClearTasks();
		driveTrain.stopCoast();
		controlLoopCycle = 0;
	}
	
	public void teleopPeriodic() {
		//do nothing
	}
	
	public void updateLoopStat(double current_time) {
		if(controlLoopCycle % moduloUpdateCycle == 1) {
			SmartDashboard.putNumber("control loop delta", current_time - lastTime);
		}
		
		lastTime = current_time;
		controlLoopCycle++;
	}
	
	public void autoRealTimeControlLoop() {
		System.out.println("Control Loop (Autonomous) Starting");
		while (this.isEnabled() && this.isAutonomous()) {
			double current_time = Timer.getFPGATimestamp() - realStartTime;
			taskExecutor.executeDT(current_time, false); //dont care about realtime locks, just run at full speed
			try {
				Thread.sleep((long) (1000 / REAL_TIME_LOOP_HZ));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			updateLoopStat(current_time);
		}
		taskExecutor.stop();
	}

	public void teleopRealTimeController() {
		System.out.println("Control Loop (Teleop) Starting");
		while (this.isEnabled() && this.isOperatorControl()) {
			double current_time = Timer.getFPGATimestamp() - realStartTime;
			if(this.isNewDataAvailable()) {
				taskExecutor.executeDT(current_time, false);
			} else {
				taskExecutor.executeDT(current_time, true);
			}
			
			try {
				Thread.sleep((long) (1000 / REAL_TIME_LOOP_HZ));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			updateLoopStat(current_time);
		}
		taskExecutor.stop();
	}
	
	public void testInit() {
		System.out.println("no test");
	}
}