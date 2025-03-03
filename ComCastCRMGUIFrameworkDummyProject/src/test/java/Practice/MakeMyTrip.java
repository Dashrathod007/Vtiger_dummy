package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class MakeMyTrip {

	public static void main(String[] args) {
		String monthAndYear="August 2025";
		   int date=25;
		   
		   WebDriver driver=new ChromeDriver();
	       driver.get("https://www.makemytrip.com/");
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	       
	       driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
	       WebElement ele=driver.findElement(By.id("departure"));
	       Actions act=new Actions(driver);
	       act.doubleClick(ele).perform();
	       for(;;) 
	    {
	    	   try {
	      
	       WebElement ele1=driver.findElement(By.xpath("//div[text( )='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text( )='"+date+"']") );
	       act.doubleClick(ele1).perform();
	       break;
	    	   }
	       catch(Exception e)
	       {
	    	   WebElement ele2=driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"));
	    	   act.doubleClick(ele2).perform();
	       }
	
	       }
	       driver.quit();

	}

}
