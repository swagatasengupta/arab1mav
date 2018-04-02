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

	public ExtentReports extRep = ExtentManager.getReportInstance();

	
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
		ExtentTestManager.getTest().log(LogStatus.FAIL, getTestMethodName(testResult)
				+ " @Test has failed.");
		
		ExtentTestManager.endTest();

		extRep.flush();

	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just got skipped");
		ExtentTestManager.getTest().log(LogStatus.SKIP, getTestMethodName(testResult)
				+ " @Test has been skipped.");
		
		ExtentTestManager.endTest();

		extRep.flush();

	}

	@Override
	public void onTestStart(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just got started");
		
		ExtentTestManager.startTest(getTestMethodName(testResult),
				getTestMethodDescription(testResult));

		ExtentTestManager.getTest().log(LogStatus.INFO, getTestMethodName(testResult)
				+ " @Test is statrting");
		ExtentTestManager.getTest().assignCategory("TestCategory");
		
		Map params = getXMLParamList(testResult);
		ArrayList<String> paramValues = (ArrayList<String>) params.values();
		System.out.println(paramValues.toString());
		if(params != null) {
			for (int i=0; i < paramValues.size(); i++) {
				ExtentTestManager.getTest().assignCategory(paramValues.get(i));
			}
		}
		
	}

	@Override
	public void onTestSuccess(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just was successful");
		
		ExtentTestManager.getTest().log(LogStatus.PASS, getTestMethodName(testResult)
				+ " @Test has passed");
		
		ExtentTestManager.endTest();

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
