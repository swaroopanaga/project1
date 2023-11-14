package com.test.app.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FilterResultsPage {
	
	public By resetAllLocator = By.xpath("//*[text()='Reset All']");
	public By publishedYearLocator = By.xpath("//*[text()='Published Year']");
	
	private WebDriver driver;
	public FilterResultsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickResetAll() {
		this.driver.findElement(resetAllLocator).click();
		System.out.println("Clicking on Reset All Link");
	}
	
	public void clickPublishedYear() {
		this.driver.findElement(publishedYearLocator).click();
		System.out.println("Clicking on Published Year");
	}
	
	public void clickYear(String year) {
		this.driver.findElement(By.xpath("//*[text()='Published Year']/following::*[@class='popup']/div/div[@class='value' and text()='"+year+"']")).click();
		System.out.println("Clicking year : "+year);
	}

}
