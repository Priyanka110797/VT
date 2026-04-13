package practice.testNG;

import org.testng.annotations.Test;

public class OrderTest_invocationCount {

//	@Test(invocationCount = 5)
//	public void createOrderTest() {
//		System.err.println("execute createOrderTest");
//	}
//	@Test
//	public void billingAnOrderTest() {
//		System.out.println("execute billingAnOrderTest");
//	}
//	
	//output>>>> tests run: 6, Passes: 6, Failures: 0, Skips: 0
	
//	@Test(invocationCount = 5)
//	public void createOrderTest() {
//		System.err.println("execute createOrderTest");
//	}
//	@Test(enabled = false)
//	public void billingAnOrderTest() {
//		System.out.println("execute billingAnOrderTest");
//	}
	//output>>>>>Total tests run: 5, Passes: 5, Failures: 0, Skips: 0
	
	
	//=============using for loop instead of invocationCount
	@Test
	public void createOrderTest() {
		for(int i=0;i<10;i++)
		System.out.println("execute createOrderTest");
	}
	@Test(enabled = false)
	public void billingAnOrderTest() {
		System.out.println("execute billingAnOrderTest");
	}
	
	//output>>>>Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
	
	
	
	
	
	
}
