package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Basepage{
	
	
	
	public Homepage(WebDriver driver) {
		
		super(driver);
	}

	@FindBy(xpath="//*[@title='My Account']")
	WebElement LnMyaccount;
	
	@FindBy(xpath="(//*[text()='Register'])[1]")
	WebElement LnRegister;
	
	@FindBy(xpath="//*[text()='Login']")
	WebElement LnLogin;
	
	public void clickMyAccount() {
		
		LnMyaccount.click();
	}
	
    public void clickRegister() {
		
    	LnRegister.click();
	}
    
   public void clickLogin() {
		
	   LnLogin.click();
	}
}

