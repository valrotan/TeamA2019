package org.usfirst.frc.team972.ui;

import edu.wpi.first.wpilibj.Encoder;

import static org.usfirst.frc.team972.util.Constants.*;

public class Sensors {
	
	Encoder leftSideEncoderDriveTrain;
	Encoder rightSideEncoderDriveTrain;
	
	public void SetupEncoderDriveTrain(int l1, int l2, int r1, int r2) {
		leftSideEncoderDriveTrain = new Encoder(l1, l2);
		rightSideEncoderDriveTrain = new Encoder(r1, r2);
		
		leftSideEncoderDriveTrain.setDistancePerPulse(DISTANCE_PER_PULSE);
		rightSideEncoderDriveTrain.setDistancePerPulse(DISTANCE_PER_PULSE);
	}
	
	public void resetDriveEncoders() {
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

	public int getRightDriveEncoderSpeed() {
		return (int)rightSideEncoderDriveTrain.getRate();
	}

}