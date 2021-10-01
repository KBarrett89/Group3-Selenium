package Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public static final String Url = "http://54.76.136.203/";
	public static final String redirectedUrl = "http://54.76.136.203/login";
	
	@FindBy(how = How.CSS, using = "#LoginBar > form > label:nth-child(1) > input[type=text]")
	private WebElement username;
	
	@FindBy(how = How.CSS, using = "#LoginBar > form > label:nth-child(2) > input[type=password]")
	private WebElement password;
	
	@FindBy(how = How.CSS, using = "#LoginBar > form > div > button")
	public WebElement LoginButton;
	
	public void setUsernameTextbox(String username) {
		this.username.sendKeys(username);
	}
	
	public void setPasswordTextbox(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		LoginButton.click();
	}
	
	public void loginToSite(String username, String password, WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(LoginButton));
		setUsernameTextbox(username);
		setPasswordTextbox(password);
		clickLoginButton();
	}
	
	
}
