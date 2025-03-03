package com.comcast.crm.OrgTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.PropertyFileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganisationInfoPAge;
import com.comcast.crm.objectrepositoryUtility.OrganisationPage;
import com.comcast.crm.objectrepositoryUtility.creatingNewOrganisationPage;

public class CreateOranisation {

	public static void main(String[] args) throws Exception {
		PropertyFileUtility flib = new PropertyFileUtility();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String url = flib.getDataFromPropertiesFile("url");
		String username = flib.getDataFromPropertiesFile("username");
		String password = flib.getDataFromPropertiesFile("password");
		String browser = flib.getDataFromPropertiesFile("browser");

//Read the TEST script data from Excel sheet
		String orgname = elib.getDatafromExcel("org", 1, 2) + jlib.getRandomNumber();

		WebDriver driver = null;
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		wlib.waitForPageToLoad(driver);
		driver.get(url);

		/*
		 * driver.findElement(By.xpath("//input[@name='user_name']")).clear();
		 * driver.findElement(By.xpath("//input[@name='user_password']")).clear();
		 * 
		 * driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username)
		 * ; driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(
		 * password);
		 * driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		 * driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		 * driver.findElement(By.xpath("//img[@title='Create Organization...']")).click(
		 * );
		 * driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname
		 * );
		 * driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		 * Thread.sleep(2000);
		 */

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(username, password);

		HomePage hp = new HomePage(driver);
		hp.getOrganisationLink().click();

		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateOrganisationBtn().click();

		creatingNewOrganisationPage cnop = new creatingNewOrganisationPage(driver);
		cnop.getOraganisationNameTxtField().sendKeys(orgname);
		cnop.getSaveBtn().click();
		Thread.sleep(2000);

		/*
		 * Verify Header the Expected Result String HeadName =
		 * driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		 */
		OrganisationInfoPAge oip = new OrganisationInfoPAge(driver);
		String HeadName = oip.getOrgHeaderInfo().getText();
		if (HeadName.contains(orgname)) {
			System.out.println(orgname + "is created=====PASS");
		} else {
			System.out.println(orgname + "is not created=====FAILED");
		}
//Verify the Organisation name
		String ActOrgName = oip.getOrgNameInfo().getText();
		System.out.println(ActOrgName);
		System.out.println(orgname);
		if (ActOrgName.equals(orgname)) {
			System.out.println(orgname + "is created=====PASS");
		} else {
			System.out.println(orgname + "is not created==FAILED");
		}
		hp.LogOut();
		driver.quit();

	}

}
