package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {

	// contains all generic method
			// rows cnt
			// col cnt
			// read data from 0,0
			//                0,1

		
//		HW Develop a method   to get rows count from Excl File ?
		public static int getRowsCnt(String xlFilePath, String sheetName) throws EncryptedDocumentException, IOException
		{
//			String  xlFilePath= "C:\\brahma\\Practise\\SelniumPractiseNew\\Aug2022BatchWorkSpace\\MavenEvngProject\\TestData.xlsx";
			int rowscnt=-1;
			
			FileInputStream fis =  new FileInputStream(xlFilePath);
			Workbook wb =  WorkbookFactory.create(fis);		
			Sheet sh =  wb.getSheet(sheetName);	
			if(sh==null)
			{
				System.out.println("Given sheet name =" +sheetName  + " is not available in Excel File");
			}
			else
			{
				System.out.println("Given sheet name =" +sheetName  + " is  available in Excel File");
			}
			
			try
			{
			//  get all rows cnt 
			 rowscnt= sh.getLastRowNum()+1; // actaul rows cnt =  3 + 1 = 4
			 
			}
			
			catch (Exception e) {
				System.out.println("Sheet name ="+ sheetName +  "is not there in excel file ");
			}
			
			return rowscnt;
		}
		
		
		public static int  getColumnsCnt(String xlFilePath, String sheetName) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis =  new FileInputStream(xlFilePath);
			Workbook wb =  WorkbookFactory.create(fis);		
			Sheet sh =  wb.getSheet(sheetName);	
			
			// egt colsn cnt
			 int colsCnt= sh.getRow(0).getLastCellNum();		
			
			return colsCnt;
		}
		
		public static String readExcel(String xlFilePath,String sheetName, int rowNo, int CellNo) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis =  new FileInputStream(xlFilePath);
			Workbook wb =  WorkbookFactory.create(fis);		
			Sheet sh =  wb.getSheet(sheetName);	
			//  rowno -0  cell no -0 -	
//			           0,0 --->  	1,1  actual
			//         0,1  --->    1,2  
			String data = null;
			try
			{
			 data =sh.getRow(rowNo-1).getCell(CellNo-1).toString(); // Prod name 		
			}
			catch(Exception e)
			{
				
				if(e.toString().contains("getRow(int)"))
				{ //  problem with rowno 
					System.out.println("Plz give valid Row no= " +  rowNo + " in sheet=" + sheetName);
				}
				else
				{
					System.out.println("Plz give valid Cell no or ColumnNo= " +  rowNo + " in sheet=" + sheetName);
				}
				
			}
			return data;
			
		}
		
		// HW 
		public static void readExcel(String xlFilePath,String sheetName, int rowNo, String columnName) throws EncryptedDocumentException, IOException
		{
			
		}
		
//		getColNoBasedColumnName(xlfile, shhetname, "ProductName");// 1 
//		getColNoBasedColumnName(xlfile, shhetname, "Qty");// 2
		
		public static int getColNoBasedColumnName(String xlFilePath,String sheetName, String colName ) throws EncryptedDocumentException, IOException
		{
			FileInputStream fis =  new FileInputStream(xlFilePath);
			Workbook wb =  WorkbookFactory.create(fis);		
			Sheet sh =  wb.getSheet(sheetName);	
			String actualColNameData;
			int colNo=-1;
			int colsCnt= getColumnsCnt(xlFilePath, sheetName);// 5
			
			for(int i=1;i<=colsCnt;i++)//  i=1   i<= 7
			{
				// get all columns names
				   // 1,1    1,2 1,3    .. 1,5
				actualColNameData =readExcel(xlFilePath, sheetName, 1, i);
				//                                            
				//System.out.println("actualColNameData='" +actualColNameData + "',Expected Col='"+colName + "'");
			
				if(colName.trim().equals(actualColNameData.trim()))
				{
					//System.out.println("actualColNameData='" +actualColNameData + "',Expected Col='"+colName + "'");
					System.out.println("Given Column name = "+colName + " is found at Column no ="+i);
					colNo = i;
					return i;
				}
			}	
			System.out.println("Given Column name = "+colName + " is found at Column no ="+colNo);
			return colNo;		
		}
		
		
		public static ArrayList<String> readColumnData(String xlFilePath,String sheetName, int  colNo ) throws EncryptedDocumentException, IOException
		{
			ArrayList<String>  al =  new ArrayList<String>();
			
			FileInputStream fis =  new FileInputStream(xlFilePath);
			Workbook wb =  WorkbookFactory.create(fis);		
			Sheet sh =  wb.getSheet(sheetName);	
			String data ;
			int rowsCnt= getRowsCnt(xlFilePath, sheetName);
			System.out.println("rowsCnt=" +rowsCnt);
			for(int i=1;i<=rowsCnt-1;i++)
			{
				data  = sh.getRow(i).getCell(colNo-1).toString();
				//                0         0 
				System.out.println("data="+ data);
				al.add(data);
			}
			System.out.println("array list =" + al);	
			return al;
		}
		
		
		public static ArrayList<String> readColumnData(String xlFilePath,String sheetName, String  colNname ) throws EncryptedDocumentException, IOException
		{
			ArrayList<String>  al =  new ArrayList<String>();
			
			FileInputStream fis =  new FileInputStream(xlFilePath);
			Workbook wb =  WorkbookFactory.create(fis);		
			Sheet sh =  wb.getSheet(sheetName);	
			String data ;
			int rowsCnt= getRowsCnt(xlFilePath, sheetName);
			System.out.println("rowsCnt=" +rowsCnt);
			
			//  get colno by passingcol name 
			int colNo = getColNoBasedColumnName(xlFilePath, sheetName, colNname);
			System.out.println();
			for(int i=1;i<=rowsCnt-1;i++)
			{     //   1 to 5
				System.out.println("i="+  i + "col =" +  (colNo-1)); //  1,5
				data  = sh.getRow(i).getCell(colNo-1).toString();// 
				//                1       0 
				//     
				System.out.println("data="+ data);
				al.add(data);
			}
			System.out.println("array list =" + al);	
			return al;
		}

}
