package LoginPageTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.truage.qa.commonmethods.TestBase;
import com.truage.qa.pages.login_Page;

public class ImageAndTextDisplay extends TestBase {
	login_Page login_Page;
	
	public ImageAndTextDisplay() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		login_Page = new login_Page();
	}
	
	//Verify login Page title successfully display.
	@Test(priority=1)
	public void verify_page_title() {
		String title = login_Page.validate_page_title();
		Assert.assertEquals(title, "");
	}
	
	//Verify TruAge logo successfully display on the login.html Page
	@Test(priority=2)
	public void verify_TruAge_Logo() {
		Boolean logo = login_Page.validate_logo();
		Assert.assertTrue(logo);
	}
	
	//Verify check-box successfully display on the login.html Page
	//@Test(priority=3)
	//public void verify_check_box() {
		//Boolean check_box=login_Page.validate_check_box();
		//Assert.assertTrue(check_box);
	//}
	
	//Verify forgot password link successfully display on the screen
	@Test(priority=4)
	public void verify_forgot_password_link() {
		Boolean forgot_password_link=login_Page.validate_forgot_password_page();
		Assert.assertTrue(forgot_password_link);
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}
