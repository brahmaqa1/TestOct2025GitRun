package Selenium4Features;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshotForElement {

	public static void main(String[] args) throws IOException {
		
		
		WebDriver driver = null;

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver =  new ChromeDriver();

		//		// open given url ib browser
		driver.get("file:///C:/brahma/Practise/qtp%20practise/web%20apps/ALL%20Web%20objects.html");

		// Take screen shot of "first name" text box ele
		WebElement fnameEle=  driver.findElement(By.name("firstname"));
		File srcFile =  fnameEle.getScreenshotAs(OutputType.FILE);
		
		// jar --> apache- commons-io 
		//  copyFile(srcFile, DestFile);	
		File Desfile = new File("C:\\Brahma\\Practise\\SelniumPractiseNew\\Oct2025WorkSpace\\MavenProjectThroughCommandOct2025\\src\\test\\java\\Selenium4Features\\eleScreen.png");
		
		FileUtils.copyFile(srcFile, Desfile);
		
	
		//HW Take screen shot for penguin image ?
		
		// HW  take screens shot "cars" dropdown
		
		//HW  take screens shot or Multi select cars dropdown
		
		System.out.println("ends ");	
	}

}
