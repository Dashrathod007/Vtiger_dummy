package com.comcast.crm.listenerUtility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener; 
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.BaseClassUtility.copy.BaseClass;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;

public class ListenerImplementationClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		// spark report config
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		 spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
		spark.config().setDocumentTitle("HDFC result");
		spark.config().setReportName("Home Page");
		spark.config().setTheme(Theme.DARK);

		// Add Environment Information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("Browser", "Chrome-132");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report Back UP");
		report.flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println("=====" + result.getMethod().getMethodName() + "===START======");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO,result.getMethod().getMethodName()+"======>STARTED<======" );
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("=====" + result.getMethod().getMethodName() + "=====END====");
		test.log(Status.PASS,result.getMethod().getMethodName()+"======>COMPLETED<======" );

	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();

		TakesScreenshot ts = (TakesScreenshot) (BaseClass.sdriver);
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		test.log(Status.FAIL,result.getMethod().getMethodName()+"======>FAILED<======" );

	}
	public void onTestSKipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName()+"======>SKIPPED<======" );
	}

}
