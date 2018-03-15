package autop.seluitests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import autop.BaseTest;
import lib.WebUILib;



public class AutopLGN01 extends BaseTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod");
	}

	@Test
	@Parameters({ "browser","dummy" })
	public void test1(String browser, String dummy) {
		driver = WebUILib.getDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/index.php");
		System.out.println("In Test Test1: " + dummy);
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("swagatasengupta@yahoo.com");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.quit();
	}

/*	@Test
	public void test2() {
		System.out.println("In Test Test2... nothing will happen in this test but browser will open, navigate to URL and close");
	}*/

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
	}

}
