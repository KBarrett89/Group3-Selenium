package GetProfile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Dashboard.DashboardPage;
import HomePage.HomePage;
import Login.LoginPage;
import shared.SharedFunctions;

public class GetProfileTest {

	private RemoteWebDriver driver;
	private WebDriverWait wait;
	private ChromeOptions options;
	private LoginPage loginPage = new LoginPage();
	private HomePage homePage = new HomePage();
	private DashboardPage dashboardPage = new DashboardPage();
	private SharedFunctions sharedFunctions = new SharedFunctions();
	private GetProfilePage getProfilePage = new GetProfilePage();
	
	@BeforeEach
	public void setup() {
		options = new ChromeOptions();
		// options.addArguments("--headless");
		options.addArguments("start-maximized");
		this.driver = new ChromeDriver(options);

		PageFactory.initElements(this.driver, loginPage);
		PageFactory.initElements(this.driver, homePage);
		PageFactory.initElements(this.driver, dashboardPage);
		PageFactory.initElements(this.driver, getProfilePage);
		this.wait = new WebDriverWait(driver, 5);
		
		sharedFunctions.navigateToUrl(driver);
		loginPage.loginToSite("admin", "admin", wait);
		homePage.clickGoToSearch(wait);
		
		this.dashboardPage.waitForPage(wait);
		this.dashboardPage.searchForReg("MZ01 TIH");
	}
	
	@Test 
	void TestValidPlate() {
		
		this.getProfilePage.waitForPage(wait);
		assertEquals(this.getProfilePage.Url, this.driver.getCurrentUrl());
		assertEquals(12, this.getProfilePage.getNumberOfDataEntrys());

	}
	
	@AfterEach
	public void tearDown() {
		this.driver.quit();
	}
	
}
