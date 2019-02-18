package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public void setUsername(String username) {
		driver.findElement(By.id("username")).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(By.id("password")).sendKeys(password);
	}

	public void clickSubmit() {
		driver.findElement((By.xpath("//button[@class='radius']"))).click();
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

}
