package com.facebookPageObject.pages.session;

import org.openqa.selenium.WebDriver;

import com.facebookPageObject.pages.base.BasePage3;

public class ProfilePage3 extends BasePage3 
{
	
	
	public ProfilePage3(WebDriver driver)
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
