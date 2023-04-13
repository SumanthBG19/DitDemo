import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowAuthenticationPopUpDemo {

	public static void main(String[] args) {
		
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Basic Auth")).click();
		

	}

}
