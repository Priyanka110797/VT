package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage {

	public LeadsPage(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	WebElement createNewLeadBtn;
	
	@FindBy(name="search_text")
	WebElement searchTF;
	
	@FindBy(name="submit")
	WebElement searchBtn;
	
	@FindBy(name="search_field")
	WebElement searchDd;

	public WebElement getCreateNewLeadBtn() {
		return createNewLeadBtn;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchDd() {
		return searchDd;
	}
	
	
}
