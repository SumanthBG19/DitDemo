import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.DoubleClickAction;

import net.bytebuddy.implementation.bytecode.ShiftLeft;

public class ActionsDemoMouseActions {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		
		WebElement move=driver.findElement(By.id("nav-link-accountList"));         
		
		Actions a=new Actions(driver);
		a.moveToElement(move).build().perform();//Hover on the Hello, Sign in 
		
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		a.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();//Type in Capital Hello and double click on the same
		Thread.sleep(1000);
		a.moveToElement(move).contextClick().perform();
	}

}
