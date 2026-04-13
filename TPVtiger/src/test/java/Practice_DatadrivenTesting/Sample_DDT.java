package Practice_DatadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sample_DDT {

	public static void main(String[] args) throws IOException, InterruptedException {
	//Step 1:get the java representation object of physical file
		FileInputStream fis=new FileInputStream("\\Users\\priya\\OneDrive\\Desktop\\commondata.properties");
		
	//Step 2:usig Properties class load all keys
		Properties p=new Properties();
		p.load(fis);
	//Step 3: get the value based on key
		System.out.println(p.getProperty("browser"));//o/p>>>firefox
       //System.out.println(p.getProperty("Browser"));//o/p>>>>null
		String Browser=p.getProperty("browser");
		String URL=p.getProperty("url");
		String UN=p.getProperty("username");
		String PW=p.getProperty("password");
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(UN);
		driver.findElement(By.name("user_password")).sendKeys(PW);
		driver.findElement(By.id("submitButton")).submit();
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).click().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		WebElement signOut=driver.findElement(By.linkText("Sign Out"));
//		act.click(signOut);
		
	}

}
