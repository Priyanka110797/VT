package practice.lead;

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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateLeadTest {

	public static void main(String[] args) throws IOException {
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
			
			
			//click on lead link
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
			
			
			//Random input
			Random ran=new Random();
			int random=ran.nextInt(1000);
			//read data from excel
			FileInputStream fies=new FileInputStream("./testdata/testscriptdataTek.xlsx");
			Workbook wb=WorkbookFactory.create(fies);
			Sheet sh=wb.getSheet("lead");
			Row r=sh.getRow(1);
			String lastName=r.getCell(2).getStringCellValue()+random;
			String company=r.getCell(3).getStringCellValue()+random;
			//lead textfields
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			driver.findElement(By.name("company")).sendKeys(company);
			//save button
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			String headerInfo=driver.findElement(By.className("dvHeaderText")).getText();
			if(headerInfo.contains(lastName))
				System.out.println(lastName+"  is verified test==PASS");
			else
				System.out.println(lastName+"  is not verified test==FAIL");
			
			String actaulLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
			if(actaulLastName.equals(lastName)) 
				System.out.println(lastName+"is verified test==PASS");
			else
				System.out.println(lastName+"is verified test==FAIL");

	}

}
