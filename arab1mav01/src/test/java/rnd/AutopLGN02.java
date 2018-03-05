package rnd;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import autop.BaseTest;
import lib.WebUILib;

public class AutopLGN02 extends BaseTest {

	public AutopLGN02(WebDriver driver) {
		super();
		// TODO Auto-generated constructor stub
	}

	public static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("BeforeMethod02");
	}

	@Test
	@Parameters({ "browser", "dummy" })
	public void sc01tc101_testXYZfunctionality(String browser, String dummy) throws InterruptedException {
		System.out.println("In Test Test02-02");
		driver = WebUILib.getDriver(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://letskodeit.teachable.com/p/practice");

		/*
		 * multi select example
		 */

		WebElement element = driver.findElement(By.id("multiple-select-example"));
		Select sel = new Select(element);

		Thread.sleep(2000);
		System.out.println("Select orange by value");
		sel.selectByValue("orange");

		Thread.sleep(2000);
		System.out.println("De-select orange by value");
		sel.deselectByValue("orange");

		Thread.sleep(2000);
		System.out.println("Select peach by index");
		sel.selectByIndex(2);

		Thread.sleep(2000);
		System.out.println("Select Apple by visible text");
		sel.selectByVisibleText("Apple");

		Thread.sleep(2000);
		System.out.println("Print all selected options");
		List<WebElement> selectedOptions = sel.getAllSelectedOptions();
		for (WebElement option : selectedOptions) {
			System.out.println("Visible Value: " + option.getText() + "actual value: " + option.getAttribute("value"));
		}
		sel.deselectAll(); // clean up
		/*
		 * select example
		 */

		WebElement selectList = driver.findElement(By.id("carselect"));
		Select listVals = new Select(selectList);
		listVals.selectByValue("benz");
		Thread.sleep(2000);
		listVals.selectByValue("bmw");

		/*
		 * radio button example:
		 */
		WebElement radioBenz = driver.findElement(By.id("benzradio"));
		radioBenz.click();

		/*
		 * Conceptual: Little difficult to understand but try.
		 * getting all select elements and reading their individual options and
		 * selecting them one by one using click and not Select.
		 */
		List<WebElement> selectElements = driver.findElements(By.xpath(".//select"));
		System.out.println("found select items: " + selectElements.size());
		for (WebElement elem : selectElements) {
			System.out.println("working for select item: " + elem.getAttribute("name"));
			List<WebElement> currOptions = elem.findElements(By.xpath(".//option"));
			System.out.println("number of options: " + currOptions.size());
			for (WebElement opt : currOptions) {
				System.out.println("Visible Value: " + opt.getText() + "actual value: " + opt.getAttribute("value"));
				opt.click();
				Thread.sleep(2000);
			}
		}
		Thread.sleep(5000);
		driver.quit();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod02");
	}

}
