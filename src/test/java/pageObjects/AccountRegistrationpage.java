package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationpage extends Basepage{

public AccountRegistrationpage(WebDriver driver) {
		
		super(driver);
	}


      @FindBy(name="firstname")
      WebElement txtFirstname;
      
      @FindBy(name="lastname")
      WebElement txtLastname;
      
      @FindBy(name="email")
      WebElement txtEmail;
      
      @FindBy(name="telephone")
      WebElement txtPhoneno;
      
      @FindBy(name="password")
      WebElement txtPassword;
      
      @FindBy(name="confirm")
      WebElement txtConfirmPassword;
      
      @FindBy(name="agree")
      WebElement chkdPolicy;
      
      @FindBy(xpath="//*[@type='submit']")
      WebElement btnContinue;
      
      @FindBy(xpath="(//*[text()='Your Account Has Been Created!'])[2]")
      WebElement msgConfirmation;
      
      
      public void setFirstname(String fname) {
    	  
    	  txtFirstname.sendKeys(fname);
      }
      
      public void setLastname(String lname) {
    	  
    	  txtLastname.sendKeys(lname);
      }
       
     public void setEmail(String email) {
     	  
    	  txtEmail.sendKeys(email);
       }
     
     public void setTelephone(String telphone) {
    	  
   	  txtPhoneno.sendKeys(telphone);
      }
     
     public void setPassword(String pwd) {
   	  
    	 txtPassword.sendKeys(pwd);
       }
     
     public void setConfirmPassword(String pwd) {
      	  
    	 txtConfirmPassword.sendKeys(pwd);
       }
     
     public void setPrivacyPolicy() {
    	 chkdPolicy.click();
    	 
       }
     
     public void clickContinue() {
    	 btnContinue.click();
    	 
       }
    
     public String getConfirmationMsg() {
    	 try {
    		 return(msgConfirmation.getText());
    	 }catch(Exception e) {
    		 return(e.getMessage());
    	 }
    	 
    	 
     }
     
}
