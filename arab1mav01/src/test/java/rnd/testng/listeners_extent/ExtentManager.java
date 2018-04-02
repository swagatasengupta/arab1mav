package rnd.testng.listeners_extent;

import com.relevantcodes.extentreports.ExtentReports;

import lib.UtilLib;

public class ExtentManager {

	private static ExtentReports extReport;
	
	public synchronized static ExtentReports getReportInstance() {
		String repPath = "C:\\Users\\swagat\\Desktop\\TestNG_Demo_ExtentReport"
				+ UtilLib.getTimeStamp() + ".html";
		if(extReport == null) {
			extReport = new ExtentReports(repPath, false);
		}
		
		return extReport;
	}
	
}
