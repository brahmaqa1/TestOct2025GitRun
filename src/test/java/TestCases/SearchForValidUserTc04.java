package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AllPages.HomePage;
import AllPages.LoginPage;
import AllPages.SystemUsersPage;
import Utilities.WebUtilites;

public class SearchForValidUserTc04 {

	@Test
	public void searchForValidUserTc04() throws InterruptedException
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


		//************************************************
		// Search with valid user		
		// EnterValueInUserName

		String user=  "FMLName";
		SystemUsersPage spage =  new SystemUsersPage(driver);
		spage.EnterValueInUserName(user);

		/// click Search button
		spage.ClickSearch();

		// Verify  '(1) Record Found'  msg is displayed
		spage.verify1RecordFoundMsg();
		
		// Verify the user is exist in table -verifyUserExistInTable
		hpage.verifyUserExistInTable(user);

	}

}
