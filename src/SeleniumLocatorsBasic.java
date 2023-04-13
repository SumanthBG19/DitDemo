import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumLocatorsBasic {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputUsername")).sendKeys("ABC");
		
		driver.findElement(By.name("inputPassword")).sendKeys("abc");
		driver.findElement(By.className("submit")).click();
		
		Thread.sleep(2000);
		
		String emessage=driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(emessage);
		
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("abc");
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("abc@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("1234567890");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
		
		//driver.findElement(By.xpath("//input[@type='text'][3]")).sendKeys("0987654321");
		driver.findElement(By.cssSelector("input[type='text']:nth-child(4)")).sendKeys("0987654321");
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		//System.out.println(driver.findElement(By.xpath("//form/p")).getText());//Using Xpath
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("ABC");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy"); //Using CSS regular expression
		Thread.sleep(2000);
		driver.findElement(By.id("chkboxOne")).click();
		//driver.findElement(By.cssSelector(".submit.signInBtn")).click();
		driver.findElement(By.xpath("//button[contains(@type,'sub')]")).click(); //Using Xpath regular Expression
		//driver.close();
	}
}
