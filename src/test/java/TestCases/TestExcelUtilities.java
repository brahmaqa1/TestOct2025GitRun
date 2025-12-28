package TestCases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;

import Utilities.ExcelUtilities;

public class TestExcelUtilities {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		String xlFilePath= "C:\\brahma\\Practise\\SelniumPractiseNew\\Nov2023WorkSpace\\MyMavenProjectWitCMD\\src\\test\\Resources\\TestData\\TestData.xlsx";
		
		// getRowsCnt from Sheet1
		//Create obj for ExcelUtilities- class
		ExcelUtilities xlutil = new ExcelUtilities();
		int  rowscnt = xlutil.getRowsCnt(xlFilePath, "Sheet1");
	
		System.out.println("rowscnt-"+rowscnt);
		
//		HW   get rows cnt from 'CreateUsers'
		 
//		System.out.println("rowscnt-");
//		
		//**********************************
		// HW Get Columns cnt from excel file , passing sheet name =sheet1
			

		//HW Get Columns cnt from excel fiel , passing sheet name =CreateUsers
		
		//************************
		
		// Read data from row no 1 .cell no =1 ,   from given xl file and sheet name ?
		String data11= 	xlutil.readExcel(xlFilePath, "Sheet1", 1, 1);
		System.out.println("data11= "+data11);
//		
		//// Read data from row no 1 .cell no =2 ,   from given xl file and sheet name ?
		String data12 = 	xlutil.readExcel(xlFilePath, "Sheet1", 1, 2);
		System.out.println("data12= "+data12);
//		data11= ProductName
//				data12= Qty//		
//		
////	HW 	Read data from 2,1 ,,2,2 		
				
				
		//   Get Column No by passing ColumnNo from given xl file and sheet name 
		// From sheet1, get "ProductName",  -->  column no  1
		int ColNo=  xlutil.getColNoBasedColumnName(xlFilePath, "Sheet1", "ProductName");
		System.out.println("colNo for Productname -column ="+ColNo);
		
		// From sheet1, get  "Qty" -->  column no
		 ColNo=  xlutil.getColNoBasedColumnName(xlFilePath, "Sheet1", "Qty");
		System.out.println("colNo for Qty -column ="+ColNo);
		
		// HW get column no for Price column
		
		// read all column data  by passing column name -Sheet1, ProductName and store into arraylist
		ArrayList<String> ProductNameColumnDataList =  xlutil.readColumnData(xlFilePath, "Sheet1", "ProductName");
		
		System.out.println("ProductNameColumnDataList="+ProductNameColumnDataList);
		
		// read all column data  by passing column name -Qty
		ArrayList<String> QtyColumnDataList =  xlutil.readColumnData(xlFilePath, "Sheet1", "Qty");
		
		System.out.println("QtyColumnDataList="+QtyColumnDataList);
		
		
		//HW read all column data  by passing column no =1 		
		
		
		//HW read all column data  by passing column no =2		


	}


}
