package Practice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportSampleTest  {
	public ExtentReports report;

	@BeforeSuite
	public void ConfigBS() {
		// spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("HDFC result");
		spark.config().setReportName("Home Page");
		spark.config().setTheme(Theme.DARK);

		// Add Environment Information and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Operating System", "Windows 10");
		report.setSystemInfo("Browser", "Chrome-132");
	}

	@AfterSuite
	public void configAS() {
		// BAck up of the report
		report.flush();

	}

	@Test(priority = 1)
	public void createContactWithOrg() {

		ExtentTest test = report.createTest("createContactWithOrg");

		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create the contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contatc is created");
		} else {
			test.log(Status.FAIL, "Conatact is not created");
		}

		test.log(Status.INFO, "Logout from the App");
	}

	@Test(priority = 2)
	public void createContactTest() {

		ExtentTest test = report.createTest("createContactTegst");

		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create the contact");
		if ("HDFC".equals("HDFC")) {
			test.log(Status.PASS, "Contatc is created");
		} else {
			test.log(Status.FAIL, "Conatact is not created");
		}

		test.log(Status.INFO, "Logout from the App");
	}

	@Test(priority = 3)
	public void createContactWithPhoneNumberTest() {

		ExtentTest test = report.createTest("createContactWithPhoneNumberTest");

		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create the contact");
		if ("9972867098".equals("9972867098")) {
			test.log(Status.PASS, "Contatc is created");
		} else {
			test.log(Status.FAIL, "Conatact is not created");
		}

		test.log(Status.INFO, "Logout from the App");
	}
}
