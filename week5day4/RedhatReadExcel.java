package week5day4;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class RedhatReadExcel {
	
	@Test
	public void readExcelData() throws IOException {
		
		//Open the Excel book
		XSSFWorkbook book = new XSSFWorkbook("./redhat/RedHat.xlsx");
		
		//To get the sheet by using index
		//Index starts from 0S
		XSSFSheet sheet = book.getSheetAt(0);
		
		//To get the row count
		//Row count starts from 0
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row count is : " + rowCount);
		
		//To get the total column count
		//Column count starts from 1
		int colCount = sheet.getRow(rowCount).getLastCellNum();
		System.out.println("Column count is : " + colCount);
	
		//To print the value "Babu"
		//To get the value, both the index of column and row will start from 0. Hence to print "Babu" we need to give index value as 1 and not 2
		String stringCellValue = sheet.getRow(1).getCell(4).getStringCellValue();
		System.out.println("Cell value is : " + stringCellValue);
		
		String Name = sheet.getRow(1).getCell(0).getStringCellValue();
		String Password = sheet.getRow(1).getCell(1).getStringCellValue();
		String Email = sheet.getRow(1).getCell(2).getStringCellValue();
		String mobNum = sheet.getRow(1).getCell(3).getStringCellValue();
		
			
		System.out.println("Name: "+Name);
		System.out.println("Email: "+Password);
		System.out.println("Address: "+Email);
		System.out.println("City: "+mobNum);		
		
	}

}
