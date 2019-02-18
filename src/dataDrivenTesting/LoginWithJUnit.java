package dataDrivenTesting;


import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


@RunWith(value = Parameterized.class)
public class LoginWithJUnit {
WebDriver driver;
String url="https://the-internet.herokuapp.com/login";

String username, password;
WebElement usernameElement, passwordElement, buttonElement;

	//This is the main test method
	@Test
	public void test() {
		
		System.out.println("NEW RECORD : " + username + " " + password);
		
		// Define elements
		defineWebElements();
		
		// Enter the username and password
		usernameElement.sendKeys(username);
		passwordElement.sendKeys(password);
		buttonElement.click();
		
		// Get login confirmation
		String conf = driver.findElement(By.tagName("h2")).getText();
		Assert.assertTrue("Assert Statement", conf.equals("Secure Area"));

	}
	
	//This is annotated method is designed to pass parameter into the class via constructor 
	@Parameters
	public static List<String[]> getData() {
		return utilities.CSV.get(System.getProperty("user.dir")+ "\\data\\data.csv");
	}
	
	//Constructor that passes data from parameter to the test method
	public LoginWithJUnit(String username, String password) {
		this.username = username;
		this.password = password;
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
	
	public void defineWebElements () {
		 usernameElement = driver.findElement(By.id("username"));
		 passwordElement = driver.findElement(By.id("password"));
		 buttonElement = driver.findElement((By.xpath("//button[@class='radius']")));
	}
	
	
	
	
}
