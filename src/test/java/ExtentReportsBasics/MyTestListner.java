package ExtentReportsBasics;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class MyTestListner implements ITestListener 
{
	public static ExtentSparkReporter exSpaRepo;
	public static  ExtentReports exRepo;
	public static  ExtentTest extest;

	@Override
	public void onStart(ITestContext context) 
	{
		//		ITestListener.super.onStart(context);
		//exRep =  new ExtentReports(ResFile);
		// Reports will be created only one time
		String reportsFile = "C:\\Brahma\\Practise\\SelniumPractiseNew\\Oct2025WorkSpace\\MavenProjectThroughCommandOct2025\\MyExtentReportsOne.html";


		// create obj - ExtentSparkReporter and pass File Path  where to generate reports
				 
				 exSpaRepo =  new ExtentSparkReporter(reportsFile);
				
				
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

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//		ITestListener.super.onTestStart(result);
		//  gets executed for each @Test Method
//				extest = exRepo.createTest("testA: TC01: Login Test");
//		   extest =   exRepo.createTest("testA: TC01: Login Test");
		
		// get Test Method name in run time
		String name = result.getName();
		//                   testA    testB

		System.out.println("TestMethodName="+name);
		extest =   exRepo.createTest(name);



	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//		ITestListener.super.onTestFailure(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		//		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		//		ITestListener.super.onFinish(context);
		// 		at end - we have to endtest and 


		// to view reports -flush(); 
		// if we dont write  this line, results file will not be created
		exRepo.flush();

	}

	// Define logPassMsg
	
	public void logPassMsg(String msg)
	{
		//extest.log(Status.PASS, "1.Open Browser");
		extest.log(Status.PASS, msg);
	}


	//DEfibe logFailMsg
	public void logFailMsg(String msg)
	{
		extest.log(Status.FAIL, msg);
	}



}
