package com.facebookPageObject.pages.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.common.TopMenu3;
import com.facebookPageObject.util.ExtentManager;

public class BasePage3 
{
	
	public WebDriver driver;
	private TopMenu3 menu;
	
	ExtentReports extent = ExtentManager.getInstance("C:\\Users\\Mir\\eclipse-workspace\\com.facebookPageObject.Mir\\ExtentReports\\");
	ExtentTest test;
	
	public BasePage3(WebDriver driver)
	{
		this.driver = driver;
		menu = PageFactory.initElements(driver, TopMenu3.class);
	}
	
	public String verifyTitle(String expTitle)
	{
		return "";
	}
	public String verifyText(String locator, String expText)
	{
		return "";
	}
	
	public boolean isElementPresent(String locator)
	{
		return false;
	}

	public TopMenu3 getMenu() {
		return menu;
	}

	
    
//	public TopMenu getMenu()
//	{
//		return menu;
//	}
//	
	
	public void takeSceenShot()
	{
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
			//put screenshot file in reports
			test.log(Status.FAIL,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}

	

}
