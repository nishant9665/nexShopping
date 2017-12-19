package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Menproduct {
	WebDriver driver;
	
	public Menproduct(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	@FindBy(xpath=".//*[@id='username']") WebElement username;
	
	@FindBy(xpath=".//*[@id='password']") WebElement password;
	
	@FindBy(xpath=".//*[@value='Login']") WebElement signupbutton;
	
	@FindBy(xpath=".//a[text()='Men']") WebElement Menbutton;
	
	@FindBy(xpath=".//a[text()='Casuals']") WebElement causalButton;
	
	@FindBy(xpath=".//*[@id='page']//a[text()='SCHOOLBOY ITALIAN WOOL T-SHIRTS (Peach)']") WebElement shritlink1;

	@FindBy(xpath=".//*[@class='add_bag']") WebElement MenShirt1cart;
	
	@FindBy(xpath=".//*[@id='undefined-sticky-wrapper']//*[text()='shopping bag']") WebElement MenShirt1cart1;
	
	@FindBy(xpath=".//*[@id='undefined-sticky-wrapper']//a[text()='Checkout']") WebElement MenshirtCheckout;

	@FindBy(xpath=".//*[@id='address1']") WebElement addressn;
	
	@FindBy(xpath=".//*[@id='address2']") WebElement addressn2;
	
	@FindBy(xpath=".//*[@id='landmark']") WebElement landmarkn;
	
	@FindBy(xpath=".//*[@id='pincode']") WebElement pincoden;
	
	@FindBy(xpath=".//*[@id='city']") WebElement cityn;
	
	@FindBy(xpath=".//*[@id='state']") WebElement staten;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement continuen;


   // By singout= By.xpath(".//*[@id='page']//a[text()='LOGOUT']");
	
	public void Loginapplications(String user,String pass)
	{
		username.sendKeys(user);
		
		password.sendKeys(pass);
		
		signupbutton.click();	
	}
	public void productpurchesing() 
	{
		    Menbutton.click();
		   driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
			causalButton.click();
			driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
			shritlink1.click();
			driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
			MenShirt1cart.click();
			driver.manage().timeouts().implicitlyWait(05,TimeUnit.SECONDS);
			MenShirt1cart1.click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			MenshirtCheckout.click();		
		
	}
	public void Addressofcustomer(String address1,String address2,String landmark,String pincode,String city,String state)
	{
		addressn.sendKeys(address1);
		addressn2.sendKeys(address2);
		landmarkn.sendKeys(landmark);
		pincoden.sendKeys(pincode);
		cityn.sendKeys(city);
		staten.sendKeys(state);
		
		continuen.click();
	}
	
}