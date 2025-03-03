package com.comcast.crm.ContactTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.PropertyFileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class CreateContactWithSupportDateTC05 {

	public static void main(String[] args) throws Exception 
	{

		PropertyFileUtility flib= new PropertyFileUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
       String url     = flib.getDataFromPropertiesFile("url");
       String username=flib.getDataFromPropertiesFile("username");
       String password=flib.getDataFromPropertiesFile("password");
       String browser =flib.getDataFromPropertiesFile("browser");

		//read the data from excel
		   String firstname = elib.getDatafromExcel("Contact", 1, 2)+jlib.getRandomNumber();
		   String lastname = elib.getDatafromExcel("Contact", 1, 3)+jlib.getRandomNumber();
		   
		 //To Capture the Current date
		   
			String startDate = jlib.getSystemDateYYYYDDMM();
			System.out.println(startDate);
			//to Capture the date after 1 month	
			String endDate =jlib.getRequiredDateYYYYDDMM(30);
			System.out.println(endDate);
			
		   
		 WebDriver driver=null;
		   if(browser.equals("chrome"))
		   {
			   driver=new ChromeDriver();
		   }
		   else if (browser.equals("firefox")) 
		   {
			driver= new FirefoxDriver();
		   }
		   else if (browser.equals("edge")) 
		   {
			driver=new EdgeDriver();
		   }
		   else {
			driver= new ChromeDriver();
		   }
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(url);
		/*
		driver.findElement(By.xpath("//input[@name='user_name']")).clear();
		driver.findElement(By.xpath("//input[@name='user_password']")).clear();

		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='support_start_date']")).clear();
		driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(startDate);
		driver.findElement(By.xpath("//input[@name='support_end_date']")).clear();
		driver.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(endDate);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(2000);*/
		
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(username, password);
	HomePage hp=new HomePage(driver);
	hp.getContactLink().click();
	ContactPage cp=new ContactPage(driver);
	cp.getCreateContactBtn().click();
	CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
	cncp.getFirstNameTxtField().sendKeys(firstname);
	cncp.getLastNameTxtField().sendKeys(lastname);
	cncp.getSupportStartDateField().clear();
	cncp.getSupportStartDateField().sendKeys(startDate);
	cncp.getSupportEndDateField().clear();
	cncp.getSupportEndDateField().sendKeys(endDate);
	
	cncp.getSaveBtn().click();
	
	
	//Verify Header the Expected Result
		String FirstName = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(FirstName.contains(firstname))
		{
			System.out.println(firstname+ "is Verified=====PASS");
		}
		else
		{
			System.out.println(firstname+ "is not verified=====FAILED");
		}
		//Verify the Start date
		String StartDate = driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
		if(StartDate.equals(startDate))
		{
			System.out.println(startDate+ " is Verified=====PASS");
		}
		else
		{
			System.out.println(startDate+ " is not verified=====FAILED");
		}
		//Verify the End date
		
		String EndDate = driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();
		if(EndDate.equals(endDate))
		{
			System.out.println(endDate+ " is Verified=====PASS");
		}
		else
		{
			System.out.println(endDate+ " is not verified=====FAILED");
		}

		Actions act =new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
		driver.quit();

	}

}
