package PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ShoppingListPage {
	
	WebDriver driver;
	 
	public ShoppingListPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By shoppingListProduct= By.xpath("//div[@class='cart_list']//ancestor::div[@class='inventory_item_name']");
	
	
	public void getShoppingList()
	{
		List<WebElement> list = driver.findElements(shoppingListProduct);
		List<String> shoppingList = new ArrayList();
		for(WebElement l:list)
		{
			shoppingList.add(l.getText());
			System.out.println("shopping List"+l.getText());
		}
	}
	
}
