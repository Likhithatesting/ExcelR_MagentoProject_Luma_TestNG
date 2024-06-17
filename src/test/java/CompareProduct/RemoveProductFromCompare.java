package CompareProduct;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class RemoveProductFromCompare {
	
	WebDriver driver;
		
		public RemoveProductFromCompare(WebDriver idriver) {
		    driver = idriver;
			PageFactory.initElements(driver, this);
		}
		
		public void SignIn() throws InterruptedException {
			driver.findElement(By.linkText("Sign In")).click();
			driver.findElement(By.id("email")).sendKeys("likhitha5@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("Likith@123");
			driver.findElement(By.xpath("//button[@class='action login primary']/child::span")).click();
			Thread.sleep(2000);
		}
		
		public void womenOrder() {
			//To view Womens category of Jackets
			WebElement women = driver.findElement(By.xpath("//nav[@class='navigation']/child::ul/child::li[2]/child::a/child::span[2]"));
			WebElement tops = driver.findElement(By.xpath("//ul[@class='level0 submenu ui-menu ui-widget ui-widget-content ui-corner-all']/child::li/child::a/child::span[2]"));
			WebElement jackets = driver.findElement(By.xpath("//li[@class='level2 nav-2-1-1 category-item first ui-menu-item']/child::a"));
			
			Actions act = new Actions(driver);
			act.moveToElement(women).build().perform();
			act.moveToElement(tops).build().perform();
			act.moveToElement(jackets).build().perform();
			jackets.click();
		}
		//To Add to Compare
		public void addToCompare() throws InterruptedException {
			driver.findElement(By.xpath("//ol[@class='products list items product-items']/child::li[1]")).click();
			driver.findElement(By.xpath("//div[@class='product-addto-links']/a[2]")).click();
			Thread.sleep(2000);
			String msg = driver.findElement(By.xpath("//div[@class='message-success success message']")).getText();
			System.out.println(msg);
			Thread.sleep(2000);
		}
		
		//To view Comparison List after adding to "ADD TO COMPARE"
		public void viewCompareList() throws InterruptedException {
			driver.findElement(By.linkText("comparison list")).click();
			Thread.sleep(2000);
		}
		
		public void removeproduct() throws InterruptedException {
			driver.findElement(By.xpath("//a[@class='action delete']")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//button[@class='action-primary action-accept']/span")).click();
			
			String msg = driver.findElement(By.xpath("//div[@class='message-success success message']")).getText();
			String msg2 = driver.findElement(By.xpath("//div[@class='message info empty']")).getText();
			
			System.out.println(msg);
			System.out.println(msg2);
			
//			Alert a = driver.switchTo().alert();
//			//driver.switchTo().alert().accept(); (For single purpose)
//			a.accept();
		}



}
