package CreateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountwithExistingEmail {
	
	WebDriver driver;

	public CreateAccountwithExistingEmail(WebDriver idriver) {
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
		
		String errmsg = driver.findElement(By.xpath("//div[@class='message-error error message']")).getText();
		System.out.println(errmsg);

	}

}
