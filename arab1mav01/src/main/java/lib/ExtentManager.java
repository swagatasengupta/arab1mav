package lib;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

import lib.UtilLib;

public class ExtentManager {

	private static ExtentReports extReport;
	
	public synchronized static ExtentReports getReportInstance() {
		String repDir = System.getProperty("user.home") + File.separator + "reports";
		File fRepDir = new File(repDir);
		fRepDir.mkdirs();
		
		String repPath = repDir + File.separator + "TestExecutionReport_"
				+ UtilLib.getTimeStamp() + ".html";
		if(extReport == null) {
			extReport = new ExtentReports(repPath, false);
		}
		
		return extReport;
	}
}
