package pageClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReadClass;
import utilities.ExplicitWaitClass;
import utilities.GeneralUtilities;
import utilities.RandomDataGeneration;

public class RegisterPatientPageClass {

	WebDriver driver;
	GeneralUtilities glu = new GeneralUtilities();
	ExplicitWaitClass wait = new ExplicitWaitClass();
	// RandomDataGeneration random=new RandomDataGeneration();

	public RegisterPatientPageClass(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "givenName")
	WebElement givenName;

	@FindBy(name = "familyName")
	WebElement familyName;

	@FindBy(id = "next-button")
	WebElement nextButton;

	@FindBy(id = "gender-field")
	WebElement genderField;

	@FindBy(xpath = "//input[@name='birthdateYears']")
	WebElement birthdateYearsField;

	@FindBy(xpath = "//input[@name='birthdateMonths']")
	WebElement birthdateMonthsfield;

	@FindBy(id = "address1")
	WebElement addressOne;

	@FindBy(id = "country")
	WebElement country;

	@FindBy(xpath = "//input[@name='phoneNumber']")
	WebElement phoneNumber;

	@FindBy(id = "submit")
	WebElement submitButton;

	public void registerPatient(String givenNameOne, String lastName, int ageYear, int ageMonth, String address,
			String countryOne, String phone) {
		glu.typeOnElement(givenName,givenNameOne);
		glu.typeOnElement(familyName, lastName);
		glu.clickOnElement(nextButton);

		glu.selectFromDropDownByIndex(genderField, 1);
		glu.clickOnElement(nextButton);

		glu.clickToAnElementJS(driver, birthdateYearsField);
		glu.typeOnElementInt(birthdateYearsField, ageYear);
		glu.typeOnElementInt(birthdateMonthsfield, ageMonth);
		glu.clickOnElement(nextButton);

		glu.typeOnElement(addressOne, address);
		glu.typeOnElement(country, countryOne);
		glu.clickOnElement(nextButton);

		glu.typeOnElement(phoneNumber, phone);
		glu.clickOnElement(nextButton);

		glu.clickOnElement(nextButton);
		glu.clickOnElement(submitButton);

	}

	public String readPatientGivenName() {
		return RandomDataGeneration.getGivenName();
	}

	/*
	 * Excel Read Starts
	 */
	public String readStringData(int row, int col) throws IOException {
		return ExcelReadClass.readStringData(row, col);
	}

	public String readIntegerData(int row, int col) throws IOException {
		return ExcelReadClass.readInegerData(row, col);
	}
	/*
	 * Excel Read Method Close
	 */
}