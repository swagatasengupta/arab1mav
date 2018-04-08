package lib;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;




public class Retry implements IRetryAnalyzer {

	private int count = 0;
	private static final int MAX_TRY = 1 ; // Run the failed test 2 times (count = 1, 2) at max
	
	@Override
	public boolean retry(ITestResult iTestResult) {

		if (!iTestResult.isSuccess()) { // Check if test not succeed
			if (count < MAX_TRY) { // Check if max try count is reached
				count++;// Increase the maxTry count by 1
				String currMethodName = iTestResult.getMethod().getQualifiedName();
				String currXMLParams = iTestResult.getTestContext().getCurrentXmlTest().getAllParameters().toString();
				
				String logMessage = "Retry analyzer invoked for @Test " + currMethodName
						+ " ; retry count = " + count
						+ " ; params= " + currXMLParams;
				
				System.out.println(logMessage);
				//Log the same message as warning in Extent Test
				ExtentTestManager.getCurrentTest().log(LogStatus.WARNING, logMessage);
				
				iTestResult.setStatus(ITestResult.SKIP); // Mark test as failed

				
				return true; // Tells TestNG to re-run the test
			} 
		} else {
			iTestResult.setStatus(ITestResult.SUCCESS); // If test passes, TestNG marks it as passed
			//count = 1;
		}
		//count = 1; // reset count
		return false;
	}


}