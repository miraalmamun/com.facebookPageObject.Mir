package com.facebookPageObject.pages.common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebookPageObject.pages.LoginPage3;

public class TopMenu3 
{
	WebDriver driver;
	
	public TopMenu3(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath = "//div[@id='userNavigationLabel']")
	public WebElement userNavigate;
	@FindBy(xpath = "//span[text()='Log Out']")
	public WebElement logOut;
	
	
	public LoginPage3 logOut()
	{    
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('userNavigationLabel').click();");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		logOut.click();
		
		return PageFactory.initElements(driver, LoginPage3.class);
		
		
	}
	
	public void goToSetting()
	{
		
	}
	
	public void search()
	{
		
	}
	
	
   
}
