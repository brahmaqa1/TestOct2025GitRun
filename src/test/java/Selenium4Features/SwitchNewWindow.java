package Selenium4Features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchNewWindow {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

				WebDriver driver = null;

				System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
				// //open chrome browser
				driver = new ChromeDriver();

				driver.get("file:///C:/brahma/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");				
//								  
				  Thread.sleep(5000); 
//				  // open new window and switch to that window //
//				  driver.switchTo().newWindow(WindowType.WINDOW);
				 driver.switchTo().newWindow(WindowType.WINDOW);
						  
//				  // open some url in 2nd browser driver.get("https://www.google.com/");
				 driver.get("https://www.google.com/");
				 
//				  // search Rama in google 
				  driver.findElement(By.name("q")).sendKeys("Rama");			 

	
	}

}
