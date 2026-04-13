package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	@FindBy(name="accountname")
	WebElement orgNameTF;
	
	@FindBy(name="industry")
	WebElement industryDd;
	
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	WebElement saveBtn;
	
	public WebElement getOrgNameTF() {
		return orgNameTF;
	}
	
	public WebElement getIndustryDd() {
		return industryDd;
	}
	public WebElement getSavBtn() {
		return saveBtn;
	}
	
	public void createOrg(String orgName) {
		orgNameTF.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String orgName,String industry) {
		orgNameTF.sendKeys(orgName);
		Select s=new Select(industryDd);
		s.selectByVisibleText(industry);
		saveBtn.click();
	}
}
