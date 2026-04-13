package practice.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

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
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithIndustryTest2 {

	public static void main(String[] args) throws IOException {
	
		//read data from property file
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
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
	Sheet sh=wb.getSheet("org");
	Row r=sh.getRow(4);
	
	
	Random random=new Random();
	int randomInt=random.nextInt(1000);
	String orgName=r.getCell(2).toString()+randomInt;
	String industry=r.getCell(3).toString();
	String type=r.getCell(4).toString();
	wb.close();
	
	//Organization Name Textfield
	driver.findElement(By.name("accountname")).sendKeys(orgName);
	
	//Industry dropdown
	WebElement industrydd=driver.findElement(By.name("industry"));
	Select s=new Select(industrydd);
	s.selectByVisibleText(industry);
	
	WebElement typedd=driver.findElement(By.name("accounttype"));
	Select s1=new Select(typedd);
	s1.selectByVisibleText(type);
	

	//save button
	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
	
	//verify the industries and type info
	String actualIndustry=driver.findElement(By.id("dtlview_Industry")).getText();
	if(actualIndustry.equals(industry))
		System.out.println(industry+"  information verified==PASS");
	else
		System.out.println(industry+"  information is not verified==FAIL");
	
	
	String actualType=driver.findElement(By.id("dtlview_Type")).getText();
	if(actualType.equals(type))
		System.out.println(type+"  information verified==PASS");
	else
		System.out.println(type+"  information is not verified==FAIL");
	
	//Logout
//	Actions act=new Actions(driver);
//	WebElement logouticon=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//	act.moveToElement(logouticon);
//	WebElement signout=driver.findElement(By.xpath("//a[text()='Sign Out']"));
//	act.click(signout);
	driver.quit();
	
	
	
	
	}

}
