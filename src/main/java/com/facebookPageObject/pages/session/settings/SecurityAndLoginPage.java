package com.facebookPageObject.pages.session.settings;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.base.BasePage4;
import com.facebookPageObject.util.FBConstants;

public class SecurityAndLoginPage extends BasePage4 {

	public SecurityAndLoginPage(WebDriver driver, ExtentTest test) {
		super(driver, test);

	}

	@FindBy(xpath = FBConstants.CHANGEpassword)
	public WebElement changePassword;
	@FindBy(xpath = FBConstants.OLD_PASSWORD)
	public WebElement passwordOldInput;
	@FindBy(xpath = FBConstants.NEW_PASSWORD)
	public WebElement passwordNewInput;
	@FindBy(xpath = FBConstants.CONFIRM_PASSWORD)
	public WebElement confirmPassword;
	@FindBy(xpath = FBConstants.SAVE_CHANGES)
	public WebElement saveChanges;
	@FindBy(xpath = FBConstants.REVIEW_DEVICES)
	public WebElement reviewOtherDevies;
	@FindBy(xpath = FBConstants.STAY_LOGGED)
	public WebElement stayLogged;
	@FindBy(xpath = FBConstants.CONTINUE_PASSWORD_CHANGE_BUTTON)
	public WebElement continuePasswdChange;
	@FindBy(xpath = FBConstants.CLOSE)
	public WebElement closeButton;

	public void goToPasswordChange() {
		test.log(Status.INFO, "clicking on password change");
		if (!isElementPresent(FBConstants.CHANGEpassword)) {
			test.log(Status.FAIL, "Element not found-->" + FBConstants.CHANGEpassword);
			takeSceenShot();
			Assert.fail("Element not found-->" + FBConstants.CHANGEpassword);
		}
		changePassword.click();
		if (closeButton.isDisplayed()) {
			test.log(Status.INFO, "Close Button is  Displayed");
			test.log(Status.INFO, "On password change table");
		} else {
			test.log(Status.INFO, "Close Button is not Displayed");
			takeSceenShot();
			Assert.fail("Element not found-->" + FBConstants.CHANGEpassword);
		}

	}

	public String doPasswordChange(String oldPassword, String newPassword) {
		test.log(Status.INFO, "Trying to change password with valid credential");
		test.log(Status.INFO, "Entering Current Password and New Password " + oldPassword + "/" + newPassword);
		passwordOldInput.click();
		passwordOldInput.sendKeys(oldPassword);
		passwordNewInput.click();
		passwordNewInput.sendKeys(newPassword);
		confirmPassword.sendKeys(newPassword);

		if (saveChanges.isEnabled()) {
			saveChanges.click();
			test.log(Status.INFO, "Successfully click on Save Changes link");
		} else {
			test.log(Status.FAIL, "Check the input field");
		}
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		try {

			// closeButton.isDisplayed() || closeButton.isEnabled();
			closeButton.isDisplayed();
			test.log(Status.INFO, "Close Button is  Displayed");
			test.log(Status.INFO, "Your password was incorrect.");
			return "Unsuccessful";

		} catch (NoSuchElementException e) {

			// reviewOtherDevies.click();
			stayLogged.click();
			continuePasswdChange.click();
			test.log(Status.INFO, "Changed Password Successfully");

			return "Success";

		}
		
		
		//https://learn.letskodeit.com-->No such elementException
		//https://www.freecrm.com/index.html

		/*
		 * 
		 * public void gotoPasswordChange() { test.log(LogStatus.INFO,
		 * "Clicking on Security Login"); securityAndLogin.click(); if
		 * (!isElementPresent(FBConstants.PASSWORD_CHANGE_LINK)) {
		 * test.log(LogStatus.FAIL, "Element not found " +
		 * FBConstants.PASSWORD_CHANGE_LINK); reportFailure("Element not found " +
		 * FBConstants.PASSWORD_CHANGE_LINK); }
		 * 
		 * changePasswordLink.click(); test.log(LogStatus.INFO,
		 * "On password change page"); }
		 * 
		 * public String doPasswordChange(String oPassword, String nPassword) {
		 * test.log(LogStatus.INFO, "Entering Current Password and New Password " +
		 * oPassword + "/" + nPassword); oldPassword.sendKeys(oPassword);
		 * newPassword.sendKeys(nPassword); confirmPassword.sendKeys(nPassword);
		 * saveChanges.click(); test.log(LogStatus.INFO,
		 * "Successfully click on Save Changes link"); if
		 * (!isElementPresent(FBConstants.PASSWORD_CHANGE_LINK)) { return
		 * "Unsuccessful"; } reviewOtherDevies.click(); continuePasswdChange.click();
		 * test.log(LogStatus.INFO, "Changed Password Successfully"); return "Success";
		 * }
		 */

		/*
		 * if(closeButton.isEnabled()) { test.log(Status.INFO,
		 * "Close Button is Enabled"); } else { test.log(Status.INFO,
		 * "Close Button is not Enabled"); }
		 * 
		 * if(closeButton.isDisplayed()) { test.log(Status.INFO,
		 * "Close Button is  Displayed"); } else { test.log(Status.INFO,
		 * "Close Button is not Displayed"); }
		 */

		/*
		 * try { //Actions can be performed here } catch (RuntimeException ee) { if
		 * (ee.toString().contains("NoSuchElementException")) { //steps } }
		 */
	}
}
