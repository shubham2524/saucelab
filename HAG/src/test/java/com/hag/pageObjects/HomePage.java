package com.hag.pageObjects;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage {
	public WebDriver driver;
		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			 this.driver = driver;
		}
		
		@FindBy(id="add-to-cart-sauce-labs-backpack") private WebElement addToCartBackPack;
		@FindBy(xpath ="//div[@class='inventory_item_name']") private List<WebElement> productTitle;
		@FindBy(xpath = "//button[text()='Add to cart']") public List<WebElement> addToCartButton;
		@FindBy(id="shopping_cart_container") public WebElement addToCartLogo;
		@FindBy(xpath = "//div[@class='inventory_item_name' and text()= 'Sauce Labs Backpack']") 
		public static String expectedProduct;
		
	
		
	
		@FindBys(@FindBy(tagName = "a")) public List<WebElement> allproducts;



		public WebElement getAddToCartBackPack() {
			return addToCartBackPack;
		}



		public List<WebElement> getProductTitle() {
			return productTitle;
		}



		



		


		
		
		@FindBys(@FindBy(xpath = "//div[@class='inventory_item_price']")) private List<WebElement> priceOfAllProducts;


		@FindBy(id= "react-burger-menu-btn") public WebElement humburgerMenu;
		
		

		


		public List<WebElement> getPriceOfAllProducts() {
			return priceOfAllProducts;
			
			
		}
		
		
		public void clickOnProductByIndex(int index) {
			expectedProduct  = getProductTitle().get(index).getText();
			addToCartButton.get(index).click();
			addToCartLogo.click();
			
			
			
		}
		public void clickOnProductByText(String text,WebDriver driver) {
		expectedProduct =  driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()= '"+text+"']")).getText();
		driver.findElement(By.xpath("//div[@class='inventory_item_name' and text()= '"+text+"']//ancestor::div[@class='inventory_item_description']//button")).click();
		
			
			
		}
		public void checktheTitleOfParticularProduct() {
			//List<WebElement> allProd = homepage.allproducts;

			boolean flag = false;
			for (WebElement prod : allproducts) {
				String actualproduct = prod.getText();
				// System.out.println(actualproduct);

				if (actualproduct.equals(expectedProduct)) {
					flag = true;

				}

			}
			Assert.assertEquals(true, flag);
		}
		
		

public void printTitlesAndPriceOfAllTheProductByRemoving$Symbol() {
	AddToCartPage addToCartPage = new AddToCartPage(driver);
	//HomePage homepage = new HomePage(driver);
	int size = getProductTitle().size();

	for (int index = 0; index <size; index++) {
		String title = getProductTitle().get(index).getText();
		System.out.println(title);

		addToCartButton.get(index).click();

		addToCartLogo.click();
		String newPrices = addToCartPage.indivisualPrice.getText().replace('$', ' ');
		System.out.println(newPrices);

		addToCartPage.removeButton.click();
		// Thread.sleep(5000);
		addToCartPage.continueShoppingButton.click();

	}
}
		
		
		
		
		

}
