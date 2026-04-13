package practice.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateContactWithOrganization {

	public static void main(String[] args) throws IOException {
		//Read data from property file
		FileInputStream fis=new FileInputStream("\\Users\\priya\\OneDrive\\Desktop\\TekTestData\\commondata.properties");
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
			FileInputStream fies=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\TekTestData\\testscriptdataTek.xlsx");
			Workbook wb=WorkbookFactory.create(fies);
			Sheet sh=wb.getSheet("contact");
			Row r=sh.getRow(7);
			
			
			Random random=new Random();
			int randomInt=random.nextInt(1000);
			String orgName=r.getCell(2).getStringCellValue()+randomInt;
			String lastName=r.getCell(3).getStringCellValue()+randomInt;
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
			
			
			
			//Click on Contacts
			driver.findElement(By.linkText("Contacts")).click();
			
			//Create new organization page by clicking on plus icon
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			//Contact Name Textfield
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			//click on lookup icon--organization
			driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
			
			
			//switch to child window
			
			Set<String> set=driver.getWindowHandles();
			Iterator<String> itr =set.iterator();
			while(itr.hasNext()) {
				String windowID=itr.next();
				driver.switchTo().window(windowID);
				
				String actualUrl=driver.getCurrentUrl();
				if(actualUrl.contains("module=Accounts"))
					break;
				
			}
			
			//search textfield
			driver.findElement(By.id("search_txt")).sendKeys(orgName);
			
			//click on search button
			driver.findElement(By.name("search")).click();
			
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			
			//switch to parent window
			
			Set<String> set1=driver.getWindowHandles();
			Iterator<String> itr1 =set1.iterator();
			while(itr1.hasNext()) {
				String windowID=itr1.next();
				driver.switchTo().window(windowID);
				
				String actualUrl=driver.getCurrentUrl();
				if(actualUrl.contains("module=Contacts&action"))
					break;
				
			}
			
			//click on Save button
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
			//Check Page Header Information == Expected result
			 headerInfo=driver.findElement(By.xpath("//span[contains(@class,'dvHeaderText')]")).getText();
			if(headerInfo.contains(lastName)) 
				System.out.println(lastName+"  is created ==PASS");
			else
				System.out.println(lastName+" is not created==FAIL");
			
			//Verify Header orgName info ==Expected result
			String actualLastName=driver.findElement(By.id("mouseArea_Last Name")).getText();
			if(actualLastName.equals(lastName))
				System.out.println(lastName+"  is created == PASS");
			else
				System.out.println(lastName+" is not created ==FAIL");
			
			//verify header orgName expected result
			String actualOrgName=driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if(actualOrgName.trim().equals(orgName))
				System.out.println(orgName+"  is created==PASS");
			else
				System.out.println(orgName+"  is not created==FAIL");
			
	}

}
