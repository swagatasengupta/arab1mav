package rnd.appiumdemo;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidAPKDemo1 {

	public static void main(String[] args) throws MalformedURLException {

		String emulatorName = "AVD_Nexus5X_API27x86";
		String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, emulatorName);
		cap.setCapability(MobileCapabilityType.APP, appPath);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Click Preference on Home Page
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		
		//Click Preference dependencies on next page
		//another way to write.
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Preference dependencies')]")).click();;
		
		//Check wifi check-box and click on Wifi Settings 
		driver.findElementById("android:id/checkbox").click();
		//Since there are no unique properties we will go with index
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		
		//Set wifi after clearing clip-board
		driver.findElementById("android:id/edit").clear();
		clearSystemClipboard();
		driver.findElementById("android:id/edit").sendKeys("Test");
		driver.findElementByXPath("//android.widget.Button[@text='OK']").click();



	}

	public static void clearSystemClipboard() {
		StringSelection stringSelection = new StringSelection("");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	
}
