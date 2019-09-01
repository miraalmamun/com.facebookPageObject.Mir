package com.facebookPageObject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.facebookPageObject.pages.base.BasePage3;
import com.facebookPageObject.pages.session.LandingPage3;
import com.facebookPageObject.util.FBConstants;

public class LoginPage3 extends BasePage3 {

	

	public LoginPage3(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = FBConstants.LOGIN_USERNAME)
	public WebElement email;
	@FindBy(xpath = FBConstants.LOGIN_PASSWORD)
	public WebElement psWord;

	public Object doLogin(String uName, String pWord) {

		email.sendKeys(uName);
		psWord.sendKeys(pWord);
		psWord.sendKeys(Keys.ENTER);
		// Validate --> Login--> logic here
		boolean loginSuccess = true;
		if (loginSuccess) {
			return PageFactory.initElements(driver, LandingPage3.class);
		} else {
			return PageFactory.initElements(driver, LoginPage3.class);
		}

	}
}
