package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class LoginPageClass {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass ew=new ExplicitWaitClass();

	public LoginPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement usernameTextBox;

	@FindBy(id = "password")
	WebElement passwordTextBox;

	@FindBy(id = "Inpatient Ward")
	WebElement inpatientWard;

	@FindBy(id = "loginButton")
	WebElement loginButton;

	@FindBy(xpath = "//legend[contains(.,'Login')]")
	WebElement textLogin;

	@FindBy(id = "error-message")
	WebElement errorMessage;

	@FindBy(xpath = "//div[@class='logo']//child::img")
	WebElement logoImage;

	@FindBy(xpath = "//ul[@id='sessionLocation']//child::li")
	List<WebElement> allLocationSessions;
	
	/*
	 * Excel Read Starts
	 */
	public String readStringData(int row,int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
	}
	
	public String readIntegerData(int row,int col) throws IOException {
		return ExcelReadClass.readInegerData(row, col);
	}
	/*
	 * Excel Read Method Close
	 */
	
	public void login(String username, String password) {
		gu.typeOnElement(usernameTextBox, username);
		gu.typeOnElement(passwordTextBox, password);
		ew.elementToBeClickableWait(driver, inpatientWard);
		gu.clickOnElement(inpatientWard);
		gu.clickOnElement(loginButton);
	}

	public String getTextOfErrorMessageFromLoginPage() {
		ew.visibilityOfWait(driver, errorMessage);
		return gu.getTextOfElement(errorMessage);
	}

	public boolean isLogoDisplayed() {
		return gu.isElementDisplayed(logoImage);
	}

	public String getTextOfCurrentLoginPageURL() {
		return gu.getTextOfElement(textLogin);
	}

	public boolean isAllSessionsAreDisplayed() {
		for (WebElement element : allLocationSessions) {
			gu.isElementDisplayed(element);
			return true;
		}
		return false;
	}
	
	
}