package Practice_Assertion;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tiger.crm.generic.fileutility.PropertyFileUtility;
import com.tiger.crm.objectreposotory.LoginPage;

import junit.framework.Assert;

public class HomePageVerification_HardAssert {

	@Test
	public void homePageTest(Method methodName) throws IOException {
	
		Reporter.log(methodName+"Test Starts");
		
		
		Reporter.log("Step-1");
		Reporter.log("Step-2");
		Assert.assertEquals("Home","Home-Page");
		Reporter.log("Step-3");
		Assert.assertEquals("Home-CRM","Home-CRM");
		Reporter.log("Step-4");
		Reporter.log(methodName+"Test Ends");
	}
	
	@Test
	public void verifyLogoInHomePage(Method methodName) throws IOException {
		
		System.out.println(methodName+"Test Start");
		System.out.println("Step-1");
		System.out.println("Step-2");
		Assert.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println(methodName+"Test End");
	}
}
