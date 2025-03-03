package PracticeTestNGTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createDataProviderTest 
{
	@Test(dataProvider="GetData")
	public void CREATEdataProviderTest(String firstname,String lastname)
	{
		System.out.println("FirstName is "+firstname+"  LastNAme is "+lastname);
	}
	@DataProvider
	public Object[][] GetData()
	
	{
		Object[][] objArr=new Object[3][2];
		objArr[0][0]="Sachin";
		objArr[0][1]="Tendulkar";
		
		objArr[1][0]="Virat";
		objArr[1][1]="Kohli";
		
		objArr[2][0]="Rohit";
		objArr[2][1]="sharma";
		return objArr;
	
		
	}
	WebDriver driver=new ChromeDriver();
public WebDriver getDriver() {
	return driver;
}
}
