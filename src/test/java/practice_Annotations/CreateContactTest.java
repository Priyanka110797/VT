package practice_Annotations;

import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CreateContactTest {
	@BeforeSuite
	public void configBS(){
		System.out.println("execute BeforeSuite");
	}
	@BeforeClass
public void configBC() {
	System.out.println("execute BC");
}
	
	@Test
	public void createContactTest() {
		System.out.println("execute create contact test");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("execute BM");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("execute AM");
	}
	
	@Test
	public void createContactWithDate() {
		System.out.println("execute createContactWithDate");
	}
	
	@AfterMethod
	public void configAC() {
		System.out.println("execute AfterMethod");
	}
	
	@AfterSuite
	public void configSuite() {
		System.out.println("execute AfterSuite");
	}
}
