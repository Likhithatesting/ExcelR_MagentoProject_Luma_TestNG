package PlacingOrderFlow;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class OrderFlow {

	WebDriver driver;

	public OrderFlow(WebDriver idriver) {
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
	public void addCart() {
		
		driver.findElement(By.xpath("//ol[@class='products list items product-items']/child::li[1]")).click();
		driver.findElement(By.id("option-label-size-143-item-169")).click();
		driver.findElement(By.id("option-label-color-93-item-50")).click();
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("2");
		driver.findElement(By.id("product-addtocart-button")).click();
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		driver.findElement(By.id("top-cart-btn-checkout")).click();
		
		
	}
	//Fetching Address from Excel Sheet
	public void fetchAddr() throws IOException {
	String filepath = "D:\\Selenium\\Jyothi Shukla Trainer\\Project\\Majento_LUMA Ecom Project\\Input Data.xlsx";
	FileInputStream fis = new FileInputStream(filepath);
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("Data");
	
	int rows = sheet.getLastRowNum();
	
	for(int r=1;r<=rows;r++) {
		XSSFRow row = sheet.getRow(r);
		XSSFCell Fname = row.getCell(0);
		XSSFCell Lname = row.getCell(1);
		XSSFCell Company = row.getCell(2);
		XSSFCell Address1 = row.getCell(3);
		XSSFCell Address2 = row.getCell(4);
		XSSFCell City = row.getCell(5);
		XSSFCell State = row.getCell(6);
		XSSFCell Zip = row.getCell(7);
		XSSFCell Country = row.getCell(8);
		XSSFCell Phone = row.getCell(9);
		
		try {
		driver.findElement(By.name("firstname")).sendKeys(Fname.toString());
		driver.findElement(By.name("lastname")).sendKeys(Lname.toString());
		driver.findElement(By.name("company")).sendKeys(Company.toString());
		driver.findElement(By.name("street[0]")).sendKeys(Address1.toString());
		driver.findElement(By.name("street[1]")).sendKeys(Address2.toString());
		driver.findElement(By.name("city")).sendKeys(City.toString());
		driver.findElement(By.name("region_id")).sendKeys(State.toString());
		driver.findElement(By.name("postcode")).sendKeys(Zip.toString());
		driver.findElement(By.name("country_id")).sendKeys(Country.toString());
		driver.findElement(By.name("telephone")).sendKeys(Phone.toString());
		driver.findElement(By.name("ko_unique_3")).click();
		
		Alert a = driver.switchTo().alert();
		Thread.sleep(2000);
		a.accept();
		System.out.println("Valid Data");
		}
		catch(Exception e) {
			System.out.println("Invalid Data");
		}
	}
	fis.close();

	}
	
	
}
