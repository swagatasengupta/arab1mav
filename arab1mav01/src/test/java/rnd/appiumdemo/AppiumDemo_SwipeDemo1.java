package rnd.appiumdemo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDemo_SwipeDemo1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String deviceName = "AVD_Nexus5X_API27x86";
		String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.APP, appPath);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();				
		driver.findElementByXPath("//android.widget.TextView[@text='Gallery']").click();
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'Photos')]")).click();
		
		AndroidElement photoContainer = driver.findElementById("io.appium.android.apis:id/gallery");
		
		Dimension dim = photoContainer.getSize();
		int scrHeight = dim.getHeight();
		int scrWidth = dim.getWidth();
		
		int scrollStartX = (int)(scrWidth * 0.7);
		int scrollStartY = (int)(scrHeight * 0.5) + photoContainer.getLocation().y;
/*		int scrollEndX = (int)(scrWidth * 0.3); //You will not need this with press()
		int scrollEndY = scrollStartY;*/
		
		TouchAction tAct = new TouchAction(driver);
		//Moveto works differenty with press Vs. longPress
		//for press, you need to provide the offset while for longPress, actual x,y is taken
		tAct.press(scrollStartX,scrollStartY).moveTo(-100,0).release().perform();
		//tAct.longPress(scrollStartX,scrollStartY).moveTo(scrollEndX,scrollEndY).release().perform();
		
		
	}

}
