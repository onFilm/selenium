package dataDrivenTesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginWithTestNG {
WebDriver driver;
String url="https://the-internet.herokuapp.com/login";

	@Test(dataProvider ="getData")
	public void test(String username, String password) {
		
		// Enter the username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement((By.xpath("//button[@class='radius']"))).click();
		
		// Get login confirmation
		String conf = driver.findElement(By.tagName("h2")).getText();
		Assert.assertEquals(conf,"Secure Area","Assert statement");

	}
	
	@DataProvider
	public String[][] getData() {
		return utilities.EXCEL.get(System.getProperty("user.dir")+ "\\data\\Userlogin.xls");
	}
	
	@BeforeMethod
	public void setup() {
		//Get the driver from the DriverFactory class and Open the url
		driver= utilities.DriverFactory.get("chrome");
		driver.get(url);
		
	}

	@AfterMethod
	public void tearDown() {
		// Close the browser
		driver.quit();
	}
	
	
	
	
	
	
}
