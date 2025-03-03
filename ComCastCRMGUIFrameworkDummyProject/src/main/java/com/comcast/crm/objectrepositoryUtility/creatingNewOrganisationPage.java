package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class creatingNewOrganisationPage 
{
	WebDriver driver;
	public creatingNewOrganisationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "accountname")
	private WebElement OraganisationNameTxtField;
	@FindBy(name = "website")
	private WebElement WebsiteTxtField;
	@FindBy(name = "tickersymbol")
	private WebElement tickerSymbolTxtField;
	@FindBy(name = "phone")
	private WebElement PhoneTxtField;
	@FindBy(name = "employees")
	private WebElement employeesTxtField;
	@FindBy(name = "fax")
	private WebElement faxTxtField;
	@FindBy(name = "otherphone")
	private WebElement otherphoneTxtField;
	@FindBy(xpath  = "(//input[@class='crmbutton small save'])[1]")
	private WebElement SaveBtn;
	@FindBy(xpath  = "(//input[@class='crmbutton small cancel'])[1]")
	private WebElement CancelBtn;
	@FindBy(name = "industry")
	private WebElement IndustryDropdown;
	@FindBy(name = "accounttype")
	private WebElement TypeDropdown;
	
	//getters
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getTypeDropdown() {
		return TypeDropdown;
	}
	public WebElement getIndustryDropdown() {
		return IndustryDropdown;
	}
	public WebElement getOraganisationNameTxtField() {
		return OraganisationNameTxtField;
	}
	public WebElement getWebsiteTxtField() {
		return WebsiteTxtField;
	}
	public WebElement getTickerSymbolTxtField() {
		return tickerSymbolTxtField;
	}
	public WebElement getPhoneTxtField() {
		return PhoneTxtField;
	}
	public WebElement getEmployeesTxtField() {
		return employeesTxtField;
	}
	public WebElement getFaxTxtField() {
		return faxTxtField;
	}
	public WebElement getOtherphoneTxtField() {
		return otherphoneTxtField;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public WebElement getCancelBtn() {
		return CancelBtn;
	}
	
	public void CreateOrganisation(String OrgName)
	{
		OraganisationNameTxtField.sendKeys(OrgName);
		SaveBtn.click();
	}
	
	public void CreateOrgIndustry(String industry,String type)
	{
		Select sel= new Select(IndustryDropdown);
		Select sel1=new Select(TypeDropdown);
		sel.selectByVisibleText(industry);
		sel1.selectByVisibleText(type);
	}
	}
	 

