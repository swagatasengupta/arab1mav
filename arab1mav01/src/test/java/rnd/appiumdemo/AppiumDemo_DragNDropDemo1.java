package rnd.appiumdemo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDemo_DragNDropDemo1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String deviceName = "AVD_Nexus5X_API27x86";
		String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.APP, appPath);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Thread.sleep(1500);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		Thread.sleep(1500);
		
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		AndroidElement objToDrag = driver.findElementById("io.appium.android.apis:id/drag_dot_1");
		
		AndroidElement objToDropOn = driver.findElementById("io.appium.android.apis:id/drag_dot_2");
		
		TouchAction tAct = new TouchAction(driver);
		tAct.longPress(objToDrag).moveTo(objToDropOn).release().perform();
		
		
	}

}
