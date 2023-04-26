package com.hag.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkOutCompletePage {
	
	public checkOutCompletePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//h2[contains(text(),'Thank you for your order!')]")
	public WebElement finalmessage;
	@FindBy(xpath="//div[@class =\"complete-text\"]")
	public WebElement finaltext;
	@FindBy(id="back-to-products") public WebElement backToHomeButton;
	
	@FindBy(xpath="//div[@id='checkout_complete_container']/../../../..//h2[contains(text(),'Thank you for your order!')]") private WebElement mainmessage;
	
	public WebElement getMainmessage() {
		return mainmessage;
	}
	@FindBy(xpath="//span[contains(text(),'Checkout: Complete!')]") private WebElement checkoutmessage;
	public WebElement getCheckoutmessage() {
		return checkoutmessage;
	}
	
	
	
	public void checkoutCompleteDetails() {
		String finaltexts = finaltext.getText();
		String finalmessages = finalmessage.getText();
		System.out.println("final text :-"+finaltexts);
		System.out.println("final message :-"+finalmessages);
		backToHomeButton.click();
		
	}
	
	

}
