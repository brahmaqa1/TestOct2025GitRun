package Utilities;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebUtilites {


	// This class contains all reusable methods  for browser , textbox, Radio btn, checkbox, Dropdown , MultiSelect dropdown

	/*
	 * Method Name 		: 
	 * Objective		: 
	 * Arguments		: 
	 * Author		: 
	 * Create Date 		: 
	 * Modified Date	: 
	 * Method call		:  
	 * 						
	 * 						
	 * Return type		: 
	 */


	//  ............  etc
	int i ; // 0
	float f; // 0.0
	String name; //  null
	char ch ;  // space
	boolean b ;// false
	//	static WebDriver driver; //   null
	public static WebDriver driver;


	//Browser :   common methods / Generic methods:
	//-------------------------------
	//		 Open chrome, Edge browser      --> openBrowser() --> Defined
	//		 open url in browser		--> openUrlInBrowser("amazon.com") --> Defined
	//		get title					--> getTitleOfBrowser()  --> 
	//		getcurrent url 		        --> HW getCurrentUrl()
	//		close single browser		--> HW
	//		close all browser			--> HW

	//***********************************************************************************************************************
	//					Browser Common/Generic Methods

	//***********************************************************************************************************************
	/*
	 * Method Name 		: openBrowser
	 * Objective		: it opens given browser i.e chrome, edge
	 * Arguments		: String browserName
	 * Author			: Jyothi
	 * Create Date 		: 12-Dec-2025
	 * Modified Date	: NA
	 * Method call		:  openBrowser("chrome")
	 * 						openBrowser("edge")
	 * 						
	 * Return type		: void
	 */


	public static WebDriver openBrowser(String browserName)
	{	//                               chrome  browserName =  chrome

		System.out.println("openBrowser= "+ browserName);
		if(browserName.equals("chrome"))
		{ //  chrome    true 
			//open chrome browser		
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			//			WebDriver  driver = new ChromeDriver();
			driver = new ChromeDriver();
		}
		// open edge browser
		else if (browserName.equals("edge"))
		{

			System.setProperty("webdriver.edge.driver", ".\\Drivers\\msedgedriver.exe")	;
			//		//		//open chrome browser -create obj for "ChromeDriver" class										

			// open edge browser -// create obj for EdgeDriver-class
			//			WebDriver driver =  new EdgeDriver();	
			driver =  new EdgeDriver();
		}
		// -ve 
		else
		{
			System.out.println("invalid browser name ="+ browserName + ". Please check given browser name" );
		}

//		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);//Seleni -3 Version
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));// Sele - 4 version
		
		return driver;
	}


	//***********************************************************************************************************************
	/*
	 * Method Name 		: openUrlInBrowser
	 * Objective		: it opens given url 
	 * Arguments		: String url
	 * Author			: Jyothi
	 * Create Date 		: 12-Dec-2025
	 * Modified Date	: NA
	 * Method call		:  openUrlInBrowser("https://www.amazon.com")
	 * 						
	 * 						
	 * Return type		: void
	 */

	public static void openUrlInBrowser(String url)
	{

		// open url
		//		driver.  define wbdriver var as instance var
		System.out.println("openUrlInBrowser="+ url);
		driver.get(url);
	}


	/*
	 * Method Name 		: getTitleOfBrowser
	 * Objective		: gets title of browser 
	 * Arguments		: NA
	 * Author			: Jyothi 
	 * Create Date 		: 12-Dec-2025
	 * Modified Date	: NA
	 * Method call		: String title =   getTitleOfBrowser();
	 * 						
	 * 						
	 * Return type		: String
	 */
	public static String getTitleOfBrowser()
	{
		String myTitle =  driver.getTitle();

		System.out.println("myTitle="+myTitle);
		return myTitle;
	}


	/*
	 * Method Name 		: 
	 * Objective		: 
	 * Arguments		: 
	 * Author		: 
	 * Create Date 		: 
	 * Modified Date	: 
	 * Method call		:  
	 * 						
	 * 						
	 * Return type		: 
	 */




	//------------------------
	//Textbox  common Methods:
	//---------------------
	//		enter value in text box  --> enterValueInTextBox()  --> Done
	//		get value from text box   --> getValueFromTextBox() -->
	//		delete from text box   -->  HW

	/*
	 * Method Name 		: enterValueInTextBox
	 * Objective		: it enters given value in given xpath element
	 * Arguments		: String myxpath,String data
	 * Author			: Mamatha 
	 * Create Date 		: 12-Dec-2025
	 * Modified Date	: NA
	 * Method call		:  enterValueInTextBox("//input[@name='firstname']", "Raju");
	 * 					    enterValueInTextBox("//input[@name='lastname']", "Yadhava");
	 * 						
	 * Return type		: void
	 */

	public void enterValueInTextBox(String myxpath,String data )
	{
		try {

			//				driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Ramu");
//			driver.findElement(By.xpath(myxpath)).sendKeys(data);
			//			driver.findElement(By.name(myxpath)).sendKeys(data);
			//			driver.findElement(By.id(myxpath)).sendKeys(data);
			//			driver.findElement(By.className(myxpath)).sendKeys(data);			
			//			driver.findElement(By.cssSelector(myxpath)).sendKeys(data);

				getElement(myxpath).sendKeys(data);

		}			
		catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException.Please check locator ="+ myxpath);
		}

	}


	//	getElement("firstname_name");
	//	getElement("idfirst_id");
	//getElement("idfirst_class");

	public static WebElement getElement(String locator)
	{  //                          firstname_name  i.e locator =firstname_name
		//                                                   idfirst_cssSelector
		//                        firstname_cssselectorr
		
		String [] sarr =  locator.split("_");
		// sarr[0]  firstname -loca val
		// sarr[1] -name   -loc name
		
		String locValue = sarr[0];
		
		WebElement ele = null;
		if(locator.contains("_name"))
		{
			 ele = driver.findElement(By.name(locValue));
			 //                              //firstname_name
			 //                                   firstname
		}
		else if(locator.contains("_id"))
		{
			 ele = driver.findElement(By.id(locValue));
			 //                               idfirst
		}
		else if(locator.contains("_class"))
		{
			 ele = driver.findElement(By.className(locValue));	
		}

		else if(locator.contains("_xpath"))
		{
			 ele = driver.findElement(By.xpath(locValue));	
		}

		else if(locator.contains("_css"))
		{
			 ele = driver.findElement(By.cssSelector(locValue));	
		}
		else
		{
			//  if no locator is matching

			System.out.println("You gave locator=" +locator+".Plz give valid locator format ex:  _name,_id, _class,_xpath,_css...etc");
		}
		
		return ele;
		//   ele   --  null

	}


	// String valFromFirstNAmeTxtbox =   getValueFromTextBox("//input[@name='firstname']")
	//
	// String valFromlastnameTxtbox = getValueFromTextBox("//input[@name='lastname']")
	public static String getValueFromTextBox(String myxpath)
	{
		// get val from  'text box 'first name
		try
		{
//			String val = driver.findElement(By.xpath(myxpath)).getAttribute("value");
			String val = getElement(myxpath).getAttribute("value");
			
			return val;
		}			
		catch (NoSuchElementException  e) {
			System.out.println("NoSuchElementException.Please check locator ="+ myxpath);
		}
		return "Please check locator "+myxpath;					
	}


	//----------------------------------
	//Radio button :
	//---------------
	//		Select radio button --> clickRadioButton 
	//		check radio button is selected --> isRadioBtnSelected
	//		it is displayed or not --> HW
	//		is enabled --> HW


	/*
	 * Method Name 		: selectRadioBtn
	 * Objective		: to select given radio btn
	 * Arguments		: 
	 * Author			: 
	 * Create Date 		: 
	 * Modified Date	: 
	 * Method call		: 					
	 * Return type		:  
	 *  
	 */

	public static void clickRadioButton(String myxpath)
	{
		// click Male radio btn
		try {
			System.out.println("Select Radio btn ="+ myxpath);
//			driver.findElement(By.xpath(myxpath)).click();
			getElement(myxpath).click();
		} 
		catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException.Please check locator ="+ myxpath);
		}		

	}

	// isRadioBtnSelected("male radio btn xpath")
	//	isRadioBtnSelected("female radio btn xpath ")
	public static boolean isRadioBtnSelected(String myxpath)
	{

		// radio btn is slected
//		boolean	isSelected  = driver.findElement(By.xpath(myxpath)).isSelected();
		boolean	isSelected  = getElement(myxpath).isSelected();
		

		return isSelected;
	}


	/*
	 * Method Name 		: 
	 * Objective		: 
	 * Arguments		: 
	 * Author			: 
	 * Create Date 		: 
	 * Modified Date	: 
	 * Method call		: 					
	 * Return type		:  
	 *  
	 */


	//---------------------------------
	//checkbox Common methods:
	//----------------
	//		click/ Select checkbox  -->  HW
	//		unselect checbox	-->  HW
	//		checkbox is selected    --> HW 
	//		isdisplayed    --> HW 
	//		is is enabled or not    --> HW 
	//----------------------------

	//Button common method :
	//------------------
	//		click button    --> HW 
	//		get button name    --> HW 
	//		isdisplayed    --> HW 
	//		is is enabled or not    --> HW 
	//---------------------------------



	//Dropdown common methods:
	//---------------	
	//		select some value in dropdown		-->  selectValueInDropdown()
	//		get selected value in dropdown     -->  HW 
	//		get all dropdown values 		  -->  HW 
	//		check given value/ text is exist in dropdown   --- >  HW
	//		get count values from dropdown		-->   HW
	//--------------------------------------

	// select "Adui" value in cars dropdown
	public static void selectValueInDropdown(String myxpath, String ValueToSelect)
	{
		try
		{
//			WebElement  dropdownEle =  driver.findElement(By.xpath(myxpath));
			WebElement  dropdownEle =  getElement(myxpath);
			
			
			Select sel = new Select(dropdownEle);
			//  3 methods  SelectByVisibleText("Audi")
			//   2.  SelectbyValue("value");
			// 3.  SelectByindexNo

			System.out.println("Select value ="+ ValueToSelect + " in dropdown ="+ myxpath);
			sel.selectByVisibleText(ValueToSelect);
		}
		catch (NoSuchElementException e) {

			//			/  e = org.openqa.selenium.NoSuchElementException: Cannot locate option with text: Kia123
			if(e.toString().contains("Cannot locate option with text"))
			{
				System.out.println("Given text = '" + ValueToSelect + " is not available in dropdown");
			}
			else
			{
				System.out.println(e+ "NoSuchElementException . unable to find the dropdown Ele. Please check xpath = "+myxpath);
			}

		}

	}


	//Multi Select dropdown  common methods:
	//--------------------
	//		select multiple values in MultiSelect dropdown    --> HW 
	//		get selected values from Multi Select dropdown    --> HW 
	//		get all dropdown values  from Multi Select dropdown    --> HW 
	//		check given value/ text is exist in Multi Select dropdown    --> HW 
	//		get count values from Multi Select dropdown	    --> HW 
	//
	//------------------------------------------
	//Links:
	//------------
	//
	//
	//-----------------
	//Image :
	//--------



	// Actions class methods:

	/*
mouse over on Given Element     --> HW 
double click -->HW 
Rt click -->HW 
key board operation --? HW 
Press Tab  -->HW 
Press tab 2 or 3 times -->HW 
press enter from k/b --> HW 
	 */

	//Alert :

	/*
if alert is there,switch to alert -->HW 
-Get msg from alert popup window -->HW 
accept alert -->HW 
dismiss alert  --> HW 
	 */



	//HW JSE --> write all reusable method names for all elements ex: text box, Radio button,checkbox...etc

	//Text Box

	//jseEnterText(By locator, String text)

	//jseClearText(By locator)

	//jseGetText(By locator)


	//Radio Button
	//
	//jseClickRadio(By locator)
	//
	//jseIsRadioSelected(By locator)
	//
	//jseSelectRadio(By locator) (based on condition/id/value)
	//
	//
	//Checkbox
	//
	//jseClickCheckbox(By locator)
	//
	//jseCheckCheckbox(By locator) (only if not checked)
	//
	//jseUncheckCheckbox(By locator) (only if checked)
	//
	//jseIsCheckboxSelected(By locator)
	//
	//
	//Dropdown
	//
	//jseSelectDropdownByValue(By locator, String value)
	//
	//jseSelectDropdownByIndex(By locator, int index)
	//
	//jseSelectDropdownByVisibleText(By locator, String text)
	//
	//
	//Button / Link
	//
	//jseClick(By locator)
	//
	//jseGetAttribute(By locator, String attrName)
	//
	//jseGetInnerText(By locator)
	//
	//
	//Visibility / Scrolling
	//
	//jseScrollIntoView(By locator)
	//
	//jseScrollToTop()
	//
	//jseScrollToBottom()
	//
	//jseHighlightElement(By locator)
	//
	//jseIsVisible(By locator)
	//
	//Page Level Helpers
	//
	//jsePageRefresh()
	//
	//jseClickUsingXY(int x, int y)
	//
	//jseOpenNewTab(String url)
	//
	//jseNavigateTo(String url)
	//
	//
	//Bonus: Wait Handling (JSE Based)
	//
	//jseWaitForPageLoad()






}
