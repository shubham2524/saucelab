package com.hag.utils;

import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Listener extends BaseSteps implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExtentReport.getReportObject();
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test = extent.createTest(methodName);
		extenttest.set(test);
		System.out.println(methodName + " started!");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		WebDriver driver = null;
		String methodName = result.getMethod().getMethodName();
		try {
			driver =(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {

		}
		extenttest.get().log(Status.PASS, methodName + " : executed succesfully");
		System.out.println(methodName + " Passed!");

		/* Enable this if screenshot required for passed test cases */
		// extenttest.get().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64)).build());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		extenttest.get().fail(result.getThrowable());
		WebDriver driver = null;

		String methodName = result.getMethod().getMethodName();
		try {

		} catch (Exception e) {
		}
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			// extenttest.get().addScreenCaptureFromPath(getScreenShotPath(methodName,driver));

			extenttest.get().fail(MediaEntityBuilder
					.createScreenCaptureFromBase64String(((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64))
					.build());

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println(methodName + " Failed!");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
