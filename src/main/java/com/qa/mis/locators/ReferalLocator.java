package com.qa.mis.locators;

import org.openqa.selenium.By;

public class ReferalLocator {


    public static By dashboardVisible = By.xpath("//span[text()='Dashboard']");

    // public static By dsbrdVisible=By.xpath("//a[@href='https://mymis.geminisolutions.com/Dashboard/Index']");

    public static By verifyJdWindow = By.xpath("//h3[text()='Referral']");

    public static By referralAction = By.xpath("//button[@title='Refer']");

    public static By refName = By.xpath("//input[@maxlength='200']");

    public static By refSection = By.xpath("//section[@id='Referrals']");

    public static By refEmail = By.xpath("(//input[@maxlength='200'])[2]");

    public static By refSaveButton = By.xpath("//button[@id='btnAddReferral']");

    public static By refWarning = By.xpath("//h2[text()='Warning']");

    public static By clickFAQ = By.xpath("//a[text()='FAQ']");

    public static By pdfVisible = By.xpath("//div[@id='viewDocumentModal']");

    //public static By manual=By.xpath("//a[text()='Manual']");

    public static By manualVisible = By.xpath("//div[@class='col-md-9']/a[2]");
            //"//a[@onclick='showStepsPopup()']");
        //    By.xpath("//a[text()='Manual']");

    public static By resumeUpload =By.xpath("/html[1]/body[1]/div[2]/div[12]/div[1]/div[1]/div[2]/div[5]/div[2]/input[1]");
            //By.xpath("//input[@id='resume']");

    public static By selectHimOrHer=By.xpath("//select[@id='relationName']");

    public static By resumeWarning = By.xpath("//div[@class='sa-icon sa-warning pulseWarning']");

    public static By enterCorrEmail = By.id("refereeID");

    public static By enterRefContNo = By.xpath("//input[@type='number']");


}