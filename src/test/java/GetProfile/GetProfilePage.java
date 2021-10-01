package GetProfile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetProfilePage {

	
	public final static String Url = "http://54.76.136.203/GetProfile/MZ01%20TIH";
	
	@FindBy(how = How.CSS, using = "#pinfo > div.card-header > div > h3")
	private WebElement PersonInformation;
	
	@FindBy(how = How.CSS, using = "#timeloc > div.collapse > div > table > tbody")
	private WebElement vehicleOberservations;
	
	@FindBy(how = How.ID, using = "mapbox")
	private WebElement mapElement;
	
	public void waitForPage(WebDriverWait wait) {
		wait.until(ExpectedConditions.textToBePresentInElement(PersonInformation, "Person Information"));
	}
	
	public int getNumberOfDataEntrys() {
		return vehicleOberservations.findElements(By.cssSelector("tr")).size();	
	}
}
