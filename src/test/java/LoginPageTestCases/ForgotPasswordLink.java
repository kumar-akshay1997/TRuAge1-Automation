package LoginPageTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.truage.qa.commonmethods.TestBase;
import com.truage.qa.pages.login_Page;
import com.truage.qa.pages.forgot_password_Page;

public class ForgotPasswordLink extends TestBase {
	 login_Page login_Page;
	 forgot_password_Page forgot_password_Page;
	
	public ForgotPasswordLink() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		login_Page = new login_Page();	
		forgot_password_Page = new forgot_password_Page();
	}
	
	//Verify Forgot Password Page is successfully getting display
	@Test
	public void verify_forgot_password_link() {
		login_Page.validate_forgot_password_link_click();
		String Text2 = forgot_password_Page.validate_text_display();
		Assert.assertEquals(Text2, "Forgot Password");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
