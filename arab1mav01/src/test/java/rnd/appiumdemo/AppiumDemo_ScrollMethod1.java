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

public class AppiumDemo_ScrollMethod1 {

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
		
		Dimension dim = driver.manage().window().getSize();
		int scrHeight = dim.getHeight();
		int scrWidth = dim.getWidth();
		
		int scrollStartX = (int)(scrWidth * 0.5);
		int scrollStartY = (int)(scrHeight * 0.6);
		int scrollEndY = (int)(scrHeight * 0.2);
		
		System.out.printf("Screen width = %d, height = %d \n",scrWidth, scrHeight);
		System.out.printf("Scroll start x,y = %d, %d; end x,y = %d, %d \n",scrollStartX, scrollStartY, scrollStartX, scrollEndY);
		
		TouchAction tAct = new TouchAction(driver);
		
		for(int i=1; i<=5; i++) {
			tAct.longPress(scrollStartX, scrollStartY).moveTo(scrollStartX, scrollEndY).release().perform();			
		}
		
		driver.findElementByXPath("//android.widget.TextView[@text='Visibility']").click();
		
		
		
	}

}
