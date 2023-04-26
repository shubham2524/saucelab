package com.hag.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "checkout")
	public WebElement checkoutButton;
	@FindBy(id = "continue-shopping")
	public WebElement continueShoppingButton;

	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeButton;
	@FindBy(xpath = "//div[contains(text(),'$')]")
	public WebElement indivisualPrice;
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	public WebElement addedProduct;

	public void clickOnCheckOutButton() {
		checkoutButton.click();
	}

//	@FindBy(xpath = "//div[@class='inventory_item_price']")
//	private WebElement priceOfProducts;
//
//	public WebElement getPriceOfProducts() {
//		return priceOfProducts;
//	}
//	
//	@FindBys(@FindBy(xpath = "//div[@class='inventory_item_price']")) private List<WebElement> priceOfAllProducts;
//
//
//
//	public List<WebElement> getPriceOfAllProducts() {
//		return priceOfAllProducts;
//	}

}
