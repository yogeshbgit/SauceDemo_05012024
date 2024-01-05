package LoginPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import Resources.BaseRepository;

public class LoginPageTest extends BaseRepository{
	
	
	WebDriver driver;
	LoginPage lp;
	
	@BeforeTest()
	public void initialize() throws IOException
	{
		driver=initializer();
	}
	
	@Test(priority=0)
	public void validateLoginPage()
	{
		lp = new LoginPage(driver);
		lp.enterUserName("standard_user");
		lp.enterPassword("secret_sauce");
		lp.clickOnLoginButton();
	}

	
	@AfterTest
	public void browserCloser()
	{
		driver.close();
	}
}
