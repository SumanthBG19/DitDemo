import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AssignmentFrameHandling {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@href='/frames']")).click();
		WebElement nestedframe=driver.findElement(By.xpath("//a[@href='/nested_frames']"));
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(2));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/nested_frames']")));
		nestedframe.click();
		
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());
		
		driver.switchTo().defaultContent();
		driver.switchTo().defaultContent();
		
	}

}
