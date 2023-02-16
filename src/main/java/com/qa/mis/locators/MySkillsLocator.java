package com.qa.mis.locators;

import org.openqa.selenium.By;

public class MySkillsLocator {
    public static By userImg = By.xpath("//div[contains(@class,'user-menu')]");
    public static By skillsBtn = By.xpath("//a[@id='skills']");
    public static By SkillPopup = By.id("mypopupUpdateSkills");
    public static By technologyDropDown = By.xpath("//span[@id='select2-ddlSkills-container' and @title='Select']");
    public static By selectTechnology(String technology) {

        return By.xpath("//li[contains(text(),'" + technology + "')]");
    }

    public static By professionalDropDown = By.xpath("//select[@id=\"ddlSkillLevel\"]");

    public static By selectProfessional(String professionalLevel) {

        return By.xpath("//option[contains(text(),'" + professionalLevel + "')]");
    }

    public static By skillsUpdated=By.xpath("//section[@id='SkillSet']");

    public static By mySkill(String mySkills) {

        return By.xpath("//a[contains(text(),'" + mySkills + "')]");
    }
    public static By skillOkBtn=By.xpath("//button[text()='OK']");
    public static By closeBtn=By.xpath("//button[@id=\"btnskillsEditClose\"]");

    public static By totalExperience = By.xpath("//input[@id=\"TotalExp\"]");
    public static By skillSaveBtn = By.xpath("//button[@id=\"btnSaveSkills\"]");

    public static By technologyOption(String option) {
        return By.xpath("//span[@class='select2-results']//li[text()='" + option + "']");
    }

    public static By proficiencySelect = By.xpath("//div[@id='UpdateSkills']//label[text()='Proficiency Level']/../..//select");
    public static By skillSelect = By.xpath("//div[@id='UpdateSkills']//label[text()='Skill Type']/../..//select");

    public static By selectOption(String option) {
        return By.xpath("//select/option[text()='\" + option + \"']");
    }

    public static By techExperience = By.id("expinMonths");
    public static By skillCloseBtn=By.xpath("//button[@id=\"btnskillsClose\"]");

    public static By heading_alertType = By.xpath("//div[contains(@class,'sweet-alert')]/h2");
    public static By text_alertMessage = By.xpath("//div[contains(@class,'sweet-alert')]/p");

    public static By skillsTypeBtn = By.xpath("//select[@id=\"ddlSkillType\"]");

}
