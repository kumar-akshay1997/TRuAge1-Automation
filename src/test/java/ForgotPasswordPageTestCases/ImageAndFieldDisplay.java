package ForgotPasswordPageTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.truage.qa.commonmethods.TestBase;
import com.truage.qa.pages.forgot_password_Page;
import com.truage.qa.pages.login_Page;

public class ImageAndFieldDisplay extends TestBase {
	forgot_password_Page forgot_password_Page;
	login_Page login_Page;
	
	public ImageAndFieldDisplay() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		forgot_password_Page = new forgot_password_Page();
		login_Page = new login_Page();
		login_Page.validate_forgot_password_link_click();
	}
	
	@Test(priority=1)
	public void verify_mfa_logo() {
		forgot_password_Page.validate_mfa_logo();
		Assert.assertTrue(true);
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	

}
