package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConvertLeadPage {
	
	public ConvertLeadPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="Save")
	WebElement saveConvertLeadBtn;
	
	@FindBy(className="genHeaderSmall")
	WebElement convertLeadHeaderMsg;
	
	@FindBy(xpath="//div[@id='orgLay']")
	WebElement convertLeadPopup;

	public WebElement getConvertLeadPopup() {
		return convertLeadPopup;
	}

	public WebElement getConvertLeadHeaderMsg() {
		return convertLeadHeaderMsg;
	}

	public WebElement getSaveConvertLeadBtn() {
		return saveConvertLeadBtn;
	}
	
	

}
