package autop.seluitests.pagebojects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import lib.UtilLib;

public class Autop_LoginPage {

	private WebDriver driver = null;

	@FindBy(how = How.ID, using = "email")
	public WebElement txtUserName;

	@FindBy(how = How.ID, using = "passwd")
	public WebElement txtPassword;

	@FindBy(how = How.ID, using = "SubmitLogin")
	public WebElement btnLogin;

	public Autop_LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean doLogin(String userName, String encodedPassword) {

		try {
			txtUserName.clear();
			txtPassword.clear();
			txtUserName.sendKeys(userName);
			txtPassword.sendKeys(UtilLib.decodeString(encodedPassword));
			btnLogin.click();
			return true;
		} catch (Exception e) {
			System.out.println("Exception occured while logging in: " + e.toString());
			return false;
		}
	}

}
