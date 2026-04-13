package practice.pom.repository;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tiger.crm.generic.fileutility.ExcelUtility;
import com.tiger.crm.generic.fileutility.PropertyFileUtility;
import com.tiger.crm.generic.webdriverutility.JavaUtility;
import com.tiger.crm.objectreposotory.CreatingNewOrganizationPage;
import com.tiger.crm.objectreposotory.HomePage;
import com.tiger.crm.objectreposotory.LoginPage;
import com.tiger.crm.objectreposotory.OrganizationInfoPage;
import com.tiger.crm.objectreposotory.OrganizationPage;

public class CreateOrganizationTest {
public static void main(String[] args) throws IOException {
	

	//Read data from property file
	PropertyFileUtility p=new PropertyFileUtility();
	
	String Browser=p.getDataFromPropertiesFile("browser");
	String URL=p.getDataFromPropertiesFile("url");
	String UN=p.getDataFromPropertiesFile("username");
	String PW=p.getDataFromPropertiesFile("password");
//	
		
		WebDriver driver=new ChromeDriver();
	//Step:1 login to app
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(URL);
	
	
	//read data from excel file
	JavaUtility j=new JavaUtility();
	int random=j.getRandomNumber();
	ExcelUtility e=new ExcelUtility();
	String orgName=e.getDataFromExcel("org", 10, 2)+random;
	String industry=e.getDataFromExcel("org", 4, 3);
	
	//LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
	
//	lp.getUsername().sendKeys("admin");
//	lp.getPassword().sendKeys("admin");
//	lp.getLoginbtn().click();
	
	LoginPage lp=new LoginPage(driver);
	lp.loginToapp(UN, PW);
	
	
	
	
	//Step2:navigate to organisation module
	
	HomePage hp=new HomePage(driver);
	hp.getOrgLink().click();
	
	//Step3:click on "create organization" button
	OrganizationPage op=new OrganizationPage(driver);
	op.getCreateNewOrgBtn().click();
	//Step4:enter all the details & create new organization
	CreatingNewOrganizationPage cp=new CreatingNewOrganizationPage(driver);
	cp.createOrg(orgName,industry);
	//verify header msg expected result
	OrganizationInfoPage oip=new OrganizationInfoPage(driver);
	String actualOrgName=oip.getHeaderMsg().getText();
	
	if(actualOrgName.contains(orgName))
		System.out.println(orgName+"  is verified ==PASS");
	else
		System.out.println(orgName+"  is not verified == FAIL");
	
	
	//hp.logout();
	//Step5:logout
	driver.close();
	
	
	
	
	
	
	
	
	
	
}	
	
	
}
