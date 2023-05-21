/* Test 1*/
package LoginPageTestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.truage.qa.commonmethods.TestBase;
import com.truage.qa.pages.login_Page;

public class Login extends TestBase  {
	login_Page login_Page;
	 
	 public Login() {
		 super();
	 }
	 
	 @BeforeMethod 
	 public void setup() {
		 initialization();
		 login_Page = new login_Page();
	 }
	 @Test(priority=1)
	 public void verify_valid_login() {
		login_Page.valid_login(prop.getProperty("QA_Email_Address"), prop.getProperty("QA_Password"));
	
	 }
	 
	 @Test(priority=2)
	 public void verify_invalid_login() {
		 login_Page.invalid_login(prop.getProperty("QA_Invalid_Email"), prop.getProperty("QA_Invalid_Password"));
	 }
	 
	 @Test(priority=3)
	 public void verify_empty_login() {
		 login_Page.validate_empty_login();
	 }
	 
	 @Test(priority=4)
	 public void verify_magic_link_login() {
		String message1 = login_Page.validate_login_with_magic_link(prop.getProperty("QA_Email_Address"));
		 Assert.assertEquals(message1, "Thank you!");
	 }
	 
	 @AfterMethod
	 public void teardown() {
		 driver.quit();
	 }

}
