package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;

public class PatientPageClass {
	
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	ExplicitWaitClass wait=new ExplicitWaitClass();
	
	public PatientPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h1[@class='mt-0 mb-2 name']")
	WebElement patientGivenName;
	
	public String getTextOfHomePageText() {
		wait.presenceOfElementLocatedWait(driver, "//h1[@class='mt-0 mb-2 name']");
		return gu.getTextOfElement(patientGivenName);
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
