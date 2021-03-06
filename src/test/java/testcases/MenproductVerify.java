package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;
import factory.BrowseFactory;
import factory.DataProviderFactory;
import pages.Homepage;
import pages.Loginpage;
import pages.Menproduct;

public class MenproductVerify {
	
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp(){
		driver=BrowseFactory.getbrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getappliactionUrl());
				//driver.get(ConfigDataProvider.getappliactionUrl());	
	}
	
	@Test
	public void testHomepage()
	{
		Homepage home = PageFactory.initElements(driver,Homepage.class);
		
		String title= home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("innovative Ways of Shopping"));
		
		home.clickonsignLink();
		
	    driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);

		
		Loginpage login=PageFactory.initElements(driver,Loginpage.class);
		 //System.out.println("cant find any excel value");
		
		login.Loginapplications("testpriya","testpriya");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Menproduct productpurches=PageFactory.initElements(driver,Menproduct.class);

		driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
		
		productpurches.productpurchesing();
		
		Menproduct Address=PageFactory.initElements(driver,Menproduct.class);
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		Address.Addressofcustomer("pimpleGurav", "ramkrushana", "shivlok", "411061", "pune","maharashtra");

		
	// login.Loginapplications(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		 //this is method for direct call not using excel
		//System.out.println("cant kkkkc find any excel value");
		//System.out.println("My appliaction title is"+title);	
	//login.VerifySingOutLink(); 
	//	login.v
	}
	@AfterMethod
	public void teardown()
	{
		BrowseFactory.closeBrowser(driver);	
	}

}
