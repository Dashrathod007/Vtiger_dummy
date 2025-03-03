package Practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleTheBrokenLink {

	public static void main(String[] args) {
	ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("http://localhost:8888");
	List<WebElement> links = driver.findElements(By.xpath("//a"));
    System.out.println(links.size());
    for(WebElement each:links)
    {
		String link = each.getDomAttribute("href");
		try {
			URL url=new URL(link);
			HttpURLConnection httpcon=(HttpURLConnection) url.openConnection();
			int statusCode=httpcon.getResponseCode();
			System.out.println(statusCode);
			if(statusCode>=400)
			{
				System.out.println(link+"-------->"+statusCode);
			}
			
		}
		catch(Exception e)
		{
			
		}
    }

	}

}
