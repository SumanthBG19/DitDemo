import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AssignmentMostoftheconcepts {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		//Selecting an Option from the checkbox
		WebElement chkbox=driver.findElement(By.id("checkBoxOption1"));
		chkbox.click();	
		String v=chkbox.getAttribute("Value");//Get the Value attributed from the selected Option
		System.out.println(v);
		
		WebElement dropDown=driver.findElement(By.id("dropdown-class-example")); //Selecting the same option in the dropDown
		Select s= new Select(dropDown);
		s.selectByValue(v);
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(v);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		
		Alert alertmsg=driver.switchTo().alert();
		String alertMsgText=alertmsg.getText();		
		System.out.println(alertMsgText);
		
		String o=alertMsgText.split(" ")[1].split(",")[0];
		System.out.println(o);
		alertmsg.accept();		
		
		Assert.assertEquals(v, o);
						
		}
		
	}

