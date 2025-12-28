package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AllPages.LoginPage;
import Utilities.WebUtilites;

public class LoginTC2InvalidUser {

	@Test
	public void loginTC2() throws InterruptedException
	{
		// open chrome browser	
				// create obj -WebUtilites
		WebUtilites util =  new WebUtilites();
		WebDriver driver = util.openBrowser("chrome");
		
				//openUrlInBrowser		
				// open url = https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		util.openUrlInBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

							// Enter user name  = Admin
							// Create loginpage class object
							
			
							// enter_Password -admin123
							
			
			
							// clickLoginBtn'
						
				// or 

				// logintoAppl  pass user, pwd  -> LoginPAge,  HomePage
		LoginPage lpage = new LoginPage(driver);
		lpage.loginToAppl("Admin12345", "admin123");

		// Verify 'Invalid credentials' msg is displayed -> LoginPAge,  HomePage
		lpage.verifyInValidCrednetialsMsg();
		
	}

}
