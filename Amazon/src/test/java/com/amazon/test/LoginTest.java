package com.amazon.test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.amazon.base.TestDriver;
import com.amazon.pageobjects.LoginPage;
import com.amazon.utility.Utility;
import com.relevantcodes.extentreports.LogStatus;

public class LoginTest extends TestDriver {



	public LoginTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Test(priority=1)
	public void login(){
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		logger = report.startTest("login");
		login.Emailid().sendKeys(Utility.USERNAME);
		login.Password().sendKeys(Utility.PASSWORD);
		logger.log(LogStatus.PASS, "Title verified");
		//login.Login().click();

	}

	@Test(priority=2)
	public void login2(){
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);

		login.Emailid().clear();;
		login.Password().clear();;
		//login.Login().click();

	}
}
