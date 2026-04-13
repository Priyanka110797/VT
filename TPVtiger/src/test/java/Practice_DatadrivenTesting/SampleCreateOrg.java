package Practice_DatadrivenTesting;

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
import org.openqa.selenium.interactions.Actions;

public class SampleCreateOrg {

	public static void main(String[] args) throws IOException {
	
		//Read common data from property file
//		FileInputStream fis=new FileInputStream("‪‪C:\\Users\\priya\\OneDrive\\Desktop\\commondata.properties");
//		Properties p=new Properties();
//		p.load(fis);
		
		FileInputStream fis=new FileInputStream("\\Users\\priya\\OneDrive\\Desktop\\commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		
		
		String Browser=p.getProperty("browser");
		String URL=p.getProperty("url");
		String UN=p.getProperty("username");
		String PW=p.getProperty("password");
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).submit();
		
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//Read Test Script Data from Excel File
		FileInputStream fies=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\testScriptdataTP.xlsx");
		Workbook wb=WorkbookFactory.create(fies);
		Sheet sh=wb.getSheet("org");
		Row r=sh.getRow(1);
		
		
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		String orgName=r.getCell(2).toString()+randomInt;
		
		//Organization >>Name textfield
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				//click on save button
				driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
				
				//logout operation
				Actions act=new Actions(driver);
				WebElement logout=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				act.moveToElement(logout).perform();
				//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
				
				
				//driver.close();
		
		
		

	}

}
