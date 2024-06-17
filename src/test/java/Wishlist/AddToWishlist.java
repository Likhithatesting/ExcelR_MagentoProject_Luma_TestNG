package Wishlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class AddToWishlist {
	
	WebDriver driver;
	
	public AddToWishlist(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}
	
	public void SignIn() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("likhitha4@gmail.com");
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
	
	//Add to Wishlist
	public void addWishlist() throws InterruptedException {
		
		driver.findElement(By.xpath("//ol[@class='products list items product-items']/child::li[1]")).click();
		driver.findElement(By.xpath("//div[@class='product-addto-links']/a/span")).click();
		Thread.sleep(5000);
		
		//Add to Cart from WishList to display error message
		driver.findElement(By.xpath("//div[@data-bind='visible: isShowAddToCart']/button/span")).click();
		WebElement errormsg = driver.findElement(By.xpath("//div[@class='message-error error message']"));
		
		if(errormsg.isDisplayed()) {
			
			System.out.println("Error Message: ------------------"+errormsg.getText()+"-------------------");
			
		}
		
		
	}

}
