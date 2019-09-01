package com.facebookPageObject.pages.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.LoginPage4;
import com.facebookPageObject.pages.session.settings.GeneralSettingsPage;
import com.facebookPageObject.util.FBConstants;

public class TopMenu4 {
	WebDriver driver;
	ExtentTest test;

	public TopMenu4(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	@FindBy(xpath = FBConstants.NAVIGATE_LINK)
	public WebElement userNavigate;
	@FindBy(xpath = FBConstants.LOGOUT_LINK)
	public WebElement logOut;
	@FindBy(xpath = FBConstants.SETTINGS_LINK)
	public WebElement settings;
	
	public LoginPage4 logOut() {
		test.log(Status.INFO, "I am logging out");
		userNavigation();
		logOut.click();
		test.log(Status.INFO, "Logged Out Success");
		LoginPage4 loginPage = new LoginPage4(driver, test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;

	}

	public GeneralSettingsPage goToSetting() {

		userNavigation();
		test.log(Status.INFO, "Clicking on Settings link");
		settings.click();
		test.log(Status.INFO, "General Account Settings Page opened");
		GeneralSettingsPage settingsPage = new GeneralSettingsPage(driver, test);
		PageFactory.initElements(driver, settingsPage);
		return settingsPage;
	}

	public void search() {

	}

	public void userNavigation() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		test.log(Status.INFO, "I am clicking on navigation link for setting");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('userNavigationLabel').click();");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	
}
