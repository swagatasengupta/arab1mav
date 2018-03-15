package rnd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lib.WebUILib;


public class ExplicitWaitDemo {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
	}
	
	@Test()
	public void test() throws Exception {
		
		WebDriver driver = WebUILib.getDriver("mozilla");
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement userName = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		userName.clear();
		userName.sendKeys("swagatasengupta@yahoo.com");

	}

	@AfterMethod
	public void tearDown() throws Exception {
	}
}
