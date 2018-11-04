package org.usfirst.frc.team972.ui;

import static org.usfirst.frc.team972.util.Constants.DISTANCE_PER_PULSE;

import org.usfirst.frc.team972.util.RobotLogger;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

public class Sensors {
	
	Encoder leftSideEncoderDriveTrain;
	Encoder rightSideEncoderDriveTrain;
	
	IMU imu;
	AHRS ahrs;
	ADIS16448_IMU adis;
	
	public void setupEncoderDriveTrain(int l1, int l2, int r1, int r2) {
		leftSideEncoderDriveTrain = new Encoder(l1, l2);
		rightSideEncoderDriveTrain = new Encoder(r1, r2);
		
		leftSideEncoderDriveTrain.setDistancePerPulse(DISTANCE_PER_PULSE);
		rightSideEncoderDriveTrain.setDistancePerPulse(DISTANCE_PER_PULSE);
	}
	
	public void setupIMU(IMU _imu) {
		imu = _imu;
	}
	
	private void setupIMU(AHRS _ahrs) {
		setupIMU(new IMU(_ahrs));
	}
	
	private void setupIMU(ADIS16448_IMU _adis) {
		setupIMU(new IMU(_adis));
	}
	
	public void setupAHRS() {
		RobotLogger.toast("Preparing to obtain the AHRS");
		try {
			ahrs = new AHRS(SPI.Port.kMXP, (byte) 200);
			if (ahrs.isConnected()) {
				RobotLogger.toast("AHRS Success");
			} else {
				RobotLogger.toast("AHRS Not Connected");
			}
		} catch(Exception e) {
			RobotLogger.toast("Failed to obtain the AHRS! " + e.getMessage(), RobotLogger.URGENT);
		}
		setupIMU(ahrs);
	}
	
	public void setupADIS() {
		RobotLogger.toast("Preparing to obtain the ADIS");
		try {
			adis = new ADIS16448_IMU();
		} catch(Exception e) {
			RobotLogger.toast("Failed to obtain the ADIS! " + e.getMessage(), RobotLogger.URGENT);
		}
		setupIMU(adis);
	}
	
	public IMU getIMU() {
		return imu;
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