package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC03_LoginStatus_Verification extends BaseClass
{

	@Test
	public void verify_loginstatus_msg()
	{
		try
		{
			logger.info("Started Executing TC 03.....");
			HomePage hp = new HomePage(driver);
			hp.setUsername(p.getProperty("validusername"));
			hp.setPassword(p.getProperty("validpassword"));
			hp.clickSubmit();
			
			LoginPage lp = new LoginPage(driver);
			boolean status = lp.getStatus();	
			Assert.assertTrue(status);
			lp.clickLogout();
			logger.info("Completed executing TC 03....");
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		
	}
}
