package ShoppingListPage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import PageObjects.ShoppingListPage;
import Resources.BaseRepository;

public class ShoppingListPageTest extends BaseRepository {
	
	WebDriver driver;
	
	@BeforeTest()
	public void initialize() throws IOException
	{
		driver = initializer();
	}
	
	@Test(priority=0)
	public void validateShoppingList()
	{
		ShoppingListPage shp = new ShoppingListPage(driver);
		shp.getShoppingList();
		
	}
	

}
