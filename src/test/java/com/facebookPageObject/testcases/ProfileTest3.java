package com.facebookPageObject.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.facebookPageObject.pages.LaunchPage3;
import com.facebookPageObject.pages.LoginPage3;
import com.facebookPageObject.pages.session.LandingPage3;
import com.facebookPageObject.pages.session.ProfilePage3;
import com.facebookPageObject.testcases.base.BaseTest;

public class ProfileTest3 extends BaseTest{
	

	@Test
	public void testProfile() {
		
		init("Mozilla");
		LaunchPage3 launchPage = PageFactory.initElements(driver, LaunchPage3.class);
		LoginPage3 loginPage = launchPage.goToLoginPage();
		Object pages = loginPage.doLogin("miraalmamun@gmail.com", "Mimo94965812345678");
		if (pages instanceof LoginPage3) {
			Assert.fail("Login failed");
		} else if (pages instanceof LandingPage3) {
			System.out.println("Logged in successfully");
		}

		LandingPage3 landingPage = (LandingPage3) pages;

		ProfilePage3 profilePage = landingPage.goToProfilePage();
		profilePage.verifyProfile();
		LoginPage3 login = profilePage.getMenu().logOut();
		System.out.println("Logout success");
		login.doLogin("miraalmamun@gmail.com", "Mimo94965812345678");
		landingPage.getMenu().logOut();
		
        
	}
	
	@AfterMethod
	public void quitDriver()
	{
		if(driver!=null)
		{
			driver.quit();
		}
	}

	
}
