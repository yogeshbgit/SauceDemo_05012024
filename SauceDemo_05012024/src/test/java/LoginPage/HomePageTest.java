package LoginPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import PageObjects.HomePage;
import Resources.BaseRepository;

public class HomePageTest extends BaseRepository{
	
	WebDriver driver;
	HomePage hp ;
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializer();
		login();
	}
	
	@Test
	public void validateShoppingList()
	{
		
				
	}
	
	
	
	
	
	
	
	//for login Only
	public void login()
	{
		LoginPageTest lpt = new LoginPageTest();
		lpt.driver=driver;
		lpt.validateLoginPage();
	}
	

}
