package com.truage.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.truage.qa.commonmethods.TestBase;

public class press_releases_Page extends TestBase {
    press_releases_Page press_releases_Page;

    @FindBy(xpath="//h1[text()='Press Releases']")
    WebElement press_releases_title;

    @FindBy(xpath="//button[text()='Add Press Release']")
    WebElement add_press_release_btn;

    public press_releases_Page(){
        PageFactory.initElements(driver, this);
    }
    
}
