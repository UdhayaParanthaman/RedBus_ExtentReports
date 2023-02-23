package MakemyTrip.Booking;




import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class HomePage {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"manageHeaderdd\"]/div[2]")).click();
		driver.findElement(By.xpath("(//span[@class='cli'])[4]")).click();
		
		String expectedUrl=driver.getCurrentUrl();
	
		Assert.assertEquals("https://www.redbus.in/Home/SmsAndEmailTicket",expectedUrl);
		System.out.println(expectedUrl);
		
		
	}

}
