package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class LeadInformationPage {
 
		public LeadInformationPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
		}

		@FindBy(className="dvHeaderText")
		WebElement headerMsg;
		
		@FindBy(id="dtlview_Last Name")
		WebElement actualLastName;
		
		@FindBy(id="dtlview_Phone")
		WebElement actualPhoneNumber;

		@FindBy(xpath="//a[text()='Convert Lead']")
		WebElement convertLeadLink;
		
		

		public WebElement getHeaderMsg() {
			return headerMsg;
		}

		public WebElement getActualLastName() {
			return actualLastName;
		}

		public WebElement getActualPhoneNumber() {
			return actualPhoneNumber;
		}

		public WebElement getConvertLeadLink() {
			return convertLeadLink;
		}

		
}
