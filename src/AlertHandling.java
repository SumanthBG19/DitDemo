import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
				
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		String name="Sumanth";
		driver.findElement(By.id("name")).sendKeys(name);
		
		driver.findElement(By.xpath("//input[@value='Alert']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
		
		Thread.sleep(1000);
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}

}
