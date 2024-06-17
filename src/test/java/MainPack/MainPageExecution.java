package MainPack;

import java.io.IOException;
import java.time.Duration;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import Cart.RemoveFromCart;
import CompareProduct.AddToCompare;
import CompareProduct.RemoveProductFromCompare;
import CreateAccount.CreateAccount;
import CreateAccount.CreateAccountwithExistingEmail;
import CreateAccount.SignInIncorrect;
import Filters.ApplyFilters;
import Others.DisplayDeals;
import Others.GridSelect;
import PlacingOrderFlow.OrderFlow;
import PlacingOrderFlow.OrderWithLogin;
import PlacingOrderFlow.OrderWithOutLogin;
import PlacingOrderFlow.SignInBeforeCheckOut;
import PlacingOrderFlow.SignInWhileCheckOut;
import VerifyTitlePage.VerifyTitleAndURL;
import Wishlist.AddToWishlist;
import Wishlist.AddToWishlistWithOutLogin;
import Wishlist.MoveToWishlistFromCart;

public class MainPageExecution {
	
	WebDriver driver;
	
	@Test
	public void mainTest() throws InterruptedException, IOException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		CreateAccount acc= new CreateAccount(driver);
		CreateAccountwithExistingEmail caee = new CreateAccountwithExistingEmail(driver);
		VerifyTitleAndURL vt = new VerifyTitleAndURL(driver);
		OrderFlow of = new OrderFlow(driver);
		OrderWithLogin owl = new OrderWithLogin(driver);
		OrderWithOutLogin owol = new OrderWithOutLogin(driver);
		SignInBeforeCheckOut sbc = new SignInBeforeCheckOut(driver);
		SignInWhileCheckOut swc = new SignInWhileCheckOut(driver);
		AddToWishlist aw = new AddToWishlist(driver);
		AddToWishlistWithOutLogin awwol = new AddToWishlistWithOutLogin(driver);
		RemoveFromCart rc = new RemoveFromCart(driver);
		MoveToWishlistFromCart awfc = new MoveToWishlistFromCart(driver);
		AddToCompare atc = new AddToCompare(driver);
		RemoveProductFromCompare rpfc = new RemoveProductFromCompare(driver);
		ApplyFilters ap = new ApplyFilters(driver);
		SignInIncorrect si = new SignInIncorrect(driver);
		GridSelect gs = new GridSelect(driver);
		DisplayDeals dd = new DisplayDeals(driver);
	
		
		acc.createacc();
		acc.signOut();
		acc.SignIn();
		acc.closeBrowser();
	
		
		caee.createacc();
		
		vt.url();
		vt.verifyHomePageTitle();
		vt.verifyCurrentURL();
		vt.searchBar();
		vt.linksList();
		vt.closeBrowser();
		
		of.womenOrder();
		of.addCart();
		of.fetchAddr();
		
		owl.SignIn();
		owl.womenOrder();
		owl.addCart();
		owl.placeorder();
		owl.orderConfirmation();
		
	
		owol.womenOrder();
		owol.addCart();
		owol.placeorder();
		
		swc.womenOrder();
		swc.addCart();
		swc.placeorder();
		
		sbc.womenOrder();
		sbc.addCart();
		sbc.placeorder();
		
		aw.SignIn();
		aw.womenOrder();
		aw.addWishlist();
		
		awwol.womenOrder();
		awwol.addWishlist();
		
		rc.SignIn();
		rc.womenOrder();
		rc.addCart();
		rc.removeCart();
		rc.hereLink();
		
		awfc.SignIn();
		awfc.womenOrder();
		awfc.addCart();
		awfc.moveToWishlist();
		
		atc.SignIn();
		atc.womenOrder();
		atc.addToCompare();
		atc.viewCompareList();
	
		rpfc.SignIn();
		rpfc.womenOrder();
		rpfc.addToCompare();
		rpfc.viewCompareList();
		rpfc.removeproduct();
		
		ap.SignIn();
		ap.womenOrder();
		ap.filter();
	
		si.SignIn();
	
		gs.womenOrder();
		gs.gridSelect();
		
		dd.Deals();

		
	}

	
	@AfterTest 
	public void closeBrowser() throws InterruptedException {
	 
	Thread.sleep(7000); 
	driver.close(); 
	}


	}
