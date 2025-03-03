package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class  OrganisationInfoPAge
{
	WebDriver driver;
	public OrganisationInfoPAge(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "dvHeaderText")
	private WebElement OrgHeaderInfo;
	@FindBy(id  = "dtlview_Organization Name")
	private WebElement OrgNameInfo;
	@FindBy(id = "dtlview_Phone")
	private WebElement OrgPhoneInfo;
	@FindBy(id="mouseArea_Industry")
	private WebElement IndustryInfo;
	@FindBy(id="dtlview_Type")
	private WebElement TypeInfo;
	
	//getters
	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement getOrgHeaderInfo() {
		return OrgHeaderInfo;
	}
	public WebElement getTypeInfo() {
		return TypeInfo;
	}
	public WebElement getIndustryInfo() {
		return IndustryInfo;
	}
		
	public WebElement getOrgNameInfo() {
		return OrgNameInfo;
	}
	public WebElement getOrgPhoneInfo() {
		return OrgPhoneInfo;
	}
	
	
	
}