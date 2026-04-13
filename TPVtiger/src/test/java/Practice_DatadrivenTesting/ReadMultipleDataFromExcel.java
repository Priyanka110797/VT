package Practice_DatadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\testScriptdataTP.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet("Sheet1");
		
		
		
		//for(int i=1;i<50;i++)
		int rowCount=sh.getLastRowNum();
		for(int i=1;i<=rowCount;i++)
		{
			Row r=sh.getRow(i);
		
		String col1Data=r.getCell(0).toString();
		String col2Data=r.getCell(1).toString();
		
		System.out.println(col1Data+"\t"+col2Data);
		}
		
		wb.close();
	}

}
