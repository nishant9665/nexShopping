package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class Loginpage {
	WebDriver driver;
	
	public Loginpage(WebDriver ldriver){
		this.driver=ldriver;
		
	}
	@FindBy(xpath=".//*[@id='username']") WebElement username;
	
	@FindBy(xpath=".//*[@id='password']") WebElement password;
	
	@FindBy(xpath=".//*[@value='Login']") WebElement signupbutton;
	
    By singout= By.xpath(".//*[@id='page']//a[text()='LOGOUT']");
	
	public void Loginapplications(String user,String pass){
		username.sendKeys(user);
		
		password.sendKeys(pass);
		
		signupbutton.click();
		
	}
	public void VerifySingOutLink()
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(singout));
		System.out.println(ele);
		String text= ele.getText();
		
		
		Assert.assertEquals(text, "");
		
	}

	


}
