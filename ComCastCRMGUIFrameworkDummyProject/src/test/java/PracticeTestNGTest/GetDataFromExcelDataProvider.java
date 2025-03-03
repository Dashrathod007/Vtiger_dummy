 package PracticeTestNGTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.FileUtility.ExcelUtility;
public class GetDataFromExcelDataProvider 
{
	@Test(dataProvider = "GetData")
	public void GetDataProviderData(String brandname,String productname)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//input[@title='Search for Products, Brands and More']")).sendKeys(brandname);
		driver.findElement(By.xpath("//button[@aria-label='Search for Products, Brands and More']")).click();
		WebElement ele = driver.findElement(By.xpath("//div[text()='"+productname+"']/ancestor::div[@class='tUxRFH']/descendant::div[@class='Nx9bqj _4b5DiR']"));                             
	   System.out.println("The Price of "+ productname +" is " +ele.getText());
	   driver.quit();
	}
	
	@DataProvider
	public Object[][] GetData() throws Exception
	{
		ExcelUtility elib=new ExcelUtility();
		int rowCount=elib.getRowCount("Mobile");
		Object[][] objArr1 =new Object[rowCount][2];
		
		for(int i=0;i<rowCount;i++)
		{
		objArr1[i][0]=elib.getDatafromExcel("Mobile", i+1, 0);
		objArr1[i][1]=elib.getDatafromExcel("Mobile", i+1, 1);
		
	}
		return objArr1;
	
	}
}
