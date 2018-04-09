package androiddemoapk.appiumuitests.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Appdemo_PrefDetailsPage {
	private AndroidDriver<AndroidElement> driver;
	
	@AndroidFindBy (xpath="//android.widget.TextView[contains(@text,'Preference dependencies')]")
	//public AndroidElement prefDependencies;
	public WebElement prefDependencies;
	
	public Appdemo_PrefDetailsPage(AndroidDriver<AndroidElement> driver){
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
}
