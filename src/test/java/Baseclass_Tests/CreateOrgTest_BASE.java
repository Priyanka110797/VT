package Baseclass_Tests;

import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import SampleBaseClass.BaseClass;

public class CreateOrgTest_BASE extends BaseClass {
	
		
		@Test
		public void createOrgWithIndustry() {
			System.out.println("execute createOrgWithIndustryTest");
		}
		
		
		
		@Test
		public void createContactWithDate() {
			System.out.println("execute createContactWithDate");
		}
		
		
	}

