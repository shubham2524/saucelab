package com.hag.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hag.utils.BaseSteps;

public class AboutPage extends BaseSteps {

	public AboutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()= 'Products'][1]")
	public WebElement product;

	@FindBy(id = "onetrust-close-btn-container")
	public WebElement xsymbol;

	public void hoverOnProduct(WebDriver driver) {
		xsymbol.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(product).perform();
	}
}
