package com.hag.tests;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;
import com.hag.pageObjects.AccessibilityTestingPage;
import com.hag.pageObjects.RequestTrial;
import com.hag.pageObjects.UiUxPage;
import com.hag.pageObjects.UserTestingHome;
import com.hag.utils.BaseSteps;

public class Scenario_6 extends BaseSteps {
	@Test

	public void nevigateToUserTesting() throws InterruptedException {
		String firstname = prop.getProperty("firstname");
		String lastname = prop.getProperty("lastname");
		String jobtitle = prop.getProperty("jobtitle");
		String phonenumber = prop.getProperty("phone");
		String emailid = prop.getProperty("email");
		String comapanyname = prop.getProperty("companyname");

		driver.navigate().to("https://www.usertesting.com/");

		UserTestingHome userTestingHome = new UserTestingHome(driver);

		userTestingHome.removePopUp(driver);
		userTestingHome.clickOnUiVsUxLink(driver);
		userTestingHome.moveUivsuxPage(driver);

		UiUxPage uivsuxpage = new UiUxPage(driver);
		uivsuxpage.clickOnRequestTrial();

		RequestTrial requestTrial = new RequestTrial(driver);
		requestTrial.requestTrialStep1(firstname, lastname, jobtitle, phonenumber, emailid, driver);

		requestTrial.requestTrailForm2(comapanyname);

		requestTrial.printThanksMessage();
		
		userTestingHome.moveToUserTestingHomePage(driver);
		userTestingHome.hoverOnPlatformAndClickOnAccessibilityTesting(driver);
		
		AccessibilityTestingPage accessibility = new AccessibilityTestingPage(driver);
		accessibility.clickOnRequestTrial();

		RequestTrial requestTrial1 = new RequestTrial(driver);
		requestTrial1.requestTrialStep1(firstname, lastname, jobtitle, phonenumber, emailid,driver);

		requestTrial1.requestTrailForm2(comapanyname);
		requestTrial1.printThanksMessage();
		
		//requestTrial.backToHomePage();
		
	
		String titleOfHomepage = driver.getTitle();
		System.out.println("title of home page "+titleOfHomepage);		

	}

}
