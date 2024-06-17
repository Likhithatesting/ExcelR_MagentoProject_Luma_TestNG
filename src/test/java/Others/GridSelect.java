package Others;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class GridSelect {
	
	WebDriver driver;

	public GridSelect(WebDriver idriver) {
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
	
	//To view products in Grid
	public void gridSelect(){
		
		driver.findElement(By.id("mode-list")).click();
	}

}
