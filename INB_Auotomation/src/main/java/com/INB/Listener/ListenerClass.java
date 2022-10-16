package com.INB.Listener;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.INB.reports.ExtentLogger;
import com.INB.reports.ExtentReport;

public class ListenerClass implements ITestListener , ISuiteListener {

	public void onStart(ISuite suite) {
		try {
			ExtentReport.initReport();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onFinish(ISuite suite) {
		try {
			ExtentReport.flushReport();

		} catch (IOException e) {

			e.printStackTrace();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getDescription());

	}

	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");

	}

	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName()+" is failed");
		ExtentLogger.fail(result.getThrowable().toString());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));

	}

	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
		ExtentLogger.skip(result.getThrowable().toString());
		ExtentLogger.skip(Arrays.toString(result.getThrowable().getStackTrace()));

	}



	public void onStart(ITestContext context) {


	}

	public void onFinish(ITestContext context) {


	}

}
