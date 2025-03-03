package com.comcast.crm.ContactTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseClassUtility.copy.BaseClass;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.objectrepositoryUtility.ContactInfoPage;
import com.comcast.crm.objectrepositoryUtility.ContactPage;
import com.comcast.crm.objectrepositoryUtility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganisationInfoPAge;
import com.comcast.crm.objectrepositoryUtility.OrganisationPage;
import com.comcast.crm.objectrepositoryUtility.creatingNewOrganisationPage;

@Listeners(com.comcast.crm.listenerUtility.ListenerImplementationClass.class)
public class CreateContactTestNGTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void CreateContactTest() throws Exception {
		System.out.println("Execute CreateContact and Verify");
		UtilityClassObject.getTest().log(Status.INFO, "Read the Data from Excel");
		String firstname = elib.getDatafromExcel("Contact", 1, 2) + jlib.getRandomNumber();
		String lastname = elib.getDatafromExcel("Contact", 1, 3) + jlib.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Contact Page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to new contact page");
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create the Contact with firstname and lastname ");
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getFirstNameTxtField().sendKeys(firstname);
		cncp.getLastNameTxtField().sendKeys(lastname);
		cncp.getSaveBtn().click();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the first name");
		ContactInfoPage cip = new ContactInfoPage(driver);
		String FirstName = cip.getFirstNameInfo().getText();
		boolean status = FirstName.trim().contains(firstname);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the last name");
		String LastName = cip.getLastNameInfo().getText();

		boolean a = LastName.trim().contains(lastname);
		assertEquals(a, true);

	}

	@Test(groups = "regressionTest")
	public void CreateConatctWithSupportDateTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO, "Execute createConatctWithDate and Verify");
		UtilityClassObject.getTest().log(Status.INFO, "Read the Data from Excel");
		String firstname = elib.getDatafromExcel("Contact", 1, 2) + jlib.getRandomNumber();
		String lastname = elib.getDatafromExcel("Contact", 1, 3) + jlib.getRandomNumber();
		String startDate = jlib.getSystemDateYYYYDDMM();
		String endDate = jlib.getRequiredDateYYYYDDMM(30);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Contact page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the create contact page");
		ContactPage cp = new ContactPage(driver);
		UtilityClassObject.getTest().log(Status.INFO,
				"Create New Conatct with name and support start date and end date");
		cp.getCreateContactBtn().click();
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getFirstNameTxtField().sendKeys(firstname);
		cncp.getLastNameTxtField().sendKeys(lastname);
		cncp.getSupportStartDateField().clear();
		cncp.getSupportStartDateField().sendKeys(startDate);
		cncp.getSupportEndDateField().clear();
		cncp.getSupportEndDateField().sendKeys(endDate);
		cncp.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Conatact Name");
		ContactInfoPage cip = new ContactInfoPage(driver);
		String LastName = cip.getLastNameInfo().getText();
		boolean status = LastName.trim().contains(lastname);
		Assert.assertEquals(status, true);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the support Start date");
		String StartDate = cip.getSupportStartDateInfo().getText();
		boolean a = StartDate.trim().contains(startDate);
		assertEquals(a, true);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the support ebd date");
		String EndDate = cip.getSupportStartDateInfo().getText();
		boolean b = EndDate.trim().contains(endDate);
		assertEquals(b, true);

	}

	@Test(groups = "regressionTest")
	public void CreateContactsWithOrganisationTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO, "Create the contact with organisation name");
		UtilityClassObject.getTest().log(Status.INFO, "Read the Data from Excel");
		String orgname = elib.getDatafromExcel("org", 7, 2) + jlib.getRandomNumber();
		String firstname = elib.getDatafromExcel("Contact", 7, 2) + jlib.getRandomNumber();
		String lastname = elib.getDatafromExcel("Contact", 7, 3) + jlib.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the organisation page");
		HomePage hp = new HomePage(driver);
		hp.getOrganisationLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create organisation page");
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateOrganisationBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create the Organisation");
		creatingNewOrganisationPage cnop = new creatingNewOrganisationPage(driver);
		cnop.getOraganisationNameTxtField().sendKeys(orgname);
		cnop.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Organisation name");
		OrganisationInfoPAge oip = new OrganisationInfoPAge(driver);
		String ActOrgNames = oip.getOrgHeaderInfo().getText();
		boolean flag = ActOrgNames.contains(orgname);
		Assert.assertEquals(flag, true);
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Contact page");
		// navigate to contact Module
		hp.getContactLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the Create Contact Page");
		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create the Contact with First name and last name");
		CreatingNewContactPage cncp = new CreatingNewContactPage(driver);
		cncp.getFirstNameTxtField().sendKeys(firstname);
		cncp.getLastNameTxtField().sendKeys(lastname);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();

		// Switch to child window
		UtilityClassObject.getTest().log(Status.INFO, "Switch the control to the child window");
		wlib.switchToWindowByURL(driver, "?module=Accounts&action");
		Thread.sleep(2000);
		// perform the operations in child window

		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@type='button']")).click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		// Switch Control to the parent
		wlib.switchToWindowByURL(driver, "module=Contacts&action");

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		Thread.sleep(2000);

		// to verify the header organisation info
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Header text");
		String HeadName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		boolean a = HeadName.contains(lastname);
		Assert.assertEquals(a, true);

	}
}
