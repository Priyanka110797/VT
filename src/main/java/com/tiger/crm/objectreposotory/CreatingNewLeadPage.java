package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewLeadPage {

	public CreatingNewLeadPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(name="lastname")
	WebElement lastNameTF;
	
	@FindBy(name="company")
	WebElement companyTF;
	
	@FindBy(name="phone")
	WebElement phoneTF;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	WebElement saveBtn;
	
	@FindBy(name="username")
	WebElement newElement1;

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getCompanyTF() {
		return companyTF;
	}

	public WebElement getPhoneTF() {
		return phoneTF;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void createLead(String lastname,String company) {
		lastNameTF.sendKeys(lastname);
		companyTF.sendKeys(company);
		saveBtn.click();
	}
	
	public void createLead(String lastname,String company,String phonenum) {
		lastNameTF.sendKeys(lastname);
		companyTF.sendKeys(company);
		phoneTF.sendKeys(phonenum);
		saveBtn.click();
	}
	
}
