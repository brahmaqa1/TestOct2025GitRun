package com.birla;

import org.testng.annotations.Test;

//public class IOS // this class will not get executed as Class name does end with 'Test'
//public class IOSTest  //   gets executed
public class IOSTest //   does not get executed as class name does not end with "Test" 
// always Give Test,   but not 'test'
//public class IOSTEST ////   does not get executed as class name does not end with "Test
//public class ios //   this class will not get executed as Class name does end with Test
{
	
	@Test
	public void testC()
	{
		System.out.println("hi IOS Test");
	} 


}