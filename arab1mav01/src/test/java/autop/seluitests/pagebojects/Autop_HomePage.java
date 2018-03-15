package autop.seluitests.pagebojects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Autop_HomePage {

	private WebDriver driver = null;
	
	@FindBy(how=How.XPATH, using="//h1[text()='Automation Practice Website']")
	public WebElement elemHomePageHeader;


	public Autop_HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
