import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AssessmentScrolling {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(1000);
		js.executeScript("document.querySelector('.table-display').scrollytop=5000");
		
		//number of columns
		System.out.print("The coulum count :");
		System.out.println(driver.findElements(By.cssSelector(".table-display th")).size());
		
		//number of Rows
		System.out.print("The row count :");
		System.out.println(driver.findElements(By.cssSelector(".table-display td:nth-child(3)")).size());
		
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
		
		
	}

}
