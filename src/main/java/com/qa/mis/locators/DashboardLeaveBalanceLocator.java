package com.qa.mis.locators;

import org.openqa.selenium.By;

public class DashboardLeaveBalanceLocator {
    public static By leaveBalanceSection = By.id("LeaveBalance");
    public static By leaveheading = By.xpath("//h3[@class='panel-title'][text()='Leave Balance']");
    public static By linkleaveBalanceType = By.xpath("//div[@id='tblLeaveBalance']//table//tr/td[text()='WFH']/../td[2]/a");
    public static By linkleavePopup = By.xpath("//div[@id='myLeavePopup']//div[@class='modal-dialog']");


}
