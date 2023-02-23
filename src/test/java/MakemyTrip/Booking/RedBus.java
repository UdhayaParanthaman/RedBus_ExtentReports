package MakemyTrip.Booking;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RedBus {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.redbus.in/");

		// driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String fileLocation = "./TestData/Data.xlsx";
		XSSFWorkbook wbook = new XSSFWorkbook(fileLocation);
		XSSFSheet sheet = wbook.getSheetAt(0);
		XSSFRow row = sheet.getRow(0);
		XSSFCell cell = row.getCell(0);
		String expectedCity=cell.getStringCellValue(); // String expectedCity="Egmore, Chennai";
		String expectedToPlace=sheet.getRow(1).getCell(0).getStringCellValue();
		//	String expectedToPlace="Periyar Bus Stand, Madurai";
		
		String expectedMonth=sheet.getRow(2).getCell(0).getStringCellValue();
		//String expectedMonth = "Mar 2023";

		String expectedDate=sheet.getRow(3).getCell(0).getStringCellValue();
		//String expectedDate="27";
		
		driver.findElement(By.cssSelector("#src")).click();
		driver.findElement(By.cssSelector("#src")).sendKeys("che");
		
		// List<WebElement>
		// place=driver.findElements(By.xpath("//*[@id='search']/div/div[1]/div/ul/li"));
		List<WebElement> place = driver.findElements(By.xpath("//*[@id=\"search\"]/div/div[1]/div/ul/li"));
		
		for (WebElement pl:place)
		{
			System.out.println(pl.getText());
		
			
			if(pl.getText().equals(expectedCity))
			{
				pl.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='dest']")).click();
		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("mad");
		List<WebElement> toPlace = driver.findElements(By.xpath("//*[@id=\"search\"]/div/div[2]/div/ul/li"));
		//String expectedToPlace="Periyar Bus Stand, Madurai";
		for(WebElement toPl:toPlace)
		{
			System.out.println(toPl.getText());
			if(toPl.getText().equals(expectedToPlace))
			{
				toPl.click();
				break;
			}
		}
		

		// click date
//		String expectedMonth = "Mar 2023";
//		String expectedDate="27";
		boolean flag = true;
		while (flag) {
			
				String month = driver.findElement(By.xpath("//td[@class='monthTitle']")).getText().trim();
				if (month.equals(expectedMonth)) 
				{	
					List<WebElement> date=driver.findElements(By.cssSelector(".day"));
					for (WebElement dat : date) 
					{
					if(dat.getText().equals(expectedDate))
					{
						dat.click();
						flag=false;
					}
						
					
				  }
				}

				else {
					driver.findElement(By.className("next")).click();

			
				 }
		    }
		//to click search btn
		driver.findElement(By.id("search_btn")).click();
	}
}
