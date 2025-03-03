package com.comcast.crm.BaseClassUtility.copy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.crm.generic.DatabaseUtility.DataBaseUtility;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.PropertyFileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class BaseClass {
	public PropertyFileUtility flib = new PropertyFileUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public DataBaseUtility dlib = new DataBaseUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() throws Exception {
		System.out.println("======Connect to DB, Report the Config=======");
		dlib.getdbConnection();

	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC() throws Exception {
		System.out.println("====Launch the Browser======");

		String Browser = flib.getDataFromPropertiesFile("browser");
		// flib.getDataFromPropertiesFile("browser");
		/*
		 * ChromeOptions options=new ChromeOptions();
		 * options.addArguments("--inconginito--"); FirefoxOptions options1=new
		 * FirefoxOptions(); options1.addArguments("--inconginito--");
		 */

		String url = flib.getDataFromPropertiesFile("url");
		if (Browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (Browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (Browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setdriver(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(url);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Exception {
		System.out.println("=====Login=====");
		LoginPage lp = new LoginPage(driver);
		String Username = flib.getDataFromPropertiesFile("username");
		String Password = flib.getDataFromPropertiesFile("password");
		lp.loginToApp(Username, Password);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAM() {
		System.out.println("====Logout=====");
		HomePage hp = new HomePage(driver);
		hp.LogOut();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("======Close the Browser=====");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAS() throws Exception {
		System.out.println("======Close the DB Report BackUp======");
		dlib.closedbConnection();
	}

}
