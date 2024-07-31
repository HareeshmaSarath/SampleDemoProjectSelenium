package pageClasses;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;

import utilities.ExcelReadClass;
import utilities.FluentWaitClass;
import utilities.GeneralUtilities;

public class HomePageClass {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	FluentWaitClass fw = new FluentWaitClass();

	public HomePageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='apps']//child::a")
	List<WebElement> tilesInsideHomePage;

	@FindBy(xpath = "//div[@id='content']//child::h4")
	WebElement LoggedInAsSuperUserAdminAtInpatientWard;
	
	@FindBy(xpath = "//a[@type='button' and contains(., 'Register')]")
	WebElement registerAPatient;

	public String getTextOfHomePageText() {
		// fw.visibilityOfWait(driver, LoggedInAsSuperUserAdminAtInpatientWard);
		fw.presenceOfElementLocatedWaitByXpath(driver, "//div[@id='content']//child::h4");
		return gu.getTextOfElement(LoggedInAsSuperUserAdminAtInpatientWard);
	}

	public boolean AllTilesAreDisplayedOrNot() {
		for (WebElement element : tilesInsideHomePage) {
			gu.isElementDisplayed(element);
			return true;
		}
		return false;
	}

	public void registerAPatientClick() {
		gu.clickOnElement(registerAPatient);
	}
	
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
}