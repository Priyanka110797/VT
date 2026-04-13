package practice.testNG;

import org.testng.annotations.Test;

public class OrderTest {

//	@Test
//	public void createOrderTest() {
//		System.out.println("execute createOrderTest");
//	}
//	@Test(dependsOnMethods = "createOrderTest")
//	public void billingAnOrderTest() {
//		System.out.println("execute billingAnOrderTest");
//	}
//	Output>>>>>execute createOrderTest
//	           execute billingAnOrderTest
//	           Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
	
	
//	@Test
//	public void createOrderTest() {
//		System.out.println("execute createOrderTest");
//		String s=null;
//		System.out.println(s.equals("123"));
//	}
//	@Test(dependsOnMethods = "createOrderTest")
//	public void billingAnOrderTest() {
//		System.out.println("execute billingAnOrderTest");
//	}
//	
	//Output>>>Total tests run: 2, Passes: 0, Failures: 1, Skips: 1
	
	@Test
	public void createContactTest() {
		System.out.println("execute create contact test-----------HDFC");
	}
	@Test(dependsOnMethods = "createContactTest")
	public void modifyContactTest() {
		System.out.println("modify contact HDFC----ICICI_1");
	}
	@Test(dependsOnMethods = "modifyContactTest")
	public void deleteContactTest() {
		System.out.println("execute deleteContactTest ICICI");
	}
	
}
