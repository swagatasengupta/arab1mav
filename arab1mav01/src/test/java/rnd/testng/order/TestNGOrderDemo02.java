package rnd.testng.order;

import org.testng.annotations.Test;

public class TestNGOrderDemo02 {
/*
 * Priority order is from 0 to 5... 10 etc.. 0 being highest
 */
	
	@Test(priority = 5)
	public void d02orderTest01() {
		System.out.println("d02orderTest01");
	}
	
	@Test(priority = 2)
	public void d02orderTest02() {
		System.out.println("d02orderTest02");
	}
	
	@Test(priority = 1)
	public void d02orderTest03() {
		System.out.println("d02orderTest03");
	}
	@Test(priority = 3)
	public void d02orderTest04() {
		System.out.println("d02orderTest04");
	}
	@Test(priority = 3)
	public void d02orderTest06() {
		System.out.println("d02orderTest06");
	}
	@Test(priority = 4)
	public void d02orderTest05() {
		System.out.println("d02orderTest05");
	}
}
