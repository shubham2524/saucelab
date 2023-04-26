package com.hag.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {
	
	public CheckOutOverviewPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath= "//div[text()= 'SauceCard #31337']") public WebElement paymentImformation;
	@FindBy(xpath = "//div[text()= 'Free Pony Express Delivery!']") public WebElement shippingImformation;
	@FindBy(xpath = "//div[@class =\"summary_tax_label\"]") public WebElement total;
	@FindBy(xpath = "//div[@class =\"summary_subtotal_label\"]") public WebElement subtotal;
	@FindBy(id= "finish") public WebElement finishButton;
	
	
	public void CheckOutOverViewDetails() {
		String PaymentImformaton = paymentImformation.getText();
		String Shippingimformation = shippingImformation.getText();
		String subTotal = subtotal.getText();
		String totals = total.getText();
		System.out.println("paymentImformaton" + PaymentImformaton);
		System.out.println("shippingimformation" + Shippingimformation);
		System.out.println("subTotal" + subTotal);
		System.out.println("total price" + totals);
		finishButton.click();
	}
	
	
	
	

}
