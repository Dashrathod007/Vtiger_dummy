package Practice;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExrentReportWithScreenShots {
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

	@Test
	public void createContactWithOrg() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String filePath=ts.getScreenshotAs(OutputType.BASE64);

		ExtentTest test = report.createTest("createContactWithOrg");

		test.log(Status.INFO, "Login to App");
		test.log(Status.INFO, "Navigate to contact page");
		test.log(Status.INFO, "create the contact");
		if ("HDFCcc".equals("HDFC")) {
			test.log(Status.PASS, "Contatc is created");
		} else {
			test.addScreenCaptureFromBase64String(filePath, "Error");
		}

		test.log(Status.INFO, "Logout from the App");
	}
}
