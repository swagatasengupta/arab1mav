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

public class AppiumDemo_MobileWebOnRealDevice {

	public static void main(String[] args) throws InterruptedException, IOException {
		String deviceName = "Android Device";
		
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
		
		Thread.sleep(2000);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://www.automationpractice.com");
		
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("email")).sendKeys("swagatasengupta@yahoo.com");
		driver.findElement(By.id("passwd")).sendKeys("12345");
		driver.findElement(By.id("SubmitLogin")).click();
		
		
		

		
	}
		
		private static void saveScreenShotAsFile(String path, AndroidDriver<AndroidElement> driver) throws IOException {
		File scrShotSrc = driver.getScreenshotAs(OutputType.FILE);
		File scrShotDest = new File(path);
		FileUtil.copyFile(scrShotSrc, scrShotDest);


	}
	
}
