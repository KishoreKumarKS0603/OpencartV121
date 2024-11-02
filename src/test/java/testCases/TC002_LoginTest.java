package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("******Starting TC_002_LoginTest******");
		
		
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		Loginpage lp=new Loginpage(driver);
		String Loginemail=prop.getProperty("email");
		lp.setEmail(Loginemail);
		
		String Loginpassword=prop.getProperty("password");
		lp.setPassword(Loginpassword);
		
		
		lp.ClickLogin();
		
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean tragetPage=macc.isMyAccountPageExists();
		
		//Assert.assertEquals(tragetPage, true,"Login failed");
		Assert.assertTrue(tragetPage);
		
		
		
		logger.info("******Fineshed TC_002_LoginTest******");
		
	}

}
