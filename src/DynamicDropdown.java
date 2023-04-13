import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		//driver.findElement(By.xpath("//a[@value='BLR']")).click();
		////div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
		
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("(//a[@value='JSA'])[2]")).click();
		////div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='JSA']
		
		//Looking for the element within the desired scope
		//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']
		//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='JSA']
		
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='BLR']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='JSA']")).click();
		
	}

}
