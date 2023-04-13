import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FrameHandlingDemo {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		Actions a=new Actions(driver);
		//driver.switchTo().frame(0); // Using the frame Index
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));	//Using the locator of the Frame
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement Destination=driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, Destination).build().perform();
		
		driver.switchTo().defaultContent();//To come's out of the frame
		
		
	}

}
