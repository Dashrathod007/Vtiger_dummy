package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

public class RedBusLoginDate {

	public static void main(String[] args) 
	{
		WebDriverUtility wlib=new WebDriverUtility();
		
		WebDriver driver =new ChromeDriver();
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get("https://www.redbus.in/");
		driver.findElement(By.xpath("//i[@class='sc-cSHVUG NyvQv icon icon-datev2']")).click();
		

	}

}
