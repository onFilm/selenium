package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfPage {
	WebDriver driver;
	
	public String getConfMessage() {
		return driver.findElement(By.tagName("h2")).getText();
	}
	
	public ConfPage(WebDriver driver) {
		this.driver = driver;
	}

}
