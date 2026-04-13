package Practice_DatadrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataBackToExceltest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fis=new FileInputStream("C:\\Users\\priya\\OneDrive\\Desktop\\testScriptdataTP.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet("org");
		Row r=sh.getRow(1);
		Cell c=r.createCell(4);
		c.setCellType(CellType.STRING);
		c.setCellValue("PASS");
		
		//write mode
		FileOutputStream fos=new FileOutputStream("C:\\Users\\priya\\OneDrive\\Desktop\\testScriptdataTP.xlsx");
		//saving the excel file after writing data
		wb.write(fos);
		wb.close();
		System.out.println("Exceuted");

	}

}
