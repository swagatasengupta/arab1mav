package lib;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lib.ExtentTestManager;

public class ExtentTestManager {

	private static Map extentTestMap = new HashMap();
	private static ExtentReports extReport = ExtentManager.getReportInstance();
	
	public static synchronized ExtentTest startTest(String testName, String description) {
		ExtentTest test = extReport.startTest(testName, description);
		extentTestMap.put(Thread.currentThread().getId(), test);
		return test;
	}
	
	public static synchronized ExtentTest getCurrentTest() {
		ExtentTest test = (ExtentTest)extentTestMap.get(Thread.currentThread().getId());
		return test;
	}
	
	public static synchronized void endCurrentTest() {
		ExtentTest test = getCurrentTest();
		extReport.endTest(test);		
	}
	
	public static synchronized void attachBase64ScrShotToCurrExtentTest(String message, String base64ScreenshotPath) {
		
		ExtentTest test = getCurrentTest();
		test.log(LogStatus.INFO,message, ExtentTestManager.getCurrentTest().addBase64ScreenShot(base64ScreenshotPath));

	}
	
}
