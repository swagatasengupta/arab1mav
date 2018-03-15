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

public class ScrollingElementIntoView {
	private WebDriver driver;
	private JavascriptExecutor js;

	@BeforeMethod
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testJavaScriptExecution() throws Exception {
		// Navigation
		js.executeScript("window.location = 'https://letskodeit.teachable.com/pages/practice'");
		Thread.sleep(6000);
		
		// Scroll Down
		js.executeScript("window.scrollBy(0, 1000);");
		Thread.sleep(3000);
		
		// Scroll Up
		js.executeScript("window.scrollBy(0, -400);");
		Thread.sleep(3000);
		
		// Scroll Element Into View - Using element from WebDriver
		WebElement element = driver.findElement(By.id("mousehover"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, -100);");
		
		// Scroll Element Into View - Using javascript to directly get the element
		js.executeScript("document.getElementById(\'mousehover\').scrollIntoView(true);");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0, -80);");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}
}