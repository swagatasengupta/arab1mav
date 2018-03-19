package autop.seluitests.pagebojects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Autop_CreateAddressesPage {

	private WebDriver driver = null;
	
	@FindBy(how=How.ID, using="firstname")
	public WebElement inp_firstName;
	
	@FindBy(how=How.ID, using="lastname")
	public WebElement inp_lastName;

	@FindBy(how=How.ID, using="company")
	public WebElement inp_company;
	
	
	@FindBy(how=How.ID, using="address1")
	public WebElement inp_address1;
	
	@FindBy(how=How.ID, using="address2")
	public WebElement inp_address2;

	@FindBy(how=How.ID, using="city")
	public WebElement inp_city;
	
	@FindBy(how=How.ID, using="id_state")
	public WebElement sel_state;
	
	@FindBy(how=How.ID, using="postcode")
	public WebElement inp_postalCode;
	
	@FindBy(how=How.ID, using="id_country")
	public WebElement sel_country;
	
	@FindBy(how=How.ID, using="phone")
	public WebElement inp_phone;
	
	@FindBy(how=How.ID, using="phone_mobile")
	public WebElement inp_mobilePhone;
	
	@FindBy(how=How.ID, using="other")
	public WebElement inp_additional;
	
	
	@FindBy(how=How.ID, using="alias")
	public WebElement inp_alias;
	
	@FindBy(how=How.ID, using="submitAddress")
	public WebElement btn_submit;

	public Autop_CreateAddressesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void fillUpForm(String fname, String lname, String company, String address1, String address2, String city, String state, String zip, String homePhone, String mobile, String additional, String alias) {
		inp_firstName.clear();
		inp_firstName.sendKeys(fname);
		inp_lastName.clear();
		inp_lastName.sendKeys(lname);
		inp_company.sendKeys(company);
		inp_address1.sendKeys(address1);
		inp_address2.sendKeys(address2);
		inp_city.sendKeys(city);
		Select stateSelector = new Select(sel_state);	
		stateSelector.selectByVisibleText(state);
		inp_postalCode.sendKeys(zip);
		inp_phone.sendKeys(homePhone);
		inp_mobilePhone.sendKeys(mobile);
		inp_additional.sendKeys(additional);
		inp_alias.sendKeys(alias);
	}
}
