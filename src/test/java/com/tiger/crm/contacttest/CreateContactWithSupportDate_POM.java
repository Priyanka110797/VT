package com.tiger.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithSupportDate_POM {

	public static void main(String[] args) throws IOException {
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
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//Accessing webpage==>>URL
			driver.get(URL);
			
			//Login into application
			driver.findElement(By.name("user_name")).sendKeys(UN);
			driver.findElement(By.name("user_password")).sendKeys(PW);
			driver.findElement(By.id("submitButton")).click();
			
			//Click on Contacts
			driver.findElement(By.linkText("Contacts")).click();
			
			//Create new organization page by clicking on plus icon
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			
			//Read Data from Excel file
			FileInputStream fies=new FileInputStream("./testdata/testscriptdataTek.xlsx");
			Workbook wb=WorkbookFactory.create(fies);
			Sheet sh=wb.getSheet("contact");
			Row r=sh.getRow(4);
			
			
			Random random=new Random();
			int randomInt=random.nextInt(1000);
			String lastName=r.getCell(2).getStringCellValue()+randomInt;
			wb.close();
			
			//Start date and End date 
			
			Date d=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String startDate=sdf.format(d);
			
			Calendar cal=sdf.getCalendar();
			cal.add(Calendar.DAY_OF_MONTH,30);
			String endDate=sdf.format(cal.getTime());
			
			
			//Contact Name Textfield
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			//Support start date textfield
			driver.findElement(By.name("support_start_date")).clear();
			driver.findElement(By.name("support_start_date")).sendKeys(startDate);
			
			//Support end date textfield
			driver.findElement(By.name("support_end_date")).clear();
			driver.findElement(By.name("support_end_date")).sendKeys(endDate);
			
			//click on Save button
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
			
			
			//Check Page Header Information == Expected result
			String headerInfo=driver.findElement(By.xpath("//span[contains(@class,'dvHeaderText')]")).getText();
			if(headerInfo.contains(lastName)) 
				System.out.println(lastName+"  is created ==PASS");
			else
				System.out.println(lastName+" is not created==FAIL");
			
//			//Verify Header LastName info ==Expected result
//			String actualLastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
//			if(actualLastName.equals(lastName))
//				System.out.println(lastName+"  is created == PASS");
//			else
//				System.out.println(lastName+" is not created ==FAIL");
			
			//Verify Support Start date
			String actualStartDate=driver.findElement(By.id("dtlview_Support Start Date")).getText();
			System.out.println(actualStartDate+"  "+startDate);
			if(actualStartDate.equals(startDate))
				System.out.println(startDate+" is verified == PASS");
			else
				System.out.println(startDate+" is not verified == FAIL");
			
			//Verify Support End date
			String actualEndDate=driver.findElement(By.id("dtlview_Support End Date")).getText();
			System.out.println(actualEndDate+"  "+endDate);
			if(actualEndDate.equals(endDate))
				System.out.println(endDate+" is verified == PASS");
			else
				System.out.println(endDate+" is not verified == FAIL");
			
			//Logout
//			Actions act=new Actions(driver);
//			WebElement logouticon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//			act.moveToElement(logouticon);
//			WebElement signout=driver.findElement(By.xpath("//a[text()='Sign Out']"));
//			act.click(signout);
			driver.quit();
			
			
			
			

	}

}
