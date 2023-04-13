import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class multipleWindowDemo {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		driver.switchTo().newWindow(WindowType.TAB);
		Set<String> winName=driver.getWindowHandles();
		Iterator<String> it=winName.iterator();
		String parWinID=it.next();
		String childWinID=it.next();
		
		driver.switchTo().window(childWinID);
		driver.get("https://rahulshettyacademy.com");
		
		String courseName=driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parWinID);
		
		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys(courseName);
		
		driver.quit();

	}

}
