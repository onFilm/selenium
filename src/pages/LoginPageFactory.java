package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
WebDriver driver;

	@FindBy(id="username")
	WebElement usernameElement;
	
	@FindBy(id="password")
	WebElement passwordElement;

	@FindBy(xpath="//button[@class='radius']")
	WebElement loginButton;
	
	
	public void setUsername(String username) {
		usernameElement.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordElement.sendKeys(password);
	}

	public void clickSubmit() {
		loginButton.click();
	}
	
	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickSubmit();
	}
	
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
