package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	public static final String Url = "http://54.76.136.203/dashboard";
	
	@FindBy(how = How.ID, using = "searchReg")
	private WebElement vehicleRegTitle;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"searchReg\"]/button")
	private WebElement searchButton;
	
	@FindBy(how = How.ID, using = "logout" )
	private WebElement logoutButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"searchReg\"]/input")
	private WebElement searchText;
	
	@FindBy(how = How.CSS, using = "body > div.swal-overlay.swal-overlay--show-modal > div > div.swal-footer > div > button")
	private WebElement invalidSearchOk;
	
	@FindBy(how = How.CSS, using = "body > div.swal-overlay.swal-overlay--show-modal > div > div.swal-title")
	private WebElement invalidSearchTitle;
	
	public void waitForPage(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(this.searchButton));
	}
	
	public void clickLogoutButton() {
		logoutButton.click();
	}
	
	public void searchForReg(String numberPlate) {
		this.searchText.clear();
		this.searchText.sendKeys(numberPlate);
		this.searchButton.click();
	}
	
	public String getInvalidSearchTitle(WebDriverWait wait) {
		wait.until(ExpectedConditions.elementToBeClickable(this.invalidSearchOk));
		wait.until(ExpectedConditions.textToBePresentInElement(this.invalidSearchTitle, "Invalid Search"));
		return invalidSearchTitle.getText();
	}
	
	public void clickInvalidSearchOk() {
		invalidSearchOk.click();
	}
}
