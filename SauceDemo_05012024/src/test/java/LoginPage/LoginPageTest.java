package LoginPage;

import java.io.IOException;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Resources.BaseRepository;

public class LoginPageTest extends BaseRepository{
	
	
	public WebDriver driver;
	LoginPage lp;
	Logger log;
	
	@BeforeTest()
	public void initialize() throws IOException
	{
		driver=initializer();
		log=logger();
		log.info("Browser Invoked");
	}
	
	@Test(priority=0)
	public void validateTitle()
	{
		String expectedTitle = "Swag Labs";
		String actualTitle =driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		log.info("Validating Title");
	}
	
	
	@Test(priority=1)
	public void validateLoginPage()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("standard_user");
		log.info("Entered User Name");
		lp.enterPassword("secret_sauce");
		log.info("Entered Password");
		lp.clickOnLoginButton();
		log.info("Clicked On Login Button");
	}

	
	@AfterTest
	public void browserCloser()
	{
		driver.close();
		log.info("Browser Closed");
	}
}
