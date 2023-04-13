import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Calenderdemo {

	public static void main(String[] args) {
		//.ui-state-default.ui-state-highlight
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//(//button[@class='ui-datepicker-trigger'])[1]
		driver.findElement(By.xpath("(//button[@class='ui-datepicker-trigger'])[1]")).click();
		//Selecting the current date
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));
		
		/* if(driver.findElement(By.id("Div1")).getAttribute("Style").contains("1")){
			System.out.println("The Return Date is enabled");
		}
		else {
				System.out.println("The Return Date is Disabled");	
		}*/
		
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		//System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
		
		System.out.println(driver.findElement(By.id("Div1")).getAttribute("Style"));
		
		if(driver.findElement(By.id("Div1")).getAttribute("Style").contains("1")){
			
			System.out.println("The Return Date is enabled");
			Assert.assertTrue(true);
		}
		else {
				System.out.println("The Return Date is Disabled");
				Assert.assertTrue(false);	
				
			}
		
	}
	
}
