package BasicUtilities;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browsers {
	
	static WebDriver driver;
	
	public  static WebDriver LaunchBrowser(String browser,String url)
	{
	  if(browser.contains("CHROME"))
		{
		
         //Launching Chrome Browser		
		
			System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("CHROME Browser launched successfully");
		}
		
		//Launching Firefox Browser		
		
			else
			{
			System.setProperty("webdriver.gecko.driver","src\\test\\resources\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			System.out.println("FIREFOX Browser launched successfully");
		
			}
		   
		   driver.get(url);
		   driver.manage().window().maximize();
		   return driver;
	}
}
