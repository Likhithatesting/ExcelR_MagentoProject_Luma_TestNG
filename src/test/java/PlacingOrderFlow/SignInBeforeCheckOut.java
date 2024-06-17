package PlacingOrderFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class SignInBeforeCheckOut {
              
	WebDriver driver;
	
	public SignInBeforeCheckOut(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
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
	
	//View product and Add to cart - with Size, Color, Quantity
		public void addCart() throws InterruptedException {
			
			driver.findElement(By.xpath("//ol[@class='products list items product-items']/child::li[1]")).click();
			driver.findElement(By.id("option-label-size-143-item-169")).click();
			driver.findElement(By.id("option-label-color-93-item-50")).click();
			driver.findElement(By.id("qty")).clear();
			driver.findElement(By.id("qty")).sendKeys("2");
			driver.findElement(By.id("product-addtocart-button")).click();
			Thread.sleep(5000);
			
		}
		
		public void placeorder() throws InterruptedException {
			
			//Sign In before checkout
			driver.findElement(By.linkText("Sign In")).click();
			driver.findElement(By.id("email")).sendKeys("likhitha4@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("Likith@123");
			driver.findElement(By.xpath("//button[@class='action login primary']/child::span")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//a[@class='action showcart']")).click();
			driver.findElement(By.id("top-cart-btn-checkout")).click();
			Thread.sleep(3000);
			
			//To select the shipment method
			driver.findElement(By.name("ko_unique_1")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//form[@id='co-shipping-method-form']/div[3]/div/button")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='payment-method _active']/div[2]/div[4]/div/button")).click();
			
		}


}
