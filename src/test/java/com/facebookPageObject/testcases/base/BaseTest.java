package com.facebookPageObject.testcases.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.facebookPageObject.util.ExtentManager;
import com.facebookPageObject.util.FBConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public ExtentReports extent = ExtentManager
			.getInstance("C:\\Users\\Mir\\eclipse-workspace\\com.facebookPageObject.Mir\\ExtentReports\\");
	public ExtentTest test;

	public void init(String bType) {
		if (bType.equalsIgnoreCase("Mozilla")) {

			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, FBConstants.BROWSER_LOGFILE);
			FirefoxOptions opt = new FirefoxOptions();
			opt.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(opt);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();

		} else if (bType.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			// System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,
			// System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");
			ChromeOptions ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("disable-infobars");
			ops.addArguments("--start-maximized");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, FBConstants.CHROME_DRIVER_LOGFILE);
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			driver = new ChromeDriver(ops);

		}

		else {

		}
	}

}
