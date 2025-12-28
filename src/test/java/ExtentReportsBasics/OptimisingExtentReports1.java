package ExtentReportsBasics;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class OptimisingExtentReports1 extends MyTestListner
	//extends MyTestListner
	{
		// get parent class var + Methods  i,e exRepo,exTest from MyTestListner-class  into child class
		
		
		
		@Test
		public void testA()
		{
			System.out.println("test A stm-1");
					// create Test - pass - Test Name and description-test A", "test A - describption
//			System.out.println("exRepo="+ exRepo);
			// null 
//			  exTest =  exRepo.createTest("test A", "test A - describption");
//			 extest =  exRepo.createTest("test A", "test A - describption");

			//Log diff msgs in reports(pass,fail, info, warning..etc)
			
			//log pass msgs in extent report
			//  1.Open Browser
			//  2.Enter url
			extest.log(Status.PASS, "1.Open Browser");
			extest.log(Status.PASS, "2.Enter url");
			  // Define logPassMsg()  in MytestListner and call method
			// 1.Open Browser
			// 2.Enter url
			
			logPassMsg("1.Open Browser");

			// Log fail  msgs in extent reports		
			// 3.enter user name
			// 4.enter password
//			exTest.log(Status.FAIL, "3.enter user name");
//			exTest.log(Status.FAIL, "4.enter password");
			 // Define logFailMsg()  in MytestListner and call method-logFailMsg
			logFailMsg("3.enter user name");
			logFailMsg("4.enter password");
			
		}


}
