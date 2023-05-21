
package com.truage.qa.commonmethods;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
	try {
			prop = new Properties();
			FileInputStream inputstream = new FileInputStream("/Users/kumar.akshay/eclipse-workspace/TruAge/src\\main/java/com/truage/qa/environmentvariables/config.properties");
			prop.load(inputstream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void initialization() {
		String Browser = prop.getProperty("Browser");
			System.setProperty("webdriver.chrome.driver", "/Users/kumar.akshay/Downloads/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(prop.getProperty("QA_URL"));
	}

}