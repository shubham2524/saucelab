package com.hag.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.hag.pageObjects.AboutPage;
import com.hag.pageObjects.AddToCartPage;
import com.hag.pageObjects.HomePage;
import com.hag.pageObjects.LeftDrawer;
import com.hag.pageObjects.LoginPage;
import com.hag.pageObjects.SauceMobilePage;
import com.hag.pageObjects.Products;
import com.hag.utils.BaseSteps;

public class Scenario_5 extends BaseSteps {
	@Test(priority = 5, groups = "regression")

	public void featuresOfRealDeviceCloud() throws InterruptedException {
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");

		LoginPage login = new LoginPage(driver);
		login.login(username, password);

		HomePage homepage = new HomePage(driver);
		homepage.humburgerMenu.click();

		LeftDrawer leftdrawer = new LeftDrawer(driver);
		leftdrawer.about.click();

		AboutPage aboutpage = new AboutPage(driver);
		aboutpage.hoverOnProduct(driver);

		Products products = new Products(driver);
		products.clickOnSauceMobile();
		
		SauceMobilePage saucemobilepage = new SauceMobilePage(driver);
		saucemobilepage.scrollDownUptolearnMorelinkAndClick(driver);
		saucemobilepage.getTitleOfRealDeviceCloud();

	}

}
