package com.hag.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.hag.pageObjects.AddToCartPage;
import com.hag.pageObjects.CheckoutImformationPage;

import com.hag.pageObjects.HomePage;
import com.hag.pageObjects.LoginPage;
import com.hag.utils.BaseSteps;

public class Scenario_3 extends BaseSteps {
	@Test(priority = 3,groups="regression")

	public void validateThePrice() throws InterruptedException {
		
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		
		
		LoginPage login = new LoginPage(driver);
		login.login(username, password);

		HomePage homepage = new HomePage(driver);

		AddToCartPage addToCartPage = new AddToCartPage(driver);
		homepage.printTitlesAndPriceOfAllTheProductByRemoving$Symbol();

	

//		test.info("fetch the price of each product and replaces the dollar symbool");
//		List<WebElement> price = homepage.getPriceOfAllProducts();
//		for (WebElement p : price) {
//			String prices = p.getText().replace('$', ' ');
//			ArrayList<String> list = new ArrayList<String>();
//			list.add(prices);
//			System.out.println(list);
//
//		}
//		test.info("get the price of a particular product ");
//		String expectedpriceOfProduct1 = homepage.getPriceOfAllProducts().get(0).getText();
//		homepage.getAddToCartButton().get(0).click();
//		homepage.getAddToCartLogo().click();

//		test.info("get price of particualar product added to the cart");
//		AddToCartPage addToCartPage = new AddToCartPage(driver);
//		addToCartPage.getCheckoutButton().click();
//
//		CheckoutImformationPage checkout = new CheckoutImformationPage(driver);
//		checkout.getFirstnameTextFeild().sendKeys(firstname);
//		checkout.getLastNameTextFeild().sendKeys(lastname);
//		checkout.getPostalcode().sendKeys(postalcode);
//		checkout.getContinueButton().click();
//
//		//FinalCheckOutPage finalpage = new FinalCheckOutPage(driver);
//		//String actualPriceOfProduct1 = finalpage.getPriceOfProduct1().getText();
//
//		Assert.assertEquals(actualPriceOfProduct1, expectedpriceOfProduct1, " PRICE OF PRODUCT IS NOT SAME  ");
//		Reporter.log("PRICE OF THE PRODUCT IS SAME AS ADDED TO THE CART", true);
//		test.pass("product price  matched");

	}

}
