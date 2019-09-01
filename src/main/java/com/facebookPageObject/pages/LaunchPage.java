package com.facebookPageObject.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage {
	WebDriver driver;

	public LaunchPage(WebDriver driver) {
		// System.out.println("Here LaunchPage");
		// driver.manage().window().maximize();
		// driver.get("http://yahoo.com");

		this.driver = driver;
	}

	public LoginPage goToLoginPage() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://facebook.com");
		//LoginPage loginPage = new LoginPage(driver);
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		return loginPage;
	}

}
