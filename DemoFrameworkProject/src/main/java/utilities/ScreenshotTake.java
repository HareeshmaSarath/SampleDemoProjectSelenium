package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotTake {
	
	public void takeScreenshot(WebDriver driver,String name) throws IOException
	{
		String folder_path="D:\\MavenProjects\\DemoFrameworkProject"+"\\Screenshots\\";
		File file=new File(folder_path);
		if(!file.exists()){
			file.mkdir();
		}
		
		TakesScreenshot take_screenshot=(TakesScreenshot) driver;
		File screenshot_Output=take_screenshot.getScreenshotAs(OutputType.FILE);
		
		String timeStamp=new SimpleDateFormat("DD-MM-YYYY-HH-MM-SS").format(new Date());
		String destination_path=folder_path+name+timeStamp+".png";
		
		File destination=new File(destination_path);
		FileHandler.copy(screenshot_Output, destination);
		
	}

}