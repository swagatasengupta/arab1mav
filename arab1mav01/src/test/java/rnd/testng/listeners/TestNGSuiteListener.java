package rnd.testng.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestNGSuiteListener implements ISuiteListener{

	@Override
	public void onFinish(ISuite arg0) {
		System.out.println("TestNGSuiteListener>> ON suite finish");
		
	}

	@Override
	public void onStart(ISuite arg0) {
		System.out.println("TestNGSuiteListener>>ON suite start");
		
	}

}
