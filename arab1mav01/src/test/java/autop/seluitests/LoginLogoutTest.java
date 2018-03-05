package autop.seluitests;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import autop.BaseTest;
import lib.UtilLib;
import lib.WebUILib;
import rnd.DemoDataProvider;

public class LoginLogoutTest extends BaseTest {

	private WebDriver driver = null;

	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser) throws IOException {

		driver = WebUILib.getDriver(browser);
		initPages(driver); // this will initialize the browser
		Properties prop = UtilLib.getPropertiesFile(UtilLib.fetchPath("AUTOP_PROP_FILE"));

		driver.get(prop.getProperty("URL"));

	}

	@Test(dataProvider = "autop_lgn02_positive", dataProviderClass = autop.testdata.LoginDataProvider.class)
	public void lgn02_postive(String userName, String decodedPassword) throws InterruptedException {
		commonPage.signInLink.click();
		
		boolean retVal = loginPage.doLogin(userName, decodedPassword);
		Assert.assertTrue(retVal);
		commonPage.signOutLink.click();
		Thread.sleep(3000);
		driver.manage().timeouts().setScriptTimeout(1, TimeUnit.SECONDS);

		try {
			driver.findElement(By.className("logout"));
			Assert.assertTrue(false);
			System.out.println("Log Out button was found while it was unexpected");
		} catch (NoSuchElementException e) {
			Assert.assertTrue(true);
			System.out.println("Log Out button was not found as expected");
		}

		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
