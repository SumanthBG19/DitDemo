import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class UpdateDropdown {

	public static void main(String[] args) throws InterruptedException {
		

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		int i=1;
		while(i<3) { //for(int i=0;i<2;i++)
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}	
		driver.findElement(By.xpath("//input[@value='Done']")).click(); 
		
		
	}

	
}
