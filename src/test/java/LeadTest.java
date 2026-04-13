import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tiger.crm.baseclassutility.BaseClassUtilityTest;
import com.tiger.crm.objectreposotory.ConvertLeadPage;
import com.tiger.crm.objectreposotory.CreatingNewLeadPage;
import com.tiger.crm.objectreposotory.HomePage;
import com.tiger.crm.objectreposotory.LeadInformationPage;
import com.tiger.crm.objectreposotory.LeadsPage;
import com.tiger.crm.objectreposotory.OrganizationInfoPage;

import junit.framework.Assert;
@Listeners(com.tiger.crm.listenerutility.ListenerImplementationClass.class)
public class LeadTest extends BaseClassUtilityTest{
	
	@Test
	public void createLeadTest() throws EncryptedDocumentException, IOException {
		
		String lastName=elib.getDataFromExcel("leads", 1, 2)+jlib.getRandomNumber();
		String companyName=elib.getDataFromExcel("leads", 1, 3)+jlib.getRandomNumber();
		
		
		HomePage hp=new HomePage(driver);
		hp.getLeadLink().click();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.getCreateNewLeadBtn().click();
		
		
		CreatingNewLeadPage cnl=new CreatingNewLeadPage(driver);
		cnl.createLead(lastName,companyName);
		
		LeadInformationPage leadinfo=new LeadInformationPage(driver);
	    String headerMsg=leadinfo.getHeaderMsg().getText();
	    System.out.println(headerMsg);
	    System.out.println(lastName);
	    Assert.assertTrue(headerMsg.contains(lastName));
	    
	}
	
	@Test
	public void CreateLeadWithPhoneNumberTest() throws EncryptedDocumentException, IOException {
		String lastName=elib.getDataFromExcel("leads", 4, 2)+jlib.getRandomNumber();
		String companyName=elib.getDataFromExcel("leads", 4, 3)+jlib.getRandomNumber();
		String phoneNumber=elib.getDataFromExcel("leads", 4, 4)+jlib.getRandomNumber();
		
		HomePage hp=new HomePage(driver);
		hp.getLeadLink().click();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.getCreateNewLeadBtn().click();
		
		CreatingNewLeadPage newLead=new CreatingNewLeadPage(driver);
		newLead.createLead(lastName, companyName, phoneNumber);
		
		LeadInformationPage leadinfo=new LeadInformationPage(driver);
		String headerMesssage=leadinfo.getHeaderMsg().getText();
		String actualPhoneNumber=leadinfo.getActualPhoneNumber().getText();
		
	   Assert.assertTrue(headerMesssage.contains(lastName));
	   Assert.assertTrue(actualPhoneNumber.equals(phoneNumber));
	}
	
	@Test
	public void ConvertLeadTest() throws EncryptedDocumentException, IOException {
		String lastName=elib.getDataFromExcel("leads", 1, 2)+jlib.getRandomNumber();
		String companyName=elib.getDataFromExcel("leads", 1, 3)+jlib.getRandomNumber();
		
		
		HomePage hp=new HomePage(driver);
		hp.getLeadLink().click();
		
		LeadsPage lp=new LeadsPage(driver);
		lp.getCreateNewLeadBtn().click();
		
		
		CreatingNewLeadPage cnl=new CreatingNewLeadPage(driver);
		cnl.createLead(lastName,companyName);
		
		LeadInformationPage leadInfo=new LeadInformationPage(driver);
		leadInfo.getConvertLeadLink().click();
		ConvertLeadPage convertLead=new ConvertLeadPage(driver);
		convertLead.getConvertLeadPopup();
		convertLead.getSaveConvertLeadBtn().click();
		
		OrganizationInfoPage orgInfo=new OrganizationInfoPage(driver);
		String headerMsg=orgInfo.getHeaderMsg().getText();
		Assert.assertTrue(headerMsg.contains(companyName));
		
		
		
	
	}

}
