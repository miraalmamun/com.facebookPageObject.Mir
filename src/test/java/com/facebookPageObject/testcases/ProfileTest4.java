package com.facebookPageObject.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.LaunchPage4;
import com.facebookPageObject.pages.LoginPage4;
import com.facebookPageObject.pages.session.LandingPage4;
import com.facebookPageObject.pages.session.ProfilePage4;
import com.facebookPageObject.testcases.base.BaseTest4;

public class ProfileTest4 extends BaseTest4{
	

	@Test
	public void testProfile() {
		test = extent.createTest("Profile Test");
		test.log(Status.INFO, "Starting Profile Test");
		
		init("Mozilla");
		LaunchPage4 launchPage = new LaunchPage4(driver,test);
		PageFactory.initElements(driver, launchPage);
		LoginPage4 loginPage = launchPage.goToLoginPage();
		loginPage.verifyTitle("Facebook login");
		Object pages = loginPage.doLogin("miraalmamun@gmail.com", "Mimo94965812345678");
		if (pages instanceof LoginPage4) {
			Assert.fail("Login failed");
		} else if (pages instanceof LandingPage4) {
			System.out.println("Logged in successfully");
		}

		LandingPage4 landingPage = (LandingPage4) pages;

		ProfilePage4 profilePage = landingPage.goToProfilePage();
		profilePage.verifyProfile();
		test.log(Status.PASS, "Profile Test Passed");
		profilePage.takeSceenShot();
		LoginPage4 login = profilePage.getMenu().logOut();
		System.out.println("Logout success");
		login.doLogin("miraalmamun@gmail.com", "Mimo94965812345678");
		landingPage.getMenu().logOut();
		
        
	}
	
	 @AfterMethod
	   public void quitting()
	   {
		   
				if (extent != null)
					extent.flush();
				if (driver != null)
					driver.quit();
			
	   }

	
}
