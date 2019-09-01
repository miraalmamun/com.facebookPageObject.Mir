package com.facebookPageObject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebookPageObject.pages.session.LandingPage;

public class LoginPage {
   
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(xpath="//*[@id='email']")
	public WebElement email;
	@FindBy(xpath = "//*[@id='pass']")
	public WebElement psWord;
	
	
	
	public Object doLogin(String uName,String pWord) 
	{
		//boolean loginSuccess = true;
		//driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(uName);
		//driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys(pWord);
		
		
		  email.sendKeys(uName);
		  psWord.sendKeys(pWord);
		  psWord.sendKeys(Keys.ENTER);
		 //Validate --> Login
		  boolean loginSuccess = true;
		  if(loginSuccess)
		  {
			  return PageFactory.initElements(driver,LandingPage.class);
		  }
		  else
		  {
			  return PageFactory.initElements(driver,LoginPage.class);
		  }
		
		
		
	}
}
