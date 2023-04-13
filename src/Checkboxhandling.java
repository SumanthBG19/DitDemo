import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Checkboxhandling {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		System.out.println("Selected "+driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		System.out.println("Enabled "+driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isEnabled());
		System.out.println("Selected "+driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		//count the number of Checkboxes
		
		List<WebElement> checkboxcount=driver.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println(checkboxcount.size());
		
	}

}
