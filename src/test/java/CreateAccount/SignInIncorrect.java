package CreateAccount;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignInIncorrect {
	
WebDriver driver;
	
	public SignInIncorrect(WebDriver idriver) {
		driver = idriver;
		PageFactory.initElements(driver, this);
	}
	
	//Sign In with incorrect details using Data Driven
	public void SignIn() throws InterruptedException, IOException {
		
		driver.findElement(By.linkText("Sign In")).click();
		
		String filepath = "D:\\Selenium\\Jyothi Shukla Trainer\\Project\\Majento_LUMA Ecom Project\\Input Data.xlsx";
		FileInputStream fis = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("SignIn");
		
		int rows = sheet.getLastRowNum();
		
		for(int r=1;r<=rows;r++) {
			XSSFRow row = sheet.getRow(r);
			XSSFCell Email = row.getCell(0);
			XSSFCell pswd = row.getCell(1);
			
			try {
			driver.findElement(By.id("email")).sendKeys(Email.toString());
			driver.findElement(By.id("pass")).sendKeys(pswd.toString());
			driver.findElement(By.xpath("//button[@class='action login primary']/child::span")).click();
			Thread.sleep(2000);
			
			System.out.println("Valid Data");
			}
			catch(Exception e) {
				System.out.println("Invalid Data");
			}
		System.out.println(driver.findElement(By.xpath("//div[@class='message-error error message']")).getText());
		}
		fis.close();

		}
		

}
