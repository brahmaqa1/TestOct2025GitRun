package ExtentReportsBasics;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports1 {

	@Test
	public void testA()
	{
		System.out.println("stmt-1 from testA");
		// Extent Reports:
//		 3 imp classes 
		//		ExtentSparkReporter
		//		ExtentReports
		//		ExtentTest
		
		// create obj - ExtentSparkReporter and pass File Path  where to generate reports
		String ReportFile = "C:\\Brahma\\Practise\\SelniumPractiseNew\\Oct2025WorkSpace\\MavenProjectThroughCommandOct2025\\MyExtenReports.html"; 
		ExtentSparkReporter exSpaRepo =  new ExtentSparkReporter(ReportFile);
		
		
		// Create obj for- ExtentReports and call attachreporter
	    ExtentReports exRepo =  new ExtentReports();
	    exRepo.attachReporter(exSpaRepo);
		
		
		 //configuration items to change the look and feel- config()
	       //add title , Report name , Set  theme  , setTimeStzampFormat
		// configure setDocumentTitle
	    exSpaRepo.config().setDocumentTitle("My Automation Report Title");		
				
//		setReportName
	    exSpaRepo.config().setReportName("My Automation Report name");
		
		
//		setTheme
	    exSpaRepo.config().setTheme(Theme.DARK);
				
		//setTimeStzampFormat
//		exSparkRepo.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	    exSpaRepo.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
				
		// In extent report, create test 
		// create Test - pass - Test Name and description
	    ExtentTest exTest =  exRepo.createTest("LoginTC01", "Description:  Verify login success or not");

		//Log diff msgs in reports(pass,fail, info, warning..etc)
		
		//log pass msgs for each test
			//  1.Open Browser
			//  2.Enter url
	    exTest.log(Status.PASS, " 1.Open Browser");
	    exTest.log(Status.PASS, "2.Enter url");
		

		// Log fail  msgs in extent reports		
			// 3.enter user name
			// 4.enter password
	    exTest.log(Status.FAIL, "3.enter user name");
	    exTest.log(Status.FAIL, "4.enter password");
		//HW  send  some'info' msg in extent reports

		//HW send some 'warning' msg  in extent reports
			

		// to view reports -flush(); 
		// if we dont write  this line, results file will not be created
	    exRepo.flush();
		
	}




}
