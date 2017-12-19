 package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import factory.BrowseFactory;
import factory.DataProviderFactory;
import pages.Homepage;

public class VeryHomepage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp(){
		//System.out.println("this is main page");
		
		 driver=BrowseFactory.getbrowser("chrome");
				
				//System.out.println("this is sss page");
				
		driver.get(DataProviderFactory.getConfig().getappliactionUrl());
				//driver.get(ConfigDataProvider.getappliactionUrl());
		
	}
	
	@Test
	public void testHomepage()
	{
		Homepage home = PageFactory.initElements(driver,Homepage.class);
		
		String title= home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("innovative Ways of Shopping"));
		 
		//System.out.println("My appliaction title is"+title);	
	}
	@AfterMethod
	public void teardown()
	{
		BrowseFactory.closeBrowser(driver);	
	}

}
