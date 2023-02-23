package com.kumaran.RedBus;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public static WebDriver driver;
	//public  WebDriver driver;
	
	public void webBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
	
	public String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir")+"//target//fail"+".png");
		
		 try {
			 FileUtils.copyFile(src, file);
			 } 
		 catch (IOException e) { 
			 e.printStackTrace();
			 }
		 String fileLocation=System.getProperty("user.dir")+"//target//fail"+".png";
		 return fileLocation;
		
	}
}
