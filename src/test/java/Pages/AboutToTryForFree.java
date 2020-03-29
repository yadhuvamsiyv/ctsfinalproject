package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import BasicUtilities.Wait;

public class AboutToTryForFree {

	
	WebDriver driver;
	Wait wt;

	public AboutToTryForFree(WebDriver driver)
	{
		this.driver=driver;
		wt = new Wait(driver);
		
	}
	//clicking corner button
	public void linkForAboutPage() 
	{
		System.out.println("link clicked");
		driver.findElement(By.xpath("//div[@class='bm-burger-button']")).click();	
	}
	
	//clicking About
	public void AboutSaucedemo(){
		
		wt.Sleep(100);
		driver.findElement(By.xpath("//nav[@class='bm-item-list']//child::a[2]")).click();
		
	}
	
	//clicking "Try it Free"
	public void TryForFree()
	{
		wt.Sleep(100);
		driver.findElement(By.xpath("//a[@class='button is-rounded is-secondary']")).click();
		
	}
	
	//clicking "Sign-in"
	public void Signin()
	{
		driver.findElement(By.xpath("//a[@class='button is-rounded is-primary is-small']")).click();
	}
	
	//calling all the methods
	public void TotalAboutPage() 
	{
        this.linkForAboutPage();
		this.AboutSaucedemo();
		this.TryForFree();
		this.Signin();
	}
	
	

}

