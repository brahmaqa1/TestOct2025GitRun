package ExtentReportsBasics;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import TestBase.TestBase1;


public class OptimisingLog4jBasics1 extends TestBase1
//extends TestBase
{
//get parent class var + methods from parent class 

	@Test
	public void LoginTC1()
	{
		
	// to log msgs in logger files -Logger.getLogger("Ram");
//		Logger log =  Logger.getLogger("Ram");
//		Logger log =  Logger.getLogger("Ram");
		// log msgs - debug()
				
		log.debug("LoginTC1 -started");
		log.debug("1.Open chrome browser");
		log.debug("Debug--> 2.Enter user name");
		log.info("info -> 2.Enter user name");
		log.error("error -> 2.Enter user name");
				
	}

}