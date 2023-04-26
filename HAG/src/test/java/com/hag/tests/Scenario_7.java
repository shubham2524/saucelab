package com.hag.tests;

import org.testng.annotations.Test;

import com.hag.pageObjects.AccessibilityTestingPage;
import com.hag.pageObjects.RequestTrial;
import com.hag.pageObjects.UserTestingHome;
import com.hag.utils.BaseSteps;

public class Scenario_7 extends BaseSteps {
	@Test
	public void moveToAccessibilityTesting() throws InterruptedException {
		String firstname = prop.getProperty("firstname");
		String lastname = prop.getProperty("lastname");
		String jobtitle = prop.getProperty("jobtitle");
		String phonenumber = prop.getProperty("phone");
		String emailid = prop.getProperty("email");
		String comapanyname = prop.getProperty("companyname");

		driver.navigate().to("https://www.usertesting.com/");

		UserTestingHome userTestingHome = new UserTestingHome(driver);
		userTestingHome.removePopUp(driver);
		//userTestingHome.clickOnPlatform(driver);
		//userTestingHome.clickOnAccessibilityTesting();
		
		AccessibilityTestingPage accessibility = new AccessibilityTestingPage(driver);
		accessibility.clickOnRequestTrial();

		RequestTrial requestTrial = new RequestTrial(driver);
		requestTrial.requestTrialStep1(firstname, lastname, jobtitle, phonenumber, emailid,driver);

		requestTrial.requestTrailForm2(comapanyname);
		requestTrial.printThanksMessage();
		requestTrial.backToHomePage();
		
	
		String titleOfHomepage = driver.getTitle();
		System.out.println("title of home page "+titleOfHomepage);	
		
		
		
		
	}

}
