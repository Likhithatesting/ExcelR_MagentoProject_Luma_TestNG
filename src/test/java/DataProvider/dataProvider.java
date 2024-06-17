package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	
	WebDriver driver;
	
	@BeforeSuite
	
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@DataProvider(name="dataset")
	public Object[][] searchJackets(){
		
		Object[][] data = new Object[1][2];
		
		data[0][0] = "Jackets";
		data[0][1] = " For women";
		
		return data;
	}
	
	@Test(dataProvider = "dataset")
	public void searchJacket(String Category, String Type) {
		
		//Using Search Bar
		WebElement searchBox = driver.findElement(By.id("search"));
		searchBox.sendKeys(Category+" "+Type);
		searchBox.sendKeys(Keys.ENTER);
		
	}
	
	@AfterSuite
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
	

}
