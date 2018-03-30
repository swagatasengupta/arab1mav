package rnd.testng.group;

import org.testng.annotations.Test;

public class TestNGGroupDemo01 {

	@Test(groups = {"api_smoke"})
	public void groupAPISmokeTest01() {
		System.out.println("groupAPISmokeTest01");
	}
	
	@Test(groups = {"api_smoke"})
	public void groupAPISmokeTest02() {
		System.out.println("groupAPISmokeTest02");
	}
	
	@Test(groups = {"web_smoke"})
	public void groupWebSmokeTest01() {
		System.out.println("groupWebSmokeTest01");
	}
	@Test(groups = {"api_regression","api_smoke"})
	public void groupAPIRegressionTest01() {
		System.out.println("groupAPIRegressionTest01");
	}
	@Test(groups = {"api_regression"})
	public void groupAPIRegressionTest02() {
		System.out.println("groupAPIRegressionTest02");
	}
	@Test(groups = {"web_smoke","web_regression"})
	public void groupWebRegressionTest01() {
		System.out.println("groupWebRegressionTest01");
	}
	@Test(groups = {"web_regression"})
	public void groupWebRegressionTest02() {
		System.out.println("groupWebSmokeTest02");
	}
	@Test(groups = {"web_smoke"})
	public void groupWebSmokeTest03() {
		System.out.println("groupWebSmokeTest03");
	}
}
