package org.usfirst.frc.team972.ui;

import edu.wpi.first.wpilibj.Joystick;

public class UserInputGamepad {
	Joystick driverStick;
	Joystick operatorStick;
	
	public UserInputGamepad(int driverStickID, int operatorStickID) {
		driverStick = new Joystick(driverStickID);
		operatorStick = new Joystick(operatorStickID);
	}
	
	public Joystick getDriverStick() {
		return driverStick;
	}
	
	public Joystick getOperatorStick() {
		return operatorStick;
	}
}