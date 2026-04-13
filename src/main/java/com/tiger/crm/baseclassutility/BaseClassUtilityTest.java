package com.tiger.crm.baseclassutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tiger.crm.generic.databaseutility.DatabaseUtility;
import com.tiger.crm.generic.fileutility.ExcelUtility;
import com.tiger.crm.generic.fileutility.PropertyFileUtility;
import com.tiger.crm.generic.webdriverutility.JavaUtility;
import com.tiger.crm.generic.webdriverutility.UtilityClassObject;
import com.tiger.crm.generic.webdriverutility.WebDriverUtility;
import com.tiger.crm.objectreposotory.HomePage;
import com.tiger.crm.objectreposotory.LoginPage;

public class BaseClassUtilityTest {

	public DatabaseUtility dlib=new DatabaseUtility();
	public PropertyFileUtility plib=new PropertyFileUtility();
	public  ExcelUtility elib=new ExcelUtility();
	public JavaUtility jlib=new JavaUtility();
	public WebDriverUtility wlib=new WebDriverUtility();
	public  WebDriver driver=null;
	public static  WebDriver sdriver;
	
	
	
	@BeforeSuite
	public void configBS() throws SQLException{
		System.out.println("====Connect to DB,Report Config=====");
		
		
		
		
		
	}
	//@Parameters("BROWSER")
	@BeforeClass
public void configBC()throws IOException {
	System.out.println("=====Launch the Browser=====");
	String BROWSER=plib.getDataFromPropertiesFile("browser");
	//String BROWSER=browser;
	
	if(BROWSER.equals("chrome"))
		driver=new ChromeDriver();
	else if(BROWSER.equals("edge"))
		driver=new EdgeDriver();
	else if (BROWSER.equals("firefox"))
		driver=new FirefoxDriver();
	else
		driver=new ChromeDriver();
	System.out.println(driver);
	
	sdriver=driver;
	//UtilityClassObject.setDriver(driver);
}
	
	
	
	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("===login===");
		String URL=plib.getDataFromPropertiesFile("url");
		
		driver.get(URL);
		wlib.waitForPagetoLoad(driver);
		driver.manage().window().maximize();
		String UN=plib.getDataFromPropertiesFile("username");
		String PW=plib.getDataFromPropertiesFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(UN, PW);
		
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("==logout===");
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
	}
	
	
	@AfterClass
	public void configAC() {
		System.out.println("===close browser===");
		driver.quit();
	}
	
	@AfterSuite
	public void configSuite() throws SQLException {
		System.out.println("===close DB,Report BAckup=====");
		
	}
	
	
	
}
