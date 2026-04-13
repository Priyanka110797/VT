package Practice_DatadrivenTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectandVerifyDBwithGUI {

	public static void main(String[] args) throws SQLException {
     //create Project in GUI
		String projectName="Instagram_1";
		
		final Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("credentials_enable_service", false);
		chromePrefs.put("profile.password_manager_enabled", false);
		chromePrefs.put("profile.password_manager_leak_detection", false); // <======== This is the important one

		final ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		WebDriver driver=new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		
		driver.get("http://49.249.28.218:8091/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.linkText("Projects")).click();
		
	
		
		
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.name("projectName")).sendKeys(projectName);
		driver.findElement(By.name("createdBy")).sendKeys("Ram");
		
		
		WebElement selectd=driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sel=new Select(selectd);
		
		sel.selectByIndex(1);
//		
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
//		//verify the project in Backend(Database) using JDBC
		boolean flag=false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection conn=DriverManager.getConnection("jdbc:mysql://49.249.28.218:3307/ninza_hrm","root@%","root");
		Statement stat=conn.createStatement();
		ResultSet result= stat.executeQuery("select * from project");
		
		while(result.next()) {
			String actualProjectName=result.getString(4);
			if(actualProjectName.equals(projectName)) {
				flag=true;
				System.out.println(projectName+"  is available DB==PASS");
			}
		}
		
		if(flag==false) {
			System.out.println(projectName+"  is not available DB==FAIL");
		}
		
		conn.close();

	}

}
