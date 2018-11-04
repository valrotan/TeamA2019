package org.usfirst.frc.team972.ui;

import static org.usfirst.frc.team972.util.Constants.DISTANCE_PER_PULSE;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;

public class Sensors {
	
	Encoder leftSideEncoderDriveTrain;
	Encoder rightSideEncoderDriveTrain;
	
	AHRS ahrs;
	
	public void setupEncoderDriveTrain(int l1, int l2, int r1, int r2) {
		leftSideEncoderDriveTrain = new Encoder(l1, l2);
		rightSideEncoderDriveTrain = new Encoder(r1, r2);
		
		leftSideEncoderDriveTrain.setDistancePerPulse(DISTANCE_PER_PULSE);
		rightSideEncoderDriveTrain.setDistancePerPulse(DISTANCE_PER_PULSE);
	}
	
	public void setupAHRS(AHRS _ahrs) {
		ahrs = _ahrs;
	}
	
	public AHRS getAHRS() {
		return ahrs;
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