package lib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class WebUILib {

	public static WebDriver getDriver(String browser) {
		WebDriver driver = null;
		switch(browser.toUpperCase()) {
		case "CHROME":
			//System.setProperty("webdriver.chrome.driver","/Users/swagat/webdrivers/chromedriver"); //not setting properties as I have drivers directory
			//covered in PATH system variable
			driver = new ChromeDriver();
			break;
		case "MOZILLA":
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("browser unsupported: " + browser);
			break;
						
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return driver;
		
	}

	public static void scrollIntoView(WebDriver driver, WebElement elem) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", elem);
	}

	public static void executeJS(WebDriver driver, String jsCommand) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jsCommand);
	}

	public static void mouseHover(WebDriver driver, WebElement elem) {
		Actions action = new Actions(driver);
		action.moveToElement(elem).perform();
	}

	public static void mouseHoverAndClick(WebDriver driver, WebElement parentElem, String xpathOfChildElement) {
		Actions action = new Actions(driver);
		action.moveToElement(parentElem).perform();
		
		action.moveToElement(
				driver.findElement(
						By.xpath(xpathOfChildElement)
						)
				).click().perform();
	}

}
