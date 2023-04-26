package com.hag.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hag.utils.BaseSteps;

public class Products extends BaseSteps {
	public Products(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[contains(text(),'Sauce Mobile')]") public WebElement sauceMobile;
	
	public void clickOnSauceMobile() {
		wait.until(ExpectedConditions.visibilityOf(sauceMobile));
		sauceMobile.click();
	
		
	}
	
	

}
