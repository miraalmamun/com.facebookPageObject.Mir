package com.facebookPageObject.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.facebookPageObject.pages.common.TopMenu;

public class BasePage2 
{
	
	public WebDriver driver;
	private TopMenu menu;
	
	public BasePage2(WebDriver driver)
	{
		this.driver = driver;
		menu = PageFactory.initElements(driver, TopMenu.class);
	}
	
	public String verifyTitle(String expTitle)
	{
		return "";
	}
	public String verifyText(String locator, String expText)
	{
		return "";
	}
	
	public boolean isElementPresent(String locator)
	{
		return false;
	}

	public TopMenu getMenu() {
		return menu;
	}

	
    
//	public TopMenu getMenu()
//	{
//		return menu;
//	}
//	

	

}
