package com.tiger.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {

	public static void main(String[] args) throws IOException, Throwable {
	
//Read data from property file
		FileInputStream fis=new FileInputStream("./AppData/commondata.properties");
Properties p=new Properties();
p.load(fis);
	String Browser=p.getProperty("browser");
	String URL=p.getProperty("url");
	String UN=p.getProperty("username");
	String PW=p.getProperty("password");
	
	System.out.println(Browser+" "+URL+" "+UN+" "+PW);

	//Launching browser
	WebDriver driver;
	
	if(Browser=="chrome")
		driver=new ChromeDriver();
	else if(Browser=="edge")
		driver=new EdgeDriver();
	else if(Browser=="firefox")
		driver=new FirefoxDriver();
	else
		driver=new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	//Accessing webpage==>>URL
	driver.get(URL);
	
	//Login into application
	driver.findElement(By.name("user_name")).sendKeys(UN);
	driver.findElement(By.name("user_password")).sendKeys(PW);
	driver.findElement(By.id("submitButton")).click();
	
	//Click on Organization
	driver.findElement(By.linkText("Organizations")).click();
	
	//Create new organization page by clicking on plus icon
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	
	
	//Read Data from Excel file
	FileInputStream fies=new FileInputStream("./testdata/testscriptdataTek.xlsx");
	Workbook wb=WorkbookFactory.create(fies);
	Sheet sh=wb.getSheet("org");
	Row r=sh.getRow(1);
	Cell c=r.getCell(2);
	
	Random random=new Random();
	int randomInt=random.nextInt(1000);
	String orgName=c.getStringCellValue()+randomInt;
	wb.close();
	
	//Organization Name Textfield
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	
	//click on Save button
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	//Check Page Header Information == Expected result
	String headerInfo=driver.findElement(By.xpath("//span[contains(@class,'dvHeaderText')]")).getText();
	if(headerInfo.contains(orgName)) 
		System.out.println(orgName+"  is created ==PASS");
	else
		System.out.println(orgName+" is not created==FAIL");
	
	//Verify Header orgName info ==Expected result
	String actualorgName=driver.findElement(By.id("dtlview_Organization Name")).getText();
	if(actualorgName.equals(orgName))
		System.out.println(orgName+"  is created == PASS");
	else
		System.out.println(orgName+" is not created ==FAIL");
	
	
	//Logout
//	Actions act=new Actions(driver);
//	WebElement logouticon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	act.moveToElement(logouticon);
//	WebElement signout=driver.findElement(By.xpath("//a[text()='Sign Out']"));
//	act.click(signout);
	driver.quit();
	
	
	
	
	}

}
