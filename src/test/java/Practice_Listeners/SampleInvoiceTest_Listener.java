package Practice_Listeners;


import org.testng.annotations.Test;

import com.tiger.crm.baseclassutility.BaseClassUtilityTest;

import junit.framework.Assert;
//@Listeners(com.tiger.crm.listenerutility.ListenerImplementationClass.class)
public class SampleInvoiceTest_Listener extends BaseClassUtilityTest {

	@Test
	public void createInvoiceTest() {
		System.out.println("execute createInvoiceTest");
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle,"Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
	
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("execute createInvoiceWithContactTest");
		
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}
}
