package com.INB.reports;

import java.awt.Desktop;
import java.io.File;

import java.util.Objects;

import com.INB.constants.FrameworkConstants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import enums.CategoryType;

public final class ExtentReport {
	private ExtentReport() {

	}
	private static ExtentReports extent;
	//work as a logger
	public static void initReport() throws Exception {

		if(Objects.isNull(extent)) {
			extent=new ExtentReports();
			ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);

			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Kiran's INB Automation Reports");
			spark.config().setReportName(" Kiran's INB Automation Test  Reports ");
		}
	}

	public static void flushReport() throws Exception {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
	}

	public static void createTest(String testCaseName) {

		ExtentManager.setExtTest(extent.createTest(testCaseName)); //to create a test

	}

	public static void addAuthors(String [] authors){
		for(String temp:authors) {
			ExtentManager.getExtTest().assignAuthor(temp);}
	}

	public static void addCategory(CategoryType [] category){
		for(CategoryType temp:category) {
			ExtentManager.getExtTest().assignCategory(temp.toString());}
	}


}
