package org.usfirst.frc.team972.ui;

import org.usfirst.frc.team972.util.RobotLogger;

import com.analog.adis16448.frc.ADIS16448_IMU;
import com.kauailabs.navx.frc.AHRS;

public class IMU {

	AHRS ahrs;
	ADIS16448_IMU adis;
	
	int selected = 0;

	public IMU(AHRS _ahrs) {
		ahrs = _ahrs;
	}

	public IMU(ADIS16448_IMU _adis) {
		adis = _adis;
	}
	
	public double getYaw() {
		switch (selected) {
			case 0:
				return ahrs.getAngle();
			case 1:
				return adis.getYaw();
			default:
				RobotLogger.toast("IMU NOT FOUND", 1);
				return 0;
		}
	}

}
