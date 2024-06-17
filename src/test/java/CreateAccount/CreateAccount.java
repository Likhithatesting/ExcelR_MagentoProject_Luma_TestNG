package CreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

	WebDriver driver;
	
	

	public CreateAccount(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='panel header']/child::ul/child::li[3]/child::a") WebElement acct;
	
	//To create an Account
	public void createacc() {
		acct.click();
		driver.findElement(By.id("firstname")).sendKeys("Likhitha");
		driver.findElement(By.id("lastname")).sendKeys("Papari");
		driver.findElement(By.name("email")).sendKeys("likhitha5@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Likith@123");
		driver.findElement(By.name("password_confirmation")).sendKeys("Likith@123");
		driver.findElement(By.xpath("//button[@class='action submit primary']/child::span")).click();

	}

	//To SignOut after creating account
	public void signOut() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='panel header']/child::ul/child::li[2]/child::span")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
	}
	
	//To SignIn After SignOut
	
	public void SignIn() {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("likhitha22@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Likith@123");
		driver.findElement(By.xpath("//button[@class='action login primary']/child::span")).click();
	}

	//To Close the Browser
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		
	}
}
