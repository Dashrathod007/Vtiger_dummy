package com.comcast.crm.objectrepositoryUtility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement CreateProduct;
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement SearchProdField;
	@FindBy(xpath = "//div[@id='basicsearchcolumns_real']")
	private WebElement ProductDropDown;

}
