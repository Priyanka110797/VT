package practice.testNG;

import org.testng.annotations.Test;

public class SampleTest_Priority {

//	@Test(priority = -1)
//	public void createContactTest() {
//		System.out.println("execute create contact test");
//	}
//	@Test(priority = 0)
//	public void modifyContactTest() {
//		System.out.println("execute modify contact test");
//	}
//	@Test(priority = 1)
//	public void deleteContactTest() {
//		System.out.println("execute delete contact test");
//	}
	
	//ouput>>>>>//execute create contact test
				//	execute modify contact test
				//	execute delete contact test
	
	
	//dependent testCases >>>>Priority fails when one TC fails remaining all Tc Fails
	
//	@Test(priority = 1)
//	public void createContactTest() {
//		System.out.println("execute create contact test----HDFC");
//	}
//	@Test(priority = 2)
//	public void modifyContactTest() {
//		System.out.println("execute modify contact test -----HDFC to ICICI");
//	}
//	
//	@Test(priority = 3)
//	public void deleteContactTest() {
//		System.out.println("execute delete contact test---ICICI");
//	}
//	execute create contact test----HDFC
//	execute modify contact test -----HDFC to ICICI
//	execute delete contact test---ICICI
//	
	
	//making TestCases Independent
//	@Test
//	public void createContactTest() {
//		System.out.println("execute create contact test-----------HDFC");
//	}
//	@Test
//	public void modifyContactTest() {
//		System.out.println("execute create contact------ICICI ");
//		System.out.println("modify contact ICICI----ICICI_1");
//	}
//	@Test
//	public void deleteContactTest() {
//		System.out.println("create contact UPI");
//		System.out.println("execute delete contact------UPI");
//	}
	
	//best approach insert contact in Database
	@Test
	public void createContactTest() {
		System.out.println("execute create contact test-----------HDFC");
	}
	@Test
	public void modifyContactTest() {
		System.out.println("execute query insert contact in DB------ICICI ");
		System.out.println("modify contact ICICI----ICICI_1");
	}
	@Test
	public void deleteContactTest() {
		System.out.println("execute query insert contact in DB---- UPI");
		System.out.println("execute delete contact------UPI");
	}
}

