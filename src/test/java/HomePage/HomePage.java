package HomePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	public static final String Url = "http://54.76.136.203/";
	
	@FindBy(how = How.ID, using = "welcome")
	private WebElement welcomeMessage;
	
	@FindBy(how = How.ID, using = "logPage")
	public WebElement GoToSecureSerch;
	
	@FindBy(how = How.ID, using = "logout")
	private WebElement LogoutButton;
	
	@FindBy(how = How.CSS, using = "body > div.swal-overlay.swal-overlay--show-modal > div > div.swal-title")
	private WebElement SessionExpiredTitle;
	
	@FindBy(how = How.CSS, using = "body > div.swal-overlay.swal-overlay--show-modal > div > div.swal-footer > div > button")
	private WebElement SessionExpiredOk;
	
	public String getWelcomeMessage(){
		return welcomeMessage.getText();
	}
	
	public void clickGoToSearch(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(GoToSecureSerch));
		GoToSecureSerch.click();
	}
	
	public void clickGoToSearch() {
		GoToSecureSerch.click();
	}
	
	public void clickLogoutButton() {
		LogoutButton.click();
	}
	
	public String getExpiredSessionTitle(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(this.SessionExpiredOk));
		wait.until(ExpectedConditions.textToBePresentInElement(this.SessionExpiredTitle, "Session Expired"));
		return SessionExpiredTitle.getText();
	}
	
	public void clickSessionExpiredOk() {
		SessionExpiredOk.click();
	}
	
}
