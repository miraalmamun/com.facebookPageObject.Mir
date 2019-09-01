package com.facebookPageObject.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.facebookPageObject.pages.base.BasePage2;

public class LaunchPage2 extends BasePage2 {


	public LaunchPage2(WebDriver driver) {
       super(driver);
		
	}

	public LoginPage2 goToLoginPage() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		LoginPage2 loginPage = PageFactory.initElements(driver, LoginPage2.class);
		return loginPage;
	}

}
