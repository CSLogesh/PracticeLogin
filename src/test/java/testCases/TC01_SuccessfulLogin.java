package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC01_SuccessfulLogin extends BaseClass
{
	
	@Test(groups="sanity")
	public void verify_successful_login()
	{
		try
		{
		logger.info("Started executing TC01");
		HomePage hp = new HomePage(driver);
		hp.setUsername(p.getProperty("validusername"));
		hp.setPassword(p.getProperty("validpassword"));
		hp.clickSubmit();
		
		LoginPage lp = new LoginPage(driver);
		lp.clickLogout();
		System.out.println("TC 01 Completed - Successfully Logged in...");
		logger.info("Completed executing TC01");
		Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			logger.debug("TC01 Failed - please check logs");
			Assert.fail();
		}
	}
	
	

}
