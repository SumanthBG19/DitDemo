import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AssignmentAutoSuggestiveDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("autocomplete")).sendKeys("United");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> country=driver.findElements(By.xpath("//ul[@id='ui-id-1']//div"));
		
		String c="United States Minor Outlying Islands";
		
		
		for(WebElement option:country) {
				
			if(option.getText().equalsIgnoreCase(c)) {
				
				System.out.println(option.getText() +" is selected");
				option.click();
				break;
			}else 
				System.out.println("Wrong country selected");
				
		}
		

	}

}
