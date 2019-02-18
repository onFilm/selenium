package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*
 * This class returns a WebDriver object using 3 overloaded .get() methods:
 * 1. get() - default
 * 2. get(String browserType)
 * 3. get(String browserType, String webURL)
 */

public class DriverFactory {
	
	
	// function that returns a default WebDriver (user does not specify)
	public static WebDriver get() {
		WebDriver driver;
		System.out.println("Opening chrome browser");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	// function that returns a WebDriver when user sends desired browser
	public static WebDriver get(String browserType) {
		WebDriver driver;
		if (browserType.equalsIgnoreCase("Chrome")) {
			System.out.println("Opening chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("Firefox")) {
			System.out.println("Opening Firefox browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("IE")) {
			System.out.println("Opening IE browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Could not understand input. Will open Chrome as default");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		setConfigs(driver);
		return driver;
	}
	
	
	public static WebDriver get(String browserType, String webURL) {
		WebDriver driver;
		if (browserType.equalsIgnoreCase("Chrome")) {
			System.out.println("Opening chrome browser");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("Firefox")) {
			System.out.println("Opening Firefox browser");
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ "\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if (browserType.equalsIgnoreCase("IE")) {
			System.out.println("Opening IE browser");
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("Could not understand input. Will open Chrome as default");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get(webURL);
		setConfigs(driver);
		return driver;
	}
	
	// This function returns a WebDriver with maximized window and 3 second wait
	private static void setConfigs(WebDriver driver) {
		System.out.println("Setup basic WebDriver configurations");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
}