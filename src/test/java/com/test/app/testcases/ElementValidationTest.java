package com.test.app.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.app.pageobjects.FilterResultsPage;
import com.test.app.pageobjects.HomePage;
import com.test.app.pageobjects.LoginPage;

public class ElementValidationTest {
	private WebDriver driver;
	private LoginPage loginPage;
	private HomePage homePage;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		loginToApp();
	}

	public void loginToApp() {
		driver.get("https://subscription.packtpub.com/");
		driver.findElement(By.xpath("//a[text()='Sign In']")).click();

		loginPage.enterEmail("apptest2@gmail.com");
		loginPage.enterPassword("App@12345");
		loginPage.clickLogin();
	}

	@Test
	public void validatePacktBrandLogo() {
		WebElement brandLogoElement = this.driver.findElement(homePage.brandLogoLocator);
		boolean isDisplayed = brandLogoElement.isDisplayed();
		Assert.assertTrue(isDisplayed, "Brand Logo is not displayed");

		String color = brandLogoElement.getCssValue("color");
		Assert.assertEquals(color, "rgba(69, 74, 85, 1)", "Brand Logo color is not correct");
		String fontSize = brandLogoElement.getCssValue("font-size");
		Assert.assertEquals(fontSize, "14px", "Brand font-size is not correct");
		String lineHeight = brandLogoElement.getCssValue("line-height");
		Assert.assertEquals(lineHeight, "16px", "Brand line-height is not correct");
	}

	@Test
	public void validateBrowseLibraryElement() {
		WebElement browseLibraryElement = this.driver.findElement(homePage.browseLibraryLocator);
		boolean isDisplayed = browseLibraryElement.isDisplayed();
		Assert.assertTrue(isDisplayed, "Browse Library Element is not displayed");

	}

	@Test
	public void validateAdvancedSearchButtonElement() {
		WebElement advSearchElement = this.driver.findElement(homePage.advSearchButtonLocator);
		boolean isDisplayed = advSearchElement.isDisplayed();
		Assert.assertTrue(isDisplayed, "Adv Search Element is not displayed");

		String color = advSearchElement.getCssValue("color");
		Assert.assertEquals(color, "rgba(236, 102, 17, 1)", "Adv Search Element color is not correct");

		String height = advSearchElement.getCssValue("height");
		Assert.assertEquals(height, "40px", "Adv Search Element height is not correct");
	}

	@Test
	public void validateStartFreeTrialButtonElement() {
		WebElement advSearchElement = this.driver.findElement(homePage.startFreeTrialButton);
		boolean isDisplayed = advSearchElement.isDisplayed();
		Assert.assertTrue(isDisplayed, "Start Trial Element is not displayed");

		String color = advSearchElement.getCssValue("color");
		String fontSize = advSearchElement.getCssValue("font-size");
		String fontWeight = advSearchElement.getCssValue("font-weight");

		Assert.assertEquals(color, "rgba(255, 255, 255, 1)", "Start Trial Element color is not correct");

		Assert.assertEquals(fontSize, "16px", "Start Trial Element font size is not correct");

		Assert.assertEquals(fontWeight, "500", "Start Trial Element font weight is not correct");
	}
	
	public void validateBrowseBooksAndSetPublicationYear() {
		homePage.clickBrowseLibrary();
		FilterResultsPage filterResultsPage = new FilterResultsPage(driver);
		filterResultsPage.clickResetAll();
		filterResultsPage.clickPublishedYear();
		filterResultsPage.clickYear("2021");
	}

}
