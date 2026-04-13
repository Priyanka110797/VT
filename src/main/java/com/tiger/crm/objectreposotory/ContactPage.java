package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	WebElement createNewContactBtn;
	
	@FindBy(name="search_text")
	WebElement searchTF;
	
	@FindBy(name="submit")
	WebElement searchBtn;
	
	@FindBy(name="search_field")
	WebElement searchDD;

	public WebElement getCreateNewContactBtn() {
		return createNewContactBtn;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}
}
