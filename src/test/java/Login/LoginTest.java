package Login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Login.LoginPage;

public class LoginTest {
	
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	private ChromeOptions options;
	private LoginPage loginPage;
	@BeforeEach
	public void setup() {
		options = new ChromeOptions();
		// options.addArguments("--headless");
		options.addArguments("start-maximized");
		this.driver = new ChromeDriver(options);
		
		loginPage = new LoginPage();
		PageFactory.initElements(this.driver, loginPage);
		this.wait = new WebDriverWait(driver, 5);
		
	}
	
	private void navigateToUrl() {
		this.driver.get(loginPage.Url);
	}
	
	@Test
	void successfulLoginTest() {
		navigateToUrl();
		loginPage.setUsernameTextbox("admin");
		loginPage.setPasswordTextbox("admin");
		loginPage.clickLoginButton();
	}
	
	@AfterEach
	public void tearDown() {
		this.driver.quit();
	}
}
