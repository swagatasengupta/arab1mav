package rnd.testng.listeners_extent;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReportTestManager {

	private static Map extentTestMap = new HashMap();
	private static ExtentReports extReport = ExtentReportManager.getReportInstance();
	
	public static synchronized ExtentTest startTest(String testName, String description) {
		ExtentTest test = extReport.startTest(testName, description);
		extentTestMap.put(Thread.currentThread().getId(), test);
		return test;
	}
	
	public static synchronized ExtentTest getTest() {
		ExtentTest test = (ExtentTest)extentTestMap.get(Thread.currentThread().getId());
		return test;
	}
	
	public static synchronized void endTest() {
		ExtentTest test = getTest();
		extReport.endTest(test);		
	}
	
}
