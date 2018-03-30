package rnd.testng.order;

import org.testng.annotations.Test;

public class TestNGOrderDemo01 {
/*
 * Priority order is from 0 to 5... 10 etc.. 0 being highest
 */
	
	@Test(priority = 1)
	public void d01orderTest01() {
		System.out.println("d01orderTest01");
	}
	
	@Test(priority = 2)
	public void d01orderTest02() {
		System.out.println("d01orderTest02");
	}
	
	@Test(priority = 0)
	public void d01orderTest03() {
		System.out.println("d01orderTest03");
	}
	@Test(priority = 2)
	public void d01orderTest04() {
		System.out.println("d01orderTest04");
	}
	@Test(priority = 3)
	public void d01orderTest06() {
		System.out.println("d01orderTest06");
	}
	@Test(priority = 3)
	public void d01orderTest05() {
		System.out.println("d01orderTest05");
	}
}
