package com.qa.mis.locators;

import org.openqa.selenium.By;

public class NavBarLocator {

    public static By Username = By.id("username");
    public static By Password = By.id("password");
    public static By Signbutton = By.id("btnLogin");

    public static By Location = By.xpath("//div[text()='Canaan Tower']");

    public static By Dashboardheading = By.xpath("//span[text()='Dashboard']");
    public static By SkillPopup = By.id("mypopupUpdateSkills");

    public static By Togglebtn = By.className("toggle-menu");

    public static By Sidebar = By.tagName("nav");

    public static By Profilemenu = By.xpath("//div[contains(@class,'user-menu')]");

    public static By UpdateProfileOption = By.id("updateProfile");

    public static By UpdateProfileSection = By.id("divUpdateProfile");


    public static By navigation_tabs(String tab) {

        return By.xpath("//ul[@class='nav']/li//span[text()='" + tab + "']");
    }

    public static By fields(String field) {
        return By.xpath("//div[@role='tabpanel']//label[text()='" + field + "']");
    }

    public static By buttons(String button){
        return By.xpath("//div[@class='tab-pane active']//button[contains(text(),'"+button+"')]");
    }

    public static By SiteLogo = By.xpath("//a[@class='site-logo']/img");

    public static By SkillsOption = By.id("skills");

    public static By Setting = By.id("dashBoardSettings");

    public  static  By technologySelect= By.xpath("//span[@id='select2-ddlSkills-container']");
    public static By technologyOption(String option){
        return By.xpath("//span[@class='select2-results']//li[text()='"+option+"']");
    }
    public  static  By proficiencySelect= By.xpath("//div[@id='UpdateSkills']//label[text()='Proficiency Level']/../..//select");
    public  static  By skillSelect= By.xpath("//div[@id='UpdateSkills']//label[text()='Skill Type']/../..//select");
    public static By techExperience = By.id("expinMonths");

    public static By totalExperience = By.id("TotalExp");

    public static By skillClosebtn = By.id("btnskillsClose");

    public static By skillSavebtn = By.id("btnSaveSkills");


    public static By heading_alertType = By.xpath("//div[contains(@class,'sweet-alert')]/h2");
    public static By text_alertMessage = By.xpath("//div[contains(@class,'sweet-alert')]/p");

    public static By changeADPassword = By.xpath("//a[text()='Change AD Password']");
    public static By Logout = By.xpath("//a[text()='Logout']");

    public static By loginForm = By.xpath("//form[contains(@class,'login-form')]");


    public static By DashboardPopup = By.id("DashBoardSettings");
    public static By DashboardCheckbox = By.xpath("//div[@id='DashBoardSettings']//input[@type='checkbox']");

    public static By DashboardUpdatebtn= By.id("btnSaveSetting");
    public static By Cardname = By.className("panel-title");

}


