package TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import AllPages.HomePage;
import AllPages.LoginPage;
import AllPages.SystemUsersPage;
import Utilities.WebUtilites;

public class DeleteUserTC5 {

	@Test
	public void deleteUserTC5() throws InterruptedException
	{
		 
		// open browser		
				// open url in browser
				WebUtilites wutil = new WebUtilites();
				WebDriver driver = wutil.openBrowser("chrome");
				wutil.openUrlInBrowser("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");				

				// 	loginToAppl
				// logintoAppl  pass user, pwd
				LoginPage lpage = new LoginPage(driver);
				lpage.loginToAppl("Admin", "admin123");//	

				// Verify Home page is displayed or not
				// Create obj for HomePage - class
				HomePage hPage = new HomePage(driver);
				hPage.isProfileImageDisplayed();


				//  Navigate to admin menu
				hPage.navigateToAdminMenu();

				// Verify System user page is displayed or not
				hPage.verifySystemUserPageDisplayed();

				//*******************************************************************
				//		// Delete the given user - by selecting Checkbox For GivenUser
				String username= "atester6";// 
				SystemUsersPage spage = new SystemUsersPage(driver);
				spage.selectCheckboxForGivenUser(username);
			
				// Click "delete image" icon
				spage.clickDeleteImageForUser(username);

			
				// Verify the msg -"The selected record will be permanently deleted. Are you sure you want to continue?"
				spage.verifyDeleteRecordMsgDisplayed();	
				
				//// Click "Yes" Delete button
				spage.clickYesDeleteBtn();
				
							
				//	HW// Verify given user name  should not be available in table  (or) No records found
					// searchForInvalidUser





			}


}
