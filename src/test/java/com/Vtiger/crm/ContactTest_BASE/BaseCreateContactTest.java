package com.Vtiger.crm.ContactTest_BASE;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Vtiger.crm.basetest.BaseClassTest;
import com.tiger.crm.objectreposotory.ContactPage;
import com.tiger.crm.objectreposotory.CreatingNewContactsPage;
import com.tiger.crm.objectreposotory.HomePage;

public class BaseCreateContactTest extends BaseClassTest{

	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		//read data from excelfile
		String lastName=elib.getDataFromExcel("contact", 1, 2)+jlib.getRandomNumber();
		
		//navigate to contact module
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		//click on create contact "+" button
		ContactPage cp=new ContactPage(driver);
		cp.getCreateNewContactBtn().click();
	
		//enter all details
		CreatingNewContactsPage cnc=new CreatingNewContactsPage(driver);
		cnc.createContact(lastName);
			
			
	}
	
	@Test
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {
		String lastName=elib.getDataFromExcel("contact", 1, 2)+jlib.getRandomNumber();
	    String startDate=jlib.getSystemDate();
	    String endDate=jlib.getRequiredDate(30);
	    System.out.println(endDate);
	    
	    HomePage hp=new HomePage(driver);
	    hp.getContactLink().click();
	    
	    ContactPage cp=new ContactPage(driver);
	    cp.getCreateNewContactBtn().click();
	    
	    CreatingNewContactsPage newContact=new CreatingNewContactsPage(driver);
	    newContact.createContact(lastName, startDate, endDate);
		
	}

}
