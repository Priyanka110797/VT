package com.tiger.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tiger.crm.generic.fileutility.ExcelUtility;
import com.tiger.crm.generic.fileutility.PropertyFileUtility;
import com.tiger.crm.generic.webdriverutility.JavaUtility;
import com.tiger.crm.generic.webdriverutility.WebDriverUtility;
import com.tiger.crm.objectreposotory.CreatingNewOrganizationPage;
import com.tiger.crm.objectreposotory.HomePage;
import com.tiger.crm.objectreposotory.LoginPage;
import com.tiger.crm.objectreposotory.OrganizationInfoPage;
import com.tiger.crm.objectreposotory.OrganizationPage;

public class DeleteOrgTest {

	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility p=new PropertyFileUtility();
		String Browser=p.getDataFromPropertiesFile("browser");
		String URL=p.getDataFromPropertiesFile("url");
		String UN=p.getDataFromPropertiesFile("username");
		String PW=p.getDataFromPropertiesFile("password");
		
		JavaUtility j=new JavaUtility();
		int random=j.getRandomNumber();
		ExcelUtility e=new ExcelUtility();
		String orgName=e.getDataFromExcel("org", 10, 2)+random;
		
		WebDriverUtility wb=new WebDriverUtility();
		
		WebDriver driver;
		if(Browser=="chrome")
			driver=new ChromeDriver();
		else if(Browser=="edge")
			driver=new EdgeDriver();
		else if(Browser=="firefox")
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(UN, PW);
		
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		OrganizationPage op=new OrganizationPage(driver);
		op.getCreateNewOrgBtn().click();
		
		
		CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
		cop.createOrg(orgName);
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actualOrgName=oip.getHeaderMsg().getText();
		System.out.println(actualOrgName);
		if(actualOrgName.contains(orgName))
			System.out.println(orgName+"  is verified == PASS");
		else
			System.out.println(orgName+"  is not verified == FAIL");
		
		//go back to Organization page
		hp.getOrgLink().click();
		
		//search for Organization
		op.getSearchTF().sendKeys(orgName);
		wb.select(op.getSearchDd(), "Organization Name");
		op.getSearchBtn().click();
		
		//in dynamic webtable select and delete org
		driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
		
		//logout
		
		
		
		
		
	}
}
