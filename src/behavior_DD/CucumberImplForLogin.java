package behavior_DD;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberImplForLogin {
	WebDriver driver;	
	
		@Given("^setUp$")
		public void setup() {
			//Get the driver from the DriverFactory class and Open the url
			driver= utilities.DriverFactory.get("chrome");			
		}

	
		@And("^User is in login app$")
		public void login() {
			driver.get("https://the-internet.herokuapp.com/login");
		}
		
	    @When("^User enter correct user id$")
	    public void setUsername_hardcoded() {
	    	driver.findElement(By.id("username")).sendKeys("tomsmith");
	    }
	    
	    @And("^User enter correct password$")
	    public void setPassword_hardcoded() {
	    	driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	    }
	    
	    
	    //Parameterized username and password using cucumber "Examples" 
	    @When("^User enters username (.*)$")
	    public void setUsername_parameterized(String username) {
	    	driver.findElement(By.id("username")).sendKeys(username);
	    }
	    
	    @And("^User enters password (.*)$")
	    public void setPassword_parameterized(String password) {
	    	driver.findElement(By.id("password")).sendKeys(password);
	    }
	    
	    @And("^User click on login button$")
	    public void clickLoginButton() {
	    	driver.findElement((By.xpath("//button[@class='radius']"))).click();
	    }
	    
	    @Then("^I validate the outcomes$")
	    public void validate() {
	    	// Get login confirmation
			String conf = driver.findElement(By.tagName("h2")).getText();
			Assert.assertTrue("Login successful", conf.contains("Secure Area"));
	    }
	    
		@And("^tearDown$")
		public void tearDown() {
			// Close the browser
			driver.quit();
		}

		
		//It is not mandatory to use the "setUp" and "tearDown" in gherkin feature, instead we can use "Cucumber JUnit Annotations". 
}
