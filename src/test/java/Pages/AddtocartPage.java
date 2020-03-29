package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import BasicUtilities.Wait;

public class AddtocartPage {
	WebDriver driver;
	Wait wt;
	public AddtocartPage(WebDriver driver)
	{
		this.driver=driver;
		wt=new Wait(driver);
	}
	
	
	//selecting the Price (low to high) 
	public void SearchLowToHigh()
	{  
		
		WebElement wb=driver.findElement(By.xpath("//select[@class='product_sort_container']"));        
		Select DD=new Select(wb);
		DD.selectByVisibleText("Price (low to high)");       
		
	}
	
    //Clicking the Add to Cart Buttons
	public void AddtocartButton() {         
	for(int i=1;i<=4;i++)
	{
		driver.findElement(By.xpath("//div[@class='inventory_item']["+i+"]//following::button")).click();
	}
		
	}
	
	//Clicking "checkout" button
	public void Basket()
	{
		driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']")).click();
		
		driver.findElement(By.xpath("//a[@class='btn_action checkout_button']")).click();
		
	}
	
	//calling all the methods
	public void TotalAddToCart() 
	{
		this.SearchLowToHigh();
		this.AddtocartButton();
		this.Basket();
	}

}

