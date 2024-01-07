package PageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	By productList = By.cssSelector(".inventory_item_name ");
	By filter = By.cssSelector(".product_sort_container");
	By filterOptions = By.cssSelector(".product_sort_container option");
	By pricelist = By.cssSelector(".inventory_item_price");
	By Label = By.cssSelector(".inventory_item_description");
	By addCart = By.xpath("//button[text()='Add to cart']");
	
	
	public List<String> getProductList()
	{
		List<WebElement> list=	driver.findElements(productList);
		List<String> actualProductList= new ArrayList();
		
		
		for(WebElement l : list)
		{
			actualProductList.add(l.getText())	;
			System.out.println(l.getText());
		}
		return actualProductList;
	}
	
	public List<String> getPiceList()
	{
		List<WebElement> list=	driver.findElements(pricelist);
		List<String> actualList= new ArrayList();
		
		
		for(WebElement l : list)
		{
			String nm = l.getText();
			actualList.add(nm.split(Pattern.quote("$"))[1]);
			System.out.println("p:"+nm.split(Pattern.quote("$"))[1]);
		}
		return actualList;
	}
	
	
	public List<String> getProductLabel()
	{
		List<WebElement> lists = driver.findElements(Label);
		List<String> productLabel = new ArrayList();
		for(WebElement l : lists)
		{
			productLabel.add(l.getText());
			//System.out.println(l.getText());
		}
		return productLabel;
	}
	
	public List<String> getFilterOptions()
	{
	List<WebElement> list= driver.findElements(filterOptions);
	List<String> filterList = new ArrayList();
	for(WebElement l : list)
	{
		filterList.add(l.getText());
	}
	return filterList;
	}
	
	public void getFilter(String Filter)
	{
		Select filterDropDown = new Select(driver.findElement(filter));
		filterDropDown.selectByVisibleText(Filter);
	}
	
	public List<WebElement> clickAddtoCart()
	{
		List<WebElement> click = driver.findElements(addCart);
		
		return click;
	}

}
