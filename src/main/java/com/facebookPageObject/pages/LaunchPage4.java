package com.facebookPageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.facebookPageObject.pages.base.BasePage4;
import com.facebookPageObject.util.FBConstants;


public class LaunchPage4 extends BasePage4 {

    
	public LaunchPage4(WebDriver driver,ExtentTest test) {
       super(driver,test);
       
		
	}
	
	
	//input[@name='firstname']
	//input[@name='lastname']
	//input[@ aria-label='Mobile number or email']
	//input[@name='reg_passwd__']--->new password
	//select[@id='month']-->Select Month
	//select[@id='day']
	//select[@id='year']
	//span/input[@value='1']--sex custom
	//select[@name='preferred_pronoun']
	//div/input[@name='custom_gender']-->Gender(optional)
	//button[@name='websubmit']-->Sign Up Button
	
	
	
	
	
	
	

	public LoginPage4 goToLoginPage() {
		test.log(Status.INFO, "Opening the URL-->"+FBConstants.HOMEPAGE_URL);
		driver.get(FBConstants.HOMEPAGE_URL);
		test.log(Status.INFO, "Opened the URL-->"+FBConstants.HOMEPAGE_URL);
		LoginPage4 loginPage = new LoginPage4(driver, test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}

}
