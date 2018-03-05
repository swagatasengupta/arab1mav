package autop.seluitests;

import java.io.IOException;
import java.util.Properties;

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

public class LoginTest extends BaseTest {

	private WebDriver driver = null;

	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser) throws IOException {

		driver = WebUILib.getDriver(browser);
		initPages(driver); // this will initialize the browser
		Properties prop = UtilLib.getPropertiesFile(UtilLib.fetchPath("AUTOP_PROP_FILE"));

		driver.get(prop.getProperty("URL"));

	}

	@Test(dataProvider = "autop_lgn01_positive", dataProviderClass = autop.testdata.LoginDataProvider.class)
	public void lgn01_postive(String userName, String decodedPassword) {
		commonPage.signInLink.click();
		
/*		loginPage.txtUserName.clear();
		loginPage.txtPassword.clear();
		loginPage.txtUserName.sendKeys("swagatasengupta@yahoo.com");
		loginPage.txtPassword.sendKeys(UtilLib.decodeString("MTIzNDU="));
		loginPage.btnLogin.click();*/
		
		boolean retVal = loginPage.doLogin(userName, decodedPassword);
		Assert.assertTrue(retVal);
		
	}

	@AfterMethod
	public void afterMethod() {
	}

}
