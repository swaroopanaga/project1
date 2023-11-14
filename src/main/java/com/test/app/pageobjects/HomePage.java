package com.test.app.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public By brandLogoLocator = By.className("navbar-brand");
	public By browseLibraryLocator = By.xpath("//a[text()='Browse Library' and @class='nav-link']");
	public By advSearchButtonLocator = By.xpath("//button[text()='Advanced Search']");
	public By startFreeTrialButton = By.xpath("//a[text()='Start FREE trial']");
	public By searchFieldLocator = By.name("query");
	public By searchButtonLocator = By.xpath("//button[@type='submit']");
	private WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBrowseLibrary() {
		this.driver.findElement(browseLibraryLocator).click();
		System.out.println("Clicked on Browser Library button");
	}
	
	public void searchFor(String word) {
		this.driver.findElement(searchFieldLocator).sendKeys(word);
		System.out.println("Searching for : "+word);
	}
	
	public void clickSearchIcon() {
		this.driver.findElement(searchButtonLocator).click();
		System.out.println("Clicking search button");
	}
	
	
	
	

}
