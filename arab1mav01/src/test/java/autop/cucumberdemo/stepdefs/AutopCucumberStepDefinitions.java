package autop.cucumberdemo.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import autop.cucumberdemo.CucumberRunner;
import autop.seluitests.pagebojects.Autop_CommonPage;
import autop.seluitests.pagebojects.Autop_HomePage;
import autop.seluitests.pagebojects.Autop_LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import lib.WebUILib;

public class AutopCucumberStepDefinitions extends CucumberRunner {
	WebDriver driver;
	public static String USER_NAME;
	public static String PASSWORD;
	public static final String URL = "http://automationpractice.com/index.php";
	
	@Given("^User is using (.+)")
	public void user_is_using_browser(String browser) {
		
		driver = WebUILib.getDriver(browser);
		initPages(driver);

		
	}

	@Given("^User credential is (.+) and (.+)")
	public void user_credential_is(String userName, String password) {
		USER_NAME = userName;
		PASSWORD = password;
	}

	@When("^user clicks on Sign In link on automationpractice.com website")
	public void user_clicks_on_SignIn_on_website() {
		driver.manage().window().maximize();
		driver.get("http://automationpractice.com/index.php");
		commonPage.signInLink.click();		
	}
	
	@When("^provides valid credentials for log in")
	public void provides_valid_credentials_for_login() {
		loginPage.txtUserName.clear();
		loginPage.txtUserName.sendKeys(USER_NAME);
		loginPage.txtPassword.clear();
		loginPage.txtPassword.sendKeys(PASSWORD);
		loginPage.btnLogin.click();	
	}
	
	@Then("^User is able to log in to the system")
	public void user_is_able_to_login_to_the_system() {
		String pageHeaderText = commonPage.elemPageHeader.getText();
		Assert.assertEquals(pageHeaderText.trim().toLowerCase(), "My account".toLowerCase());
	}
	
	@Then("^user is able to log out and close the page")
	public void logout_and_close_the_page() {
		commonPage.signOutLink.click();
		driver.quit();
	}
	
	
	
}
