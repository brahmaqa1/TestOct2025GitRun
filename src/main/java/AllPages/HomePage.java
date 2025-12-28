package AllPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage 
{


	WebDriver driver;//  defaul val = null
	// int a; 0

	// 1. Define all elements with locators  using @Findby annot

	// Define "profileImg" with className 
	@FindBy(className = "oxd-userdropdown-img")
	public WebElement profileImg;
	
	//// Define "adminMenu" xpath
	@FindBy(xpath = "//span[text()='Admin']")
	public WebElement adminMenu;


//	@FindBy(xpath = "//span[text()='Admin']")
//	public WebElement adminMenu1;
	
	// Define "pimMenu";


	// system user page  -"systemUserTxt";  using xpath
	@FindBy(xpath = "//h5[text()='System Users']")
	public WebElement systemUserTxt;


	//Define		addBtn;	 classname,xpath -//button[text()=' Add ']
	@FindBy(xpath = "//button[text()=' Add ']")
	public WebElement addBtn;

	
	// clikAddBt //butt   oxd-button oxd-button--medium oxd-button--secondary']
	
	//Define addUserTxt using xpath //h6[text()='Add User']
	@FindBy(xpath = "//h6[text()='Add User']")
	public WebElement addUserTxt;

	//Define  userRoleDropdown; using xpath //label[text()='User Role']/parent::div/following-sibling::div
	@FindBy(xpath = "//label[text()='User Role']/parent::div/following-sibling::div")
	public WebElement userRoleDropdown;

	
	//adminValInuserRoleDropdown; usin xpath= //div[@role='listbox']//*[text()='Admin']
	@FindBy(xpath = "//div[@role='listbox']//*[text()='Admin']")
	public WebElement adminValInuserRoleDropdown;


	//Exception in thread "main" org.openqa.selenium.InvalidSelectorException: invalid selector: Unable to locate an element with the xpath expression //label[text()='User Role']/parent::div/following-sibling::div/following-sibling::div[@role='listbox']']//*[text()='Admin'] because of the following error:
	//		SyntaxError: Failed to execute 'evaluate' on 'Document': The string '//label[text()='User Role']/parent::div/following-sibling::div/following-sibling::div[@role='listbox']']//*[text()='Admin']' is not a valid XPath expression.
	//				  (Session info: chrome=114.0.5735.199)
	// note: when we give invalid xpath, it throws 'InvalidSelectorException'

	//Define employeeNameTxtboxEle xpath -//label[text()='Employee Name']/../following-sibling::div//input
	@FindBy(xpath = "//label[text()='Employee Name']/../following-sibling::div//input")
	public WebElement employeeNameTxtboxEle;
	
	
	// Define valuesinEmployeeName  -//*[text()='vin eetha Dan']
//	@FindBy(xpath = "//*[text()='manda']")
	@FindBy(xpath = "//*[contains(text(),'manda')]")
	public WebElement valuesinEmployeeName;
		

	//Define statusArrowBtn-//label[text()='Status']/parent::div/following-sibling::div
	@FindBy(xpath = "//label[text()='Status']/parent::div/following-sibling::div")
	public WebElement statusArrowBtn;

	
	// Status dropdown values 
	@FindBy(xpath = "//*[text()='Enabled']")
	public WebElement statusdropdownValEle;

	//Define UsernameTxtbox -//label[text()='Username']/parent::div/following-sibling::div/input
	@FindBy(xpath = "//label[text()='Username']/parent::div/following-sibling::div/input")
	public WebElement UsernameTxtbox;

	//Define PasswordTxtbox;//label[text()='Password']/parent::div/following-sibling::div/input
	@FindBy(xpath = "//label[text()='Password']/parent::div/following-sibling::div/input")
	public WebElement PasswordTxtbox;
	
	//Define ConfirmPasswordTxtbox; //label[text()='Confirm Password']/parent::div/following-sibling::div/input
	
	@FindBy(xpath = "//label[text()='Confirm Password']/parent::div/following-sibling::div/input")
	public WebElement ConfirmPasswordTxtbox;

	//Define saveBtn //button[@type='submit']
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement saveBtn;
	
	//searchBtn;



	//**************************

	// 2. We have to define constructor  and initialise all elements 
	// 
	public HomePage(WebDriver driver)
	{
		//// initialise all elements -driver, this
			PageFactory.initElements(driver, this);
		// can be used to initalise all elements with locators of current class		
			this.driver = driver;
			// curretn class driver = null 
			//             actuctal driver ref var 
	}
	


	//3. utilise all elements in reusable methods
	// // check the "profile image" is displayed in home page
	//	if Profile image is displayed- display -Login is succesfull
	//	else - Login is not succesfull
	// Define isProfileImageDisplayed()
	 public void isProfileImageDisplayed()
	 {
		 try
		 {
			  boolean  profileImgDisplayed =  profileImg.isDisplayed();
		         if(profileImgDisplayed == true)
		         {
		        	 System.out.println("Login is succesfull");
		         }
		         else
		         {
		        	 System.out.println("Login is not succesfull");
		         }
		 }
		 catch (NoSuchElementException e) {
			 
			System.out.println("NoSuchElementException. Unable to find Profile image. check locator changed");
			System.out.println("Login is not succesfull");
			Assert.assertTrue(false, "Login is not succesfull");
		}
	     
	 }


	// Navigate to diff menu options
	// Navigate to Admin menu -navigateToAdminMenu
	public void navigateToAdminMenu()
	{
	
		System.out.println("Click Admin menu");
		// click adminMenu
		adminMenu.click();
	}
	

	// navigateToPIMMenu


	// Define verifySystemUserPageDisplayed
	 public void verifySystemUserPageDisplayed()
	 {
		// check systemUserTxt is displayed 
		if(systemUserTxt.isDisplayed())
		{
		
			System.out.println(" System Users page is displayed");
		}
		else
		{
			System.out.println(" System Users page is not displayed");
		}
	 }


	//Define clickAddBtn
	 public void clickAddBtn()
	 {
		System.out.println("Click add button");
		addBtn.click();
	 }

	//Define verifyAddUserpageDisplayed
	 public void verifyAddUserpageDisplayed()
	 {
		// check -addUserTxt is displayed
		if(addUserTxt.isDisplayed())
		{
		
			System.out.println("Add user page is displayed");
		}
		else
		{
			System.out.println("Add user page is not displayed");
		}		
	 }


	// 	selectUserRole("Admin")
	// selectUserRole("ESS")
	// Define selectUserRole
	public void selectUserRole(String role) throws InterruptedException
	{
		System.out.println("Click user role dropodown");
		userRoleDropdown.click();
		
		Thread.sleep(3000);
		System.out.println("click'" +role+"'  value in user role dropdown");
		//adminValInuserRoleDropdown.click();
//		adminValInuserRoleDropdown.click();
		// click given role 
		System.out.println("driver=" + driver);
		driver.findElement(By.xpath("//div[@role='listbox']//*[text()='" +role+ "']")).click();
		// null * any method --> java.lang.NullPointerException: 
	}
	//Exception in thread "main" org.openqa.selenium.support.ui.UnexpectedTagNameException: Element should have been "select" but was "div"
	//Build info: version: '3.141.59', revision: 'e82be7d358', time: '2018-11-14T08:17:03'



	// type some employee name(Orange test) - in "Employee Name" txt box
	// Define typeEmployeeName -pass empName
	public void typeEmployeeName(String empName) throws InterruptedException
	{

		System.out.println("Enter emp name="+ empName);
	    employeeNameTxtboxEle.sendKeys(empName);
		Thread.sleep(5000);
		try {
			// click givne emp name //*[text()='Orange  Test']
//			valuesinEmployeeName.click();
			
			String myxpath = "//*[contains(text(),'"+ empName +"')]";
			System.out.println("myxpath="+myxpath);
			List<WebElement> all = driver.findElements(By.xpath(myxpath));
			
			// click 2nd ele
			System.out.println("Count of empname="+ all.size());
			if(all.size()==2)
			{
				
				all.get(1).click();
			}
			else
			{
				//
				System.out.println("Unable to find the emp name="+empName);
			}
			
			
			
////			List<WebElement> all = driver.findElements(By.xpath("//*[contains(text(),'suresh')]"));
//			List<WebElement> all = driver.findElements(By.xpath("//*[contains(text(),'"+empName+"')]"));
//			System.out.println("count ="+  all.size());	
//			if(all.size()>=2)
//			{
//				System.out.println("Employee name found="+ empName);
//				all.get(1).click();
//			}
//			else
//			{
//				Assert.assertTrue(false,"Please check test data .Unable to find employee name="+empName );
//			}					
			
		} catch (NoSuchElementException e) {
			System.out.println("Unable to find employee name="+empName );
		}
	
	
	
	
	}	



	// Select some status =Enabled
	//			selectStatus("Enabled")
	//			selectStatus("Disabled");
	// Define selectStatus -status
	public void selectStatus(String status)
	{

		// click statusArrowBtn
		statusArrowBtn.click();

		System.out.println("Select status="+ status);
		//clikc given status
		statusdropdownValEle.click();
	}


	// Type some value in "user name" text box 
	// Define -enterUserName -user
	public void enterUserName(String user)
	{

		System.out.println("enterUserName="+user);
		UsernameTxtbox.sendKeys(user);
	}


	// Type some value in "password"  text box
	//Define			EnterValueInPassword("Test@123321")
	public void EnterValueInPassword(String pwd)
	{

		System.out.println("EnterValueInPassword="+pwd);
		PasswordTxtbox.sendKeys(pwd);
	}	



	//// Type some value in "Confirm password"  text box
	//Define EnterValueInConfirmPassword("Test@123321")
	public void EnterValueInConfirmPassword(String confirmPwd)
	{
	
		System.out.println("Enter confirmPwd="+confirmPwd);
		ConfirmPasswordTxtbox.sendKeys(confirmPwd);
		
	}
	// click on "Save" button
	// Define clickSaveBtn
	public void clickSaveBtn()
	{
		System.out.println("Click Save button");
		saveBtn.click();
	}	
	

	// Verify user name is exist in table or not verifyUserExistInTable(String user)
	//Define  verifyUserExistInTable("RajaRam")
	public void verifyUserExistInTable(String user)
	{
	//div[@class='oxd-table-body']//div[text()='rajaram1']
	////div[@class='oxd-table-body']/div/div[@role='row']/div[2]/div[text()='sita']
	  boolean textDisplayed = driver.findElement(By.xpath("//div[@class='oxd-table-body']/div/div[@role='row']/div[2]/div[text()='" +user +"']")).isDisplayed();
	
	  if(textDisplayed)
	  {
		  System.out.println("Pass.Given user="+ user + " is exist in table");
	  }		
	  else
	  {
			System.out.println("Fail.Given user="+ user + " is  not exist in table");
	  }
	}


		// creaateNewUser()
	// createNewUser("Admin","Vin_test_1 Dan_test_1","Enabled","Ramarao","Admin123");
	
	///Define createNewUser(String UserRole, String EmployeeName,String Status,String Username, String Password) throws InterruptedException
	public void createNewUser(String UserRole, String EmployeeName,String Status,String Username, String Password) throws InterruptedException
	{
		//Select some value (Admin) in User Role dropdown
			selectUserRole(UserRole);
				// or selectUserRole-ESS  -->  
				// working

				// type some employee name(Orange  Test) - in "Employee Name" txt box
			typeEmployeeName(EmployeeName);
				
				// Select some status =Enabled
				selectStatus(Status);

				// Type some value in 'user name' text box 
			enterUserName(Username);				


				// Type some value in 'password'  text box
//				String pwd = "Admin123";				
				EnterValueInPassword(Password);

				//// Type some value in 'Confirm password'  text box
				EnterValueInConfirmPassword(Password);

				Thread.sleep(3000);

				// click on Save button
				clickSaveBtn();
	}

				// Verify  new user name is exist in table or not--> verifyUserExistInTable
//					System.out.println("Pass.Given user="+ user + " is exist in table");

//					System.out.println("Fail.Given user="+ user + " is exist in table");



			//searchForGivenUser
		
		
		// define 	searchForInvalidUser()  and pass user
			
		// Enter user in UsernameTxtbox
					
//					
//					// click Search button			
			
					
			// check isNoRecordMsgDisplayed





}
