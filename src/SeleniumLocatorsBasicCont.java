import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class SeleniumLocatorsBasicCont {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String IUname="ABCDEF";
		String pwd=getpassword(driver);
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("inputUsername")).sendKeys(IUname);				
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwd);
		driver.findElement(By.cssSelector(".submit.signInBtn")).click();
		Thread.sleep(1000);
		String msg=driver.findElement(By.tagName("p")).getText();
		System.out.println(msg);
		Assert.assertEquals(msg,"You are successfully logged in.");
		String AUname=driver.findElement(By.tagName("h2")).getText();
		System.out.println(AUname);
		Assert.assertEquals(AUname,"Hello "+IUname+",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.close();
	}
	
	
		 public static String getpassword(WebDriver driver) throws InterruptedException {
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.findElement(By.linkText("Forgot your password?")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
			String Vpwd=driver.findElement(By.cssSelector("form p")).getText();
			//Please use temporary password 'rahulshettyacademy' to Login.
			String[] pwd=Vpwd.split("'");
			String[] Apwd=pwd[1].split("'");		
			return Apwd[0];
		}

}
