package autop.seluitests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import autop.BaseTest;
import lib.ExtentTestManager;
import lib.UtilLib;
import lib.WebUILib;

public class AutopCreateAddress extends BaseTest {
	
	WebDriver driver = null;
	Properties prop = null;
	
	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser) throws IOException {

		driver = WebUILib.getDriver(browser);
		initPages(driver); // this will initialize the browser
		prop = UtilLib.getPropertiesFile(UtilLib.fetchPath("AUTOP_PROP_FILE"));

	}

/*	@Test(dataProvider = "autop_lgn01_positive", dataProviderClass = autop.testdata.LoginDataProvider.class)
	public void test01Login(String userName, String encodedPassword) {
		driver.get(prop.getProperty("URL"));
		commonPage.signInLink.click();
		loginPage.doLogin(userName, encodedPassword);
		myAccPage.lnkMyAddressess.click();
		
	}*/
	
	@Test(dataProvider = "autop_createaddress_sqliteProvider", dataProviderClass = autop.testdata.AutopDataProviders.class)
	public void test02CreateAddress(String fname, String lname, String company, String address1, String address2, String city, String state, String zip, String homePhone, String mobile, String additional) {
		driver.get(prop.getProperty("URL"));
		commonPage.signInLink.click();
		loginPage.doLogin("swagatasengupta@yahoo.com", "MTIzNDU=");
		/*loginPage.txtUserName.sendKeys("wrongUser@yahoo.com");
		loginPage.txtPassword.sendKeys("ABCDE");
		loginPage.btnLogin.click();*/

		
		ExtentTestManager.getCurrentTest().log(LogStatus.PASS, "Login","Logged in to the application successfully");
		
		myAccPage.lnkMyAddressess.click();
		myAddressesPage.lnkAddNewAddress.click();
		
		ExtentTestManager.getCurrentTest().log(LogStatus.INFO, "Navigation","Navigated to New Address Page successfully");

		String alias = "Addr" + UtilLib.getTimeStamp();
		
		createAddressPage.fillUpForm(fname, lname, company, address1, address2, city, state, zip, homePhone, mobile, additional, alias);
		
		createAddressPage.btn_submit.click();
		ExtentTestManager.getCurrentTest().log(LogStatus.PASS, "Validation","Adress with alias " + alias + " created successfully");

		//Take screenshot and attach to the extent report
		String screenShotPath = WebUILib.getScreenShotBase64Path(driver);
		ExtentTestManager.attachBase64ScrShotToCurrExtentTest("Screenshot", screenShotPath);
		
		commonPage.signOutLink.click();
		ExtentTestManager.getCurrentTest().log(LogStatus.PASS, "Sign Out","Logged out successfully");
		
		driver.quit();
		
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		int resStatus = result.getStatus();
		if(resStatus == ITestResult.FAILURE || resStatus == ITestResult.SKIP) {
			WebUILib.takeScrShotAttachToReport(driver);
			driver.quit();
		}
		
	}
	
}
