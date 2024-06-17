package VerifyTitlePage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerifyTitleAndURL {

	WebDriver driver;

	public VerifyTitleAndURL(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}

	public void url() {
		driver.get("https://magento.softwaretestingboard.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	// To Verify Home Page Title
	public void verifyHomePageTitle() {

		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(ActualTitle, ActualTitle);
	}

	// Verify Current URL for What's New
	public void verifyCurrentURL() {
		driver.findElement(By.linkText("What's New")).click();
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://magento.softwaretestingboard.com/what-is-new.html");
		System.out.println(URL);

		if (URL.equalsIgnoreCase("https://magento.softwaretestingboard.com/what-is-new.html")) {
			System.out.println("URL is matching");
		} else {
			System.out.println("URL is not matching");
		}

	}
	
	
	//Verify Search bar is Enabled in Home Page
	public void searchBar() {
		WebElement search = driver.findElement(By.id("search"));
		if(search.isEnabled()) {
			search.click();
			System.out.println("Search Bar is enabled");
		}
		else {
			System.out.println("Search Bar is not enabled");
		}
		//To search the Product
		search.sendKeys("Juno Jacket");
		search.sendKeys(Keys.ENTER);
		
	}

	// Verify No. of Links in Home Page
	public void linksList() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for(int i=0; i<links.size();i++) {
			String linkname = links.get(i).getText();
			System.out.println(i+". "+linkname);
		}
	}

	// To Close the Browser
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();

	}

}
