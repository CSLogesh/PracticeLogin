package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	
	// Locators
	
	@FindBy(xpath="//*[@id='username']")
	WebElement txt_username;
	
	@FindBy(xpath="//*[@id='password']")
	WebElement txt_password;
	
	@FindBy(xpath="//*[@id='submit']")
	WebElement btn_submit;
	
	
	
	// Action Methods 
	
	public void setUsername(String name)
	{
		txt_username.sendKeys(name);
	}
	
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		txt_password.click();
	}
	
}
