package org.usfirst.frc.team972.executor.teleop;

import org.usfirst.frc.team972.executor.Task;
import org.usfirst.frc.team972.motors.MechanismActuators;
import org.usfirst.frc.team972.ui.UserInputGamepad;
import org.usfirst.frc.team972.util.Constants;

public class TeleopIntakeTask extends Task {
	UserInputGamepad uig;
	MechanismActuators mechanismActuators;

	public TeleopIntakeTask(double _executionTime, UserInputGamepad _uig, MechanismActuators _mechanismActuators) {
		super(_executionTime);
		uig = _uig;
		mechanismActuators = _mechanismActuators;
	}

	@Override
	public void init(double dt) {
//		Only use if on team C
//		mechanismActuators.setupIntakeMotors(Constants.INTAKE_MOTOR_ID);
		
//		Only use if on team A
//		mechanismActuators.setupIntakeMotors(Constants.INTAKE_MOTOR_ID_1, Constants.INTAKE_MOTOR_ID_2);
	}

	@Override
	public void execute(double dt) {
		double speed = 0.5; // Change this to whatever works
		
//		Only use if on team C
		/*
		if (uig.getDriverStick().getRawButtonPressed(Constants.INTAKE_BUTTON_ID)) {
			mechanismActuators.runSingleMotorIntake(speed);
		} else if (uig.getDriverStick().getRawButtonPressed(Constants.OUTTAKE_BUTTON_ID)) {
//			runs intake backwards
			mechanismActuators.runSingleMotorIntake(-speed);
		} else {
			mechanismActuators.runSingleMotorIntake(0);
		}
		*/
		
//		Only use if on team A
		/*
		if (uig.getDriverStick().getRawButtonPressed(Constants.INTAKE_BUTTON_ID)) {
			mechanismActuators.runDoubleMotorIntake(speed);
		} else if (uig.getDriverStick().getRawButtonPressed(Constants.OUTTAKE_BUTTON_ID)) {
//			runs intake backwards
			mechanismActuators.runDoubleMotorIntake(-speed);
		} else {
			mechanismActuators.runDoubleMotorIntake(0);
		}
		*/
	}

}