package com.facebookPageObject.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebookPageObject.pages.base.BasePage3;
import com.facebookPageObject.util.FBConstants;

public class LandingPage3 extends BasePage3 
{
	
	
	public LandingPage3(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = FBConstants.PROFILEPAGE_LINK)
	public WebElement profile;
	
	public ProfilePage3 goToProfilePage()
	{   
		profile.click();
		return PageFactory.initElements(driver, ProfilePage3.class);
	}

}
