package com.facebookPageObject.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.facebookPageObject.testcases.base.BaseTest;

public class ChangePasswordTest extends BaseTest {

	@Test
	public void changePasswordTest() {

		test = extent.createTest("Change Password Test");
		test.log(Status.INFO, "Starting Login Test");
		test.log(Status.FAIL, "Test failed");

	}

	@AfterMethod
	public void quitting() {

		if (extent != null)
			extent.flush();
		if (driver != null)
			driver.quit();

	}
}
