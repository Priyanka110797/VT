package Practice_Listeners;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class SimActivateTest_Retry {
@Test(retryAnalyzer = com.tiger.crm.listenerutility.RetryListenerImplementationClass.class)
public void activateSimTest() {
	System.out.println("execute activateSimTest");
	
	Assert.assertEquals(" ","Login");
	System.out.println("Step-1");
	System.out.println("Step-2");
	System.out.println("Step-3");
	System.out.println("Step-4");
}
}
