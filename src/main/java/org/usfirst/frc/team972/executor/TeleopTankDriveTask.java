package org.usfirst.frc.team972.executor;

import org.usfirst.frc.team972.motors.MainDriveTrain;
import org.usfirst.frc.team972.ui.UserInputGamepad;

import com.kauailabs.navx.frc.AHRS;

public class TeleopTankDriveTask extends Task {

	final int LEFT_DRIVE_AXIS = 1;
	final int RIGHT_DRIVE_AXIS = 5;
	final int SHIFT_BUTTON = 5;
	final int TURBO_BUTTON = 6;
	final double DEAD_BAND_THROTTLE = 0.0005;

	MainDriveTrain driveTrain;
	UserInputGamepad uig;
		
	int currentSpeedMode = 0;
	
	double speedModes[] = {0.25, 0.5, 0.75, 1};
	double speedModeMultiplier = speedModes[0];
	
	final int SPEED_MODE_0 = 3; //these are button id's
	final int SPEED_MODE_1 = 1;
	final int SPEED_MODE_2 = 2;
	final int SPEED_MODE_3 = 4;
	
	double leftDrive = 0;
	double rightDrive = 0;
	double easingValue = 0.1;
	
	public TeleopTankDriveTask(double _executionTime, UserInputGamepad _uig, MainDriveTrain _driveTrain, AHRS _ahrs) {
		super(_executionTime);
		super.autoRemove = false;
		uig = _uig;
		driveTrain = _driveTrain;
	}
	
	private double interpolateValues(double want, double actual) {
		double error = (want - actual) * easingValue;
		return actual + error;
	}
	
	//this is teleopPeriodic
	public void execute(double dt) {
		
		if(uig.getDriverStick().getRawButton(SPEED_MODE_0)) {
			currentSpeedMode = 0;
		} else if(uig.getDriverStick().getRawButton(SPEED_MODE_1)) {
			currentSpeedMode = 1;
		} else if(uig.getDriverStick().getRawButton(SPEED_MODE_2)) {
			currentSpeedMode = 2;
		} else if(uig.getDriverStick().getRawButton(SPEED_MODE_3)) {
			currentSpeedMode = 3;
		}
		speedModeMultiplier = speedModes[currentSpeedMode];
		
		double wantLeftDrive = -uig.getDriverStick().getRawAxis(LEFT_DRIVE_AXIS);
		double wantRightDrive = -uig.getDriverStick().getRawAxis(RIGHT_DRIVE_AXIS);

		wantLeftDrive = handleDeadband(wantLeftDrive, DEAD_BAND_THROTTLE);
		wantRightDrive = handleDeadband(wantRightDrive, DEAD_BAND_THROTTLE);
		
		
		if(uig.getDriverStick().getRawButton(TURBO_BUTTON)) {
			driveTrain.voltageUnlock();
		} else {
			driveTrain.voltageCompensation();
		}

		leftDrive = interpolateValues(wantLeftDrive, leftDrive);
		rightDrive = interpolateValues(wantRightDrive, rightDrive);
		
		leftDrive = handleDeadband(leftDrive, DEAD_BAND_THROTTLE);
		rightDrive = handleDeadband(rightDrive, DEAD_BAND_THROTTLE);

		driveTrain.driveSidesPWM(leftDrive * speedModes[currentSpeedMode], rightDrive * speedModes[currentSpeedMode]);
	}

	@Override
	public void init(double dt) {
		// TODO Auto-generated method stub
		
	}
	
    public double handleDeadband(double val, double deadband) {
        return (Math.abs(val) > Math.abs(deadband)) ? val : 0.0;
    }

}