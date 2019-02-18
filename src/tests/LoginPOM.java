package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.ConfPage;
import pages.LoginPage;


public class LoginPOM {
	WebDriver driver;
	String url="https://the-internet.herokuapp.com/login";
	
	@Test
	public void runLoginTest() {
		
		
		// 1. Initialize the login page 
			LoginPage loginPage = new LoginPage(driver);
		
		// 2. run the test steps
			loginPage.setUsername("tomsmith");
			loginPage.setPassword("SuperSecretPassword!");
			loginPage.clickSubmit();
		
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
