package com.facebookPageObject.testcases.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.util.ExcelReadWrite;
import com.facebookPageObject.util.ExtentManager;
import com.facebookPageObject.util.FBConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest4 {
	public WebDriver driver;
	public ExtentReports extent = ExtentManager.getInstance(FBConstants.ExtentReports_Path);
	public ExtentTest test;
	public ExcelReadWrite excel = new ExcelReadWrite(FBConstants.DATA_XLS_PATH);

	public void init(String bType) {
		test.log(Status.INFO, "Opening browser-->" + bType);
		if (bType.equalsIgnoreCase("Mozilla")) {

			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, FBConstants.BROWSER_LOGFILE);
			FirefoxOptions opt = new FirefoxOptions();
			opt.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(opt);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			test.log(Status.INFO, "Browser opening successfully");
		} else if (bType.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("disable-infobars");
			ops.addArguments("--start-maximized");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, FBConstants.CHROME_DRIVER_LOGFILE);
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			driver = new ChromeDriver(ops);
			test.log(Status.INFO, "Browser opening successfully");

		}

		else {

		}
	}
	
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
			//test.log(Status.FAIL,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
			test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
			//test.log(Status.INFO,test.addScreenCapture(filePath));
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}
	
	public void reportFailure(String failureMessage){
		test.log(Status.FAIL, failureMessage);
		takeSceenShot();
		Assert.fail(failureMessage);
	}


}
