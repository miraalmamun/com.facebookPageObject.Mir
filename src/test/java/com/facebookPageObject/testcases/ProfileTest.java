package com.facebookPageObject.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.facebookPageObject.pages.LaunchPage;
import com.facebookPageObject.pages.LoginPage;
import com.facebookPageObject.pages.session.LandingPage;
import com.facebookPageObject.pages.session.ProfilePage;

public class ProfileTest {
	WebDriver driver;

	@Test
	public void testProfile() {
		// pro.getProperty("geckodriver_exe"));
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\Driver\\geckodriver.exe");

		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,
				System.getProperty("user.dir") + "\\DriverLog\\mozila.log");
		// Turn off notification
		FirefoxProfile foxProfile = new FirefoxProfile();
		foxProfile.setPreference("dom.webnotifications.enabled", false);

		driver = new FirefoxDriver();

		LaunchPage launchPage = new LaunchPage(driver);
		LoginPage loginPage = launchPage.goToLoginPage();
		Object pages = loginPage.doLogin("miraalmamun@gmail.com", "Mimo94965812345678");
		if (pages instanceof LoginPage) {
			Assert.fail("Login failed");
		}
		else if(pages instanceof LandingPage)
		{
			System.out.println("Logged in successfully");
		}

		LandingPage landingPage = (LandingPage) pages;

		ProfilePage profilePage = landingPage.goToProfilePage();
		profilePage.verifyProfile();

		/*
		 * LaunchPage launchPage = PageFactory.initElements(driver, LaunchPage.class);
		 * launchPage.goToLoginPage();
		 * 
		 * LoginPage loginPage = launchPage.goToLoginPage();
		 * 
		 * LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		 * 
		 * loginPage.doLogin("mula", "vula");
		 */
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
