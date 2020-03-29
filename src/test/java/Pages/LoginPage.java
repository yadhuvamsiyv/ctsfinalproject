package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUtilities.Browsers;
import BasicUtilities.Wait;

public class LoginPage extends Browsers{
	
	By user=By.xpath("//input[@id='user-name']");
	By password0=By.xpath("//input[@id='password']");
	By login=By.xpath("//input[@class='btn_action']");
	
	WebDriver driver;
	Wait wt;                               // declaring the waitsBrowser

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		wt= new Wait(driver);               // intialization of waits
	}
	
	
	//   Entering the Username
	public void UserName(String name)       
	{
		WebElement wt1=wt.WaitForElement(user,20);         
		wt1.sendKeys(name);
	}
	
	
	// Entering the Password
	public void Password(String password)     
	{
		WebElement wt2=wt.WaitForElement(password0,20);
		wt2.sendKeys(password);
	}
	
	
	//  Clicking the Login Button
	public void ClickButton()                    
	{
		WebElement wt3=wt.WaitForElement(login,20);
		wt3.click();
	}
	
	
	//  Calling all the Login methods
	public  void TotalLogin(String Usrname,String Pswd)      
	{
		System.out.println(Usrname+" "+Pswd);
		this.UserName(Usrname);
		this.Password(Pswd);
		this.ClickButton();
		}
}

