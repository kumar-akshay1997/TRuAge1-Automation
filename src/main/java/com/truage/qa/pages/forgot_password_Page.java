package com.truage.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.truage.qa.commonmethods.TestBase;

public class forgot_password_Page extends TestBase {

	@FindBy(xpath="//img[@alt='TruAgeLogo']")
	WebElement mfa_logo;
	
	@FindBy(xpath="//h1[text()='Forgot Password']")
	WebElement forgot_password_text;
	
	@FindBy(name="email")
	WebElement email_field;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement mfa_submit_button;
	
	@FindBy(xpath="//*[text()='Reset password link sent to your email']")
	WebElement forgot_password_message;
	
	public forgot_password_Page() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validate_mfa_logo() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean mfa_logo1 = mfa_logo.isDisplayed();
		return mfa_logo1;
	}
	
	public String validate_text_display() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		forgot_password_text.isDisplayed();
		String Text2 = forgot_password_text.getText();
		return Text2;
	}
	
	public login_Page validate_forgot_password_link_send(String email_address) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		email_field.sendKeys(email_address);
		mfa_submit_button.click();
		//forgot_password_message.isDisplayed();
		return new login_Page();
		
	}
}
