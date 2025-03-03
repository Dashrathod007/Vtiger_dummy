package com.comcast.crm.ScreenShotUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


public class TakeScreenShot {

	public void takeScreenshot(WebDriver driver) throws IOException
	{
		String pics="./Screenshots/";
		Date d=new Date();
		
		String d1 = d.toString();
		String d2 = d1.replaceAll(":", "-");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(pics+d2+".jpeg");
		FileHandler.copy(src, dst);	
	}
	public void takeScreenshot(WebDriver driver,WebElement ele) throws IOException
	{
		String pics="./Screenshots/";
		Date d=new Date();
		String d1 = d.toString();
		String d2 = d1.replaceAll(":", "-");
		File src = ele.getScreenshotAs(OutputType.FILE);
		File dst=new File(pics+d2+".jpeg");
		FileHandler.copy(src, dst);	
	}



}
