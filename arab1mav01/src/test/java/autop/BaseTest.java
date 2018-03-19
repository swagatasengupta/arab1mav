package autop;

import org.testng.annotations.Test;

import autop.seluitests.pagebojects.Autop_CommonPage;
import autop.seluitests.pagebojects.Autop_CreateAddressesPage;
import autop.seluitests.pagebojects.Autop_HomePage;
import autop.seluitests.pagebojects.Autop_LoginPage;
import autop.seluitests.pagebojects.Autop_MyAccountPage;
import autop.seluitests.pagebojects.Autop_MyAddressesPage;

import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {

	private WebDriver driver = null;
	public Autop_CommonPage commonPage = null;
	public Autop_LoginPage loginPage = null;
	public Autop_HomePage homePage = null;
	public Autop_MyAccountPage myAccPage = null;
	public Autop_MyAddressesPage myAddressesPage = null;
	public Autop_CreateAddressesPage createAddressPage = null;
	

	public void initPages(WebDriver driver) {
		this.driver = driver;
		homePage = new Autop_HomePage(driver);
		commonPage = new Autop_CommonPage(driver);
		loginPage = new Autop_LoginPage(driver);
		myAccPage = new Autop_MyAccountPage(driver);
		myAddressesPage = new Autop_MyAddressesPage(driver);
		createAddressPage = new Autop_CreateAddressesPage(driver);
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside BeforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Inside AfterTest");

	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Inside BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Inside AfterClass");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside BeforeSuite");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside AfterSuite");

	}

}
