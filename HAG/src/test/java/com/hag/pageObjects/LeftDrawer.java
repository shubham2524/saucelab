package com.hag.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftDrawer {
	public LeftDrawer(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="about_sidebar_link") public WebElement about;
//	public WebElement getAbout() {
//		return about;
//	}
	

}
