import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.beust.jcommander.Strings;

public class windowHandling {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String>windows=driver.getWindowHandles();//-----------windows=[parentid,childid]
		Iterator<String> it=windows.iterator(); //
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		
		driver.findElement(By.xpath("//p[@class='im-para red']")).getText();//Get the entire paragraph and extract only the emailID
		//Extracting only the Email ID
		String email=driver.findElement(By.xpath("//p[@class='im-para red']")).getText().split("at")[1].trim().split(" ")[0];
		Thread.sleep(1000);
		
		//Switching back to the Parent Window
		driver.switchTo().window(parent);
		driver.findElement(By.id("username")).sendKeys(email);
	}

}
