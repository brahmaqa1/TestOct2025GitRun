package ExtentReportsBasics;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jBasics1 {

	@Test
	public void LoginTC1()
	{
		// In Java, we can send msgs to console window 
		//1.Open chrome browser
		System.out.println("1.Open Chrome browser");
		//2.Enter user name
		System.out.println("2.Enter user name");
		//3.Enter pwd
		System.out.println("4.click login button");
		System.out.println("5.Verify Home page is displayed");

		// Testng :we can send msgs in testNG reports  --Reporter.log("msg ");
		//  2. index.html 2. emailable-report.html
		// log msg in Testng reprts-  
		//1.Open chrome browser

		//2.Enter user name

		//3.Enter pwd

		//4.click login button
		//5.Verify Home page is displayed

		// Log msgs in Extent reports
		//	ExtentSparkReporter	  ExtentReports, ExtentTest
		// extTest.log(Status.PAss,"1tion").Open the applica


		// to log msgs in logger files -Logger.getLogger("Ram");
		Logger logobj=  Logger.getLogger("Ram");

		// log msgs in logger file - debug()

		//1.Open chrome browser
		logobj.debug("1.Open chrome browser");
		//2.Enter user name
		logobj.debug("2.Enter user name");
		//3.Enter pwd
		logobj.debug("3.Enter pwd");
		//4.click login button
		logobj.debug("4.click login button");

		//5.Verify Home page is displayed	
		logobj.debug("5.Verify Home page is displayed");


	}

}
