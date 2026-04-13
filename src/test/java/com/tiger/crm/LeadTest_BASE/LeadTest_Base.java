package com.tiger.crm.LeadTest_BASE;

import org.testng.annotations.Test;

import com.tiger.crm.baseclassutility.BaseClassUtilityTest;
import com.tiger.crm.objectreposotory.CreatingNewLeadPage;
import com.tiger.crm.objectreposotory.HomePage;
import com.tiger.crm.objectreposotory.LeadsPage;

public class LeadTest_Base extends BaseClassUtilityTest{

	@Test
	public void createLead() {
		HomePage hp=new HomePage(driver);
		hp.getLeadLink().click();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.getCreateNewLeadBtn().click();
		
		CreatingNewLeadPage clp=new CreatingNewLeadPage(driver);
		clp.createLead(null, null);
	}
}
