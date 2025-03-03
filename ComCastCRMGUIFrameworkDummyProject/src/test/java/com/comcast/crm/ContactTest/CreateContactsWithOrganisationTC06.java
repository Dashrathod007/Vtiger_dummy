package com.comcast.crm.ContactTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.FileUtility.ExcelUtility;
import com.comcast.crm.generic.FileUtility.PropertyFileUtility;
import com.comcast.crm.generic.WebDriverUtility.JavaUtility;
import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.LoginPage;
import com.comcast.crm.objectrepositoryUtility.OrganisationInfoPAge;
import com.comcast.crm.objectrepositoryUtility.OrganisationPage;
import com.comcast.crm.objectrepositoryUtility.creatingNewOrganisationPage;

public class CreateContactsWithOrganisationTC06 
{

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
	      String orgname =elib.getDatafromExcel("org", 7, 2)+jlib.getRandomNumber();
	      String firstname= elib.getDatafromExcel("Contact", 7, 2)+jlib.getRandomNumber();
	      String lastname = elib.getDatafromExcel("Contact", 7, 3)+jlib.getRandomNumber();
	 		
	 		   
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
			
			
			/*driver.findElement(By.xpath("//input[@name='user_name']")).clear();
			driver.findElement(By.xpath("//input[@name='user_password']")).clear();

			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		     Thread.sleep(2000);*/
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(username, password);
			
			HomePage hp=new HomePage(driver);
			hp.getOrganisationLink().click();
			
		   OrganisationPage op= new OrganisationPage(driver);
		   op.getCreateOrganisationBtn().click();
		   
		   creatingNewOrganisationPage cnop=new creatingNewOrganisationPage(driver);
		   cnop.getOraganisationNameTxtField().sendKeys(orgname);
		   cnop.getSaveBtn().click();
		   
		   OrganisationInfoPAge oip=new OrganisationInfoPAge(driver);		
		     String ActOrgNames =oip.getOrgHeaderInfo().getText();
		     if(ActOrgNames.equals(orgname))
		     {
		     	System.out.println(orgname+ "is created=====PASS");
		     }
		     else
		     {
		     	System.out.println(orgname+ "is not created==FAILED");
		     }
		     
		     //navigate to contact Module
		    /* driver.findElement(By.xpath("//a[text()='Contacts']")).click();
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstname);
				driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
				driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();*/
		     hp.getContactLink().click();
		     ContactPage cp=new ContactPage(driver);
		     cp.getCreateContactBtn().click();
		     CreatingNewContactPage cncp=new CreatingNewContactPage(driver);
		     cncp.getFirstNameTxtField().sendKeys(firstname);
		     cncp.getLastNameTxtField().sendKeys(lastname);
		     driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
				
				//Switch to child window
				wlib.switchToWindowByURL(driver, "?module=Accounts&action");
				Thread.sleep(2000);
				//perform the operations in child window
				
				driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
				driver.findElement(By.xpath("//input[@type='button']")).click();
				driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
				
		
				//Switch Control to the parent
				wlib.switchToWindowByURL(driver, "module=Contacts&action");
				
				 
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				Thread.sleep(2000);
				
				  //to verify the header organisation info
			     String HeadName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			     if(HeadName.contains(firstname))
			     {
			     	System.out.println(firstname + "is created=====PASS");
			     }
			     else
			     {
			     	System.out.println(firstname + "is not created=====FAILED");
			     }	
			     	//Verify the Organisation name is there
			     	String ActOrgName =driver.findElement(By.xpath("//td[@id='mouseArea_Organization Name']")).getText();
			     	if(ActOrgName.trim().equals(orgname))
			     	{
			     		System.out.println(orgname + "is created=====PASS");
			     	}
			     	else
			     	{
			     		System.out.println(orgname + "is not created==FAILED");
			     	}
			     	
			     
				Thread.sleep(2000);
				WebElement ele2=hp.getUserLink();
				wlib.mouseMoveOnElement(driver, ele2);
				hp.getLogoutLink().click();
				driver.quit();

	}

}
