package com.facebookPageObject.pages.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.common.TopMenu4;
import com.facebookPageObject.util.ExtentManager;

public class BasePage4 {

	public WebDriver driver;
	public TopMenu4 menu;
	public ExtentTest test;

	public BasePage4(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		menu = new TopMenu4(driver, test);
		PageFactory.initElements(driver, menu);
	}

	public String verifyTitle(String expTitle) {
		test.log(Status.INFO, "Varifying the Title" + expTitle);
		return "";
	}

	public String verifyText(String locator, String expText) {
		return "";
	}

	public TopMenu4 getMenu() {
		return menu;
	}

//	public TopMenu getMenu()
//	{
//		return menu;
//	}
//	

	public void takeSceenShot() {
		// fileName of the screenshot
		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		// take screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath + screenshotFile));
			// put screenshot file in reports
			// test.log(Status.FAIL,"Screenshot-> "+
			// test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
			test.log(Status.INFO, "Screenshot-> "
					+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath + screenshotFile));
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void reportFailure(String failureMessage) {
		test.log(Status.FAIL, failureMessage);
		takeSceenShot();
		Assert.fail(failureMessage);
	}
	/*******************************************************************************************************/
	public boolean isElementPresent(String locator) {
		test.log(Status.INFO, "Trying to find element -> " + locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if (s == 0) {
			test.log(Status.INFO, "Element not found");
			return false;
		} else {
			test.log(Status.INFO, "Element found");
			return true;
		}

	}
	
	/*
	public boolean isElementPresent2(String objectKey) {
		List<WebElement> e = null;

		if (objectKey.endsWith("_xpath")) {
			e = driver.findElements(By.xpath(prop.getProperty(objectKey)));// present
		} else if (objectKey.endsWith("_id")) {
			e = driver.findElements(By.id(prop.getProperty(objectKey)));// present
		} else if (objectKey.endsWith("_name")) {
			e = driver.findElements(By.name(prop.getProperty(objectKey)));// present
		} else if (objectKey.endsWith("_css")) {
			e = driver.findElements(By.cssSelector(prop.getProperty(objectKey)));// present
		}
		if (e.size() == 0)
			return false;
		else
			return true;
	}
  */
	/*
	public boolean isElementPresent3(String locatorKey) {
		// If the given path of an element is present
		// then it will return true
		// otherwise return false
		List<WebElement> elementList = null;
		if (locatorKey.endsWith("_id"))
			elementList = driver.findElements(By.id(pro.getProperty(locatorKey)));
		else if (locatorKey.endsWith("_name"))
			elementList = driver.findElements(By.name(pro.getProperty(locatorKey)));
		else if (locatorKey.endsWith("_xpath"))
			elementList = driver.findElements(By.xpath(pro.getProperty(locatorKey)));
		else {
			reportFailure("Locator is not correct - " + locatorKey);
			Assert.fail("Locator is not correct - " + locatorKey);
		}

		if (elementList.size() == 0)
			return false;
		else
			return true;
	}
	
	*/
	/**********************************************************************************************/
	
	
	
	
	
}
