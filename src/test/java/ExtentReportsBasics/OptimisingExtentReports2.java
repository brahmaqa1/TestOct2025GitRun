package ExtentReportsBasics;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class OptimisingExtentReports2 extends MyTestListner
//extends MyTestListner
{ 
// get parent class var + Methods  i,e exRepo,exTest from MyTestListner-class  into child class
	
	
	@Test
	public void testB()
	{
		System.out.println("test B stmt-1");
		// createTest -testB:TC02:Create Order  , Create Order Description 
//		 extest = exRepo.createTest("testB:TC02:Create Order", "Create Order Description ");
		
//		//Search for Product
		extest.log(Status.PASS, "Search for Product");
		// call -logPassMsg
		
//		
//		//Select the Samsung mobile
		extest.log(Status.PASS, "Select the Samsung mobile");
//		 call -logPassMsg
//		
//		// add 2 qty
//		exTest.log(Status.PASS, "add 2 qty");
		//call -logPassMsg
		
		
				
	}
}

