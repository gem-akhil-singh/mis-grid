package com.qa.mis.locators;

import org.openqa.selenium.By;

public class LoginLocator {
    public static By username = By.id("username");
    public static By password = By.id("password");
    public static By signInButton = By.id("btnLogin");
    public static By forgotPasswordButton = By.id("lnkForgotPassword");
    public static By loginWithSSOButton = By.xpath("//button[@class='btn btn-rounded ssobtn']");
    public static By loginMsg = By.xpath("//div[@class='loginMsgDiv']");
    public static By loginErrorMessage = By.xpath("//span[@class='message']");
    public static By closeButton = By.xpath("//div[@id='skillsSettings']//button[@class='close']");
    public static By forgotPasswordMessage = By.xpath("//span[@class='message']");
    public static By successMessage = By.xpath("//p[@class='lead text-muted '] ");
    public static By profileOption=By.xpath("//button[@id='dd-user-menu']");
    public static By logOutButton=By.xpath("//span[@class='font-icon glyphicon glyphicon-log-out']");
}
