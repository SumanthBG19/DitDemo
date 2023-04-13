import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class ScrollingDemouding {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js= (JavascriptExecutor)driver; 
		
		js.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		js.executeScript("document.querySelector('.tableFixHead\').scrollTop=5000");
		
		List<WebElement> a=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		
		int s=0;
		for(int i=0;i<a.size();i++) {
			
			String v=a.get(i).getText();
			System.out.println(v);
			s=s+Integer.parseInt(v);
			//System.out.println(s);
		}
		
		System.out.println(s);
		
		
		String sum=driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		int total=Integer.parseInt(sum);
		
		Assert.assertEquals(s, total);
	}

}
