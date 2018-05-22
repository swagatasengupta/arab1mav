package rnd.appiumdemo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDemo_WebViewDemoOnRealDevice {

	public static void main(String[] args) throws InterruptedException, IOException {
		String deviceName = "Android Device";
		//String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		//cap.setCapability(MobileCapabilityType.APP, appPath);
		//https://appium.io/docs/en/writing-running-appium/caps/ : refer to this
		
		//RUn this on local command prompt: I was making a mistake in the command and hence it was not running
		// adb shell "dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'"
		cap.setCapability("appPackage", "com.snc.test.webview2");
		cap.setCapability("appActivity", "com.snc.test.webview.activity.MainActivity");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
		Thread.sleep(2000);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		Thread.sleep(2000);
		
		driver.findElementById("com.snc.test.webview2:id/action_go_website").click();
		
		driver.findElementById("com.snc.test.webview2:id/input_url").sendKeys("www.devop-trics.com/elems.html");
		driver.findElementById("android:id/button1").click();
		Thread.sleep(2000);
		System.out.println(driver.getContextHandles());
		
		driver.context("WEBVIEW_com.snc.test.webview2");
		driver.findElement(By.id("benzcheck")).click();
		
		driver.context("NATIVE_APP");
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Open navigation drawer']").click();
		
		
/*		String scrShotFileName = System.getProperty("user.home") + File.separator + "TestScreenshot03.jpg";
		saveScreenShotAsFile(scrShotFileName, driver);
		*/
		
	}

	
	private static void saveScreenShotAsFile(String path, AndroidDriver<AndroidElement> driver) throws IOException {
		File scrShotSrc = driver.getScreenshotAs(OutputType.FILE);
		File scrShotDest = new File(path);
		FileUtil.copyFile(scrShotSrc, scrShotDest);


	}
	
}
