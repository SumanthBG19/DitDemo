import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class greenkartdemo2AmazonIntQuestion {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		String[] itemsneeded= {"Cucumber", "Brocolli", "Beetroot", "Carrot", "Potato"};
		System.out.println(itemsneeded.length);
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
		List<WebElement> Vegetables=driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<Vegetables.size();i++) {
			
			String[] Veggis=Vegetables.get(i).getText().split("-");
			String Veg=Veggis[0].trim();
			
			//Format the Veggies in the format defined in the Array
						
			//Convert the Array to Array list for easy search
			//Search for the items needed in the Array list
			List al = Arrays.asList(itemsneeded);
			
			int j=0;
			if(al.contains(Veg)) {
				
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				System.out.println(i);	
				j++;
				if(j==itemsneeded.length)
					break;
			}
			
		}

	}

}
