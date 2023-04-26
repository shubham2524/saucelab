package com.hag.pageObjects;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.hag.utils.BaseSteps;

public class SauceMobilePage extends BaseSteps {
	public SauceMobilePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[text()='Real device cloud']//parent::div//parent::div//span[text()='Learn more']")
	public WebElement learnmoreLink;
	@FindBy(xpath = "//h2[text()='Features of real device cloud']//parent::div//parent::div//parent::div//h3")
	public List<WebElement> titleOfRealDevicecloud;

	public void scrollDownUptolearnMorelinkAndClick(WebDriver driver) {
		Point location = learnmoreLink.getLocation();
		wait.until(ExpectedConditions.visibilityOf(learnmoreLink));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("arguments[0].scrollIntoView(false);",learmorelink);
		js.executeScript("window.scrollBy(location)", "");
		learnmoreLink.click();

	}

	public void getTitleOfRealDeviceCloud() {
		int size = titleOfRealDevicecloud.size();
		for (int i = 0; i < size; i++) {
			String titles = titleOfRealDevicecloud.get(i).getText();
			System.out.println(titles);
		}
	}

}
