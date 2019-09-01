package com.facebookPageObject.pages.session.settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.base.BasePage4;
import com.facebookPageObject.util.FBConstants;

public class GeneralSettingsPage extends BasePage4 {

	public GeneralSettingsPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

	@FindBy(xpath = FBConstants.SECURITYandLOGIN_LINK)
	public WebElement securityAndLogin;
	@FindBy(xpath = FBConstants.CHANGEpassword)
	public WebElement changePassword;

	public SecurityAndLoginPage goToSecurityAndLoginPage() {
		test.log(Status.INFO, "Going to Security and Login Page");
		securityAndLogin.click();
		test.log(Status.INFO, "Security and login Page opened");
		SecurityAndLoginPage securityAndLoginPage = new SecurityAndLoginPage(driver, test);
		PageFactory.initElements(driver, securityAndLoginPage);
		return securityAndLoginPage;
	}

}
