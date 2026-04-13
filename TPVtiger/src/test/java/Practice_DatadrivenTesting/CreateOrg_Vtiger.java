package Practice_DatadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrg_Vtiger {

	public static void main(String[] args) throws IOException, ParseException {
		
		
//========================READ DATA FROM PROPERTY FILE===============================
//		FileInputStream fis=new FileInputStream("\\Users\\priya\\OneDrive\\Desktop\\commondata.properties");
//		Properties p=new Properties();
//		p.load(fis);
//		
//		String Browser=p.getProperty("browser");
//		String URL=p.getProperty("url");
//		String UN=p.getProperty("username");
//		String PW=p.getProperty("password");
//		String orgName=p.getProperty("organization");
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("Enter the browser");
//		String browser=sc.next();
//		
		
		//excel
	//===============READ DATA FROM JSON FILE=======================================
		
		JSONParser parser =new JSONParser();
		Object obj=parser.parse("C:\\Users\\priya\\OneDrive\\Desktop\\appCommonData.json");
		JSONObject map=(JSONObject)obj;
		 String URL=map.get("url").toString();
		 String Browser=map.get("browser").toString();
		 String UN=map.get("username").toString();
		 String PW=map.get("password").toString();
		 
		WebDriver driver=null;
		if(Browser.equals("chrome"))
			driver=new ChromeDriver();
		
		else if(Browser.equals("edge"))
			driver=new EdgeDriver();
		else if(Browser.equals("firefox"))
			driver=new FirefoxDriver();
		else
			driver=new ChromeDriver();
		
		//1.Login
		//launching the browser
		driver.get(URL);
		//username textfield
		driver.findElement(By.name("user_name")).sendKeys(UN);
		//password textfield
		driver.findElement(By.name("user_password")).sendKeys(PW);
		//click on login button
		driver.findElement(By.id("submitButton")).submit();
		
		
		//2.navigate to Organization module
		driver.findElement(By.linkText("Organizations")).click();
		
		//3.click on create organization Button
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//4.enter all the details & create new organization
		//driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.name("button")).click();
		
		//5.verify organization name in header of the msg
		String orgTitle=driver.getTitle();
		String ExpectedOrgTitle="Organization Information";
		if(orgTitle.equals(ExpectedOrgTitle)) {
			System.out.println("New Organization created ");
		}
		else
			System.out.println("Not Validated");
		
		//6.logout
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();

	}

}
