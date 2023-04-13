import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AssignimentWindowsHandling {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@href='/windows']")).click();
		driver.findElement(By.xpath("//a[@href='/windows/new']")).click();
		
		Set<String>windows=driver.getWindowHandles();//-----------windows=[parentid,childid]
		Iterator<String> it=windows.iterator(); //
		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
		
		System.out.println(driver.findElement(By.xpath("//div//h3")).getText());
		
		driver.switchTo().window(parent);
		System.out.println(driver.findElement(By.xpath("//div//h3")).getText()); 
		

	}

}
