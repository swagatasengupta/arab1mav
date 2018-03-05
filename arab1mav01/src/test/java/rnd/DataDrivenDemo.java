package rnd;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DataDrivenDemo {

	@BeforeMethod
	public void beforeMethod() {
	}

	@Test(dataProvider = "test_provider", dataProviderClass = DemoDataProvider.class)
	public void t01_MyTest(String fName, String lName, String email, String title) {
		System.out.println("FirstName: " + fName);
		System.out.println("FirstName: " + lName);
		System.out.println("Email: " + email);
		System.out.println("Title: " + title);
	}

	@AfterMethod
	public void logoutAndClose() {
	}
}
