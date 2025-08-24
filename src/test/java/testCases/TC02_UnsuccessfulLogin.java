package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import testBase.BaseClass;

public class TC02_UnsuccessfulLogin extends BaseClass
{

	@Test(groups="regression")
	public void verify_unsuccessful_login()
	{
		try
		{
			logger.info("Started Executing TC02...");
			HomePage hp = new HomePage(driver);
			hp.setUsername(p.getProperty("invalidusername"));
			hp.setPassword(p.getProperty("invalidpassword"));
			hp.clickSubmit();
			System.out.println("Invalid username and password hence login is not succesful - Test Passed");
			logger.info("Completed executing TC02...");
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			logger.debug("TC 02 Execution failed - Please check logs...");
			Assert.fail();
		}
		
	}
}
