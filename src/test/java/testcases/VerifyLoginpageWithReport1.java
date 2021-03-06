package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;
import factory.BrowseFactory;
import factory.DataProviderFactory;
import pages.Homepage;
import pages.Loginpage;
import uTlity.Helper;

public class VerifyLoginpageWithReport1 {
	WebDriver driver;
	ExtentReports repot;
	ExtentTest   logger;
	
	@BeforeMethod
	public void SetUp()
	{   repot= new ExtentReports("./Reports/LoginpageReport.html",true);
	
	    logger=repot.startTest("Verify Test Login");
	
		driver=BrowseFactory.getbrowser("chrome");
		
		driver.get(DataProviderFactory.getConfig().getappliactionUrl());
		
		logger.log(LogStatus.INFO, "Application up and running");
	}
	
	@Test
	public void testHomepage()
	{
		Homepage home = PageFactory.initElements(driver,Homepage.class);
		
		String title= home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("innovative Ways of Shopping"));
		
		logger.log(LogStatus.PASS, "Home page Loaded and Verified");

		
		home.clickonsignLink();
		
		logger.log(LogStatus.INFO, "Click on sing out Link");

		
	    driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);

		
		Loginpage login=PageFactory.initElements(driver,Loginpage.class);
		
		 
	     login.Loginapplications(DataProviderFactory.getExcel().getData(0, 0, 0),DataProviderFactory.getExcel().getData(0, 0, 1));
		 	
			logger.log(LogStatus.INFO, "fill the Test data");

	     
	login.VerifySingOutLink(); 
	
	logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenShot(driver, "validation2")));
	
	logger.log(LogStatus.PASS, "singout link is present");

	
	}
	@AfterMethod
	
	public void teardown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=Helper.captureScreenShot(driver, result.getName());
			logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
		}
		BrowseFactory.closeBrowser(driver);	
		repot.endTest(logger);
		repot.flush();
	}

}
