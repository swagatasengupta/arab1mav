package rnd.extent;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lib.UtilLib;

public class TestNGExtentDemo01 {
	
	
	String timeStamp = UtilLib.getTimeStamp();
	String repPath = "C:\\Users\\swagat\\Desktop\\TestNG_Demo_ExtentReport"
			+ timeStamp + ".html";
	ExtentReports extRep;
	ExtentTest extTest;
	
	@BeforeSuite
	public void beforeSuite() {
		extRep = new ExtentReports(repPath, false);
		extRep.assignProject("All Round Automator B1");
		extRep.addSystemInfo("Selenium Version","3.9.1");
	}

	@BeforeClass
	public void beforeClass() {
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test
	public void t1() {

		extTest = extRep.startTest("Test1", "Test1 Description");
		extTest.log(LogStatus.INFO, "Starting test1");
		extTest.log(LogStatus.PASS, "Passing test1");
	}

	@Test
	public void t2() {
		extTest = extRep.startTest("Test2", "Test2 Description");
		extTest.log(LogStatus.INFO, "Starting test2");
		extTest.log(LogStatus.WARNING, "Test2 Warning");
		extTest.log(LogStatus.PASS, "Passing test2");

	}

	@Test
	public void t3() {
		extTest = extRep.startTest("Test3", "Test3 Description");
		extTest.log(LogStatus.INFO, "Starting test3");
		extTest.log(LogStatus.WARNING, "Test3 Warning");
		extTest.log(LogStatus.FAIL, "Failing test3");

	}

	@Test
	public void t4() {
		extTest = extRep.startTest("Test4", "Test4 Description");
		extTest.log(LogStatus.INFO, "Starting test4");
		extTest.log(LogStatus.SKIP, "Skipping test4");

	}

	@Test
	public void t5() {
		extTest = extRep.startTest("Test5", "Test5 Description");
		extTest.log(LogStatus.INFO, "Starting test5");
		extTest.log(LogStatus.UNKNOWN, "Unknown Error test5");
		extTest.log(LogStatus.FATAL, "Fatal Error test5");

	}

	@AfterMethod
	public void afterMethod() {
		extRep.endTest(extTest);
		extRep.flush();
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

	@AfterSuite
	public void afterSuite() {
		extRep.flush();
	}

}
