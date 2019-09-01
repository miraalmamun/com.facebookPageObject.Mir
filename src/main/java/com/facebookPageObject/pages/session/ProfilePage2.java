package com.facebookPageObject.pages.session;

import org.openqa.selenium.WebDriver;

import com.facebookPageObject.pages.base.BasePage2;

public class ProfilePage2 extends BasePage2 
{
	
	
	public ProfilePage2(WebDriver driver)
	{
		super(driver);
	}
	
	public void proMethod()
	{
		System.out.println("I am ProfilePage");
		
	}
	
	public void verifyProfile()
	{
		System.out.println("Profile Page is okey");
	}

}
