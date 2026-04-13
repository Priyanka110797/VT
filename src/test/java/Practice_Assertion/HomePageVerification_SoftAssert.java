package Practice_Assertion;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tiger.crm.generic.fileutility.PropertyFileUtility;
import com.tiger.crm.objectreposotory.LoginPage;

import junit.framework.Assert;

public class HomePageVerification_SoftAssert {

	@Test
	public void homePageTest(Method methodName) throws IOException {
	   SoftAssert sa=new SoftAssert();
	   
		System.out.println(methodName+"Test Starts");
		System.out.println("Step-1");
		System.out.println("Step-2");
		sa.assertEquals("Home","Home-Page");
		System.out.println("Step-3");
		sa.assertEquals("Home-CRM","Home-CRM");
		System.out.println("Step-4");
		
		sa.assertAll();
		System.out.println(methodName+"Test Ends");
	}
	
	@Test
	public void verifyLogoInHomePage(Method methodName) throws IOException {
		 SoftAssert sa=new SoftAssert();
		System.out.println(methodName+"Test Start");
		System.out.println("Step-1");
		System.out.println("Step-2");
		sa.assertTrue(true);
		System.out.println("Step-3");
		System.out.println("Step-4");
		System.out.println(methodName+"Test End");
	}
}
