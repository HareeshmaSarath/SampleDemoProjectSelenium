package testClasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageClasses.HomePageClass;
import pageClasses.LoginPageClass;
import pageClasses.PatientPageClass;
import pageClasses.RegisterPatientPageClass;
import retryAnalyzer.RetryAnalyzer;

public class RegisterPatientTestClass extends BaseClass{
	HomePageClass hp;
	LoginPageClass lp;
	PatientPageClass p;
	RegisterPatientPageClass rp;

	@Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
	public void verifyToRegisterPatient() throws IOException {
		lp = new LoginPageClass(driver);
		lp.login("admin", "Admin123");
		hp=new HomePageClass(driver);
		hp.registerAPatientClick();
		rp=new RegisterPatientPageClass(driver);
		int agey=Integer.parseInt(rp.readIntegerData(7, 1));
		int agem=Integer.parseInt(rp.readIntegerData(8, 1)) ;
		int ph=Integer.parseInt(rp.readIntegerData(11, 1));
		String phn=""+ph;
		rp.registerPatient(rp.readStringData(5, 1),rp.readStringData(6, 1),agey,agem,rp.readStringData(9, 1),rp.readStringData(10, 1),phn);
		p=new PatientPageClass(driver);
		String actual_result = p.getTextOfHomePageText();
		Assert.assertTrue(actual_result.contains("Akku"));
	}
}