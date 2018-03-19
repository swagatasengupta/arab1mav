package autop.seluitests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import autop.BaseTest;
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
		myAccPage.lnkMyAddressess.click();
		
		myAddressesPage.lnkAddNewAddress.click();
		
		String alias = "Addr" + UtilLib.getTimeStamp();
		
		createAddressPage.fillUpForm(fname, lname, company, address1, address2, city, state, zip, homePhone, mobile, additional, alias);
		
		createAddressPage.btn_submit.click();
		
		commonPage.signOutLink.click();
		
		driver.close();
		
		
	}

}
