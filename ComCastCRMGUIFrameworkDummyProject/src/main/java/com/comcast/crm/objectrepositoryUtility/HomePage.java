package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "query_string")
	private WebElement SerachField;
	@FindBy(className = "searchBtn")
	private WebElement SearchBtn;
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement UserLink;
	@FindBy(linkText = "themes/softed/images/info.PNG")
	private WebElement InfoLink;
	@FindBy(linkText = "themes/softed/images/mainSettings.PNG")
	private WebElement SettingLink;
	@FindBy(className = "tabSelected")
	private WebElement HomeLink;
	@FindBy(linkText = "index.php?module=Leads&action=index")
	private WebElement LeadsLink;
	@FindBy(xpath = "//a[@href='index.php?module=Accounts&action=index']")
	private WebElement OrganisationLink;
	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement ContactLink;
	@FindBy(linkText = "index.php?module=Contacts&action=index")
	private WebElement OpportunitiesLink;
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement ProductsLink;
	@FindBy(linkText = "index.php?module=Documents&action=index")
	private WebElement DocumentsLink;
	@FindBy(linkText = "index.php?module=Emails&action=index")
	private WebElement EmailLink;
	@FindBy(linkText = "index.php?module=HelpDesk&action=index")
	private WebElement TroubleTicketsLink;
	@FindBy(linkText = "index.php?module=HelpDesk&action=index")
	private WebElement DashBoardLink;
	@FindBy(linkText = "javascript:;")
	private WebElement MoreLink;
	@FindBy(id = "qccombo")
	private WebElement QuickCreateDropDown;
	@FindBy(linkText = "index.php?action=index&module=Home")
	private WebElement BackToHomePage;
	@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")
	private WebElement LogoutLink;

//Getters
	public WebElement getLogoutLink() {
		return LogoutLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSerachField() {
		return SerachField;
	}

	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getUserLink() {
		return UserLink;
	}

	public WebElement getInfoLink() {
		return InfoLink;
	}

	public WebElement getSettingLink() {
		return SettingLink;
	}

	public WebElement getHomeLink() {
		return HomeLink;
	}

	public WebElement getLeadsLink() {
		return LeadsLink;
	}

	public WebElement getContactLink() {
		return ContactLink;
	}

	public WebElement getOrganisationLink() {
		return OrganisationLink;
	}

	public WebElement getOpportunitiesLink() {
		return OpportunitiesLink;
	}

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getDocumentsLink() {
		return DocumentsLink;
	}

	public WebElement getEmailLink() {
		return EmailLink;
	}

	public WebElement getTroubleTicketsLink() {
		return TroubleTicketsLink;
	}

	public WebElement getDashBoardLink() {
		return DashBoardLink;
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getQuickCreateDropDown() {
		return QuickCreateDropDown;
	}

	public WebElement getBackToHomePage() {
		return BackToHomePage;
	}

	public void LogOut() {
		Actions act = new Actions(driver);
		act.moveToElement(UserLink).perform();
		LogoutLink.click();
	}

}
