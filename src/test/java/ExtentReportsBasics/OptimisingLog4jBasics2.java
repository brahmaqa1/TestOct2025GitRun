package ExtentReportsBasics;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import TestBase.TestBase1;

public class OptimisingLog4jBasics2 extends TestBase1
// extends TestBase
{


	@Test
	public void CreateOrder()
	{

//		Logger  log =  Logger.getLogger("Sita");

		// log msgs
		//CreateOrder -started//
//		1.Search for Product
//		2.Add qty  
//		3. Add to cart and Proceed with payment 
		log.debug("CreateOrder -started");
		log.debug("1.Search for Product");
		
	

	}

}


