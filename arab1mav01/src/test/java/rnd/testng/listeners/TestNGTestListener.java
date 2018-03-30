package rnd.testng.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGTestListener implements ITestListener {

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

	}

	@Override
	public void onTestSkipped(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just got skipped");

	}

	@Override
	public void onTestStart(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just got started");

	}

	@Override
	public void onTestSuccess(ITestResult testResult) {
		System.out.println("TestNGTestListener>> "
				+ getTestAndMethodName(testResult)
				+ "Test Method just was successful");

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
