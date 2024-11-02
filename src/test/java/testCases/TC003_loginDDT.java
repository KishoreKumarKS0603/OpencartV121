package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_loginDDT extends BaseClass{
	
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DataDriven")
	public void verify_LoginDDT(String email,String pwd,String exp)
	{
		logger.info("******Starting TC003_loginDDT******");

		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		Loginpage lp=new Loginpage(driver);
	    lp.setEmail(email);
		lp.setPassword(pwd);
		lp.ClickLogin();
		
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean tragetPage=macc.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(tragetPage==true)
			{
				Assert.assertTrue(true);
				macc.clickLogout();
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(tragetPage==true)
			{
				macc.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}

}
