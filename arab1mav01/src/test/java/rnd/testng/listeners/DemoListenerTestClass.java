package rnd.testng.listeners;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class DemoListenerTestClass {
  @Test
  public void f() {
	  System.out.println("during testMethod");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("BEFORE testMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("AFTER testMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("BEFORE class");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("AFTER class");

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("BEFORE test");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AFTER test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BEFORE suite");
 }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AFTER suite");
  }
  

}
