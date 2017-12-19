package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {
	
	
	WebDriver driver;
	public Homepage(WebDriver ldriver)
	{
		this.driver= ldriver;		 
	}
    @FindBy(xpath=".//a[text()='Login']") WebElement signLink;
    
    @FindBy(xpath=".//a[text()='Women']") WebElement Womenlink;
    
    @FindBy(xpath=".//a[text()='Baby & Kids']") WebElement Babylink;
    
    @FindBy(xpath=".//a[text()='Home Appliances']") WebElement applianceLink; 
    public void clickonsignLink()
    {
    	signLink.click();	
    }
    public void clickonWomenlink()
    {
    	Womenlink.click();	
    }
    public void clickonBabylink()
    {
    	Babylink.click();	
    }
    public void applianceLink()
    {
    	applianceLink.click();	
    }
    public String getApplicationTitle()
    {
		return driver.getTitle();
    	
    }

}
