package autop.seluitests.pagebojects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class Autop_MyAddressesPage {

	private WebDriver driver = null;
	

	@FindBy(how=How.LINK_TEXT, using="Add a new address")
	public WebElement lnkAddNewAddress;

	public Autop_MyAddressesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


}
