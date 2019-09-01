package com.facebookPageObject.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.facebookPageObject.pages.LaunchPage2;
import com.facebookPageObject.pages.LoginPage2;
import com.facebookPageObject.pages.session.LandingPage2;
import com.facebookPageObject.pages.session.ProfilePage2;

public class ProfileTest2 {
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

		LaunchPage2 launchPage = new LaunchPage2(driver);
		LoginPage2 loginPage = launchPage.goToLoginPage();
		Object pages = loginPage.doLogin("miraalmamun@gmail.com", "Mimo94965812345678");
		if (pages instanceof LoginPage2) {
			Assert.fail("Login failed");
		} else if (pages instanceof LandingPage2) {
			System.out.println("Logged in successfully");
		}

		LandingPage2 landingPage = (LandingPage2) pages;

		ProfilePage2 profilePage = landingPage.goToProfilePage();
		profilePage.verifyProfile();
		LoginPage2 login = profilePage.getMenu().logOut();
		System.out.println("Logout success");
		login.doLogin("miraalmamun@gmail.com", "Mimo94965812345678");
		landingPage.getMenu().logOut();
        
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
