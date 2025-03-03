package com.comcast.crm.OrgTest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseClassUtility.copy.BaseClass;
import com.comcast.crm.generic.WebDriverUtility.UtilityClassObject;
import com.comcast.crm.objectrepositoryUtility.HomePage;
import com.comcast.crm.objectrepositoryUtility.OrganisationInfoPAge;
import com.comcast.crm.objectrepositoryUtility.OrganisationPage;
import com.comcast.crm.objectrepositoryUtility.creatingNewOrganisationPage;
@Listeners(com.comcast.crm.listenerUtility.ListenerImplementationClass.class)
public class CreateNewOrgTestNGTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void CreateOrg() throws Exception {
		System.out.println("Execute CreateOrganisation and Verify");
		UtilityClassObject.getTest().log(Status.INFO, "Read the Data from Excel");
		String orgname = elib.getDatafromExcel("org", 1, 2) + jlib.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "Navibagte to Organisation page");
		HomePage hp = new HomePage(driver);
		hp.getOrganisationLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Click on new Organisation Button");
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateOrganisationBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the create new organisation");
		creatingNewOrganisationPage cnop = new creatingNewOrganisationPage(driver);
		cnop.getOraganisationNameTxtField().sendKeys(orgname);
		cnop.getSaveBtn().click();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Header Text ");
		OrganisationInfoPAge oip = new OrganisationInfoPAge(driver);
		String HeadName = oip.getOrgHeaderInfo().getText();
		boolean a = HeadName.contains(orgname);
		Assert.assertEquals(a, true);
		// Verify the Organisation name
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Organisation name");
		String ActOrgName = oip.getOrgNameInfo().getText();
		SoftAssert soft = new SoftAssert();
		boolean b=ActOrgName.contains(orgname);
		soft.assertEquals(b, true);
		soft.assertAll();
	}

	@Test(groups = "regressionTest")
	public void CreateOrgWithIndustry() throws Exception {
		System.out.println("Execute CreateOrgWithIndustry and Verify");
		UtilityClassObject.getTest().log(Status.INFO, "Read the Data from Excel");
		String orgname = elib.getDatafromExcel("org", 4, 2) + jlib.getRandomNumber();
		String industry = elib.getDatafromExcel("org", 4, 3);
		String type = elib.getDatafromExcel("org", 4, 4);
		UtilityClassObject.getTest().log(Status.INFO, "Navibagte to Organisation page");
		HomePage hp = new HomePage(driver);
		hp.getOrganisationLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the create new organisation");
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateOrganisationBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the create new organisation");
		creatingNewOrganisationPage cnop = new creatingNewOrganisationPage(driver);
		cnop.getOraganisationNameTxtField().sendKeys(orgname);
		UtilityClassObject.getTest().log(Status.INFO, "Create new organisation with Industry");
		WebElement ele1 = cnop.getIndustryDropdown();
		wlib.select(ele1, industry);
		UtilityClassObject.getTest().log(Status.INFO, "Create new organisation with Type");
		WebElement ele2 = cnop.getTypeDropdown();
		wlib.select(ele2, type);
		cnop.getSaveBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Header Text ");
		Thread.sleep(2000);
		OrganisationInfoPAge oip = new OrganisationInfoPAge(driver);
		String HeadName = oip.getOrgHeaderInfo().getText();
		boolean b = HeadName.contains(orgname);
		Assert.assertEquals(b, true);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Organisation industy ");
		String ActIndustry = oip.getIndustryInfo().getText();
		boolean c= ActIndustry.contains(industry);
		assertEquals(c, true);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the organisation Type");
		String ActType = oip.getTypeInfo().getText();
		boolean d= ActType.contains(type);
		assertEquals(d, true);
	}

	@Test(groups = "regressionTest")
	public void CreateOrganisationWithPhoneNumberTest() throws Exception {
		UtilityClassObject.getTest().log(Status.INFO, "Create the Organisation with phone number");
		UtilityClassObject.getTest().log(Status.INFO, "Read the Data from Excel");
		String orgname = elib.getDatafromExcel("org", 7, 2) + jlib.getRandomNumber();
		String Pnum = elib.getDatafromExcel("org", 7, 3);
		UtilityClassObject.getTest().log(Status.INFO, "Navibagte to Organisation page");
		HomePage hp = new HomePage(driver);
		hp.getOrganisationLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to the create new organisation");
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateOrganisationBtn().click();
		UtilityClassObject.getTest().log(Status.INFO,"create new organisation");
		creatingNewOrganisationPage cnop = new creatingNewOrganisationPage(driver);
		cnop.getOraganisationNameTxtField().sendKeys(orgname);
		UtilityClassObject.getTest().log(Status.INFO, "Create New Organisation with Phone Number");
		cnop.getPhoneTxtField().sendKeys(Pnum);
		cnop.getSaveBtn().click();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Organisation name");
		OrganisationInfoPAge oip = new OrganisationInfoPAge(driver);
		String HeadName = oip.getOrgHeaderInfo().getText();
		boolean b = HeadName.contains(orgname);
		Assert.assertEquals(b, true);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Organisation Phone Number");
		String Actphone = oip.getOrgPhoneInfo().getText();
		boolean c = Actphone.trim().contains(Pnum);
		assertEquals(c, true);
		

	}

	@Test(groups = "regressionTest")
	public void CreateAndDeleteOrgTest() throws Exception {
		// Read the TEST script data from Excel sheet#
		UtilityClassObject.getTest().log(Status.INFO, "Read the data from excel sheet");
		String orgname = elib.getDatafromExcel("org", 9, 2) + jlib.getRandomNumber();
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to new Organisation page");
		HomePage hp = new HomePage(driver);
		hp.getOrganisationLink().click();
		UtilityClassObject.getTest().log(Status.INFO, "NAvigatetoCreate new Oraganisation page");
		OrganisationPage op = new OrganisationPage(driver);
		op.getCreateOrganisationBtn().click();
		UtilityClassObject.getTest().log(Status.INFO, "Create new Organisation");
		creatingNewOrganisationPage cnop = new creatingNewOrganisationPage(driver);
		cnop.getOraganisationNameTxtField().sendKeys(orgname);
		cnop.getSaveBtn().click();
		Thread.sleep(2000);
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Header name");
		OrganisationInfoPAge oip = new OrganisationInfoPAge(driver);
		String HeadName = oip.getOrgHeaderInfo().getText();
		boolean c = HeadName.contains(orgname);
		Assert.assertEquals(c, true);

		// Verify the Organisation name
		UtilityClassObject.getTest().log(Status.INFO, "Verify the Organisation Name");
		String ActOrgName = oip.getOrgNameInfo().getText();
		boolean a =ActOrgName.contains(orgname);
		assertEquals(a, true);

		// delete the organisation
		UtilityClassObject.getTest().log(Status.INFO, "Delete the created Organisation");
		hp.getOrganisationLink().click();
		op.getSearchTextField().sendKeys(orgname);
		wlib.select(op.getSerachDropDown(), "Organization Name");
		op.getSerchNowBtn().click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']/../../td[8]/a[text()='del']")).click();
		wlib.AlertPopupAccept(driver);
	}
}
