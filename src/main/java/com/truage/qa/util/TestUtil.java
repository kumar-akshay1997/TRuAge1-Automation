package com.truage.qa.util;

import java.io.IOException;
import java.io.File;
import com.truage.qa.commonmethods.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends TestBase {

    public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "\\screenshots\\" + System.currentTimeMillis() + ".png"));
    }
    
}
