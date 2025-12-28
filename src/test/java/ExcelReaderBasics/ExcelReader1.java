package ExcelReaderBasics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class ExcelReader1 {

	public static void main(String[] args) throws  IOException  {
		// TODO Auto-generated method stub
		//  Apache POI:

		String xlFile = ".\\TestData.xlsx";

		//create FileInputStream   class object
		FileInputStream fis  = new FileInputStream(xlFile);

		//create workbook reference var
		
		// Workbook - Predefined Interface in POI
         Workbook wb =  WorkbookFactory.create(fis);

		//create Sheet reference var  and refer Sheet1
		Sheet sh =  wb.getSheet("Sheet1");

		// sheet contains rows and cells
		// Rows count 
		int  rowscnt = sh.getLastRowNum();
		System.out.println("rowscnt=" + rowscnt);

		// rowscnt=3  But actual = 4 rows  - 0,1,2,3 
		
		// Get columns count
		//			sh.getLastCellNum();

		int colsCnt = sh.getRow(0).getLastCellNum();
		
		System.out.println("colsCnt="+colsCnt);

		// columnsCnt=3  --  displays exact columns count

		// Read data from row, cell -  0,0 .toString(); ProductName
		 String data00 = sh.getRow(0).getCell(0).toString();
		
		System.out.println("data00="+data00);
		

		// Read data from row, cell -  0,1 --Qty
		String data01 =sh.getRow(0).getCell(1).toString();
		
		System.out.println("data01="+ data01);

		// HW Read data from 0,2 - Price

		//HW  Read data from 1,0  -Lux
	

		// Read data from 1,1	  - 4	
		String data11 =  sh.getRow(1).getCell(1).toString();
		System.out.println("data11="+data11);// data11=4.0  ??? data11=4
		//  Note:   add ' single quote before number in excel file 
		//   '4 ==   treat as string  else number
// Apache POI returns numeric cells as double values by default.


		// Read data from 1,2 cell  -200
		String data12 =  sh.getRow(1).getCell(2).toString();
		System.out.println("data12=" + data12);// data12=200



	}

}
