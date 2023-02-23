package StepDefinitions;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.kumaran.RedBus.BaseTest;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Service {

	BaseTest bt=new BaseTest();

	
	@Before
	public void start()
	{
		bt.webBrowser();
		
	}
	


}
