package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage 
{
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name  = "firstname")
	private WebElement FirstNameTxtField;
	@FindBy(name = "lastname") 
	private WebElement LastNameTxtField;
	@FindBy(id = "jscal_field_support_start_date")
	private WebElement SupportStartDateField;
	@FindBy (id ="jscal_field_support_end_date")
	private WebElement SupportEndDateField;
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getFirstNameTxtField() {
		return FirstNameTxtField;
	}
	public WebElement getLastNameTxtField() {
		return LastNameTxtField;
	}
	public WebElement getSupportStartDateField() {
		return SupportStartDateField;
	}
	public WebElement getSupportEndDateField() {
		return SupportEndDateField;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	
	
	

}
