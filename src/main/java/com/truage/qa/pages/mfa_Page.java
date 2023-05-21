package com.truage.qa.pages;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.truage.qa.commonmethods.TestBase;

public class mfa_Page extends TestBase {
	mfa_Page mfa_Page;
	
	@FindBy(name="code")
	WebElement code_field;
	
	@FindBy(xpath="//h1[text()='MFA Security Code']")
	WebElement mfa_security_code;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement verify_button;
	
	@FindBy(xpath="//a[@href='/login']")
	WebElement back_to_login;

	@FindBy(xpath="//p[text()='Get your security code from your preferred authentication app (e.g. Google Authenticator)']")
	WebElement invalid_code_text;
	
	public mfa_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public press_releases_Page validate_valid_mfa_login() {
		String key = prop.getProperty("key");
		Totp totp = new Totp(key);
		String valid_code=totp.now();
		code_field.sendKeys(valid_code);
		verify_button.click();
		return new press_releases_Page();
	}
	
	public String validate_invalid_mfa_login() {
		String invalid_key = prop.getProperty("invalid_key");
		Totp totp1 = new Totp(invalid_key);
		String invalid_code=totp1.now();
		code_field.sendKeys(invalid_code);
		verify_button.click();
		String invalid_code_text1 = invalid_code_text.getText();
		return invalid_code_text1;
	}

	public login_Page validate_back_to_login_link(){
		back_to_login.click();
		return new login_Page();
	}

}
