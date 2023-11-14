package com.test.app.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private By emailTextFieldLocator = By.id("inline-form-input-username");
	private By passwordTextFieldLocator = By.id("inline-form-input-password");
	private By signInButtonLocator = By.xpath("//button[contains(@class, 'login')]");
	private WebDriver driver;
	private static final String PAGE_NAME = "LOGIN PAGE";
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmail(String email) {
		driver.findElement(emailTextFieldLocator).sendKeys(email);
		System.out.println(PAGE_NAME+" : Entering Email - "+email);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTextFieldLocator).sendKeys(password);
		System.out.println(PAGE_NAME+" : Entering Password - "+password);
	}
	
	public void clickLogin() {
		driver.findElement(signInButtonLocator).click();
		System.out.println(PAGE_NAME+" : Clicking Login Button.");	
	}

}
