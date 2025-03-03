package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage // Rule 1 Seperate logine java class created
{
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Rule 2 Identify all the elements by @FindBy
	@FindBy(name = "user_name")
	private WebElement usernameEdit;

	@FindBy(name = "user_password")
	private WebElement passwordEdit;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	// Rule 3 Objection initilization will be done in the Test Script

//Rule 4 provide the setter service to access the the Webelements

	// Rule 5 Provide action
	public void loginToApp(String username, String password) {
		driver.manage().window().maximize();
		usernameEdit.clear();
		passwordEdit.clear();
		usernameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		loginBtn.click();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsernameEdit() {
		return usernameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
