package com.hag.tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import java.lang.reflect.Method;
import com.hag.pageObjects.LoginPage;
import com.hag.utils.BaseSteps;

public class Scenario_4 {
	public class Scenarios_4 extends BaseSteps {
		@Test(priority = 4, description = "invalid username and password",groups="regression")

		public void valiadteErroMessage() {

			String invalidusername = prop.getProperty("invalidusername");
			String invalidpassword = prop.getProperty("invalidpassword");
			String expectedErrorMessage = prop.getProperty("expectedErrorMessage");

			LoginPage login = new LoginPage(driver);
			wait.until(ExpectedConditions.titleContains(driver.getTitle()));
			login.login(invalidusername, invalidpassword);

			String actualErrorMessage = login.errormessage.getText();
			Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "ERROR MESSAGE IS NOT SAME  ");
			Reporter.log("ERROR MESSAGE IS VALIDATED", true);

		}

	}
}