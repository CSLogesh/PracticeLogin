package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC04_Login_Confirmation_Message extends BaseClass
{

	@Test
	public void verify_confirmationmessage()
	{
		
		try
		{
		logger.info("Started Executing TC 04....");
		HomePage hp = new HomePage(driver);
		hp.setUsername(p.getProperty("validusername"));
		hp.setPassword(p.getProperty("validpassword"));
		hp.clickSubmit();
		
		LoginPage lp = new LoginPage(driver);
		Assert.assertTrue(lp.getVerificationInfo());
		String verificationdetails = lp.getVerificationdetails();
		Assert.assertEquals("Congratulations student. You successfully logged in!", verificationdetails);
		lp.clickLogout();
		logger.info("Completed TC 04 Execution...");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
}
