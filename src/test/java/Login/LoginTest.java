package Login;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HomePage.HomePage;
import Login.LoginPage;
import shared.SharedFunctions;

public class LoginTest {
	
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	private ChromeOptions options;
	private LoginPage loginPage;
	private HomePage homePage;
	private SharedFunctions sharedFunctions = new SharedFunctions();
	
	@BeforeEach
	public void setup() {
		options = new ChromeOptions();
		// options.addArguments("--headless");
		options.addArguments("start-maximized");
		this.driver = new ChromeDriver(options);
		
		loginPage = new LoginPage();
		homePage = new HomePage();
		PageFactory.initElements(this.driver, loginPage);
		PageFactory.initElements(this.driver, homePage);
		this.wait = new WebDriverWait(driver, 5);
		
	}
	
	@Test
	void successfulLoginTest() {
		sharedFunctions.navigateToUrl(driver);
		loginPage.loginToSite("admin", "admin", wait);
		this.wait.until(ExpectedConditions.elementToBeClickable(this.homePage.GoToSecureSerch));
		assertEquals(homePage.Url, this.driver.getCurrentUrl());
	}
	
	@Test
	void badLogingTest() {
		sharedFunctions.navigateToUrl(driver);
		loginPage.loginToSite("badUser", "badPassword", wait);
		assertEquals(loginPage.Url, this.driver.getCurrentUrl());
	}
	
	@Test 
	void reLogginInWorks(){
		sharedFunctions.navigateToUrl(driver);
		loginPage.loginToSite("admin", "admin", wait);
		this.wait.until(ExpectedConditions.elementToBeClickable(this.homePage.GoToSecureSerch));
		assertEquals(homePage.Url, this.driver.getCurrentUrl());
		this.homePage.clickLogoutButton();
		loginPage.loginToSite("admin", "admin", wait);
		this.wait.until(ExpectedConditions.elementToBeClickable(this.homePage.GoToSecureSerch));
		assertEquals(homePage.Url, this.driver.getCurrentUrl());
	}
	@Test
	void noLoginInfor() {
		sharedFunctions.navigateToUrl(driver);
		this.wait.until(ExpectedConditions.elementToBeClickable(this.loginPage.LoginButton));
		this.loginPage.clickLoginButton();
		assertEquals(loginPage.Url, this.driver.getCurrentUrl());
	}
	
	@AfterEach
	public void tearDown() {
		this.driver.quit();
	}
}
