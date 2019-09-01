package com.facebookPageObject.practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//package com.facebookPageObject.testcases.base;

public class WebDriverManagerClass {
	static WebDriver driver;

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
				System.getProperty("user.dir") + "\\DriverLog\\mozila.log");
		FirefoxOptions opt = new FirefoxOptions();
		opt.addPreference("dom.webnotifications.enabled", false);
		driver = new FirefoxDriver(opt);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://yahoo.com");
		driver.quit();
		chrome();
		edge();
		
		

	}

	public static void chrome() {
		WebDriverManager.chromedriver().setup();
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY,
				System.getProperty("user.dir") + "\\DriverLog\\chrome.log");
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--disable-notifications");
		ops.addArguments("disable-infobars");
		ops.addArguments("--start-maximized");
		driver = new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://cnn.com");
		driver.quit();

	}
	
	
	public static void edge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://bbc.com");
		driver.quit();

	}

	
	
	
	
	
	
	
	
	
	
	

}
