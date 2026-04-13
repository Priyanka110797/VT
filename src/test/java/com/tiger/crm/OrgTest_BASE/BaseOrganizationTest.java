package com.tiger.crm.OrgTest_BASE;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tiger.crm.baseclassutility.BaseClassUtilityTest;
import com.tiger.crm.objectreposotory.CreatingNewOrganizationPage;
import com.tiger.crm.objectreposotory.HomePage;
import com.tiger.crm.objectreposotory.OrganizationPage;

@Listeners(com.tiger.crm.listenerutility.ListenerImplementationClass.class)
public class BaseOrganizationTest extends BaseClassUtilityTest {

	@Test(groups = "Smoke Test")
	public void createOrganizationTest() throws EncryptedDocumentException, IOException {
		String orgName=elib.getDataFromExcel("org", 1, 2)+jlib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		
		
		
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgName);
		
		
		
	}
	
	
}
