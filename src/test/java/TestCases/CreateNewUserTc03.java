package TestCases;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AllPages.HomePage;
import AllPages.LoginPage;
import Utilities.WebUtilites;

public class CreateNewUserTc03 {

	@Test
	public void createNewUserTc03() throws InterruptedException
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


		//Click add +   button
		hpage.clickAddBtn();

		// Verify - Add User page is displayed
		hpage.verifyAddUserpageDisplayed();
		///**************************************

		//		//Select some value (Admin) in "User Role" dropdown

//		hpage.selectUserRole("Admin");
		//
		//		// or selectUserRole-ESS  -->  
		//		// working
		//
//		hpage.selectUserRole("ESS");
		
		
		//		// type some employee name(Orange  Test) - in "Employee Name" txt box
		//
		//		//                       Orange  Test
				String empName ="manda";
//		hpage.typeEmployeeName("Orange Test");
//		hpage.typeEmployeeName(empName);
		//		
		//		// Select some status =Enabled
//		hpage.selectStatus("Enabled");
		//
		//		// Type some value in 'user name' text box 
//		hpage.enterUserName("rama5");
		//		//  Ramarao123  ramrao9868
				String user= "SitaRam";
								Random  r = new Random();
								int randomno= r.nextInt(100);	// 0-99
		//						//     50 -0 - 49
					user= user+ randomno;
//					hpage.enterUserName(user);
					
				//
		//		// Type some value in 'password'  text box
				String pwd = "Admin123";
//		hpage.EnterValueInPassword(pwd);

		//		//// Type some value in 'Confirm password'  text box
//				hpage.EnterValueInConfirmPassword(pwd);
		
				Thread.sleep(3000);
		//
		//		// click on Save button
//				hpage.clickSaveBtn();
		//
		//		// Verify  new user name is exist in table or not
		//		hpage.verifyUserExistInTable(user);

		// Define  createNewUser("Admin","Admin Test Test","Enabled","Ramarao","Admin123");		
				hpage.createNewUser("Admin",empName,"ESS",user,pwd);

//				hpage.createNewUser("ESS",empName,"Disabled","Sita","admin@123");

//				hpage.createNewUser("Admin",empName,"Enabled","Rajaram","admin@123");
				
//				// Verify  new user name is exist in table or not
				hpage.verifyUserExistInTable(user);

	}

}
