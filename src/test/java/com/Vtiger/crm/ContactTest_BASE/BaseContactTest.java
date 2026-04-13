package com.Vtiger.crm.ContactTest_BASE;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Vtiger.crm.basetest.BaseClassTest;
import com.aventstack.extentreports.Status;
import com.tiger.crm.baseclassutility.BaseClassUtilityTest;
import com.tiger.crm.generic.webdriverutility.UtilityClassObject;
import com.tiger.crm.objectreposotory.ContactPage;
import com.tiger.crm.objectreposotory.CreatingNewContactsPage;
import com.tiger.crm.objectreposotory.HomePage;
@Listeners(com.tiger.crm.listenerutility.ListenerImplementationClass.class)

public class BaseContactTest extends BaseClassUtilityTest{

	@Test(groups = "Smoke test")
	public void createContactTest() throws EncryptedDocumentException, IOException {
		
		
		//ListenerImplementationClass.test.log(Status.INFO,"read data from Excel");
		UtilityClassObject.getTest().log(Status.INFO,"read data from Excel");
		//read data from excelfile
		String lastName=elib.getDataFromExcel("contact", 1, 2)+jlib.getRandomNumber();
		
		//navigate to contact module
		//ListenerImplementationClass.test.log(Status.INFO,"navigate to contact page");
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact page");
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		//click on create contact "+" button
		//ListenerImplementationClass.test.log(Status.INFO,"navigate to create new contact page");
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create new contact page");
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
	
		//enter all details
		//ListenerImplementationClass.test.log(Status.INFO,"create contact");
		UtilityClassObject.getTest().log(Status.INFO,"create contact");
		CreatingNewContactsPage cnc=new CreatingNewContactsPage(driver);
		cnc.createContact(lastName);
		//ListenerImplementationClass.test.log(Status.INFO,lastName+"read data from Excel");
		UtilityClassObject.getTest().log(Status.INFO,lastName+"read data from Excel");
		Assert.assertEquals("Contact Information", lastName);
	}
	
//	@Test(groups = "Regression Test")
//	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {
//		String lastName=elib.getDataFromExcel("contact", 1, 2)+jlib.getRandomNumber();
//	    String startDate=jlib.getSystemDate();
//	    String endDate=jlib.getRequiredDate(30);
//	    System.out.println(endDate);
//	    
//	    HomePage hp=new HomePage(driver);
//	    hp.getContactLink().click();
//	    
//	    ContactPage cp=new ContactPage(driver);
//	    cp.getCreateNewContactBtn().click();
//	    
//	    CreatingNewContactsPage newContact=new CreatingNewContactsPage(driver);
//	    newContact.createContact(lastName, startDate, endDate);
//		
//	}

}
