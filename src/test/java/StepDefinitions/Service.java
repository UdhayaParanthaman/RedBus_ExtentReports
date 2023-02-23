package StepDefinitions;


import org.testng.annotations.BeforeTest;

import com.kumaran.RedBus.BaseTest;

import io.cucumber.java.Before;


public class Service {

	BaseTest bt=new BaseTest();

	
	@BeforeTest
	public void start()
	{
		bt.webBrowser();
		
	}
	
}
