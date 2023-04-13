import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadedusingAutoIT {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		String downloadpath=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadpath);
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://altoconvertpdftojpg.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));	
		driver.findElement(By.id("browse")).click();
		
		Thread.sleep(3000);
		//Call the .exe file here using Java
		Runtime.getRuntime().exec("D:\\fileUploaderAutoITScript.exe");
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".action-delete")));
		//driver.findElement(By.cssSelector(".action-delete")).click();
		
		driver.findElement(By.id("submit_btn")).click();
		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-primary.btn-sm")));
		driver.findElement(By.cssSelector(".btn.btn-primary.btn-sm")).click();
		
		
		File f=new File(downloadpath+"/Converted.Zip");
		if(f.exists()) {
			
			System.out.println("The File is found");
		}
		
		
	}

}
