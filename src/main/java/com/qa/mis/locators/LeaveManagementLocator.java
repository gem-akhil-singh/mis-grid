package com.qa.mis.locators;

import org.openqa.selenium.By;

public class LeaveManagementLocator {

    public static By input_loginUsername = By.xpath("//input[@id='username']");
    public static By input_loginPassword = By.xpath("//input[@id='password']");
    public static By button_SignIn = By.xpath("//input[@id='btnLogin']");
    public static By menu_HomePage = By.xpath("//ul[@class='side-menu-list']");

    public static By menu_parentTabs(String parentTab) {
        return By.xpath("//ul[@class='side-menu-list']//span[text()='" + parentTab + "']");
    }

    public static By menu_childTabs(String childTab) {
        return By.xpath("//ul[@class='side-menu-list']//ul/li//span[text()='" + childTab + "']");
    }

    public static By heading_Page = By.xpath("//div[@class='card-block']/h5");

    public static By navigation_tabs(String tab) {
        return By.xpath("//ul[@class='nav']/li//span[text()='" + tab + "']");
    }

    public static By navigation_ActiveTab(String tab) {
        return By.xpath("//ul[@class='nav']/li//span[text()='" + tab + "']/..");
    }

    public static By title_LeaveFields(String tab) {
        return By.xpath("//div[@id='" + tab + "']/section/div/div/div[not(contains" +
                "(@style,'none'))]//label");
    }

    public static By button_leaveSubmit(String tab) {
        return By.xpath("//div[@id='" + tab + "']/section//input[@value='Submit']");
    }

    public static By field_leaveTextFields(String field) {
        return By.xpath("//input[@id='" + field + "']");
    }

    public static By field_leaveDropDown(String field) {
        return By.xpath("//select[@id='" + field + "']");
    }

    public static By field_leaveTextArea(String field) {
        return By.xpath("//textarea[@id='" + field + "']");
    }

    public static By field_leaveCalendar(String field) {
        return By.xpath("//input[@name='" + field + "']");
    }

    public static By field_outingCalendar(String field) {
        return By.xpath("//input[@id='" + field + "']");
    }

    public static By field_leaveCheckBox(String field) {
        return By.xpath("//input[@id='" + field + "']");
    }

    public static By heading_alertType = By.xpath("//div[contains(@class,'sweet-alert')]/h2");
    public static By text_alertMessage = By.xpath("//div[contains(@class,'sweet-alert')]/p");
    public static By datePicker_switchMonth = By.xpath("(//th[@class='datepicker-switch'])[1]");
    public static By datePicker_month = By.xpath("//div[@class='datepicker-months']//span");
    public static By datePicker_day = By.xpath("//div[@class='datepicker-days']//tbody//td[@class='day']");
    //    public static By button_tooltip = By.xpath("//a[@data-trigger='hover']");
    public static By button_tooltip = By.xpath("//i[@class='fa fa-info-circle']");
    public static By message_tooltip = By.xpath("//div[@class='popover-content']");
    public static By label_totalWorkingDays = By.xpath("//span[@id='leaveWorkingDays']");

    public static By checkbox_halfDayLeaveOption(String option) {
        return By.xpath("//input[@id='" + option + "']");
    }

}
