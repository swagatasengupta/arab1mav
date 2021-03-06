package rnd.testng.listeners_extent;

import java.util.ArrayList;
import java.util.Map;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import lib.UtilLib;

public class TestNGTestListener implements ITestListener,ISuiteListener {

	public ExtentReports extRep = ExtentReportManager.getReportInstance();

	
	@Override
	public void onFinish(ITestContext testContext) {
		System.out.println("TestNGTestListener>> "
				+ testContext.getCurrentXmlTest().getName()
				+ ">>XML Test just finished");

	}

	@Override
	public void onStart(ITestContext testContext) {
		System.out.println("TestNGTestListener>> "
				+ testContext.getCurrentXmlTest().getName()
				+ ">>XML Test just started");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just failed but is within success percentage");

	}

	@Override
	public void onTestFailure(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just failed");
		ExtentReportTestManager.getTest().log(LogStatus.FAIL, getTestMethodName(testResult)
				+ " @Test has failed.");
		
		ExtentReportTestManager.endTest();

		extRep.flush();

	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just got skipped");
		ExtentReportTestManager.getTest().log(LogStatus.SKIP, getTestMethodName(testResult)
				+ " @Test has been skipped.");
		
		ExtentReportTestManager.endTest();

		extRep.flush();

	}

	@Override
	public void onTestStart(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just got started");
		
		ExtentReportTestManager.startTest(getTestMethodName(testResult),
				getTestMethodDescription(testResult));

		ExtentReportTestManager.getTest().log(LogStatus.INFO, getTestMethodName(testResult)
				+ " @Test is statrting");
		//Add the parameters to the test if any
		Map params = getXMLParamList(testResult);
		
		if(params != null) {
			for (Object value: params.values()) {
				ExtentReportTestManager.getTest().assignCategory((String)value);
			}
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just was successful");
		
		ExtentReportTestManager.getTest().log(LogStatus.PASS, getTestMethodName(testResult)
				+ " @Test has passed");
		
		ExtentReportTestManager.endTest();

		extRep.flush();
	}
	@Override
	public void onFinish(ISuite arg0) {
		System.out.println("TestNGSuiteListener>> ON suite finish");
		extRep.flush();
		
	}

	@Override
	public void onStart(ISuite arg0) {
		System.out.println("TestNGSuiteListener>>ON suite start");
		
	}

	private static String getTestMethodName(ITestResult testResult) {
		return (testResult.getMethod().getMethodName());
	}
	
	private static String getXMLTestName(ITestResult testResult) {
		return (testResult.getTestContext().getCurrentXmlTest().getName());
	}
	
	private static Map<String, String> getXMLParamList(ITestResult testResult) {
		return (testResult.getTestContext().getCurrentXmlTest().getAllParameters());
	}
	
	private static String getXMLParam(ITestResult testResult, String paramName) {
		return (testResult.getTestContext().getCurrentXmlTest().getParameter(paramName));
		
	}
	
	private static String getTestMethodDescription(ITestResult testResult) {
		
		String description = testResult.getMethod().getDescription();
		if(description != null) {
			return description;
		} else {
			return "";
		}
	}
	
	private static String getTestAndMethodName(ITestResult testResult) {
		String currTest = testResult.getTestContext().getCurrentXmlTest().getName();
		String params = testResult.getTestContext().getCurrentXmlTest().getAllParameters().toString();
		String currMethod = testResult.getMethod().getMethodName();
		String currTestDescription = testResult.getMethod().getDescription();
		
		if(currTestDescription==null || currTestDescription.isEmpty()) {
			return (currTest +":"+currMethod +">>" + "params: " + params);
		} else {
			return (currTest +":"+currMethod + "(description = "+currTestDescription+")>>" + "params:"+params);
		}
		

	}
	
}
