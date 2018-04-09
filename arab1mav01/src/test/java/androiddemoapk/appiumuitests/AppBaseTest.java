package androiddemoapk.appiumuitests;

import java.io.File;

import org.openqa.selenium.WebDriver;

import androiddemoapk.appiumuitests.pageobjects.Appdemo_HomePage;
import androiddemoapk.appiumuitests.pageobjects.Appdemo_PrefDetailsPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AppBaseTest {

	private AndroidDriver<AndroidElement> driver;
	public static final String APK_PATH = new File("resources/androiddemoapp.apk").getAbsolutePath();
	//Page objects
	Appdemo_HomePage homePage;
	Appdemo_PrefDetailsPage prefDetailsPage;
	//Take driver from class extending this base test and initialize page objects
	public void initPages(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		homePage = new Appdemo_HomePage(driver);
		prefDetailsPage = new Appdemo_PrefDetailsPage(driver);
		
	}

	
}
