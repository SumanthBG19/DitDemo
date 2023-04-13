import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DimensionofwebelementsDemo {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		//Get the Dimensions from Selenium 4 and above
		WebElement name=driver.findElement(By.xpath("(//input[@name='name'])"));
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		System.out.println(name.getRect().getWidth());
	}

}
