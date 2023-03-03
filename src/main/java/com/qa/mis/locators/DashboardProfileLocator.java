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
    // ("body.with-side-menu.control-panel.control-panel-compact.chrome-browser.modal-open:nth-child(2) div.modal.fade.in:nth-child(10) div.modal-dialog.modal-lg div.modal-content:nth-child(1) div.modal-body.lunch div.row:nth-child(1) div.col-md-4:nth-child(1) div.form-group div.inputGroupContainer.date.date-picker div.input-group span.input-group-btn button.btn.default > i.fa.fa-calendar");




    public static By selectNextArrow=By.xpath("//body[1]/div[16]/div[1]/table[1]/thead[1]/tr[2]/th[3]");
    public static By selectFromDate=By.xpath("(//td[@class='day'])[27]");
    //td[@class='day'])[27]"
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
