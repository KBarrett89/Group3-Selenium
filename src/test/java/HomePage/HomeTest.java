package HomePage;

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

import Login.LoginPage;
import shared.SharedFunctions;

public class HomeTest {

	private RemoteWebDriver driver;
	private WebDriverWait wait;
	private ChromeOptions options;
	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
	private SharedFunctions sharedFunctions = new SharedFunctions();
	
	@BeforeEach
	public void setup() {
		options = new ChromeOptions();
		// options.addArguments("--headless");
		options.addArguments("start-maximized");
		this.driver = new ChromeDriver(options);

		PageFactory.initElements(this.driver, loginPage);
		PageFactory.initElements(this.driver, homePage);
		this.wait = new WebDriverWait(driver, 5);
		
		sharedFunctions.navigateToUrl(driver);
		loginPage.loginToSite("admin", "admin", wait);
	}
	
	@Test 
	void GoToSecureSearchButton() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.homePage.GoToSecureSerch));
		assertEquals("BAE12 Final Project\nGo To Secure Search", homePage.getWelcomeMessage());
		homePage.clickGoToSearch(wait);
	}
	
	@Test
	void LogoutFromHomePage() {
		this.wait.until(ExpectedConditions.elementToBeClickable(this.homePage.GoToSecureSerch));
		assertEquals("BAE12 Final Project\nGo To Secure Search", homePage.getWelcomeMessage());
		this.homePage.clickLogoutButton();
		assertEquals(this.loginPage.redirectedUrl, driver.getCurrentUrl());
	}
	
	@Test
	void TestTokenExpires() throws InterruptedException {
		Thread.sleep(180000);
		this.homePage.clickGoToSearch();
		assertEquals("Session Expired", homePage.getExpiredSessionTitle(wait));
		homePage.clickSessionExpiredOk();
		assertEquals(this.loginPage.redirectedUrl, driver.getCurrentUrl());
	}
	
	@AfterEach
	public void tearDown() {
		this.driver.quit();
	}
}
