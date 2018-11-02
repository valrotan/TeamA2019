package org.usfirst.frc.team972;
import edu.wpi.first.wpilibj.*;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends IterativeRobot {
	
	//Talon Declarations
	WPI_TalonSRX right1;
	WPI_TalonSRX left1;
	WPI_TalonSRX right2;
	WPI_TalonSRX left2;
	//WPI_TalonSRX intakeMotor1;
	//WPI_TalonSRX intakeMotor2;
	
	//Groups for each side
	SpeedControllerGroup leftGroup;
	SpeedControllerGroup rightGroup;
	
	//Differential Drive for main control
	DifferentialDrive mainDrive;
	
	//Sample encoder declaration
	//Encoder encoderExample;
	
	//Joystick Declaration
	Joystick joy;
	
	//Doubles for drive control
	double power;
	double turning;
	double intakePower;
	
	//Booleans for reading buttons
	boolean button0;
	boolean button1;
	boolean button2;
	
	//Runs once on robot start
	public void robotInit() {
		//Initialization of left side
		left1 = new WPI_TalonSRX(1);
		left2 = new WPI_TalonSRX(2);
		leftGroup = new SpeedControllerGroup(left1, left2);
		
		//Initialization of right side
		right1 = new WPI_TalonSRX(4);
		right2 = new WPI_TalonSRX(5);
		rightGroup = new SpeedControllerGroup(right1, right2);
		
		//Initialization of main drive
		mainDrive = new DifferentialDrive(leftGroup, rightGroup);
		
		//Sample encoder initialization
		//encoderExample = new Encoder(1,2);
		
		//Intake motor initializations
		//intakeMotor1 = new WPI_TalonSRX(7);
		//intakeMotor2 = new WPI_TalonSRX(8);
		
		//Joystick initialization
		joy = new Joystick(0);
	}
	
	//Runs once on auto start
	public void autonomousInit() {
		
	}
	
	//Runs repeatedly on auto period
	public void autonomousPeriodic() {
		
	}
	
	//Runs once on auto start
	public void teleopInit() {
		
	}
	
	//Runs repeatedly on teleop period
	public void teleopPeriodic() {
		//Read joystick values
		power = joy.getY();
		turning = joy.getX();
		
		//Read buttons
		button0 = joy.getRawButton(0);
		button1 = joy.getRawButton(1);
		button2 = joy.getRawButton(2);
		
		if (button0) {intakePower = -0.3; }
		if (button1) {intakePower = 0.0; }
		if (button2) {intakePower = 0.3; }
		
		//Run the differential drive in arcade mode
		mainDrive.arcadeDrive(power, turning);
		
		//Linked intake code
		//intakeMotor1.set(intakePower);
		//intakeMotor2.set(intakePower);
	}
}



