package Practice_DatadrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	//1.get excel path location & java object of physical file
		FileInputStream fis=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\testScriptdataTP.xlsx");
	
		//2.Open Workbook in read mode
		Workbook wb=WorkbookFactory.create(fis);
		
		//3.get the control of "org" sheet
		Sheet sh=wb.getSheet("org");
		
		
		//4.get the control of the 1st row
		Row r=sh.getRow(1);
		
		
		//5.get the control of the 2nd cell and read the String data of cell
		Cell c=r.getCell(3);
		
		double cellData=c.getNumericCellValue();
		System.out.println(cellData);
		
		//6.close the workbook
		wb.close();
		
		

	}

}
