package com.hag.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.hag.utils.BaseSteps;



public class RequestTrial extends BaseSteps {
	public RequestTrial(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='FirstName']")
	public WebElement firstnameTextFeild;
	@FindBy(xpath = "//input[@name='LastName']")
	public WebElement lastnameTextFeild;
	@FindBy(xpath = "//input[@name='Title']")
	public WebElement jobtitleTextFeild;
	@FindBy(xpath = "//input[@name='Phone']")
	public WebElement phonenumberTextFeild;
	@FindBy(xpath = "//input[@name='Email']")
	public WebElement emailtextFeild;
	@FindBy(xpath = "//div[text() ='Next Step']")
	public WebElement nextstepButton;

	public void requestTrialStep1(String firstname, String lastname, String jobtitle, String phonenumber, String email,WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		firstnameTextFeild.sendKeys(firstname);
		lastnameTextFeild.sendKeys(lastname);
		jobtitleTextFeild.sendKeys(jobtitle);
		phonenumberTextFeild.sendKeys(phonenumber);
		emailtextFeild.sendKeys(email);
		js.executeScript("arguments[0].click();", nextstepButton);

	}

	@FindBy(xpath = "//select[@placeholder='Business Use Case']")
	public WebElement businessUseCaseDropdown;
	@FindBy(xpath = "//input[@name='Company']")
	public WebElement companynameTextFeild;
	@FindBy(xpath = "//select[@placeholder='No. of Employees']")
	public WebElement noOfemployessDropdown;
	@FindBy(xpath = "//select[@placeholder='Country']")
	public WebElement countrynameDropdown;
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement submitButton;

	public void requestTrailForm2(String companyname) throws InterruptedException {
		Thread.sleep(1000);
		Select select1 = new Select(businessUseCaseDropdown);
		select1.selectByVisibleText("One time project");
		companynameTextFeild.sendKeys(companyname);

		Select select2 = new Select(noOfemployessDropdown);
		select2.selectByIndex(1);

		Select select3 = new Select(countrynameDropdown);
		select3.selectByVisibleText("India");

		submitButton.click();
	}

	@FindBy(xpath = "//h1[contains(text(),'Thank you for your request!')]")
	public WebElement thanksMessage;

	public void printThanksMessage() {
		wait.until(ExpectedConditions.visibilityOf(thanksMessage));
		String message = thanksMessage.getText();
		System.out.println("thanksMessage "+message);

	}

	@FindBy(id = "Page-1")
	public WebElement backToHomePage;

	public void backToHomePage() {
		backToHomePage.click();

	}

}
