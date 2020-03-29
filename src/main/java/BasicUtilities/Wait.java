package BasicUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	static WebDriver driver;
	WebElement WE;
	
	public Wait(WebDriver driver)
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

//function for waiting for the element visibility
	public WebElement WaitForElement(By password0,int timeout)
	{
		
		try
		{
		WebDriverWait WDW= new WebDriverWait(driver,timeout);
		WE=WDW.until(ExpectedConditions.visibilityOfElementLocated(password0));
		return WE;
		}
		catch (Exception e)
		{
			System.out.println("No_element_found");
			return null;
		}
		}
	
	
//function for waiting for element to be clickable
	public WebElement WaitForClickable(By locator,int timeout)
	{
		
		try
		{
		WebDriverWait WDW= new WebDriverWait(driver,timeout);
		WE=WDW.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return WE;
		}
		catch (Exception e)
		{
			System.out.println("No_element_found");
			return null;
		}
		}
	
	
//make a eclipse sleep for a while
	public void Sleep(int time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
	}
