package testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationpage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{
	
	
	
	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {
		
		logger.info("******Starting TC001_AccountRegistrationTest*********");
		
		try
		{
		Homepage homepg =new Homepage(driver);
		homepg.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		
		homepg.clickRegister();
		logger.info("Clicked on Register Link");
		
		AccountRegistrationpage AccountregPage = new AccountRegistrationpage(driver);
		logger.info("Providing Custome Details");
		
		AccountregPage.setFirstname("Keith");
		AccountregPage.setLastname("Adams");
		AccountregPage.setEmail("demo2@zmail.com");
		AccountregPage.setTelephone("9012345679");
		AccountregPage.setPassword("xyz123");
		AccountregPage.setConfirmPassword("xyz123");
		AccountregPage.setPrivacyPolicy();
		AccountregPage.clickContinue();
		
		logger.info("Validating expected message...");
		String confmsg=AccountregPage.getConfirmationMsg();
		
		Assert.assertEquals(confmsg,"Your Account Has Been Created!");
		}
		catch(Exception e) {
		
			logger.error("***Test Failed***");
		}
		
	}

}
