import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class webdriverscope {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//give me the count of the links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//System.out.println(driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size());

		WebElement footer=driver.findElement(By.id("gf-BIG")); 	//Limiting the scope of the driver-footer
		System.out.println(footer.findElements(By.tagName("a")).size());
		
		//Get the count of the links under Discount Coupons 
		WebElement firstclumn=footer.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> s=firstclumn.findElements(By.tagName("a"));
		
		//int s=firstclumn.findElements(By.tagName("a")).size();
		System.out.println(s.size());
	
		
		for (int i=1;i<s.size();i++) {
			
			String clicktoOpenInNewTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			(s.get(i)).sendKeys(clicktoOpenInNewTab);	
			Thread.sleep(2000);
		}	
			Set<String> tabs=driver.getWindowHandles();
			Iterator<String> it=tabs.iterator();
			
			while (it.hasNext()) {	
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
	}
}
