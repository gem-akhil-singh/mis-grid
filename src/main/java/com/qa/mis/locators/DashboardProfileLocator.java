package com.qa.mis.locators;

import org.openqa.selenium.By;

public class DashboardProfileLocator {

    public static By userName = By.id("username");

    public static By password = By.id("password");

    public static By signIn = By.id("btnLogin");

    public static By popUpCloseButton = By.xpath("//button[@id='btnskillsClose']");

    public static By contactNo =By.xpath("//input[@id='contactNo']");
    public static By enterExtNo = By.id("extnNo");

   // public static By editDetails=By.xpath("//i[@class='fa fa-edit']");
    public static By clickOnUpdate = By.xpath("//button[@id='btnUpdate']");

    // public static By clickOnUpdate = By.xpath("//button[@id='btnUpdate']");

    public static By clickOnChangeDetails = By.xpath("//i[@class='fa fa-edit']");

    public static By clickOnUpdateAdd = By.xpath("//span[text()='Update Address']");

    public static By enterPincode = By.xpath("//input[@id='presentPincode']");

    public static By updateButtonAdd = By.xpath("//button[@id='btnUpdateAdd']");

    public static By invalidPincode = By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");

    public static By warning = By.xpath("//h2[text()='Warning']");

    public static By changePassword= By.xpath("//span[text()='Change Password']");

    public static By enterOldPassword=By.id("txtOldPassword");

    public static By newPassword=By.xpath("//input[@id='txtNewPassword']");

    public static By confirmPassword=By.xpath("//input[@id='txtconfirmPassword']");

    public static By updatePassword=By.xpath("//button[@id='btnChangePassword']");

    public static By okButton = By.xpath("//button[text()='OK']");

    public static By applyLunch=By.xpath("//i[@class='fa fa-cutlery']");

    public static By passwordNotMatch=By.xpath("//span[@id='password_match']");

    public static By fromDate=By.xpath("(//input[@name='fromDate'])[1]");

    public static By selectFromDate=By.xpath("(//td[@class='day'])[1]");

    public static By tillDate=By.xpath("//input[@id='tillDateEmp']");

    public static By selectTillDate=By.xpath("(//td[@class='day'])[3]");

    public static By locationContainer=By.xpath("//span[@id='select2-location-container']");

    public static By selectLocation=By.xpath("//li[text()='Canaan Tower']");

    public static By addLunchButton=By.xpath("//button[@id='BtnsaveDateforLunch']");

    public static By enterMobileNo=By.xpath("//input[@id='contactNo']");

    public static By invalidPhNumber=By.xpath("//div[@class='sweet-alert  showSweetAlert visible']");
    public static By updateMobileNo=By.xpath("//button[@id='btnUpdate']");

   // public static By enterExtNo=By.xpath("//input[@id='extnNo']");

}
