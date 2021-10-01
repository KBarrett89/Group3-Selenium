package shared;

import org.openqa.selenium.remote.RemoteWebDriver;

import Login.LoginPage;

public class SharedFunctions {
	
	LoginPage loginPage = new LoginPage();
	
	public void navigateToUrl(RemoteWebDriver driver) {
		driver.get(loginPage.Url);
	}
}
