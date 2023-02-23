package StepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.kumaran.RedBus.BaseTest;
import com.kumaran.RedBus.DashBoardPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.CucumberOptions;



public class DashBoardPageStepDefinition extends BaseTest{
	
	
	
	BaseTest bt=new BaseTest();
	DashBoardPage db=new DashBoardPage(driver);
	
	  

	@Given("I want to be in {string} page")
	public void i_want_to_be_in_page(String url) {
		//bt.driver.get(url)
		db.dashBoard(url);
		

	   
	}

	@When("Have to select the location and date to book bus")
	public void have_to_select_the_location_and_date_to_book_bus() throws InterruptedException {
	  
		db.fromCity();
		db.toCity();
		db.selectDate();
		
	}

	@Then("click on to search button")
	public void click_on_to_search_button() {
	    db.clickSearchBtn();
	}
}
