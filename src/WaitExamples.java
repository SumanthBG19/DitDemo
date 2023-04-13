import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitExamples {

	public static void main(String[] args) throws InterruptedException {
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
			WebDriver driver= new ChromeDriver(options);
			
			String[] itemsneeded= {"Cucumber", "Brocolli", "Beetroot", "Carrot", "Potato"};
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
			//---driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);-----Depricated Code
			
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5)); //Global declaration of the Explicit wait(WebDriverWait)
			
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			driver.manage().window().maximize();
			
			addItems(driver,itemsneeded,w);	
			
			/* Calling the method by creating the Object if the below method was not declared static
			WaitExamples example=new WaitExamples();
			example.addItems(driver, itemsneeded);
			*/
		}
	
	
		public static void addItems(WebDriver driver,String[] itemsneeded,WebDriverWait w ) {
			
			List<WebElement> Vegetables=driver.findElements(By.cssSelector("h4.product-name"));
			
			for(int i=0;i<Vegetables.size();i++) {
				
				String[] Veggis=Vegetables.get(i).getText().split("-");
				String Veg=Veggis[0].trim();
				
				//Format the Veggies in the format defined in the Array
							
				//Convert the Array to Array list for easy search
				//Search for the items needed in the Array list
				List al = Arrays.asList(itemsneeded);
				
				int j=0;
				if(al.contains(Veg)) {
					
					driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
					//System.out.println(i);	
					j++;
					if(j==itemsneeded.length)
						break;
				}
			}
			
			driver.findElement(By.xpath("//img[@alt='Cart']")).click();	//----img[alt='Cart']-CSS
			driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
			
			//Explicit wait handles this part
			w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promocode")));
			
			//implicit wait is triggered and waits until the page is loaded completely and the searching element is available on the page
			driver.findElement(By.cssSelector(".promocode")).sendKeys("rahulshettyacademy");
			driver.findElement(By.className("promoBtn")).click();
			
			//Explicit wait handles this part
			
			w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
			String conMess=driver.findElement(By.xpath("//span[@class='promoInfo']")).getText();
			System.out.println(conMess);
		}
}
