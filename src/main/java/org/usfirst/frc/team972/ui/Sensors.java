package org.usfirst.frc.team972.ui;

import edu.wpi.first.wpilibj.*;

public class Sensors {
	
	Encoder leftSideEncoderDriveTrain;
	Encoder rightSideEncoderDriveTrain;
	
	public void SetupEncoderDriveTrain(int l1, int l2, int r1, int r2) {
		leftSideEncoderDriveTrain = new Encoder(l1, l2);
		rightSideEncoderDriveTrain = new Encoder(r1, r2);
		
		leftSideEncoderDriveTrain.setDistancePerPulse(1);
		rightSideEncoderDriveTrain.setDistancePerPulse(1);
	}
	
	public void resetDriveEncoder() {
		leftSideEncoderDriveTrain.reset();
		rightSideEncoderDriveTrain.reset();
	}
	
	public int getLeftDriveEncoder() {
		return leftSideEncoderDriveTrain.get();
	}
	
	public int getLeftDriveEncoderSpeed() {
		return (int)leftSideEncoderDriveTrain.getRate();
	}
	
	public int getRightDriveEncoder() {
		return rightSideEncoderDriveTrain.get();
	}

	public void resetDriveEncoders() {
		leftSideEncoderDriveTrain.reset();
		rightSideEncoderDriveTrain.reset();
	}

}