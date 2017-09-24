package com.amazon.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(xpath=".//*[@id='ap_email']")
    WebElement username;
	
	@FindBy(xpath="//*[@id='ap_password']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='signInSubmit']")
	WebElement login;
	
	
	public WebElement Emailid(){
		 return username;
	}
	
	public WebElement Password(){
		return password;
	}
	
	public WebElement Login(){
		return login;
	}

}
