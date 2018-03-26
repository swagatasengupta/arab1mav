package rnd.extent;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentDemo02 {

	public static void main(String[] args) {

		String repPath = "C:\\Users\\swagat\\Desktop\\ExtentReport.html";
		
		ExtentReports extRep;
		ExtentTest extTest;

		extRep = new ExtentReports(repPath,false);
		extRep.assignProject("All Round Automator B1");
		extRep.addSystemInfo("Selenium Version","3.9.1");
		
		extTest = extRep.startTest("Test2", "Test2 Description");
		
		//extTest.setDescription(description);
		
		extTest.log(LogStatus.INFO, "Step 1", "Demo Step Information");
		extTest.log(LogStatus.PASS, "Step Passed");
		extTest.log(LogStatus.WARNING,"Step 3","Warning");
		extTest.log(LogStatus.SKIP,"Step 4","Step Skipped");
		
		extRep.endTest(extTest);
		extRep.flush();
		
	}

}
