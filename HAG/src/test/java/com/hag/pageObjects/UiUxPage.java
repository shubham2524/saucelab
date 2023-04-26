package com.hag.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UiUxPage {
	public UiUxPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Request trial") public WebElement requestTrial;
	
	public void clickOnRequestTrial() {
		requestTrial.click();
	}

}
