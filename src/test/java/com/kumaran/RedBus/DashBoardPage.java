package com.kumaran.RedBus;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DashBoardPage extends BaseTest {

	public WebDriver driver;

	public DashBoardPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "#src")
	WebElement fromCityClick;

	@FindBy(css = "#src")
	WebElement fromCity;

	@FindBy(xpath = "//*[@id=\"search\"]/div/div[1]/div/ul/li")
	List<WebElement> selectFromCity;

	String expectedCity = "Egmore, Chennai";

	@FindBy(xpath = "//input[@id='dest']")
	WebElement toCity;

	@FindBy(xpath = "//*[@id=\"search\"]/div/div[2]/div/ul/li")
	List<WebElement> selectToCity;

	String expectedToPlace = "Periyar Bus Stand, Madurai";

	@FindBy(xpath = "//td[@class='monthTitle']")
	WebElement months; // driver.findElement(By.xpath("//td[@class='monthTitle']"))

	@FindBy(css = ".day")
	List<WebElement> date;

	@FindBy(className = "next")
	WebElement nextBtn;

	@FindBy(id = "searchbtn")
	WebElement searchBtn;

	public void dashBoard(String url) {
		driver.get(url);
	}

	public void fromCity() throws InterruptedException {
		fromCityClick.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		fromCity.sendKeys("che");

		for (WebElement pl : selectFromCity) {
			System.out.println(pl.getText());

			if (pl.getText().equals(expectedCity)) {
				pl.click();
				break;
			}
		}

	}

	public void toCity() {
		toCity.sendKeys("mad");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		for (WebElement toPl : selectToCity) {
			System.out.println(toPl.getText());
			if (toPl.getText().equals(expectedToPlace)) {
				toPl.click();
				break;
			}
		}
	}

	// click date
	String expectedMonth = "Mar 2023";
	String expectedDate = "27";
	boolean flag = true;

	public void selectDate() {

		while (flag) {

			// String
			// month=driver.findElement(By.xpath("//td[@class='monthTitle']")).getText().trim();
			String month = months.getText();
			if (month.equals(expectedMonth)) {
				// List<WebElement> date=driver.findElements(By.cssSelector(".day"));
				for (WebElement dat : date) {
					if (dat.getText().equals(expectedDate)) {
						dat.click();
						flag = false;
					}

				}
			}

			else {
				// driver.findElement(By.className("next")).click();
				nextBtn.click();

			}
		}
	}

	public void clickSearchBtn() {
		searchBtn.click();
	}

}
