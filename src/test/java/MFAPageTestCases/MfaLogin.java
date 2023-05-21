package MFAPageTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.truage.qa.commonmethods.TestBase;
import com.truage.qa.pages.login_Page;
import com.truage.qa.pages.mfa_Page;

public class MfaLogin extends TestBase {
	login_Page login_Page;
	mfa_Page mfa_Page;
	
	@BeforeMethod
	public void setup() {
		initialization();
		mfa_Page = new mfa_Page();
		login_Page = new login_Page();
		login_Page.valid_login(prop.getProperty("QA_Email_Address"), prop.getProperty("QA_Password"));
	}

	// Verify that user is successfully able to login with valid mfa
	@Test(priority = 1)
	public void verify_valid_mfa_login() {
		mfa_Page.validate_valid_mfa_login();
	}

	// Verify that user is  not able to login with invalid mfa
	@Test(priority = 2)
	public void verify_invalid_mfa_login(){
		String actual_mfa_text = mfa_Page.validate_invalid_mfa_login();
		Assert.assertEquals(actual_mfa_text, "Get your security code from your preferred authentication app (e.g. Google Authenticator)");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
