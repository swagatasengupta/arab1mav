package rnd.testng.dependency;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import rnd.testng.listeners_extent.ExtentTestManager;

public class TestDependencyDemo1 {

	@Test(description = "This is testMethod1 from TestDependencyDemo1 and this will fail.")
	public void testMethod1() {
		System.out.println("testMethod1");
		Assert.assertEquals(true, false);
	}
	
	@Test()
	public void testMethod2() {
		System.out.println("testMethod2");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Deliberate failure using hard assert");
		Assert.assertEquals(true, false);
	}
	
	@Test(dependsOnMethods= {"testMethod1","testMethod2"})
	public void testMethod3() {
		System.out.println("testMethod3");
		Assert.assertEquals(true, true);
	}
	
}
