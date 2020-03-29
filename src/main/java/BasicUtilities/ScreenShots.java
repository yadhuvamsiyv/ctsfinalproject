package BasicUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShots {
	
	static int count=1;
	WebDriver driver;
	
	public ScreenShots( WebDriver driver)
	{
		this.driver=driver;
	}
	
//Function to take Screenshot 
		
	public  void screenShot() throws IOException
		{
			String Path="src//test//resources//screenshots//";
		
			String file_name="Screenshot"+count+".png";
			File f1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File f2= new File(Path+file_name);
			FileUtils.copyFile(f1,f2);
			count++;
		}

}
