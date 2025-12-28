package ExcelReaderBasics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcelByXssfworkbook {

	public static void main(String[] args) throws IOException {
		

		String xlFile = ".\\TestData.xlsx";
		

		FileInputStream  fis = new FileInputStream(xlFile);
		// create obj for -XSSFWorkbook class HSSFworkbook
		
		XSSFWorkbook wb  = new XSSFWorkbook(fis);
		// Refer sheet
		XSSFSheet sh =  wb.getSheet("Sheet1");
		
		// read data from row no, cell no = 0,0 
		String data00 = sh.getRow(0).getCell(0).toString();
		
		System.out.println("data00="+ data00);
		// data00=ProductName
		
		// HW read data from  row no, cell no = 0,1
		
		
		// HW read data from  row no, cell no = 0,2
		
		
		// HW read data from  row no, cell no =1,0
		
//		HW read data from  row no, cell no =1,1


//HW  Get Rows count

//HW  Get columns Cnt 


	}

}
