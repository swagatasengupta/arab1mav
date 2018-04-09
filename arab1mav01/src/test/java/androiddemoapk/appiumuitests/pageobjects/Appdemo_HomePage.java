package androiddemoapk.appiumuitests.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Appdemo_HomePage {
	private AndroidDriver<AndroidElement> driver;
	
	@AndroidFindBy (xpath="//android.widget.TextView[@text='Preference']")
	//public AndroidElement preference;
	public WebElement preference;
	
	public Appdemo_HomePage(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
}
