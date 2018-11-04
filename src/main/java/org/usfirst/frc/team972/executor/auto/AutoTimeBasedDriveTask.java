package org.usfirst.frc.team972.executor.auto;

import org.usfirst.frc.team972.executor.Task;
import org.usfirst.frc.team972.motors.MainDriveTrain;

public class AutoTimeBasedDriveTask extends Task {
	MainDriveTrain driveTrain;
	private double desiredTime, desiredSpeed;

	/**
	 * @param desiredTime measured in milliseconds
	 */
	public AutoTimeBasedDriveTask(double _executionTime, MainDriveTrain _driveTrain, double _desiredTime, double _desiredSpeed) {
		super(_executionTime);
		driveTrain = _driveTrain;
		desiredTime = _desiredTime;
		desiredSpeed = _desiredSpeed;
	}

	@Override
	public void init(double dt) {
	}

	@Override
	public void execute(double dt) {
		if (dt <= desiredTime) {
			driveTrain.driveSidesPWM(desiredSpeed, desiredSpeed);
		} else {
			driveTrain.driveSidesPWM(0, 0);
			super.destroy();
		}
	}

}