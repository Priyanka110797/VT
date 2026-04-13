package Practice_Assertion;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tiger.crm.generic.fileutility.PropertyFileUtility;
import com.tiger.crm.objectreposotory.LoginPage;

import junit.framework.Assert;

public class HomePageVerification {

	@Test
	public void homePageTest(Method methodName) throws IOException {
	
		//System.out.println("HomePage Test start"); 
		//instead of this use Method class to capture methodNAme
		System.out.println(methodName+" Test Start");
		String expectedTitle="Home Page";
	PropertyFileUtility p=new PropertyFileUtility()	;
	String browser=p.getDataFromPropertiesFile("browser");
	String URL=p.getDataFromPropertiesFile("url");
	String UN=p.getDataFromPropertiesFile("username");
	String PW=p.getDataFromPropertiesFile("password");
	
	WebDriver driver=new ChromeDriver();
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 LoginPage lp=new LoginPage(driver);
	 lp.loginToapp(UN, PW);
	 
	 //home title
	String actualTitle= driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
	
//	if(actualTitle.trim().equals(expectedTitle))
//		System.out.println(expectedTitle+" is verified ==PASS");
//	else
//		System.out.println(expectedTitle+"  is veriefied ==FAIL");
	//Hard Assert
	Assert.assertEquals(actualTitle, expectedTitle);
	
	
	driver.close();
	
	System.out.println(methodName+" Test End");	
	}
	
	@Test
	public void verifyLogoInHomePage(Method methodName) throws IOException {
		
		System.out.println(methodName+"Test Start");
		PropertyFileUtility p=new PropertyFileUtility()	;
		String browser=p.getDataFromPropertiesFile("browser");
		String URL=p.getDataFromPropertiesFile("url");
		String UN=p.getDataFromPropertiesFile("username");
		String PW=p.getDataFromPropertiesFile("password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 LoginPage lp=new LoginPage(driver);
		 lp.loginToapp(UN, PW);
		
		boolean logoStatus= driver.findElement(By.xpath("//img[@src='test/logo/vtiger-crm-logo.gif']")).isEnabled();
//		if(logoStatus)
//			System.out.println(" Logo is verified==PASS");
//		else
//			System.out.println(" Logo is verified==FAIL");
	//Hard Assert
		Assert.assertTrue(logoStatus);
		System.out.println(methodName+"Test End");
	}
}
