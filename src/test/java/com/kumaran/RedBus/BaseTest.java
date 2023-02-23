package com.kumaran.RedBus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

	public static WebDriver driver;
	
	public void webBrowser()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		
	}
}
