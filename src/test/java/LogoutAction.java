import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.tiger.crm.generic.fileutility.PropertyFileUtility;
import com.tiger.crm.generic.webdriverutility.WebDriverUtility;
import com.tiger.crm.objectreposotory.LoginPage;

public class LogoutAction {
public static void main(String[] args) throws IOException {
	
	PropertyFileUtility p=new PropertyFileUtility();
	String browser=p.getDataFromPropertiesFile("browser");
	String URL=p.getDataFromPropertiesFile("url");
	String UN=p.getDataFromPropertiesFile("username");
	String PW=p.getDataFromPropertiesFile("password");
	WebDriver driver=new ChromeDriver();
	
	WebDriverUtility w=new WebDriverUtility();
	w.waitForPagetoLoad(driver);
	driver.get(URL);
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToapp(UN, PW);
	
//	HomePage hp=new HomePage(driver);
//	hp.logout();
	
	Actions a=new Actions(driver);
	WebElement adminImg=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	a.moveToElement(adminImg);
	driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
}
}
