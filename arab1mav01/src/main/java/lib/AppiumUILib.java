package lib;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumUILib {

	public static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723/wd/hub";
	
	public static AndroidDriver<AndroidElement> getDriver(String deviceName, String appPath)
			throws MalformedURLException{
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.APP, appPath);

		driver = new AndroidDriver<>(new URL(APPIUM_SERVER_URL), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
}
