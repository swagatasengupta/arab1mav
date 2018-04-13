package rnd.appiumdemo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumDemo_PreInstalledCalculatorDemo1 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String deviceName = "AVD_Nexus5X_API27x86";
		//String appPath = new File("resources/androiddemoapp.apk").getAbsolutePath();
		
		AndroidDriver<AndroidElement> driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		//cap.setCapability(MobileCapabilityType.APP, appPath);
		//https://appium.io/docs/en/writing-running-appium/caps/ : refer to this
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "20");

		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		String expression = "12.5x6=";
		
		for(char input : expression.toCharArray()) {
			
			driver.findElementById(getCalcID(String.valueOf(input))).click();
		}
		
	}

	
	private static String getCalcID(String inp) {
		
		switch(inp.toLowerCase()) {
		case "1": return "com.android.calculator2:id/digit_1";
		case "2": return "com.android.calculator2:id/digit_2";
		case ".": return "com.android.calculator2:id/dec_point";
		case "x": return "com.android.calculator2:id/op_mul";
		case "5": return "com.android.calculator2:id/digit_5";
		case "=": return "com.android.calculator2:id/eq";
		case "6": return "com.android.calculator2:id/digit_6";
		default: return null;
		}
	}
	
}
