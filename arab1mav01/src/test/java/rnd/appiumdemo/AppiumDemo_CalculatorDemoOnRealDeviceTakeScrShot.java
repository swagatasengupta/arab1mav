package rnd.appiumdemo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDemo_CalculatorDemoOnRealDeviceTakeScrShot {

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
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");
		Thread.sleep(2000);

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		String expression = "12.5x6";
		
		Thread.sleep(2000);
		
		for(char input : expression.toCharArray()) {
			
			driver.findElementById(getCalcID(String.valueOf(input))).click();
		}

		
		String scrShotFileName = System.getProperty("user.home") + File.separator + "TestScreenshot01.jpg";
		saveScreenShotAsFile(scrShotFileName, driver);
		
		driver.pressKeyCode(AndroidKeyCode.BACK); //sends back button press command
		Thread.sleep(1000);
		scrShotFileName = System.getProperty("user.home") + File.separator + "TestScreenshot02.jpg";
		saveScreenShotAsFile(scrShotFileName, driver);
		
		driver.pressKeyCode(AndroidKeyCode.HOME); //sends Home button press command
		Thread.sleep(1000);
		scrShotFileName = System.getProperty("user.home") + File.separator + "TestScreenshot03.jpg";
		saveScreenShotAsFile(scrShotFileName, driver);
		
		
	}

	
	private static String getCalcID(String inp) {
		
		switch(inp.toLowerCase()) {
		case "1": return "com.google.android.calculator:id/digit_1";
		case "2": return "com.google.android.calculator:id/digit_2";
		case ".": return "com.google.android.calculator:id/dec_point";
		case "x": return "com.google.android.calculator:id/op_mul";
		case "5": return "com.google.android.calculator:id/digit_5";
		case "=": return "com.google.android.calculator:id/eq";
		case "6": return "com.google.android.calculator:id/digit_6";
		default: return null;
		}
	}

	private static void saveScreenShotAsFile(String path, AndroidDriver<AndroidElement> driver) throws IOException {
		File scrShotSrc = driver.getScreenshotAs(OutputType.FILE);
		File scrShotDest = new File(path);
		FileUtil.copyFile(scrShotSrc, scrShotDest);


	}
	
}
