package practice.testNG;

import org.testng.annotations.Test;

public class CreateContactTest {

	@Test
	public void createContactTest(){
		
		System.out.println("execute login");
		System.out.println("execute navigateTocontact");
		System.out.println("execute createContact");
		System.out.println("execute verifyContact");
		System.out.println("execute logout");
		
	}
	
	@Test
	public void createContactWithMobileNumber() {
		System.out.println("execute createcontactWithMobileNumber");
	}
	
	
}
