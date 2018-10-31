package org.usfirst.frc.team972;
import edu.wpi.first.wpilibj.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {
	
	WPI_TalonSRX right;
	WPI_TalonSRX left;
	Joystick myJoystick;
	
	WPI_TalonSRX rollyGrabberMotorOne;
	WPI_TalonSRX rollyGrabberMotorTwo;
	
	//Runs once on robot start
	public void robotInit() {
		left = new WPI_TalonSRX(1);
		right = new WPI_TalonSRX(4);
		rollyGrabberMotorOne = new WPI_TalonSRX(7);
		rollyGrabberMotorTwo = new WPI_TalonSRX(8);
		
		myJoystick = new Joystick(0);
	}
	
	//Runs once on auto start
	public void autonomousInit() {
		
	}
	
	//Runs repeatedly on auto
	public void autonomousPeriodic() {
		
	}
	
	//Runs once on auto start
	public void teleopInit() {
		
	}
	
	//Runs repeatedly on teleop
	public void teleopPeriodic() {
		double rightPower = myJoystick.getRawAxis(5);
		double leftPower = myJoystick.getRawAxis(1);
		
		System.out.println("Left Power: " + leftPower);
		System.out.println("Right Power: " + rightPower);
		right.set(ControlMode.PercentOutput, rightPower);
		left.set(ControlMode.PercentOutput, -leftPower);
		
		double rollyGrabberMotorSpeed = 0.5;
		
		rollyGrabberMotorOne.set(rollyGrabberMotorSpeed);
		rollyGrabberMotorTwo.set(rollyGrabberMotorSpeed);
	}
}