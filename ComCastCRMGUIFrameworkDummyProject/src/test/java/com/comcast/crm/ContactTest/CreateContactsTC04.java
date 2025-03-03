 package com.comcast.crm.ContactTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.PropertyFileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.ContactInfoPage;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;

public class CreateContactsTC04 {

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
       

		//Read the Data from the excel
		   String firstname = elib.getDatafromExcel("Contact", 1, 2)+jlib.getRandomNumber();
		   String lastname = elib.getDatafromExcel("Contact", 1, 3)+jlib.getRandomNumber();
		   
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
cncp.getSaveBtn().click();
Thread.sleep(2000);

		//Verify Header the Expected Result
ContactInfoPage cip=new ContactInfoPage(driver);
String FirstName=cip.getFirstNameInfo().getText();
		//String FirstName = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(FirstName.trim().contains(firstname))
		{
			System.out.println(firstname+ "is Verified=====PASS");
		}
		else
		{
			System.out.println(firstname+ "is not verified=====FAILED");
		}
		String LastName=cip.getLastNameInfo().getText();
		//String FirstName = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if(LastName.trim().contains(lastname))
		{
			System.out.println(lastname+ "is Verified=====PASS");
		}
		else
		{
			System.out.println(lastname+ "is not verified=====FAILED");
		}
		
	WebElement ele2=hp.getUserLink();
	wlib.mouseMoveOnElement(driver, ele2);
	hp.getLogoutLink().click();
		/*Actions act =new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();*/
		driver.quit();


	}

}
