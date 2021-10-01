package Dashboard;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import HomePage.HomePage;
import Login.LoginPage;
import shared.SharedFunctions;

public class DashboardTest {
	
	private RemoteWebDriver driver;
	private WebDriverWait wait;
	private ChromeOptions options;
	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
	private DashboardPage dashboardPage = new DashboardPage();
	private SharedFunctions sharedFunctions = new SharedFunctions();
	
	@BeforeEach
	public void setup() {
		options = new ChromeOptions();
		// options.addArguments("--headless");
		options.addArguments("start-maximized");
		this.driver = new ChromeDriver(options);

		PageFactory.initElements(this.driver, loginPage);
		PageFactory.initElements(this.driver, homePage);
		PageFactory.initElements(this.driver, dashboardPage);
		this.wait = new WebDriverWait(driver, 5);
		
		sharedFunctions.navigateToUrl(driver);
		loginPage.loginToSite("admin", "admin", wait);
		homePage.clickGoToSearch(wait);
	}
	
	@Test 
	void enterInvalidPlate() {
		assertEquals(this.dashboardPage.Url, this.driver.getCurrentUrl());
		this.dashboardPage.waitForPage(wait);
		this.dashboardPage.searchForReg("invalid");
		this.dashboardPage.getInvalidSearchTitle(wait);
		this.dashboardPage.clickInvalidSearchOk();
	}
	
	@Test 
	void enterValidPlate() {
		assertEquals(this.dashboardPage.Url, this.driver.getCurrentUrl());
		this.dashboardPage.waitForPage(wait);
		this.dashboardPage.searchForReg("JA15 FXK");
	}
	
	@Test
	void clickLogoutButton() {
		assertEquals(this.dashboardPage.Url, this.driver.getCurrentUrl());
		this.dashboardPage.waitForPage(wait);
		this.dashboardPage.clickLogoutButton();
		assertEquals(this.loginPage.redirectedUrl, driver.getCurrentUrl());
	}
	
	@AfterEach
	public void tearDown() {
		this.driver.quit();
	}
}
