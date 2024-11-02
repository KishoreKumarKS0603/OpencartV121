package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepage{

public Loginpage(WebDriver driver) {
		
		super(driver);
	}

    @FindBy(xpath="//*[@id='input-email']")
    WebElement txtEmailAddress;
    
    @FindBy(xpath="//*[@id='input-password']")
    WebElement txtEmailpassword;
    
    @FindBy(xpath="//*[@value='Login']")
    WebElement btnLogin;
   
    public void setEmail(String email) {
    	txtEmailAddress.sendKeys(email);
    }

    public void setPassword(String Password) {
    	txtEmailpassword.sendKeys(Password);
    }
    
    public void ClickLogin() {
    	btnLogin.click();
    }

}
