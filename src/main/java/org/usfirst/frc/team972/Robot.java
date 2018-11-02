package org.usfirst.frc.team972;
import edu.wpi.first.wpilibj.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Joystick;

public class Robot extends IterativeRobot {
	
	WPI_TalonSRX right1;
	WPI_TalonSRX left1;
	WPI_TalonSRX right2;
	WPI_TalonSRX left2;
	Joystick joy;
	
	double rightPower;
	double leftPower;
	
	//WPI_TalonSRX rollyGrabberMotorOne;
	//WPI_TalonSRX rollyGrabberMotorTwo;
	
	//Runs once on robot start
	public void robotInit() {
		left1 = new WPI_TalonSRX(1);
		left2 = new WPI_TalonSRX(2);
		right1 = new WPI_TalonSRX(4);
		right2 = new WPI_TalonSRX(5);
		//rollyGrabberMotorOne = new WPI_TalonSRX(7);
		//rollyGrabberMotorTwo = new WPI_TalonSRX(8);
		
		joy = new Joystick(0);
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
		leftPower = joy.getRawAxis(1);
		rightPower = -joy.getRawAxis(5);
		
		right1.set(rightPower);
		right2.set(rightPower);
		left1.set(leftPower);
		left2.set(leftPower);
	}
}