import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndtoEndFlightbooking {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","D:\\Drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		//Delhi to Chennai current date for 3 adults, Family and Friends currency INR and search, Verify the Return date is disabled
		
		//To Select Delhi in the "From" Dropdown
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		
		Thread.sleep(1000);
		//To Select Chennai in the "To" Dropdown
		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();//Xpath Indexing
		
		//Parent to Child relationship Xpath to select Chennai in the "To" Drop down
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		
		//Selecting the current date and check if the return date is disabled
		driver.findElement(By.cssSelector(".ui-state-highlight")).click();
		String stle=driver.findElement(By.id("Div1")).getAttribute("Style");
		System.out.println(stle);
		
		if(driver.findElement(By.id("Div1")).getAttribute("Style").contains("0.5")){
			
			System.out.println("The Return Date is Disabled");
			Assert.assertTrue(true);
		}
		else {
				System.out.println("The Return Date is enabled");
				Assert.assertTrue(false);	
				
			}		
				
		//Clicking the Passengers drop down
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);
		
		//Selecting 3 Adults, 2 Child, 4 Infants
		for(int i=0;i<2;i++) {
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		
		for(int j=0;j<2;j++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		
		for (int k=0;k<1;k++) {
			
			driver.findElement(By.cssSelector("span[id='hrefIncInf']")).click();
		}
		
		//click on the Done button
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();
		
		//Selecting the currency
		WebElement staticdropdown=driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select select=new Select(staticdropdown);
		select.selectByIndex(3);
		select.selectByIndex(2);
		select.selectByIndex(1);
		
		//Selecting the Checkbox
		driver.findElement(By.name("ctl00$mainContent$chk_IndArm")).click();
		
		//Clicking the Search button
		driver.findElement(By.xpath("(//input[@type='submit'])[1]")).click();
	}

}
