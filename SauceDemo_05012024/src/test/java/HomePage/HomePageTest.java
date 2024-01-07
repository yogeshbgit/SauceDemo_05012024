package HomePage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import LoginPage.LoginPageTest;
import PageObjects.HomePage;
import Resources.BaseRepository;

public class HomePageTest extends BaseRepository{
	
	WebDriver driver;
	HomePage hp ;
	List<String> expectedProductList;
	List<String> actualProductList;
	List<String>priceList;
	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializer();
		login();
	}
	
	@Test(priority=0)
	public void validateProductList()
	{
		
		hp = new HomePage(driver);
		expectedProductList = new ArrayList<>(Arrays.asList("Sauce Labs Backpack","Sauce Labs Bike Light","Sauce Labs Bolt T-Shirt","Sauce Labs Fleece Jacket","Sauce Labs Onesie","Test.allTheThings() T-Shirt (Red)"));
		actualProductList = hp.getProductList();		
		if(expectedProductList.size()==actualProductList.size())
		{
			Assert.assertEquals(expectedProductList, actualProductList );
		}
		else
		{
			Assert.assertFalse("Product List size not mathed", true);
		}
	}
	
	
	@Test(priority=1)
	public void validateProductAndtheirPrice()
	{
		priceList=hp.getPiceList();
		List<String>productLabel= hp.getProductLabel();
		for(int i=0;i<actualProductList.size();i++)
		{
			for(int j=i;j<productLabel.size();j++)
			{
				if(productLabel.get(j).contains(actualProductList.get(i)))
				{
					//System.out.println("Product Name matched");
					for(int k=i;k<priceList.size();k++)
					{
						if(productLabel.get(i).contains(priceList.get(k)))
						{
							//System.out.println("Price matched");
						}
						break;
					}
					
				}
				else
				{
					Assert.assertTrue("Product Name Not Matched", false);
				}
				break;
			}
		}
		
	}
	
	
	@Test(priority=2,enabled=false)
	public void validateFilterOption2() throws InterruptedException
	{
		List<String> filterOptions = hp.getFilterOptions();
		String option1 = filterOptions.get(0);
		String option2 = filterOptions.get(1);
		String option3 = filterOptions.get(2);
		String option4 = filterOptions.get(3);
		//System.out.println("option1:"+option1+",option2:"+ option2+",option3:"+option3+",option4:"+option4);
		hp.getFilter(option2);
		Thread.sleep(1000);
		List<String> lists = hp.getProductList();
		Collections.sort(actualProductList,Collections.reverseOrder());
		Assert.assertEquals(actualProductList, lists);
		
	} 
	
	@Test(priority=3,enabled=false)
	public void validateFilterOption3() throws InterruptedException
	{
		List<String> filterOptions = hp.getFilterOptions();
		String option1 = filterOptions.get(0);
		String option2 = filterOptions.get(1);
		String option3 = filterOptions.get(2);
		String option4 = filterOptions.get(3); 
		hp.getFilter(option3);
		Thread.sleep(1000);
		List<String> lists = hp.getPiceList();
		
		Collections.sort(priceList);
		Assert.assertEquals(priceList, lists);
	} 
	
	@Test(priority=4)
	public void validateAddtoCart() throws InterruptedException
	{
		//String productNametoaddCart = "Sauce Labs Fleece Jacket";
		List<String>productTobeAddedCart = new ArrayList<>(Arrays.asList("Sauce Labs Fleece Jacket","Sauce Labs Onesie","Sauce Labs Bike Light","Sauce Labs Backpack"));
		for(int i=0;i<productTobeAddedCart.size();i++)
		{
			for(int j=0;j<actualProductList.size();j++) 
			{
				
				if(actualProductList.get(j).equalsIgnoreCase(productTobeAddedCart.get(i)))
				{
					Thread.sleep(1000);
					hp.clickAddtoCart().get(j).click();
					System.out.println("Product:"+actualProductList.get(j)+" added into cart");
					break;
				}
			}
		}
			
	}
	
	@Test(priority=5)
	public void validateShoppingCart()
	{
		hp.clickOnShoppingCart();
		
		
	}

	@AfterTest(enabled=false)
	public void browserCloser() throws InterruptedException
	{
		Thread.sleep(1500);
		driver.close();
	}
	

	//for login Only
	public void login()
	{
		LoginPageTest lpt = new LoginPageTest();
		lpt.driver=driver;
		lpt.validateLoginPage();
	}
	

}
