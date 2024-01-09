package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseRepository {
	
	public WebDriver driver;
	public Properties pro;
	public Logger logger ;
	
	public WebDriver initializer() throws IOException
	{
		
		pro = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\SHREE\\eclipse-workspace\\SauceDemo_05012024\\src\\main\\java\\Resources\\data.propertis");
		pro.load(file);
		String browser =pro.getProperty("browser");
		String url = pro.getProperty("url");
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(url);
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			
		}
		else
		{
			new Exception("Please Enter Correct Browser");
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	public Logger logger() 
	{
		logger = Logger.getLogger("e-commerce");
		PropertyConfigurator.configure("Log4j.properties");
		return logger;
	}
	

}
