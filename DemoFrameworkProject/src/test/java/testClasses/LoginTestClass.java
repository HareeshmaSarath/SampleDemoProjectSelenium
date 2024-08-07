package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;

public class LoginTestClass extends BaseClass {
	LoginPageClass lp;
	HomePageClass h;

	@Test(priority = 2,groups = {"groupOne"},retryAnalyzer = RetryAnalyzer.class)
	public void verifySuccessfullLogin() throws IOException {
		lp = new LoginPageClass(driver);
		String username = lp.readStringData(1, 0);
		String password = lp.readStringData(1, 1);
		//lp.login(username, password);
		/*
		 * chaining
		 */
		(new LoginPageClass(driver)).typeOnUsername(username).typeOnPassword(password).clickOnElement().clickOnButton();
		
		/*
		 * chaing end
		 */
		h = new HomePageClass(driver);
		String actual_result = h.getTextOfHomePageText();
		Assert.assertEquals(actual_result, lp.readStringData(3, 0));
	}

	/*
	 * @Test(dataProviderClass = DataProviderClass.class, dataProvider =
	 * "unsuccessful",priority = 3,groups = {"groupOne"},retryAnalyzer =
	 * RetryAnalyzer.class) public void verifyUnsuccessfulLogin(String
	 * userName,String Password) throws IOException { lp = new
	 * LoginPageClass(driver); //lp.login(lp.readStringData(1, 3),
	 * lp.readStringData(1, 4)); lp.login(userName, Password); String actual_Result
	 * = lp.getTextOfErrorMessageFromLoginPage(); Assert.assertEquals(actual_Result,
	 * lp.readStringData(3, 3)); }
	 * 
	 * @Test(priority = 4,groups = {"groupTwo"},retryAnalyzer = RetryAnalyzer.class)
	 * public void veryfyLogoIsDisplayedOrNotInLoginPage() { lp = new
	 * LoginPageClass(driver); boolean logo_status = lp.isLogoDisplayed();
	 * Assert.assertTrue(logo_status, "Logo Not Found"); }
	 * 
	 * @Test(priority = 1,groups = {"groupTwo"},retryAnalyzer = RetryAnalyzer.class)
	 * public void verifyTheExpectedPageisOpensWhileHittingTheUrl() { lp = new
	 * LoginPageClass(driver); String actual_result =
	 * lp.getTextOfCurrentLoginPageURL(); Assert.assertEquals(actual_result,
	 * "LOGIN"); }
	 * 
	 * @Test(priority = 5,groups = {"groupTwo"},retryAnalyzer = RetryAnalyzer.class)
	 * public void verifyAllLocationSessionsAreDisplayedOrNotInLoginPage() { lp =
	 * new LoginPageClass(driver); boolean actual_result =
	 * lp.isAllSessionsAreDisplayed(); Assert.assertEquals(actual_result, true); }
	 */
}