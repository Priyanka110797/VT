package PracticeTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tiger.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest_DataProvider {

	@Test(dataProvider = "getData")
	public void getProductInfoTest(String brndName,String productName) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.amazon.in/");
	driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	
	//product info
	String x="";
	String price=driver.findElement(By.xpath(x)).getText();
	System.out.println(price);
	
	}
	
	//==================
	
//	@DataProvider
//	public Object[][] getData(){
//		
//		Object arr[][]=new Object[3][3];
//		arr[0][0]="iphone";
//		arr[0][1]="Apple iPhone 12 (128GB) - Black";
//		
//		
//		arr[1][0]="iphone";
//		arr[1][1]="Apple iPhone 14 Pro (1TB) - Space Black";
//		
//		
//		arr[2][0]="iphone";
//		arr[2][1]="Apple iPhone 14 Pro Max (128GB) - Space Black";
//		
//		return arr;
	
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException{
		ExcelUtility e=new ExcelUtility();
		int rowCount =e.getRowcount("product");
		
		Object arr[][]=new Object[rowCount][2];
		for(int i=0;i<rowCount;i++) {
			arr[i][0]=e.getDataFromExcel("product", i+1, 0);
			arr[i][1]=e.getDataFromExcel("product", i+1, 1);
		}
		return arr;
				
	}
//	}
}
