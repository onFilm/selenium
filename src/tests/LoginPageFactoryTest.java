package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.ConfPage;
import pages.LoginPageFactory;

public class LoginPageFactoryTest {
	
	WebDriver driver;
	String url="https://the-internet.herokuapp.com/login";
	String username = "tomsmith";
	String password = "SuperSecretPassword!";
	
	@Test
	public void runLoginTest() {
		
		
		// 1. Initialize the login page factory 
			LoginPageFactory loginPage = new LoginPageFactory(driver);
		
		// 2. run the test steps by calling login method
			loginPage.login(username, password);
		
		// 3. get confirmation
			ConfPage confPage = new ConfPage(driver);
			Assert.assertEquals(confPage.getConfMessage(),"Secure Area","Assert statement");

	}
	
	
	@Before
	public void setup() {
		//Get the driver from the DriverFactory class and Open the url
		driver= utilities.DriverFactory.get("chrome");
		driver.get(url);
		
	}

	@After
	public void tearDown() {
		// Close the browser
		driver.quit();
	}

}
