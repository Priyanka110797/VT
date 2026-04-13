package com.tiger.crm.objectreposotory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tiger.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{

	//Rule1: create a separate java class
	//Rule2: Object creation
	
	//to intialize use constructor
	public LoginPage(WebDriver driver) {
		PageFactory.initElements( driver,this);//this >>refers to current class object
	}
	
	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	//Rule3:Object Initialization
	
	//Rule4: Object Encapsulation
	public WebElement getUsername() {
		return usernameTF;
	}

	public WebElement getPassword() {
		return passwordTF;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Rule5:provide action -utilization-business library
	public void loginToapp(String username,String password) {
		
		
		usernameTF.sendKeys(username);
		passwordTF.sendKeys(password);
		loginbtn.click();
		
	}
	
	
	
	

}
