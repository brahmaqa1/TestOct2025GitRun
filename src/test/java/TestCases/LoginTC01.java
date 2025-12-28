package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AllPages.HomePage;
import AllPages.LoginPage;
import Utilities.WebUtilites;

public class LoginTC01 {
	
	@Test
	public void loginTc01() throws InterruptedException
	{
		
		// open chrome browser	
		// create obj -WebUtilites
		   WebUtilites util = new WebUtilites();
		 WebDriver driver =   util.openBrowser("chrome");
		//openUrlInBrowser		
		// open url = https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		   util.openUrlInBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// Enter user name  = Admin
		// Create loginpage class object
		LoginPage lpage =  new LoginPage(driver);
//		lpage.enterUserName("Admin");
//		
//		// enter_Password -admin123
//		lpage.enterPassword("admin123");
//
//
//		// clickLoginBtn'
//		lpage.clickLoginBtn();


		// or 

		// logintoAppl  pass user, pwd
		lpage.loginToAppl("Admin", "admin123");

		// Verify home page is displayed --isProfileImageDisplayed

		// Verify Profile Image is displayed or not
		// Create obj for HomePage - class
		HomePage hpage =  new HomePage(driver);
		
		hpage.isProfileImageDisplayed();
		
	}


}
