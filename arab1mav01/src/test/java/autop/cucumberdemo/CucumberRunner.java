package autop.cucumberdemo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import autop.seluitests.pagebojects.Autop_CommonPage;
import autop.seluitests.pagebojects.Autop_HomePage;
import autop.seluitests.pagebojects.Autop_LoginPage;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		strict=true,
		features = "src/test/java/autop/cucumberdemo/features",
		glue = "autop.cucumberdemo.stepdefs",
		plugin = {"pretty", "html:target/cucumber-html-report"},
		tags = {"@Autop_TestScenario"}
		)

public class CucumberRunner extends AbstractTestNGCucumberTests {
	WebDriver driver;
	public Autop_HomePage homePage = null;
	public Autop_CommonPage commonPage = null;
	public Autop_LoginPage loginPage = null;

	public void initPages(WebDriver driver) {
		this.driver = driver;
		homePage = new Autop_HomePage(driver);
		commonPage = new Autop_CommonPage(driver);
		loginPage = new Autop_LoginPage(driver);
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("cucumber runner - before class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("cucumber runner - after class");
	}
}
