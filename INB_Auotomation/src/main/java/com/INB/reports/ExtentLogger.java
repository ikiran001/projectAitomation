package com.INB.reports;


import com.INB.utils.ReadPropertyFile;
import com.INB.utils.ScreenShotUtils;
import com.aventstack.extentreports.MediaEntityBuilder;

import enums.ConfigProperties;

public final class ExtentLogger {
	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtTest().skip(message);
	}

	public static void pass(String message , boolean isScreenshotNeeded) throws Exception {
		if(ReadPropertyFile.get(ConfigProperties.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")  
				&& 	isScreenshotNeeded ) {
			ExtentManager.getExtTest().pass(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}
		else {pass(message);}

	}

	public static void fail(String message , boolean isScreenshotNeeded) throws Exception {
		if(ReadPropertyFile.get(ConfigProperties.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")  
				&& 	isScreenshotNeeded ) {
			ExtentManager.getExtTest().fail(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}
		else {fail(message);}
	}

	public static void skip(String message , boolean isScreenshotNeeded) throws Exception {
		if(ReadPropertyFile.get(ConfigProperties.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")  
				&& 	isScreenshotNeeded ) {
			ExtentManager.getExtTest().skip(message, MediaEntityBuilder
					.createScreenCaptureFromBase64String(ScreenShotUtils.getBase64Image()).build());
		}
		else {skip(message);}
	}







}
