package MFAPageTestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.truage.qa.commonmethods.TestBase;
import com.truage.qa.pages.login_Page;
import com.truage.qa.pages.mfa_Page;

public class BackToLogin extends TestBase {
    login_Page login_Page;
    mfa_Page mfa_Page;
    
    @BeforeMethod
    public void setup(){
        initialization();
        mfa_Page = new mfa_Page();
		login_Page = new login_Page();
		login_Page.valid_login(prop.getProperty("QA_Email_Address"), prop.getProperty("QA_Password"));
    }

    //Verify that user is back to login Page while click on the Back to login link
    @Test
    public void varify_back_to_login_link(){
        mfa_Page.validate_back_to_login_link();
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
