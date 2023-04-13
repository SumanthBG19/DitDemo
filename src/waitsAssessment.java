import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waitsAssessment {

	public static void main(String[] args)  {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
		//Getting the UserName and Password from the webpage
		String Name=driver.findElement(By.xpath("//p[@class='text-center text-white']")).getText();
				
		String nArray[]=Name.split(" ");
		/*for(int i=0;i<nArray.length;i++) {
			System.out.println(nArray[i]);
		}*/
		
		String UName=nArray[2];//UserName
		System.out.println(UName);
		
		String pwd=nArray[6].replace(")", ""); //Password
		System.out.println(pwd);
		
		loginMethod(driver, UName, pwd);
		
	}
	
	public static void loginMethod(WebDriver driver,String Uname, String pwd)  {
		
		driver.findElement(By.id("username")).sendKeys(Uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		
		WebDriverWait w=new WebDriverWait(driver,Duration.ofSeconds(2));
		w.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='modal-content']")))).isDisplayed();
		
		driver.findElement(By.id("okayBtn")).click();
		
		//Selecting the Consultant from the DropDown
		WebElement dropDown=driver.findElement(By.xpath("//select[@data-style='btn-info']"));
		Select select=new Select(dropDown);
		select.selectByVisibleText("Consultant");
		
		driver.findElement(By.id("terms")).click();	//Checking the checkBox
		driver.findElement(By.name("signin")).click();
		
		//.nav-link.btn.btn-primary
		
		w.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(".nav-link.btn.btn-primary")))).isDisplayed();
		List<WebElement>product= driver.findElements(By.xpath("//div[@class='card-footer']"));
		
		for(int i=0;i<product.size();i++) {
			
			product.get(i).click();
		}
		
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
	}

}
