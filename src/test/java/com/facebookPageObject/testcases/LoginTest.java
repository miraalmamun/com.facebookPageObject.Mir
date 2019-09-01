package com.facebookPageObject.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.LaunchPage3;
import com.facebookPageObject.pages.LoginPage3;
import com.facebookPageObject.testcases.base.BaseTest;

public class LoginTest extends BaseTest
{  
	
	
   @Test
   public void doLogin()
   {   
	   
	   test = extent.createTest("Login Test");
	   test.log(Status.INFO, "Starting Login Test");
	   test.log(Status.INFO, "Opening Breowser");
	   
	   init("Chrome");
	   LaunchPage3 launchPage = PageFactory.initElements(driver, LaunchPage3.class);
	   LoginPage3 loginPage = launchPage.goToLoginPage();
	   test.log(Status.INFO, "Logging in");
	   loginPage.doLogin("miraalmamun@gmail.com", "Mimo94965812345678");
	   test.log(Status.PASS, "Login Test passed");
	   extent.flush();
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
