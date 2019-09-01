package com.facebookPageObject.pages.session;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage 
{
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[@class='_1vp5']")
	public WebElement profile;
	
	public ProfilePage goToProfilePage()
	{   
		profile.click();
		return PageFactory.initElements(driver, ProfilePage.class);
	}

}
