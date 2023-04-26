package com.hag.tests;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.hag.pageObjects.AddToCartPage;
import com.hag.pageObjects.CheckOutOverviewPage;
import com.hag.pageObjects.CheckoutImformationPage;

import com.hag.pageObjects.HomePage;
import com.hag.pageObjects.LoginPage;
import com.hag.pageObjects.checkOutCompletePage;
import com.hag.utils.BaseSteps;

public class Scenario_1 extends BaseSteps {

	@Test(priority = 1,groups = "smoke")

	public void logininTotheapplicaton() throws InterruptedException {
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		String firstname = prop.getProperty("firstname");
		String lastname = prop.getProperty("lastname");
		String postalcode = prop.getProperty("postalcode");

		
		LoginPage login = new LoginPage(driver);
		login.login(username,password);
		
		HomePage homepage = new HomePage(driver);
		homepage.clickOnProductByIndex(0);
		// homepage.clickOnProductByText("Sauce Labs Onesie", driver);
	
		
		AddToCartPage addToCartPage = new AddToCartPage(driver);
		String actualProduct = addToCartPage.addedProduct.getText();
		addToCartPage.clickOnCheckOutButton();
		
		CheckoutImformationPage checkout = new CheckoutImformationPage(driver);
		checkout.checkoutDetails(firstname, lastname, postalcode);
		
	
		CheckOutOverviewPage checko = new CheckOutOverviewPage(driver);
		checko.CheckOutOverViewDetails();
		

		checkOutCompletePage complete = new checkOutCompletePage(driver);
		complete.checkoutCompleteDetails();
		
		
		 String titleofHomepage = driver.getTitle();
		 System.out.println("title of homepage :-"+titleofHomepage);

		Assert.assertEquals(actualProduct, homepage.expectedProduct, "PRODUCT IS NOT SAME  ");
		Reporter.log("PRODUCT IS SAME AS ADDED TO THE CART", true);
		
		System.out.println("actual Product :-" + actualProduct);
		System.out.println("expexted Prdoduct :-" + homepage.expectedProduct);
		
	
			
		}

	}
	

