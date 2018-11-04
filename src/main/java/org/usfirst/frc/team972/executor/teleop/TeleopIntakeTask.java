package org.usfirst.frc.team972.executor.teleop;

import org.usfirst.frc.team972.executor.Task;
import org.usfirst.frc.team972.motors.MechanismActuators;
import org.usfirst.frc.team972.ui.UserInputGamepad;

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
//		mechanismActuators.setupIntakeMotors(intakeMotorID);
		
//		Only use if on team A
//		mechanismActuators.setupIntakeMotors(intakeMotorID_1, intakeMotorID_2);
	}

	@Override
	public void execute(double dt) {
//		Only use if on team C
//		mechanismActuators.runSingleMotorIntake(speed);
		
//		Only use if on team A
//		mechanismActuators.runDoubleMotorIntake(speed);
	}

}