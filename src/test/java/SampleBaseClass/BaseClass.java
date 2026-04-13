package SampleBaseClass;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BaseClass {

	@BeforeSuite
	public void configBS(){
		System.out.println("====Connect to DB,Report Config=====");
	}
	@BeforeClass
public void configBC() {
	System.out.println("=====Launch the Browser=====");
}
	
	
	
	@BeforeMethod
	public void configBM() {
		System.out.println("===login===");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("==logout===");
	}
	
	
	@AfterClass
	public void configAC() {
		System.out.println("===close browser===");
	}
	
	@AfterSuite
	public void configSuite() {
		System.out.println("===close DB,Report BAckup=====");
	}
	
	
	
}
