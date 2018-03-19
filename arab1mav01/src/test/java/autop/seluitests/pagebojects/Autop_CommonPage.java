package autop.seluitests.pagebojects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Autop_CommonPage {

	private WebDriver driver = null;
	
	@FindBy(how=How.LINK_TEXT, using="Sign in")
	public WebElement signInLink;

	@FindBy(how=How.CLASS_NAME, using="logout")
	public WebElement signOutLink;

	@FindBy(how=How.LINK_TEXT, using="Contact us")
	public WebElement contactUsLink;

	@FindBy(how=How.XPATH, using="//h1[contains(@class,'page-heading')]")
	public WebElement elemPageHeader;
	
	public Autop_CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
