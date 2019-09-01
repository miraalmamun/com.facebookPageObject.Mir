package com.facebookPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.facebookPageObject.pages.base.BasePage3;
import com.facebookPageObject.util.FBConstants;

public class LaunchPage3 extends BasePage3 {


	public LaunchPage3(WebDriver driver) {
       super(driver);
		
	}

	public LoginPage3 goToLoginPage() {
		
		driver.get(FBConstants.HOMEPAGE_URL);
		LoginPage3 loginPage = PageFactory.initElements(driver, LoginPage3.class);
		return loginPage;
	}

}
