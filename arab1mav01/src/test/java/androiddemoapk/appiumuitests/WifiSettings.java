package androiddemoapk.appiumuitests;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import lib.AppiumUILib;

public class WifiSettings extends AppBaseTest{
  @Test
  @Parameters({"deviceName"})
  public void test01_check_wifiSettings(String deviceName) throws MalformedURLException {
	  AndroidDriver<AndroidElement> driver =  AppiumUILib.getDriver(deviceName, APK_PATH);
	  initPages(driver);
	  homePage.preference.click();
	  prefDetailsPage.prefDependencies.click();
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

}
