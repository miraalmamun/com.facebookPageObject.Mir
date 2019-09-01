package com.facebookPageObject.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.LaunchPage4;
import com.facebookPageObject.pages.LoginPage4;
import com.facebookPageObject.pages.session.LandingPage4;
import com.facebookPageObject.pages.session.settings.GeneralSettingsPage;
import com.facebookPageObject.pages.session.settings.SecurityAndLoginPage;
import com.facebookPageObject.testcases.base.BaseTest4;
import com.facebookPageObject.util.DataUtil;
import com.facebookPageObject.util.FBConstants;

public class ChangePasswordTest4 extends BaseTest4 {

	String testCaseName = "ChangePasswordTest";

	@Test(dataProvider = "getData")
	public void changePasswordTest(Hashtable<String, String> data) {

		test = extent.createTest("Change Password Test");
		test.log(Status.INFO, "Passing data from Excel-->" + data.toString());
		if (data.get(FBConstants.RUNMODE_COL).equals("N")) {
			test.log(Status.SKIP, "Skipping the Test as Runmode is N");
			throw new SkipException("Skipping the Test as Runmode is N");
		}

		test.log(Status.INFO, "Starting Login Test");
		init(data.get("Browser"));
		LaunchPage4 launchPage = new LaunchPage4(driver, test);
		PageFactory.initElements(driver, launchPage);
		LoginPage4 loginPage = launchPage.goToLoginPage();
		//Object pages = loginPage.doLogin(data.get("Username"), data.get("OldPassword"));
		Object pages = loginPage.doLogin("miraalmamun@gmail.com","Pen1235874");
		
		if(pages instanceof LoginPage4)
		{
			reportFailure("Login Failed");
		}
		
		//Change password
		
		LandingPage4 landingPage = (LandingPage4)pages;
		GeneralSettingsPage settingsPage = landingPage.getMenu().goToSetting();
		SecurityAndLoginPage securityAndLoginPage = settingsPage.goToSecurityAndLoginPage();
		securityAndLoginPage.goToPasswordChange();
		String actualResult = securityAndLoginPage.doPasswordChange(data.get("OldPassword"),data.get("NewPassword"));
		
		test.log(Status.INFO, "Result of changing password - "+actualResult);

		//validation
		if(!actualResult.equals(data.get("ExpectedResult")))
			reportFailure("Got password change result as - "+actualResult);
		
		test.log(Status.INFO, "Expected password change result as - "+data.get("ExpectedResult"));
		Assert.assertEquals(actualResult, data.get("ExpectedResult"));
		test.log(Status.PASS, "Test passed");
	

	}

	@AfterMethod
	public void quitting() {

		if (extent != null)
			extent.flush();
		if (driver != null)
			driver.quit();

	}

	@DataProvider
	public Object[][] getData() {
		return DataUtil.getData(excel, testCaseName);
	}
}
