package testClasses;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelReadClass;

public class DataProviderClass {

	@DataProvider(name = "unsuccessful")
	public Object[][] dp() throws IOException {
		return new Object[][] { 
			new Object[] { ExcelReadClass.readStringData(14, 0), ExcelReadClass.readStringData(14, 1) }, 
			new Object[] { ExcelReadClass.readStringData(15, 0), ExcelReadClass.readStringData(15, 1) }, 
			new Object[] { ExcelReadClass.readStringData(16, 0), ExcelReadClass.readStringData(16, 1) }, 
		};
	}
}