package TestCases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AllPages.HomePage;
import AllPages.LoginPage;
import Utilities.ExcelUtilities;
import Utilities.WebUtilites;

public class CreateMultipleUserTC6 {

	@Test
	public void createMultipleUserTC6() throws InterruptedException, EncryptedDocumentException, IOException
	{	
		// open chrome browser	
		// create obj -WebUtilites
		WebUtilites util = new WebUtilites();
		WebDriver driver =   util.openBrowser("chrome");
		//openUrlInBrowser		
		// open url = https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		util.openUrlInBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// 	loginToAppl
		// Create loginpage class object
		LoginPage lpage =  new LoginPage(driver);

		lpage.loginToAppl("Admin", "admin123");


		// Verify Home page is displayed or not
		// Create obj for HomePage - class
		HomePage hpage=  new HomePage(driver);	
		hpage.isProfileImageDisplayed();

		//  Navigate to "admin" menu
		hpage.navigateToAdminMenu();

		// Verify System user page is displayed or not
		hpage.verifySystemUserPageDisplayed();


		//*****************
		String xlfile = ".\\TestData.xlsx";
		// read first row data and 

		// read 'UserRole' column data from 'CreateUsers' sheet  and store into ArrayList
			ExcelUtilities xl =  new ExcelUtilities();
			String Sheetname = "CreateUsers";
			
			ArrayList<String> UserRoleList =	xl.readColumnData(xlfile, Sheetname, "UserRole");
			
		System.out.println("UserRoleList="+UserRoleList);

		// 		// read 'EmployeeName' column data from 'CreateUsers' sheet  and store into ArrayList
		ArrayList<String> EmployeeNameList =	xl.readColumnData(xlfile, Sheetname, "EmployeeName");
		System.out.println("EmployeeNameList="+EmployeeNameList);


		// 		// read 'Status' column data from 'CreateUsers' sheet  and store into ArrayList
		ArrayList<String> StatusList =	xl.readColumnData(xlfile, Sheetname, "Status");
		System.out.println("StatusList="+StatusList);

		// 		// read 'Username' column data from 'CreateUsers' sheet  and store into ArrayList
		ArrayList<String> UsernameList =	xl.readColumnData(xlfile, Sheetname, "Username");


		// 		// read 'Password' column data from 'CreateUsers' sheet  and store into ArrayList
		ArrayList<String> PasswordList =	xl.readColumnData(xlfile, Sheetname, "Password");


		// 		// read 'ConfirmPassword' column data from 'CreateUsers' sheet  and store into ArrayList
		ArrayList<String> ConfirmPasswordList =	xl.readColumnData(xlfile, Sheetname, "ConfirmPassword");
			
		
			// create multiple users
//			hpage.createNewUser("Admin","orange","Enabled","sita","sita","sita");
			
			for(int i=0;i<=UserRoleList.size()-1;i++) {
				
				hpage.clickAddBtn();
				
				String userRole=  UserRoleList.get(i);				
				String empName=  EmployeeNameList.get(i);
				String status=  StatusList.get(i);
				
				String userName=  UsernameList.get(i);
				String password=  PasswordList.get(i);
				String confirmPwd=  ConfirmPasswordList.get(i);
				
				hpage.createNewUser(userRole,empName,status,userName,password);
				
				hpage.verifyUserExistInTable(userName);			
				
			}
			
			
			
		
		

		

	}

}
