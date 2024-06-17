package Wishlist;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class AddToWishlistWithOutLogin {
WebDriver driver;
	
	public AddToWishlistWithOutLogin(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}
	
	//To view Womens category of Jackets
	public void womenOrder() {
		
		WebElement women = driver.findElement(By.xpath("//nav[@class='navigation']/child::ul/child::li[2]/child::a/child::span[2]"));
		WebElement tops = driver.findElement(By.xpath("//ul[@class='level0 submenu ui-menu ui-widget ui-widget-content ui-corner-all']/child::li/child::a/child::span[2]"));
		WebElement jackets = driver.findElement(By.xpath("//li[@class='level2 nav-2-1-1 category-item first ui-menu-item']/child::a"));
		
		Actions act = new Actions(driver);
		act.moveToElement(women).build().perform();
		act.moveToElement(tops).build().perform();
		act.moveToElement(jackets).build().perform();
		jackets.click();
	}
	
	//Add to Wishlist without Login - Error message need to display to login
	public void addWishlist() throws InterruptedException {
		
		driver.findElement(By.xpath("//ol[@class='products list items product-items']/child::li[1]")).click();
		driver.findElement(By.xpath("//div[@class='product-addto-links']/a/span")).click();
		Thread.sleep(5000);
		
		//To display error message: You must login or register to add items to your wishlist.
		WebElement error = driver.findElement(By.xpath("//div[@class='message-error error message']"));
		
		System.out.println(error.getText());
		
	}

}
