package com.test.app.testcases;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.app.pageobjects.HomePage;
import com.test.app.pageobjects.LoginPage;

public class MyLibraryNavigationCheckTest {
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
	public void validateMyLibraryNavigation() {
		this.driver.findElement(By.id("library-dropdown")).click();
		int size = this.driver.findElements(By.xpath("//*[@aria-labelledby='library-dropdown']/a")).size();
		this.driver.findElement(By.id("library-dropdown")).click();
		for (int i = 2; i <= size; i++) {
			this.driver.findElement(By.id("library-dropdown")).click();
			WebElement ele = this.driver
					.findElement(By.xpath("(//*[@aria-labelledby='library-dropdown']/a)[" + i + "]"));
			String navText = ele.getText();
			ele.click();
			
			//Validation Code


		}
	}

}
