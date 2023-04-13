import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.io.Files;


public class ScreenshotDemo {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(src,new File("D://screenshot.png"));
		Files.copy(src, new File("d:\\screenshot.jpg"));

		//Screenshot of the WebElement-Selenium 4 and above
		
		String courseName="Selenium training by Rahul Shetty";
		WebElement name=driver.findElement(By.xpath("(//input[@name='name'])"));
		
		name.sendKeys(courseName);
		File src1=name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1,new File("screenshottwo.png"));
		
		driver.close();
	}

}
