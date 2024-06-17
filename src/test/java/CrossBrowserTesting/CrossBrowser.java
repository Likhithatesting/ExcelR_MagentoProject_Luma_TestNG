package CrossBrowserTesting;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser {
	
	WebDriver driver;
	// To launch Magento LUMA URL is different browsers parallel
	@Parameters("Browser")
	
	@Test
	public void launchBrowser(String Browser) {
		
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
			
		}
	
	
	@Test
	public void launchURL() {
		driver.get("https://magento.softwaretestingboard.com");
	}

}
