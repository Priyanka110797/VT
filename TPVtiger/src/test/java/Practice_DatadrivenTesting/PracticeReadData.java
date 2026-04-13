package Practice_DatadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class PracticeReadData {

	//public static void main(String[] args) throws ParseException, FileNotFoundException, IOException {
	
//==============READ COMMON DATA FROM JSON FILE================================
//		JSONParser parser=new JSONParser();
//		//Object obj=parser.parse(new FileReader("‪C:\\Users\\priya\\OneDrive\\Desktop\\appCommonData.json"));
//		Object obj=parser.parse(new FileReader("C:\\Users\\priya\\OneDrive\\Desktop\\appCommonData.json"));
//		JSONObject map=(JSONObject)obj;
//		
//		String Browser=map.get("browser").toString();
//		String URL=map.get("url").toString();
//		String UN=map.get("username").toString();
//		String PW=map.get("password").toString();
		
//==========READ COMMON DATA FROM XML FILE============================
		@Test
		public void createOrg(XmlTest test) throws EncryptedDocumentException, IOException {
			
		String URL=test.getParameter("url");
		String Browser=test.getParameter("browser");
		String UN=test.getParameter("username");
		String PW=test.getParameter("password");
	
	
	//==============READ COMMON DATA FROM CMD LINE================================================
	//@Test
//	public void createOrg() throws EncryptedDocumentException, IOException {
//		String Browser=System.getProperty("browser");
//		String URL=System.getProperty("url");
//		String UN=System.getProperty("username");
//		String PW=System.getProperty("password");
//		System.out.println(Browser+" "+URL+" "+UN+" "+PW);
		
		
		//Browser Launching Code================================================
		WebDriver driver;
		
		if(Browser=="Chrome") 
		driver=new ChromeDriver();
		else if(Browser =="firefox")
			driver=new FirefoxDriver();
		else if(Browser == "edge")
			driver=new EdgeDriver();
		else
			driver=new ChromeDriver();
		
		//login operation of Vtiger application
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).submit();
		
		//click on organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		
		//=================READ TEST SCRIPT DATA FROM EXCEL FILE====================================
		FileInputStream fis=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\testScriptdataTP.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("org");
		Row r=sh.getRow(1);
		
		//to get random data in organization name textfield
		Random random=new Random();
		int randomInt = random.nextInt(1000);
		String orgName=r.getCell(2).toString()+randomInt;
		
		//Organization >>Name textfield
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		//click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		//logout operation
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		WebElement signOut=driver.findElement(By.linkText("Sign Out"));
//		act.click(signOut);
		
		driver.close();
	}

}
