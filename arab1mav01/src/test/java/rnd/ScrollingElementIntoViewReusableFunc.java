package rnd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lib.WebUILib;

public class ScrollingElementIntoViewReusableFunc {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testJavaScriptExecution() throws Exception {
		// Navigation
		WebUILib.executeJS(driver, "window.location = 'https://letskodeit.teachable.com/pages/practice'");
		Thread.sleep(6000);
		
		// Scroll Element Into View - Using element from WebDriver
		WebElement element = driver.findElement(By.id("mousehover"));
		WebUILib.scrollIntoView(driver, element);
		WebUILib.executeJS(driver, "window.scrollBy(0, -80);");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}
}