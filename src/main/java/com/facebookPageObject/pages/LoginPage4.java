package com.facebookPageObject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.base.BasePage4;
import com.facebookPageObject.pages.session.LandingPage4;
import com.facebookPageObject.util.FBConstants;

public class LoginPage4 extends BasePage4 {

	
    
	public LoginPage4(WebDriver driver,ExtentTest test) {
		super(driver,test);
		
	}

	@FindBy(xpath = FBConstants.LOGIN_USERNAME)
	public WebElement email;
	@FindBy(xpath = FBConstants.LOGIN_PASSWORD)
	public WebElement psWord;

	public Object doLogin(String uName, String pWord) {
		test.log(Status.INFO, "Logging in-->"+uName+"/"+pWord);
        test.log(Status.INFO, "Entering data into email field-->"+uName);
		email.sendKeys(uName);
		test.log(Status.INFO, "Entering data into password field-->"+pWord);
		psWord.sendKeys(pWord+Keys.ENTER);
		test.log(Status.INFO, "Hitting the ENTER Key for login");
		//psWord.sendKeys(Keys.ENTER);
		// Validate --> Login--> logic here
		boolean loginSuccess = isElementPresent(FBConstants.PROFILEPAGE_LINK);
		if (loginSuccess) {
			test.log(Status.INFO, "Login Success");
			LandingPage4 landingPage = new LandingPage4(driver, test);
			PageFactory.initElements(driver, landingPage);
			return landingPage;
		} else {
			test.log(Status.INFO, "Login Not Success");
			LoginPage4 logingPage = new LoginPage4(driver, test);
			PageFactory.initElements(driver, logingPage);
			return logingPage;
		}

	}
}
