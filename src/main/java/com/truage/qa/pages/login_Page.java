package com.truage.qa.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.truage.qa.commonmethods.TestBase;
//import java.util.concurrent.TimeUnit;

public class login_Page extends TestBase {
	
	//Page Factory or Object Repository for login_Page
	
	@FindBy(name="email")
	WebElement email_address;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement submit_button;
	
	@FindBy(xpath="//img[@alt='TruAgelogo']")
	WebElement logo;
	
	@FindBy(xpath="//a[@href='/forgot-password']")
	WebElement forgot_password_page;
	
	@FindBy(xpath="//*[text()='Log in with Magic link']")
	WebElement text;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement check_box;
	
	@FindBy(xpath="//*[text()='Login failed, invalid email or password!']")
	WebElement error_message;
	
	@FindBy(xpath="//*[text()='Email Address is a required field']")
	WebElement email_required;
	
	@FindBy(xpath="//*[text()='Password is a required field']")
	WebElement password_required;
	
	@FindBy (xpath="//*[text()='Thank you!']")
	WebElement thank_you_message;
	
	//Initializing the Page Object of login_Page
	public login_Page()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Action Perform on login_Page
	public String validate_page_title() {
		return driver.getTitle();
	}
	
	public boolean validate_logo() {
		return logo.isDisplayed();
	}
	
	public boolean validate_check_box() {
		return check_box.isDisplayed();
	}
	
	public boolean validate_forgot_password_page() {
		return forgot_password_page.isDisplayed();
	}
	
	public mfa_Page valid_login(String email, String pwd) {
		email_address.sendKeys(email);
		password.sendKeys(pwd);
		submit_button.click();
		return new mfa_Page();
	}
	
	
	public void invalid_login(String invalid_email, String invalid_pwd) {
		email_address.sendKeys(invalid_email);
		password.sendKeys(invalid_pwd);
		submit_button.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		error_message.isDisplayed();	
	}
	
	public void validate_empty_login() {
		submit_button.click();
		email_required.isDisplayed();
		password_required.isDisplayed();
	}
	
	public String validate_login_with_magic_link(String email1) {
		email_address.sendKeys(email1);
		check_box.click();
		submit_button.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String message = thank_you_message.getText();
		return message;
	}
	
	public forgot_password_Page validate_forgot_password_link_click() {
		forgot_password_page.click();
		return new forgot_password_Page();
	}
	
	
	
	
	
	
	
	
	
	
	

}
