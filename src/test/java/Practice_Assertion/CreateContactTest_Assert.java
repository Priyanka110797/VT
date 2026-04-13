package Practice_Assertion;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import com.tiger.crm.generic.fileutility.ExcelUtility;
import com.tiger.crm.generic.fileutility.PropertyFileUtility;
import com.tiger.crm.objectreposotory.HomePage;

import junit.framework.Assert;

public class CreateContactTest_Assert {

	public static void main(String[] args) throws IOException {
		//Read data from property file
		
		PropertyFileUtility p=new PropertyFileUtility();
		
		String Browser=p.getDataFromPropertiesFile("browser");
		String URL=p.getDataFromPropertiesFile("url");
		String UN=p.getDataFromPropertiesFile("username");
		String PW=p.getDataFromPropertiesFile("password");
//		
			
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
//			
			
			ExcelUtility e=new ExcelUtility();
			Random random=new Random();
			int randomInt=random.nextInt(1000);
//			String lastName=r.getCell(2).getStringCellValue()+randomInt;
//			wb.close();
			String lastName=e.getDataFromExcel("contact", 1, 2)+randomInt;
			
			
			//Contact Name Textfield
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			
			//click on Save button
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			
			//Check Page Header Information == Expected result
			String actualheader=driver.findElement(By.xpath("//span[contains(@class,'dvHeaderText')]")).getText();
			boolean headerStatus=actualheader.contains(lastName);
			Assert.assertEquals(headerStatus,true);
			
			//Verify Header orgName info ==Expected result
			String actualLastName=driver.findElement(By.id("dtlview_Last Name")).getText();
			System.out.println(actualLastName);
			SoftAssert sa=new SoftAssert();
			sa.assertEquals(actualLastName, lastName);
			
			
			HomePage hp=new HomePage(driver);
			hp.logout(driver);
			
			
			

	}

}
