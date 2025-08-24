package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC05_Login_DDT extends BaseClass
{

	@Test(dataProvider = "Login_Data",dataProviderClass = DataProviders.class)
	public void verify_login_ddt(String name, String pwd, String type)
	{
		try
		{
			logger.info("Started TC05 Execution...");
			HomePage hp = new HomePage(driver);
			hp.setUsername(name);
			hp.setPassword(pwd);
			hp.clickSubmit();
			
			LoginPage lp = new LoginPage(driver);
			boolean verificationInfo = lp.getVerificationInfo();
			Assert.assertTrue(verificationInfo);
			
			if(type.equalsIgnoreCase("Valid"))
			{
				if(verificationInfo==true)
				{
					lp.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			if(type.equalsIgnoreCase("Invalid"))
			{
				if(verificationInfo==true)
				{
					lp.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.debug("Execution Failed...Please check logs");
		
		
		
			
	}
	
}
