package AllPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

	// 1. define elements with locators(name, id, class, xpath, cssSelector, 
	//		linktext, partial linktext
	//		 tagname..)

	// @FindBy is annotation -used to find ele with given loc name = loc value
	// syntax :  @FindBy(locName= "Loc value")

	// Define "userNameTxtbox" with name 	
	@FindBy(name="username")
	public WebElement userNameTxtbox;//  def valu  == null

	//Define "pwdTxtbox" using name
	@FindBy(name="password")
	public WebElement pwdTxtbox;

	//Define "loginBtn" using xpath
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginBtn;

	// HW  Forgot your password?

	//			@FindBy(className = "oxd-text oxd-text--p oxd-alert-content-text")// not working
	//			@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")

	//Define "InvalidcredentialsTxtMsg"
//	@FindBy(className = "oxd-text oxd-text--p oxd-alert-content-text")
	@FindBy(xpath =  "//p[text()='Invalid credentials']")
	public WebElement InvalidcredentialsTxtMsg;


	// 2. We have to define "constructor"  and initialise all elements  and pass driver ref var
	// Define LoginPage constructir and pass driver 
	public LoginPage(WebDriver driver)			// 1 PC
	{
		//// initialise all elements -driver, this
		PageFactory.initElements(driver, this);
		// can be used to initalise all elements with locators of current class
	}




	//3. define reusable method and utilise all defined elements
	// for each step , We will define seperate method 

	// Enter user name in "user name" text box -enterUserName
	// Define enterUserName
	public void enterUserName(String user) throws InterruptedException
	{
		System.out.println("enterUserName= "+ user);		
		Thread.sleep(3000);
		userNameTxtbox.sendKeys(user);// Send data -

		// null *  ---> NPE		
	}

	// Enter "pwd" in "pwd" text box --> enterPassword
	// Define enterPassword
	public void enterPassword(String pwd) throws InterruptedException
	{

		System.out.println("Enter pwd="+pwd);
		Thread.sleep(3000);
		// send data to pwdTxtbox
		pwdTxtbox.sendKeys(pwd);
	}	

	// Click "login" btn
	// Define clickLoginBtn
	public void clickLoginBtn() throws InterruptedException
	{

		System.out.println("Click Login button");
		Thread.sleep(3000);
		// click loginBtn
		loginBtn.click();
	}

	// Define loginToAppl() and pass username, pwd
	public void loginToAppl(String user, String pwd) throws InterruptedException
	{

		// Call enterUserName
		enterUserName(user);

		// call enterPassword
		enterPassword(pwd);

		// call clickLoginBtn();
		clickLoginBtn();
	}

	//// Verify 'Invalid credentials' msg is displayed
	// Define verifyInValidCrednetialsMsg()
	public void verifyInValidCrednetialsMsg()
	{

		// check InvalidcredentialsTxtMsg is displayed			
		if(InvalidcredentialsTxtMsg.isDisplayed())
		{
			System.out.println("Pass.'Invalid credentials' msg is displayed");
		}
		else					
		{
			System.out.println("Fail.'Invalid credentials' msg is not displayed");
			Assert.assertTrue(false,"Fail.'Invalid credentials' msg is not displayed");		
		}
	}

}
