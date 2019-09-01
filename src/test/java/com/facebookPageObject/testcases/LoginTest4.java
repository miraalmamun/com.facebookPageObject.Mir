package com.facebookPageObject.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.LaunchPage4;
import com.facebookPageObject.pages.LoginPage4;
import com.facebookPageObject.pages.session.LandingPage4;
import com.facebookPageObject.testcases.base.BaseTest4;
import com.facebookPageObject.util.DataUtil;
import com.facebookPageObject.util.FBConstants;

public class LoginTest4 extends BaseTest4 {
	String testCaseName = "LoginTest";

	@Test(dataProvider = "getData")
	public void doLogin(Hashtable<String, String> data) {

		test = extent.createTest("Login Test");
		test.log(Status.INFO, "Passing data from Excel-->" + data.toString());
		if (data.get(FBConstants.RUNMODE_COL).equals("N")) {
			test.log(Status.SKIP, "Skipping the test case as Runmode is N");
			throw new SkipException("Skipping the test case as Runmode is N");
		}

		test.log(Status.INFO, "Starting Login Test");

		init(data.get("Browser"));
		LaunchPage4 launchPage = new LaunchPage4(driver, test);
		LoginPage4 loginPage = launchPage.goToLoginPage();
		test.log(Status.INFO, "Logging in");
		Object pages = loginPage.doLogin(data.get("Username"), data.get("Password"));
		String actualResult = "";
		if(pages instanceof LandingPage4)
		{
			actualResult = "Success";
		}
		else
		{
			actualResult = "UnSuccess";
		}
		if(!actualResult.equals(data.get("ExpectedResult")))
			reportFailure("Unable to Login");

		test.log(Status.PASS, "Login Test passed");

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
	
//======================================Validate Login=================================================	
	
	/*
	                  com.cucumber.tqr----Project
	                  
	public void validateLogin(String expectedResult) {
		boolean result=isElementPresent(prop.getProperty("createPortfolio"));
		String actualResult="";
		
		if(result)
			actualResult="success";
		else
			actualResult="failure";

		infoLog("ExpectedResult was " + expectedResult);
		infoLog("Got actualt Result as " + actualResult);
		if(!expectedResult.equals(actualResult)) {
			reportFailure("Scenario Failure"); // reporting failure
		}
		else
		{
			infoLog("Login successful");
		}
	}
	
	*/
	//=======================================================================================================
	/*     DataDriven_Zoho_April18---Project
	 * 
	 * 
	public boolean doLogin(String userName, String password) {
		test.log(LogStatus.INFO, "Trying to login with-> " + userName + " , " + password);
		click("loginLink_xpath");
		wait(1);
		waitForPageToLoad();
		type("loginid_xpath", userName);
		type("password_xpath", password);
		click("siginButton_xpath");
		if (isElementPresent("crmlink_xpath")) {
			test.log(LogStatus.INFO, "Login Success");
			return true;
		} else {
			test.log(LogStatus.INFO, "Login Failed");
			return false;
		}

	}
	*/
	/*
	boolean actualResult = doLogin(data.get("Username"), data.get("Password"));
	boolean expectedResult = false;
	if(data.get("ExpectedResult").equals("Pass"))
	{
		expectedResult = true;
	}
	else
	{
		expectedResult = false;
	}
	
	if(expectedResult!=actualResult)
	{
		reportFailure("Login Test Failed");
	}
	else
	{
		reportPass("Login Test Passed");
	}
	
	*/
	
	
	
//=========================================================	=================================================
	
	
}
