package main;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SimpleLoginTest {
	WebDriver driver;
	
	@Test
	public void test() {

		//Get the driver from the DriverFactory class
		driver= utilities.DriverFactory.get("firefox");
		
		//Open the url
		driver.get("https://the-internet.herokuapp.com/login");
		
		// Enter the username and password
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement((By.xpath("//button[@class='radius']"))).click();
		
		// Get login confirmation
		String conf = driver.findElement(By.tagName("h2")).getText();
		Assert.assertTrue("Login successful", conf.contains("Secure Area"));
		// Close the browser
		driver.quit();
	}

}
