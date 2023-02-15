package com.qa.mis.locators;

import org.openqa.selenium.By;

public class OtherportalnTimesheetLocator {

    public static By lgnusernm=By.id("username");
    public static By lgnpwd=By.id("password");
    public static By sgnupbtn=By.id("btnLogin");
    public static By Location = By.xpath("//div[text()='Canaan Tower']");
    public static By Dashboardheading = By.xpath("//span[text()='Dashboard']");
    public static By timesheetbtn=By.xpath("//div[@class='jspPane']//child::span/span");
    public static By otherPortal=By.xpath("//div[@class='jspPane']//child::span[text()='Other Portals']");
    public static By otherPortalList=By.xpath("//li[contains(@class, 'sub open')]/ul/li");
    public static By configutetimesheet=By.xpath("//div[@class='jspPane']//child::span[text()='Configure Timesheet']");
    public static By createtimesheet=By.xpath("//div[@class='jspPane']//child::span[text()='Create Timesheet']");
    public static By managetaskTemplate=By.xpath("//div[@class='jspPane']//child::span[text()='Manage Task Template']");
    public static By configuretable=By.id("tblProjectList");
    public static By orgstructure=By.xpath("//span[text()='Organization Structure']");


}
