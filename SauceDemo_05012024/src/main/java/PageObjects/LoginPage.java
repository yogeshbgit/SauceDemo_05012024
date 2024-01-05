package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	By userName = By.id("user-name");
	By password = By.id("password");
	By loginButton = By.id("login-button");
	
	
	public void enterUserName(String username)
	{
		driver.findElement(userName).sendKeys(username);
	}
	
	public void enterPassword(String pass)
	{
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
}
