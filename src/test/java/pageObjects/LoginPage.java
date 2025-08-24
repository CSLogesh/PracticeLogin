package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//*[text()='Logged In Successfully']")
	WebElement msg_status;
	
	@FindBy(xpath="//*[text()='Congratulations student. You successfully logged in!']")
	WebElement msg_verification_info;
	
	@FindBy(xpath="//*[text()='Log out']")
	WebElement btn_logout;
	
	public boolean getStatus()
	{
		try
		{
		return(msg_status.isDisplayed()) ;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public boolean getVerificationInfo()
	{
		try
		{
		return(	msg_verification_info.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	
	public void clickLogout()
	{
		btn_logout.click();
	}
	
	public String getVerificationdetails()
	{
		try
		{
		return (msg_verification_info.getText());
		}
		catch(Exception e)
		{
			return null;
		}
	}
}
