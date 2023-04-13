import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class greenKartDemo {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
		//ADD Cucumber
		List<WebElement> Vegetables=driver.findElements(By.cssSelector("h4.product-name"));
				
		for(int i=0;i<Vegetables.size();i++) {
			String Veg=Vegetables.get(i).getText();
			
			if(Veg.contains("Cucumber")) {
				
				driver.findElements(By.xpath("//button[.='ADD TO CART']")).get(i).click();
				System.out.println(i);
				break;
			}
		}

	}

}
