package com.facebookPageObject.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.base.BasePage4;
import com.facebookPageObject.util.FBConstants;

public class LandingPage4 extends BasePage4 
{
	
	
	public LandingPage4(WebDriver driver,ExtentTest test)
	{
		super(driver,test);
	}
	
	@FindBy(xpath = FBConstants.PROFILEPAGE_LINK)
	public WebElement profile;
	
	public ProfilePage4 goToProfilePage()
	{   
		test.log(Status.INFO, "Going to Profile Page");
		profile.click();
		ProfilePage4 profilePage = new ProfilePage4(driver,test);
		PageFactory.initElements(driver, profilePage);
		return profilePage;
	}

}
