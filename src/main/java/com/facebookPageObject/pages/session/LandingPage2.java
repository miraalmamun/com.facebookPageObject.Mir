package com.facebookPageObject.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebookPageObject.pages.base.BasePage2;

public class LandingPage2 extends BasePage2 
{
	
	
	public LandingPage2(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//span[@class='_1vp5']")
	public WebElement profile;
	
	public ProfilePage2 goToProfilePage()
	{   
		profile.click();
		return PageFactory.initElements(driver, ProfilePage2.class);
	}

}
