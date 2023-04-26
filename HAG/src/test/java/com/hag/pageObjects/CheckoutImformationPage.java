package com.hag.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutImformationPage {

	public CheckoutImformationPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	@FindBy(id="first-name") public WebElement firstnameTextFeild ;
	@FindBy(id="last-name") public WebElement lastNameTextFeild;
	@FindBy(id="postal-code") public WebElement postalcodeTextFeild;
	@FindBy(id="continue") public WebElement continueButton;
	
	public void checkoutDetails(String firstname,String lastname,String postalcode) {
		firstnameTextFeild.sendKeys(firstname);
		lastNameTextFeild.sendKeys(lastname);
		postalcodeTextFeild.sendKeys(postalcode);
		continueButton.click();
	}
	
	
	
	

}
