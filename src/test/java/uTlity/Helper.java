package uTlity;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
 
	public static String captureScreenShot(WebDriver driver,String screenShotname){
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		String Destination="C:\\Users\\ASUS-PC\\Desktop\\Nishant\\Maven\\ws_maven_selenium\\com.nexmoney.hybrid\\ScreenShot\\"+screenShotname+System.currentTimeMillis()+".png";
		
		try 
		{
			System.out.println(src);
			FileUtils.copyFile(src,new File(Destination));
		
		} catch (IOException e) 
		{
			System.out.println("Fail to capture ScreenShot"+e.getMessage());
		}
		
		return Destination;
		
	}
	
}
