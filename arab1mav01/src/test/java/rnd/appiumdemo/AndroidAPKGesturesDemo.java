package rnd.appiumdemo;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidAPKGesturesDemo {

	public static void main(String[] args) throws MalformedURLException {

		String emulatorName = "AVD_Nexus5X_API27x86";
		String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorName);
		cap.setCapability(MobileCapabilityType.APP, appPath);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		TouchAction tAct = new TouchAction(driver);
		AndroidElement pref = driver.findElementByXPath("//android.widget.TextView[@text='Views']");
		tAct.tap(pref).perform();
		AndroidElement expList = driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']");
		tAct.tap(expList).perform();
		
		AndroidElement custAdapter = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Custom Adapter')]"));
		tAct.tap(custAdapter).perform();
		
		AndroidElement dogNames = driver.findElementByXPath("//android.widget.TextView[@text='Dog Names']");
		//tAct.longPress(dogNames).perform();
		//Alternatively
		//press, wait and release
		tAct.press(dogNames).waitAction(Duration.ofSeconds(2000)).release().perform();
		
/*		
		//Click Preference on Home Page
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		//Click on Preference Dependencies on Preference details page
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Preference dependencies')]")).click();

		AndroidElement wifiSettings = driver.findElementByXPath("(//android.widget.RelativeLayout)[2]");
		System.out.println("Before wifi-checked: enabled= " + wifiSettings.getAttribute("enabled"));
		//Click on wi-fi checkox
		driver.findElement(By.id("android:id/checkbox")).click();
		
//		System.out.println(wifiSettings.getAttribute("clickable"));
		System.out.println("After wifi-checked: enabled= " + wifiSettings.getAttribute("enabled"));
		
		//Click on Wifi-settings
		wifiSettings.click();
		//Write wifi-settings
		driver.findElementById("android:id/edit").sendKeys("Test Wifi Text");
		
		driver.findElementById("android:id/button1").click();
		//driver.findElementByAndroidUIAutomator("new UiSelector().text=\"OK\"").click();
*/		
	}

	
}
