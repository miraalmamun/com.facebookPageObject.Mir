package com.facebookPageObject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebookPageObject.pages.base.BasePage2;
import com.facebookPageObject.pages.session.LandingPage2;

public class LoginPage2 extends BasePage2 {

	

	public LoginPage2(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='email']")
	public WebElement email;
	@FindBy(xpath = "//*[@id='pass']")
	public WebElement psWord;

	public Object doLogin(String uName, String pWord) {

		email.sendKeys(uName);
		psWord.sendKeys(pWord);
		psWord.sendKeys(Keys.ENTER);
		// Validate --> Login--> logic here
		boolean loginSuccess = true;
		if (loginSuccess) {
			return PageFactory.initElements(driver, LandingPage2.class);
		} else {
			return PageFactory.initElements(driver, LoginPage2.class);
		}

	}
}
