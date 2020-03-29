package TestNgClasses;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasicUtilities.Browsers;
import BasicUtilities.ScreenShots;
import ExcelData.ReadExcel;
import Pages.AboutToTryForFree;
import Pages.AddtocartPage;
import Pages.LoginPage;

public class FirefoxTestNg extends ReadExcel {
	WebDriver driver;

	 Browsers brs;
	 ScreenShots shs;
	 
	 LoginPage LP;
	 AddtocartPage ACP;
	 AboutToTryForFree ATF;
	 
	 String expectedtitle="Swag Labs";
	 String expectedError="Epic sadface: Username and password do not match any user in this service";
	 String expectedmessege="Checkout: Your Information";


	 //Reading data from excel sheet
	 @BeforeClass
	 public void beforeMethod()
	    
	 {
		 GetExcel();
	 }
	 

	 //launching the FIREFOX browser
	 @BeforeMethod
	 public void BrowserLaunch() 
	 {
		brs=new Browsers(); 
		driver=Browsers.LaunchBrowser("FIREFOX","https://www.saucedemo.com/");
		String title=driver.getTitle();
		Assert.assertEquals(title, expectedtitle);
	}
	 
	 
	 
	 //login with valid data.
	 @Test(priority=0)
	 public void Test1() throws IOException {
		 String username=testdata[0][0];
		 String password=testdata[0][1];
		 LP=new LoginPage(driver);             //object intialization for loginpage
		 LP.TotalLogin(username, password);    //method calling totallogin
		 shs=new ScreenShots(driver);          //object intialization for screenshots
         shs.screenShot();                     //method calling screenshots
		 driver.quit();
	 }
	 
	 //login with invalid data.
	 @Test(priority=1)
	 public void Test2() throws IOException{
		 String username=testdata[2][0];
		 String password=testdata[2][1];
		 LP=new LoginPage(driver);
		 LP.TotalLogin(username, password);
		 String Error=driver.findElement(By.xpath("//h3[@data-test='error'] ")).getText();
		 Assert.assertEquals(Error, expectedError);
		 shs=new ScreenShots(driver);
		 shs.screenShot();
		 driver.quit();
	 }
	 
	 //Adding products to cart.
	 @Test(priority=2)
	 public void Test3(){
		 String username=testdata[1][0];
		 String password=testdata[1][1];
		 LP=new LoginPage(driver);
		 LP.TotalLogin(username, password);
		 ACP=new AddtocartPage(driver);
		 ACP.TotalAddToCart();
		 String message=driver.findElement(By.xpath("//div[@class='subheader']")).getText();
		 Assert.assertEquals(message, expectedmessege);
		 driver.quit();
	}
	 
	 //Clicking About and going to "try it free".
	 @Test(priority=3)
	 public void Test4() throws IOException {
		 String username=testdata[1][0];
		 String password=testdata[1][1];
		 LP=new LoginPage(driver);
		 LP.TotalLogin(username, password);
		 ATF=new AboutToTryForFree(driver);
		 ATF.TotalAboutPage();
		 shs=new ScreenShots(driver);
		 shs.screenShot();
		 driver.quit();
		  }
	 
	 
}
