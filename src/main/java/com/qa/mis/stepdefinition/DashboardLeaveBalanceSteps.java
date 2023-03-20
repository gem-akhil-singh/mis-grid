package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.DashboardLeaveBalanceLocator;
import com.qa.mis.locators.NavBarLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardLeaveBalanceSteps {
    String leaveCount;

    public void presenceOfElement(By elementXpath, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), time);

            wait.until(ExpectedConditions.presenceOfElementLocated(elementXpath));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Presence of Element ", "Element is not present", STATUS.FAIL);
        }
    }

    @Then("Verify leave balance section is present on the current page")
    public void verifySection() {
        try {
            DriverAction.waitSec(5);
            DriverAction.scrollIntoView(DashboardLeaveBalanceLocator.leaveBalanceSection);

            presenceOfElement(DashboardLeaveBalanceLocator.leaveheading, 20);
            if (DriverAction.isExist(DashboardLeaveBalanceLocator.leaveheading)) {
                GemTestReporter.addTestStep(" Verify leave Section", "Leave Section is present on the current page", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify leave Section", "Leave Section is not present on the current page", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify leave Section", "Leave Section is not present on the current page", STATUS.FAIL);
        }

    }


    @And("Click on number of leaves")
    public void clickOnNumberOfLeaves() {
        try {
            DriverAction.waitSec(2);
            if (DriverAction.isExist(DashboardLeaveBalanceLocator.linkleaveBalanceType)) {
                leaveCount = DriverAction.getElementText(DashboardLeaveBalanceLocator.linkleaveBalanceType);
                DriverAction.click(DashboardLeaveBalanceLocator.linkleaveBalanceType, "Leave Balance link");
            } else {
                GemTestReporter.addTestStep(" Verify leave Balance link", "Leave Balance link is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify leave Balance link", "Leave Balance link is not present", STATUS.FAIL);
        }
    }

    @And("Verify leave history popup should be open")
    public void verifyLeaveHistoryPopupShouldBeOpen() {
        try {
            By locator = DashboardLeaveBalanceLocator.linkleavePopup;
            presenceOfElement(DashboardLeaveBalanceLocator.linkleavePopup, 20);
            if (DriverAction.isExist(DashboardLeaveBalanceLocator.linkleavePopup)) {
                DriverAction.click(DashboardLeaveBalanceLocator.linkleavePopup, "Leave history Popup  ");
            } else {
                GemTestReporter.addTestStep("Verify leave history popup", "Leave history popup is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify leave history popup", "Leave history popup is not present", STATUS.FAIL);
        }
    }
}
