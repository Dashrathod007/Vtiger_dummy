package com.comcast.crm.OrgTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CreateOrganisationWithIndusetyAndTypeTest02 {

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

//Read the TEST script data from Excel sheet
   String orgname=elib.getDatafromExcel("org", 4, 2)+jlib.getRandomNumber() ;
   String industry =elib.getDatafromExcel("org", 4, 3);
   String type =elib.getDatafromExcel("org", 4, 4);
   
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
driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);

 WebElement wb1=driver.findElement(By.xpath("//select[@name='industry']"));
Select s=new Select(wb1);
s.selectByVisibleText(industry);
WebElement wb2=driver.findElement(By.xpath("//select[@name='accounttype']"));
Select s1=new Select(wb2);
s1.selectByVisibleText(type);
System.out.println(industry);
System.out.println(type);
driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
Thread.sleep(2000);
*/
LoginPage lp=new LoginPage(driver);
lp.loginToApp(username, password);
HomePage hp=new HomePage(driver);
hp.getOrganisationLink().click();
OrganisationPage op=new OrganisationPage(driver);
op.getCreateOrganisationBtn().click();
creatingNewOrganisationPage cnop= new creatingNewOrganisationPage(driver);
cnop.getOraganisationNameTxtField().sendKeys(orgname);

WebElement ele1 = cnop.getIndustryDropdown();
wlib.select(ele1, industry);
WebElement ele2=cnop.getTypeDropdown();
wlib.select(ele2, type);
cnop.getSaveBtn().click();;
Thread.sleep(2000);

//Verify Header the Expected Result
OrganisationInfoPAge oip=new OrganisationInfoPAge(driver);
String HeadName = oip.getOrgHeaderInfo().getText();
if(HeadName.contains(orgname))
{
	System.out.println(orgname+ "is created=====PASS");
}
else
{
	System.out.println(orgname+ "is not created=====FAILED");
}
//String ActIndustry = driver.findElement(By.xpath("//td[@id='mouseArea_Industry']")).getText();

String ActIndustry=oip.getIndustryInfo().getText();
if(ActIndustry.equals(industry))
{
	System.out.println(ActIndustry +"is Verified========PASS======");
}else
{
	System.out.println(ActIndustry +"is not verified========Failed======");
	
}
String ActType=oip.getTypeInfo().getText();
//String ActType = driver.findElement(By.xpath("//td[@id='mouseArea_Type']")).getText();
if(ActType.equals(type))
{
	System.out.println(ActType +" is verified========PASS======");
}else
{
	System.out.println(ActType +"is not verified========Failed======");
	
}
WebElement ele4 = hp.getUserLink();
wlib.mouseMoveOnElement(driver, ele4);
hp.getLogoutLink().click();
driver.quit();


	}

}
