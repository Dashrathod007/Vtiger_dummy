package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.comcast.crm.generic.WebDriverUtility.WebDriverUtility;

public class IRCTC {

	public static void main(String[] args) {
WebDriverUtility wlib=new WebDriverUtility();
ChromeOptions ch=new ChromeOptions();
ch.addArguments("--disable-notifications");
WebDriver driver =new ChromeDriver(ch);
		wlib.maximize(driver);
		wlib.waitForPageToLoad(driver);
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Pune");
		driver.findElement(By.xpath("//li[@class=\"ng-tns-c57-8 ng-star-inserted ui-autocomplete-list-item ui-corner-all\"]")).click();
		
	}

}
