package PlacingOrderFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrderWithLogin {
	WebDriver driver;
	
	public OrderWithLogin(WebDriver idriver) {
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
			driver.findElement(By.xpath("//a[@class='action showcart']")).click();
			driver.findElement(By.id("top-cart-btn-checkout")).click();
			Thread.sleep(3000);
			
			// To click on New Address if address already exist
			driver.findElement(By.xpath("//div[@class='new-address-popup']/button/span")).click();
			Thread.sleep(2000);
			
			 driver.findElement(By.name("firstname")).clear();
			 driver.findElement(By.name("firstname")).sendKeys("Likhitha");
			 driver.findElement(By.name("lastname")).clear();
			 driver.findElement(By.name("lastname")).sendKeys("P");
			 driver.findElement(By.name("company")).sendKeys("CG");
			 driver.findElement(By.name("street[0]")).sendKeys("713 Seminole Ridge Rd");
			 driver.findElement(By.name("street[1]")).sendKeys("Melrose");
			 driver.findElement(By.name("street[2]")).sendKeys("Florida(FL)");
			 driver.findElement(By.name("city")).sendKeys("Melrose");
			 
			 //To select from drop down
			 Select region = new Select(driver.findElement(By.name("region_id")));
			 region.selectByVisibleText("Florida");
			 
			 driver.findElement(By.name("postcode")).sendKeys("32666");
			 
			 //To select from drop down
			 Select country = new Select(driver.findElement(By.name("country_id")));
			 country.selectByVisibleText("United States");
			 
			 driver.findElement(By.name("telephone")).sendKeys("9876898712");
			 
			 //To Un-Check the Save in Address Book
			 driver.findElement(By.xpath("//input[@class='checkbox']")).click();
			 
			 
			 //To click on Ship Here
			 driver.findElement(By.xpath("//button[@class='action primary action-save-address']/span")).click();
			 
			
			//To select the shipment method
			driver.findElement(By.name("ko_unique_3")).click();
			Thread.sleep(5000);
			
			//To go to Next Page
			driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']/div/button/span")).click();
			Thread.sleep(5000);
			
			//To Place Order
			driver.findElement(By.xpath("//button[@class='action primary checkout']/span")).click();
			Thread.sleep(5000);
		}
		
		//To display Order Confirmation Message and Print Receipt
		public void orderConfirmation() {
			
			driver.findElement(By.xpath("//div[@class='page-title-wrapper']/a")).click();
			
			WebElement msg = driver.findElement(By.xpath("//div[@class='page-title-wrapper']/h1"));
				System.out.println(msg.getText());
				
			WebElement orderID = driver.findElement(By.xpath("//div[@class='checkout-success']/child::p"));
			if(orderID.isDisplayed()) {
				System.out.println(orderID.getText());
			}
			else {
				System.out.println("Order ID not found");
			}
			
			WebElement para = driver.findElement(By.tagName("p"));
			System.out.println(para.getText());
			
		}
		
		

}
