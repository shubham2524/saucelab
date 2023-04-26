package com.hag.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.hag.pageObjects.HomePage;

import com.hag.pageObjects.LoginPage;
import com.hag.utils.BaseSteps;

public class Scenarios_2 extends BaseSteps {
	@Test(priority = 2,groups ="smoke")

	public void checkTheParticularProduct() {

		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		LoginPage login = new LoginPage(driver);
		login.login(username, password);

		HomePage homepage = new HomePage(driver);
		homepage.checktheTitleOfParticularProduct();

		Reporter.log("matcehd product", true);

	}

}
