package Filters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class ApplyFilters {
	
WebDriver driver;
	
	public ApplyFilters(WebDriver idriver) {
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
	
	//Applying filters
	
	public void filter() throws InterruptedException {
		//To Select Style
		driver.findElement(By.xpath("//div[@class='filter-options']/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='layered-filter-block']/div[2]/div/div[1]/div[2]/ol/li[3]/a")).click();
		Thread.sleep(2000);
		
		//To Select Color
		driver.findElement(By.xpath("//div[@class='filter-options']/div[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='swatch-attribute swatch-layered color']/div/a[5]/div")).click();
		
		
		
	}



}
