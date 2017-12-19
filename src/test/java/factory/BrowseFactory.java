package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowseFactory {
	 static WebDriver driver;
	
	public static WebDriver getbrowser(String browsername){
		System.out.println("nishant"+browsername);
		if(browsername.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver(); 	
		}
		else if(browsername.equalsIgnoreCase("chrome"))
		{
			ConfigDataProvider config= new ConfigDataProvider();
	
             System.setProperty("webdriver.chrome.driver",config.getchormePathUrl());
		     driver = new ChromeDriver();
		     System.out.println("chrome browser herer");
		} 
		else if(browsername.equalsIgnoreCase("IE"))
		{

			System.setProperty("webdriver.ie.driver",DataProviderFactory.getConfig().getiepathUrl());
		    driver = new InternetExplorerDriver();
			System.out.println("ie for loop"+browsername);

		}
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		    return driver;
	}
	        public static void closeBrowser(WebDriver ldriver){
		    ldriver.quit();	
	}
}
