package com.qa.mis.locators;

import org.openqa.selenium.By;

public class AccountsPortalLocator {
    public static By sideTab(String tab) {
        return By.xpath("//span[text()='" + tab + "']");
    }

    public static By greytHRLogo = By.xpath("//span[contains(@class,'gt-greytip-header-logo')]");

    public static By textField(String field) {

        return By.xpath("//label[text()='" + field + "']/..//input");

    }
    public static By header = By.xpath("//header/div[contains(text(),'Hello there!')]");
    public static By loginButton = By.xpath("//button[text()=' Log in ']");
    public static By forgetpasswordLink = By.xpath("//a[contains(text(),'Forgot password?')]");

    public static By message(String message) {

        return By.xpath("//form//div[text()=' " + message + " ']");
    }
}


