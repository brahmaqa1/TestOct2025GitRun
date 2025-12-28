package ExtentReportsBasics;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports2 {

	 ExtentReports exRepo ;
	
	
//	BT BM only once   - BM - multiple 
	@BeforeTest
	public void generateReport()
	{		
		// create obj - ExtentSparkReporter and pass File Path  where to generate reports
				String ReportFile = "C:\\Brahma\\Practise\\SelniumPractiseNew\\Oct2025WorkSpace\\MavenProjectThroughCommandOct2025\\MyExtenReports.html"; 
				ExtentSparkReporter exSpaRepo =  new ExtentSparkReporter(ReportFile);				
				
				// Create obj for- ExtentReports and call attachreporter
			     exRepo =  new ExtentReports();
			    exRepo.attachReporter(exSpaRepo);
				
				
				 //configuration items to change the look and feel- config()
			       //add title , Report name , Set  theme  , setTimeStzampFormat
				// configure setDocumentTitle
			    exSpaRepo.config().setDocumentTitle("My Automation Report Title");		
						
//				setReportName
			    exSpaRepo.config().setReportName("My Automation Report name");				
				
//				setTheme
			    exSpaRepo.config().setTheme(Theme.DARK);
						
				//setTimeStzampFormat
//				exSparkRepo.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			    exSpaRepo.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
					
	}
	
	
	@Test
	public void testA()
	{
		System.out.println("stmt-1 from testA");		
		
		// create Test - pass Test Name and description i.e LoginTC1 ,Login Test 1 Description 
		ExtentTest extest =  exRepo.createTest("LoginTC1", "Login Test 1 Description ");

		//log pass msgs for each test
		//  1.Open Browser
		//  2.Enter url
		extest.log(Status.PASS, " 1.Open Browser");
		extest.log(Status.PASS, "2.Enter url");
	

	// Log fail  msgs in extent reports		
		// 3.enter user name
		// 4.enter password
		extest.log(Status.FAIL, "3.enter user name");
		extest.log(Status.FAIL, "4.enter password");
		
	

		// to view reports -flush(); 
		// if we dont write  this line, results file will not be created
//		exRepo.flush();
	}
	
	@Test
	public void testB()
	{
		//testB: TC02: Create Order ,Create Order Description
		 ExtentTest extest = exRepo.createTest("TC02: Create Order", "Create Order Description");
		
		//Log this msg in report -Search for Product
		 extest.log(Status.PASS, "Search for Product");
		
			//Log this msg in report Select the Samsung mobile
		 extest.log(Status.PASS, "Select the Samsung mobile");
		
		//log this msg -  add 2 qty
		 extest.log(Status.PASS, "add 2 qty");
		 // log this msg - create order
		 extest.log(Status.PASS, "create order");
	}
	
//	AT AM
	@AfterTest
	public void endReport()
	{
		exRepo.flush();
	}
	

}
