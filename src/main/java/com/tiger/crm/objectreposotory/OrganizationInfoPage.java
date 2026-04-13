package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements( driver,this);//this >>refers to current class object
	}
	@FindBy(className="dvHeaderText")
	WebElement headerMsg;

	
	@FindBy(id="dtlview_Organization Name")
	WebElement actualOrganizationName;
	
	@FindBy(id="dtlview_Phone")
	WebElement actualPhoneNumber;
	
	
	
	public WebElement getActualOrganizationName() {
		return actualOrganizationName;
	}

	public WebElement getActualPhoneNumber() {
		return actualPhoneNumber;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
}
