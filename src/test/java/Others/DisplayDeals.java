package Others;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DisplayDeals {
	
	WebDriver driver;

	public DisplayDeals(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}
	
	public void Deals() throws InterruptedException {
		
		driver.findElement(By.xpath("//nav[@class='navigation']/ul/li[6]")).click();
		Thread.sleep(2000);
	
		 List<WebElement> resultsList =driver.findElements(By.xpath("//div[@class='categories-menu']"));
			
			for(WebElement result:resultsList) {
				
				   System.out.println(result.getText());
			}
                        
	}
}
