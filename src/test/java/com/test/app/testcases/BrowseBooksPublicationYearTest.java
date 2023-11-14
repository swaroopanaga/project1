package com.test.app.testcases;

import java.time.Duration;
import java.util.List;

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

public class BrowseBooksPublicationYearTest {
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
	public void validateBrowseBooksAndSetPublicationYear() {
		homePage.clickBrowseLibrary();
		FilterResultsPage filterResultsPage = new FilterResultsPage(driver);
		filterResultsPage.clickResetAll();
		filterResultsPage.clickPublishedYear();
		filterResultsPage.clickYear("2021");
	}
	
	@Test
	public void searchWord() {
		String[] listOfWords = {"Python", "Paint", "Secure", "Tableau"};
		for(String word: listOfWords) {
			homePage.searchFor(word);
			homePage.clickSearchIcon();
			
			By titlesLocator = By.xpath("//*[@class='product-card__content']/child::*[contains(@class, 'product-title mb-3')]");
			List<WebElement> listOfElements = this.driver.findElements(titlesLocator);
			for(WebElement ele : listOfElements) {
				String actualTitle = ele.getText();
				Assert.assertTrue(actualTitle.contains(word));
			}
		}
		
		
	}

}
