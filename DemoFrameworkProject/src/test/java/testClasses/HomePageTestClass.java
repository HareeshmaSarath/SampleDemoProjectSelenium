package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import retryAnalyzer.RetryAnalyzer;

public class HomePageTestClass extends BaseClass{
	HomePageClass hp;
	LoginPageClass lp;
	
	@Test(priority = 1,groups = {"groupOne"},retryAnalyzer = RetryAnalyzer.class)
	public void verifyAllTilesAreDisplayedInHomePage() {
		lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");
		hp=new HomePageClass(driver);
		boolean actual_result=hp.AllTilesAreDisplayedOrNot();
		Assert.assertEquals(actual_result, true);
	}
	
	@Test(priority = 2,groups = {"groupOne"},retryAnalyzer = RetryAnalyzer.class)
	public void verifyRegisterAPatientTileIsClickable() {
		lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");
		hp=new HomePageClass(driver);
		hp.registerAPatientClick();
	}
	
	
}