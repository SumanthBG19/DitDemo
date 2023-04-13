import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutosuggestiveDropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("IND");
		Thread.sleep(1000);
		
		List<WebElement> country=driver.findElements(By.xpath("//li[@class='ui-menu-item'] //a"));;
		
		for(WebElement countries:country) {
			
			if(countries.getText().equalsIgnoreCase("India")){
				countries.click();
				break;
			}
		}
		
	}

}
