package com.facebookPageObject.pages.session;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.base.BasePage4;

public class ProfilePage4 extends BasePage4
{
	
	
	public ProfilePage4(WebDriver driver,ExtentTest test)
	{
		super(driver,test);
	}
	
	public void proMethod()
	{
		System.out.println("I am ProfilePage");
		
	}
	
	public void verifyProfile()
	{
		test.log(Status.INFO, "Verifying Profile Page ");
	}

	

}
