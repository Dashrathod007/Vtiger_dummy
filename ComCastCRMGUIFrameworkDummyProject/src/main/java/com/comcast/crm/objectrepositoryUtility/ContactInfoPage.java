package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
WebDriver driver;
public ContactInfoPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(id = "dtlview_Last Name")
private WebElement LastNameInfo;
@FindBy(id = "dtlview_First Name")
private WebElement FirstNameInfo;
@FindBy(id = "dvHeaderText")
private WebElement ContactHeaderInfo;
@FindBy(id = "dtlview_Support Start Date")
private WebElement SupportStartDateInfo;
@FindBy(id = "dtlview_Support End Date")
private WebElement SupportEndDateInfo;
public WebDriver getDriver() {
	return driver;
}
public WebElement getLastNameInfo() {
	return LastNameInfo;
}
public WebElement getFirstNameInfo() {
	return FirstNameInfo;
}
public WebElement getContactHeaderInfo() {
	return ContactHeaderInfo;
}
public WebElement getSupportStartDateInfo() {
	return SupportStartDateInfo;
}
public WebElement getSupportEndDateInfo() {
	return SupportEndDateInfo;
}



}
