package Practice_Screeshot;


import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tiger.crm.generic.fileutility.PropertyFileUtility;
import com.tiger.crm.objectreposotory.HomePage;
import com.tiger.crm.objectreposotory.LoginPage;

public class SampleScreenshotTest {

@Test
public void vTigerTest() throws IOException {
	PropertyFileUtility p=new PropertyFileUtility();
	String Browser=p.getDataFromPropertiesFile("browser");
	String URL=p.getDataFromPropertiesFile("url");
	String UN=p.getDataFromPropertiesFile("username");
	String PW=p.getDataFromPropertiesFile("password");
	
	WebDriver driver=new ChromeDriver();
	driver.get(URL);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToapp(UN, PW);
	
	HomePage hp=new HomePage(driver);
	hp.logout(driver);
	
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File("./ScreenshotFolder/test.png");
	FileUtils.copyFile(src, dest);
	
	driver.close();
	
}
}
