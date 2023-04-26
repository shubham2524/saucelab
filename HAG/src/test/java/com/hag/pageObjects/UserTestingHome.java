package com.hag.pageObjects;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hag.utils.BaseSteps;

public class UserTestingHome extends BaseSteps {
	public UserTestingHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(@class,'osano-cm-dialog')]//button[contains(@class,'osano-cm-close')]")
	public WebElement removePopup;
	@FindBy(xpath = "//h3[text()= 'UI vs. UX']")
	public WebElement uivsuxLink;

	public void removePopUp(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", removePopup);

	}

	public void clickOnUiVsUxLink(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", uivsuxLink);

	}

	public void moveUivsuxPage(WebDriver driver) {
		String parentid = driver.getWindowHandle();
		Set<String> allwindowid = driver.getWindowHandles();
		allwindowid.remove(parentid);
		for (String uivsuxPage : allwindowid) {
			driver.switchTo().window(uivsuxPage);
		}
	}

	@FindBy(xpath = "(//button[contains(text(),'Platform')])[1]")
	public WebElement platform;
	@FindBy(linkText = "Accessibility testing")
	public WebElement accessibilityTesting;

	public void hoverOnPlatformAndClickOnAccessibilityTesting(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(platform).perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		wait.until(ExpectedConditions.visibilityOf(accessibilityTesting));
		js.executeScript("arguments[0].click();",accessibilityTesting);
		

		//accessibilityTesting.click();
	}
	
	
	public void moveToUserTestingHomePage(WebDriver driver) {
		String parentid = driver.getWindowHandle();
		Set<String> allwindowid = driver.getWindowHandles();
		allwindowid.remove(parentid);
		for (String userTestingHomePage : allwindowid) {
			driver.switchTo().window(userTestingHomePage);
		}
	}

//	public void clickOnAccessibilityTesting() {
//		accessibilityTesting.click();
//	}

}
