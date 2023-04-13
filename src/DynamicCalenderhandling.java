import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicCalenderhandling {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//Select the Round trip
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		String month="(//div[@class='ui-datepicker-title'])[2]/span[@class='ui-datepicker-month']";
		
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		while(!driver.findElement(By.xpath(month)).getText().contains("May")) {
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			
		}
		//(//div[@class='ui-datepicker-title'])[2]/span[@class='ui-datepicker-month']
		
		
		//April 14
		
		////table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']
		List<WebElement> exdate=driver.findElements(By.xpath("//td[@data-handler='selectDay']"));
		
		for(int i=0;i<exdate.size();i++) {
			
			String date= exdate.get(i).getText();
		
			if (date.equalsIgnoreCase("1"))
			{
				exdate.get(i).click();
				break;
			}
		
		}
	}

}
