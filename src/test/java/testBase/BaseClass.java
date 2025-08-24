package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass

{

	public static WebDriver driver;
	public Properties p;
	public Logger logger ; 

	@BeforeClass(groups= {"sanity","regression"})
	@Parameters({"browser","os"})
	public void setup(String br, String os) throws Exception 
	{
		p= new Properties();
		FileInputStream file = new FileInputStream("./src//test//resources//config.properties");
		p.load(file);
		
		logger = LogManager.getLogger(this.getClass());
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
		
			switch (os.toLowerCase())
			{
			case "windows": capabilities.setPlatform(Platform.WIN11); break ;
			case "mac": capabilities.setPlatform(Platform.MAC); break ;
			case "linux": capabilities.setPlatform(Platform.LINUX); break ;
			default : System.out.println("No matching OS..."); return;
			}
			
			switch(br.toLowerCase())
			{
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "firefox": capabilities.setBrowserName("Firefox"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			default: System.out.println("No Matching Browser..");return;
			}
			
			driver= new RemoteWebDriver(new URL("http://localhost:4444"), capabilities);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome": driver = new ChromeDriver(); break ;
			case "firefox": driver = new FirefoxDriver(); break ;
			default : System.out.println("Invalid Browser details"); return;
			}	
		}
		

		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass(groups= {"sanity","regression"})
	public void teardown() 
	{
		driver.quit();
	}
	
	
	public String captureScreen(String tname)
	{
		String timestamp = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss").format(new Date());
		
		TakesScreenshot tks = (TakesScreenshot) driver;
		File srcfile = tks.getScreenshotAs(OutputType.FILE);
		String targetfilepath = ".//screenshots//"+" tname "+" - "+timestamp+" .png";
		File trgfile = new File(targetfilepath);
		srcfile.renameTo(trgfile);
		
		return targetfilepath;
	}
	
	

}
