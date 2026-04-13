package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactsPage {
	
	public CreatingNewContactsPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(name="lastname")
	WebElement lastNameTF;
	
	
	@FindBy(name="support_start_date")
	WebElement supStartDate;
	
	

	@FindBy(name="support_end_date")
	WebElement supEndDate;
	
	@FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	WebElement lookupIcon;
	
	
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	WebElement saveBtn;
	
	
	
	public WebElement getLastNameTF() {
		return lastNameTF;
	}
	
	public WebElement getSupStartDate() {
		return supStartDate;
	}

	public WebElement getSupEndDate() {
		return supEndDate;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	
	
	public void createContact(String lastname) {
		lastNameTF.sendKeys(lastname);
		saveBtn.click();
	}
	
	public void createContact(String lastname,String startdate,String enddate) {
		lastNameTF.sendKeys(lastname);
		supStartDate.clear();
		supStartDate.sendKeys(startdate);
		supEndDate.clear();
		supEndDate.sendKeys(enddate);
		saveBtn.click();
	}
	

}
