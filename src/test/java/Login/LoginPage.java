package Login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	public static final String Url = "http://54.76.136.203/";
	
	@FindBy(how = How.CSS, using = "#LoginBar > form > label:nth-child(1) > input[type=text]")
	private WebElement username;
	
	@FindBy(how = How.CSS, using = "#LoginBar > form > label:nth-child(2) > input[type=password]")
	private WebElement password;
	
	@FindBy(how = How.CSS, using = "#LoginBar > form > div > button")
	private WebElement LoginButton;
	
	public void setUsernameTextbox(String username) {
		this.username.sendKeys(username);
	}
	
	public void setPasswordTextbox(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickLoginButton() {
		LoginButton.click();
	}
}
