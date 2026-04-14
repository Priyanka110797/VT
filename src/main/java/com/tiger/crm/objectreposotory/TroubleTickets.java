package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTickets {

	public TroubleTickets(WebDriver driver) {
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	WebElement createNewTicketlink;
	
	@FindBy(name="search_text")
	WebElement searchTF;
	
	@FindBy(className ="txtBox")
	WebElement searchDD;
	
	@FindBy(name="submit")
	WebElement seacrhBtn;
	

	@FindBy(name="username")
	WebElement Newele1;
	
	public WebElement getCreateNewTicketlink() {
		return createNewTicketlink;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSeacrhBtn() {
		return seacrhBtn;
	}
	
	
}
