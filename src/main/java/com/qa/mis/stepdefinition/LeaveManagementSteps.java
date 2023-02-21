package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.LeaveManagementLocator;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class LeaveManagementSteps {

    static int halfDayLeaveCount = 0;
    static String totalWorkingDaysBeforeApplyingHalfDay = null;
    static String leaveHistoryDateRange = null;

    @Given("User is logged into MIS using username and password")
    public void userIsLoggedIntoMISUsingUsernameAndPassword(DataTable credTable) {
        List<Map<String, String>> credentials = credTable.asMaps(String.class, String.class);
        String username = credentials.get(0).get("username");
        String password = credentials.get(0).get("password");
        byte[] decodingString = Base64.decodeBase64(password);
        password = new String(decodingString);
        if (DriverAction.isExist(LeaveManagementLocator.input_loginUsername)) {
            DriverAction.typeText(LeaveManagementLocator.input_loginUsername, username, "username");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to enter text in username", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
        if (DriverAction.isExist(LeaveManagementLocator.input_loginPassword)) {
            DriverAction.typeText(LeaveManagementLocator.input_loginPassword, password, "password");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to enter text in password", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
        if (DriverAction.isExist(LeaveManagementLocator.button_SignIn)) {
            DriverAction.click(LeaveManagementLocator.button_SignIn, "sign in");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on Login", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @When("User is on MIS Home Page")
    public void userIsOnMISHomePage() {
        String expectedURL = "https://mymis.geminisolutions.com/Dashboard/Index";
        new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20))
                .until(ExpectedConditions.urlToBe(expectedURL));
        if (DriverAction.getCurrentURL().equals(expectedURL)) {
            GemTestReporter.addTestStep("Verifying Page URL",
                    "URL matching passed.\nExpected URL - " + expectedURL +
                            "\nActual URL - " + DriverAction.getCurrentURL(), STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Page URL",
                    "URL matching failed.\nExpected URL - " + expectedURL +
                            "\nActual URL - " + DriverAction.getCurrentURL(), STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("User clicks on {string} sub tab of {string} tab in MIS")
    public void userClicksOnSubTabOfTabInMIS(String childTab, String parentTab) {
//        DriverAction.waitUntilElementAppear(By.xpath("//h3[@class='panel-title']"), 10);

        DriverAction.waitSec(3);
        DriverAction.waitUntilElementAppear(LeaveManagementLocator.menu_parentTabs(parentTab), 10);
        if (DriverAction.isExist(LeaveManagementLocator.menu_parentTabs(parentTab))) {
            DriverAction.click(LeaveManagementLocator.menu_parentTabs(parentTab), parentTab);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on " + parentTab, STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
        DriverAction.waitUntilElementAppear(LeaveManagementLocator.menu_parentTabs(parentTab), 10);
        if (DriverAction.isExist(LeaveManagementLocator.menu_childTabs(childTab))) {
            DriverAction.click(LeaveManagementLocator.menu_childTabs(childTab), childTab);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on " + childTab, STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }


    @And("Verify {string} of {string} tab")
    public void verifyOfTab(String expectedHeading, String childTab) {
        DriverAction.waitUntilElementAppear(LeaveManagementLocator.heading_Page, 10);
        String actualHeading = DriverAction.getElementText(LeaveManagementLocator.heading_Page);
        if (actualHeading.equals(expectedHeading)) {
            GemTestReporter.addTestStep("Verifying Heading",
                    "Heading matching passed.\nExpected Heading - " + expectedHeading +
                            "\nActual Heading - " + actualHeading, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Heading",
                    "Heading matching failed.\nExpected Heading - " + expectedHeading +
                            "\nActual Heading - " + actualHeading, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("User clicks on {string} Tab")
    public void userClicksOnTab(String tabs) {
        DriverAction.waitSec(2);
        DriverAction.click(LeaveManagementLocator.navigation_tabs(tabs), tabs);
    }

    @And("Verify {string} is displayed")
    public void verifyTabIsDisplayed(String tab) {
        DriverAction.waitSec(2);
        List<String> expectedFields = null;
        String id = null;
        switch (tab) {
            case "Leave":
                id = "tabApplyLeave";
                expectedFields = Arrays.asList("From*", "Till*", "Reason*", "Primary contact number*",
                        "Other contact number", "Availability on");
                break;
            case "Work From Home":
                id = "tabApplyWFH";
                expectedFields = Arrays.asList("Date*", "Reason*", "Mobile No.*");
                break;
            case "Comp Off":
                id = "tabApplyCompOff";
                expectedFields = Arrays.asList("Date*", "Reason*");
                break;
            case "Out Duty/Tour":
                id = "tabApplyOuting";
                expectedFields = Arrays.asList("From*", "Till*", "Type *", "Reason*", "Primary contact " +
                        "number*", "Other contact number");
                break;
            case "LWP Change Request":
                id = "tabLWPChangeRequest";
                expectedFields = Arrays.asList("In case of LWP marked by system", "Date:*", "Type of " +
                        "leave*", "Reason*");
                break;
        }

        List<String> actualFields =
                DriverAction.getElementsText(LeaveManagementLocator.title_LeaveFields(id));
        if (actualFields.equals(expectedFields)) {
            GemTestReporter.addTestStep("Verifying Fields",
                    "Fields matching passed.\nExpected Fields - " + expectedFields +
                            "\nActual Fields - " + actualFields, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Fields",
                    "Fields matching failed.\nExpected Fields - " + expectedFields +
                            "\nActual Fields - " + actualFields, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("User clicks on submit button for {string}")
    public void userClicksOnSubmitButtonFor(String tab) {
        DriverAction.waitSec(2);
        String id = null;
        switch (tab) {
            case "Leave":
                id = "tabApplyLeave";
                break;
            case "Work From Home":
                id = "tabApplyWFH";
                break;
            case "Comp Off":
                id = "tabApplyCompOff";
                break;
            case "Out Duty/Tour":
                id = "tabApplyOuting";
                break;
            case "LWP Change Request":
                id = "tabLWPChangeRequest";
                break;
        }
        if (DriverAction.isExist(LeaveManagementLocator.button_leaveSubmit(id))) {
            DriverAction.click(LeaveManagementLocator.button_leaveSubmit(id), "Submit");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on submit", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Verify mandatory {string} field for {string}")
    public void verifyMandatoryFieldFor(String fieldType, String field) {
        String classValue = null;
        switch (fieldType) {
            case "dropdown":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocator.field_leaveDropDown(field),
                                "class");
                break;
            case "textField":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocator.field_leaveTextFields(field),
                                "class");
                break;
            case "textArea":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocator.field_leaveTextArea(field),
                                "class");
                break;
            case "calendar":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocator.field_leaveCalendar(field),
                                "class");
                break;
            case "outingCalendar":
                classValue =
                        DriverAction.getAttributeName(LeaveManagementLocator.field_outingCalendar(field),
                                "class");
        }
        if (classValue.contains("error-validation")) {
            GemTestReporter.addTestStep("Verifying Mandatory Fields",
                    "Fields matching passed for " + field, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Mandatory Fields",
                    "Fields matching passed for " + field, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Select compOff date {int} for {string} field")
    public void selectCompOffDateDateIndexFromDateField(Integer index, String field) {
        if (DriverAction.isExist(LeaveManagementLocator.field_leaveDropDown(field))) {
            DriverAction.dropDown(LeaveManagementLocator.field_leaveDropDown(field), index);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on dropdown", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @Then("Enter compOff reason {string} for {string} field")
    public void enterCompOffReasonForField(String message, String field) {
        if (DriverAction.isExist(LeaveManagementLocator.field_leaveTextArea(field))) {
            DriverAction.typeText(LeaveManagementLocator.field_leaveTextArea(field), message, "reason");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on dropdown", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Verify popup alert with message {string} and {string}")
    public void verifyPopupWithMessageAnd(String alertType, String alertMessage) {
        String expectedAlertType = DriverAction.getElementText(LeaveManagementLocator.heading_alertType);
        String expectedAlertMessage = DriverAction.getElementText(LeaveManagementLocator.text_alertMessage);

        if (expectedAlertType.equals(alertType)) {
            GemTestReporter.addTestStep("Verifying Alert Type",
                    "Alert Type matching passed.\nExpected Alert Type - " + expectedAlertType +
                            "\nActual Alert Type - " + alertType, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Alert Type",
                    "Alert Type matching failed.\nExpected Alert Type - " + expectedAlertType +
                            "\nActual Alert Type - " + alertType, STATUS.FAIL, DriverAction.takeSnapShot());
        }
        if (expectedAlertMessage.equals(alertMessage)) {
            GemTestReporter.addTestStep("Verifying Alert Message",
                    "Alert Message matching passed.\nExpected Alert Message - " + expectedAlertMessage +
                            "\nActual Alert Message - " + alertMessage, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Alert Message",
                    "Alert Message matching failed.\nExpected Alert Message - " + expectedAlertMessage +
                            "\nActual Alert Message - " + alertMessage, STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Verify auto populated {string} field for {string}")
    public void verifyAutoPopulatedFieldFor(String fieldType, String field) {
        String defaultText = null;
        switch (fieldType) {
            case "textField":
                defaultText =
                        DriverAction.getElementText(LeaveManagementLocator.field_leaveTextFields(field));
                break;
        }
        if (!defaultText.equals(null)) {
            GemTestReporter.addTestStep("Verifying Default Fields",
                    field + "Fields having default values", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Mandatory Fields",
                    field + "Fields not having default values", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Enter leave {string} for {string} field")
    public void enterLeaveForField(String date, String field) {
        String elementLabel = field.contains("FromDate") ? "From date" : "Till date";
        // date format == mm/dd/yyyy
        String[] dateArray = date.split("/");
        if (DriverAction.isExist(LeaveManagementLocator.field_leaveCalendar(field))) {
            DriverAction.click(LeaveManagementLocator.field_leaveCalendar(field), elementLabel);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on calendar", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
        if (DriverAction.isExist(LeaveManagementLocator.datePicker_switchMonth)) {
            DriverAction.click(LeaveManagementLocator.datePicker_switchMonth);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on calendar", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
        List<WebElement> monthElements = DriverAction.getElements(LeaveManagementLocator.datePicker_month);
        int monthNumber = Integer.parseInt(dateArray[0]);

        DriverAction.click(monthElements.get(monthNumber - 1), "month");
        List<WebElement> dayElements = DriverAction.getElements(LeaveManagementLocator.datePicker_day);

        for (WebElement day : dayElements) {
            if (DriverAction.getElementText(day).equals(dateArray[1])) {
                DriverAction.click(day, "day");
                break;
            }
        }

    }

    @And("Click total working days tool tip")
    public void clickTotalWorkingDaysToolTip() {
        DriverAction.waitSec(5);
//        new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20))
//                .until(ExpectedConditions.elementToBeClickable(LeaveManagementLocators.button_tooltip));
        if (DriverAction.isExist(LeaveManagementLocator.button_tooltip)) {
//            DriverAction.click(LeaveManagementLocators.button_tooltip, "tooltip");
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
            js.executeScript("arguments[0].click();",
                    DriverAction.getElement(LeaveManagementLocator.button_tooltip));
            GemTestReporter.addTestStep("clicked on tool tip", "Pass", STATUS.PASS);
        } else {
            GemTestReporter.addTestStep("Fail to click on tool tip", "Fail", STATUS.FAIL);
        }
    }

    @And("Verify tooltip message {string}")
    public void verifyTooltipMessage(String message) {
//        String expectedMessage = DriverAction.getAttributeName(LeaveManagementLocators.button_tooltip,
//                "data-content");
        DriverAction.waitSec(5);
        String expectedMessage = DriverAction.getElementText(LeaveManagementLocator.message_tooltip);
        if (expectedMessage.equals(message)) {
            GemTestReporter.addTestStep("Verifying ToolTip Message",
                    "ToolTip Message matching passed.\nExpected ToolTip Message - " + expectedMessage +
                            "\nActual ToolTip Message - " + message, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying ToolTip Message",
                    "ToolTip Message matching failed.\nExpected ToolTip Message - " + expectedMessage +
                            "\nActual ToolTip Message - " + message, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Select half day leave for {string}")
    public void SelectHalfDayLeaveFor(String halfDayOptions) {
        String[] options = halfDayOptions.split(",");
        halfDayLeaveCount = options.length;
        DriverAction.waitSec(2);
        totalWorkingDaysBeforeApplyingHalfDay = DriverAction.getElementText(LeaveManagementLocator.label_totalWorkingDays);
        for (String opt : options) {
            String elementLabel = (opt.trim()).equals("isLeaveFirstHalfDay") ? "FirstHalfDay" : "LastHalfDay";
            DriverAction.click(LeaveManagementLocator.checkbox_halfDayLeaveOption(opt.trim()), elementLabel);
        }

    }

    @And("Verify effective total working days")
    public void verifyEffectiveTotalWorkingDays() {
        String totalWorkingDaysAfterApplyingHalfDay =
                DriverAction.getElementText(LeaveManagementLocator.label_totalWorkingDays);

        String actualWorkingDays = null;
        if (halfDayLeaveCount == 1) {
            double wd = Integer.parseInt(totalWorkingDaysBeforeApplyingHalfDay) - 0.5;
            actualWorkingDays = Double.toString(wd);
        } else {
            int wd = Integer.parseInt(totalWorkingDaysBeforeApplyingHalfDay) - 1;
            actualWorkingDays = Integer.toString(wd);
        }

        if (actualWorkingDays.equals(totalWorkingDaysAfterApplyingHalfDay)) {
            GemTestReporter.addTestStep("Verifying Total Working Days",
                    "Total Working Days matching passed.\nExpected Total Working Days - " +
                            totalWorkingDaysAfterApplyingHalfDay + "\nActual Total Working Days - " +
                            actualWorkingDays, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Total Working Days",
                    "Total Working Days matching failed.\nExpected Total Working Days - " +
                            totalWorkingDaysAfterApplyingHalfDay + "\nActual Total Working Days - " +
                            actualWorkingDays, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Select leave type {int} for {string} field")
    public void selectLeaveTypeForField(int options, String field) {
        DriverAction.waitUntilElementAppear(LeaveManagementLocator.field_leaveDropDown(field), 20);
        if (DriverAction.isExist(LeaveManagementLocator.field_leaveDropDown(field))) {
            DriverAction.dropDown(LeaveManagementLocator.field_leaveDropDown(field), options);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on dropdown", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Enter leave reason {string} for {string} field")
    public void enterLeaveReasonForField(String message, String field) {
        DriverAction.waitSec(1);
        if (DriverAction.isExist(LeaveManagementLocator.field_leaveTextArea(field))) {
            DriverAction.typeText(LeaveManagementLocator.field_leaveTextArea(field), message, "reason");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to type text in reason", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Select availability for {string} field")
    public void selectAvailabilityForField(String field) {
        String[] availability = field.split(",");
        for (String aval : availability) {
            if (DriverAction.isExist(LeaveManagementLocator.field_leaveCheckBox(aval.trim()))) {
                DriverAction.click(LeaveManagementLocator.field_leaveCheckBox(aval.trim()), aval);
            } else {
                GemTestReporter.addTestStep("Error Occur", "Fail to click availability", STATUS.FAIL,
                        DriverAction.takeSnapShot());
            }
        }
    }

    @Then("Enter outing {string} for {string} field")
    public void enterOutingForField(String date, String field) {
        String elementLabel = field.contains("FromDate") ? "From date" : "Till date";
        // date format == mm/dd/yyyy
        String[] dateArray = date.split("/");
        DriverAction.click(LeaveManagementLocator.field_outingCalendar(field), elementLabel);

        DriverAction.click(LeaveManagementLocator.datePicker_switchMonth);

        List<WebElement> monthElements = DriverAction.getElements(LeaveManagementLocator.datePicker_month);
        int monthNumber = Integer.parseInt(dateArray[0]);

        DriverAction.click(monthElements.get(monthNumber - 1), "month");
        List<WebElement> dayElements = DriverAction.getElements(LeaveManagementLocator.datePicker_day);

        for (WebElement day : dayElements) {
            if (DriverAction.getElementText(day).equals(dateArray[1])) {
                DriverAction.click(day, "day");
                break;
            }
        }
    }

    @Then("Select outing type {string} for {string} field")
    public void selectOutingTypeForField(String option, String field) {
        if (DriverAction.isExist(LeaveManagementLocator.field_leaveDropDown(field))) {
            DriverAction.dropDown(LeaveManagementLocator.field_leaveDropDown(field), option);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on dropdown", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @Then("Enter outing reason {string} for {string} field")
    public void enterOutingReasonForField(String message, String field) {
        if (DriverAction.isExist(LeaveManagementLocator.field_leaveTextArea(field))) {
            DriverAction.typeText(LeaveManagementLocator.field_leaveTextArea(field), message, "outing " +
                    "reason");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to type text in reason", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @Then("Enter outing contact no {string} for {string} field")
    public void enterOutingContactNoForField(String number, String field) {
        if (DriverAction.isExist(LeaveManagementLocator.field_leaveTextFields(field))) {
            DriverAction.typeText(LeaveManagementLocator.field_leaveTextFields(field), number, "primary " +
                    "contact number");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to type text in contact number", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Select WFH date {string} for {string} field")
    public void selectWFHDateForField(String date, String field) {
        if (DriverAction.isExist(LeaveManagementLocator.field_leaveDropDown(field))) {
            DriverAction.dropDown(LeaveManagementLocator.field_leaveDropDown(field), date);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click on dropdown", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Verify {string} headers are displayed")
    public void verifyHeadersAreDisplayed(String tab) {
        DriverAction.waitSec(2);
        List<String> expectedFields = null;
        String id = null;
        switch (tab) {
            case "Leave":
                id = "tabApplyLeave";
                expectedFields = Arrays.asList("Period", "Type", "Reason", "Remarks", "Status", "Applied " +
                        "On", "Action");
                break;
            case "Work From Home":
                id = "tabApplyWFH";
                expectedFields = Arrays.asList("Period", "Half Day", "Reason", "Remarks", "Status");
                break;
            case "Comp Off":
                id = "tabApplyCompOff";
                expectedFields = Arrays.asList("Applied for", "Days", "Reason", "Remarks", "Status",
                        "Applied On", "Availability", "Lapse Date");
                break;
            case "Out Duty/Tour":
                id = "tabApplyOnDutyReq";
                expectedFields = Arrays.asList("Period", "Duty Type", "Reason", "Remarks", "Status",
                        "Applied On", "Action");
                break;
            case "Change Request":
                id = "tabLWPChangeRequest";
                expectedFields = Arrays.asList("Period", "Type", "Reason", "Remarks", "Status", "Applied On");
                break;
        }

        List<String> actualFields =
                DriverAction.getElementsText(LeaveManagementLocator.title_LeaveViewRequestHeaders(id));
        if (actualFields.equals(expectedFields)) {
            GemTestReporter.addTestStep("Verifying Fields",
                    "Fields matching passed.\nExpected Fields - " + expectedFields +
                            "\nActual Fields - " + actualFields, STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Fields",
                    "Fields matching failed.\nExpected Fields - " + expectedFields +
                            "\nActual Fields - " + actualFields, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify Date Range field is present")
    public void verifyDateRangeFieldIsPresent() {
        if (DriverAction.isExist(LeaveManagementLocator.dropdown_leaveHistoryFY)) {
            GemTestReporter.addTestStep("Date Range", "Date Range is present", STATUS.PASS,
                    DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Error Occur", "Date Range is not present", STATUS.FAIL,
                    DriverAction.takeSnapShot());
        }
    }

    @And("Click on View Request Status {string} dropdown")
    public void clickOnVIewRequestStatusDropdown(String field) {
        if (field.equals("Date Range")) {
            if (DriverAction.isExist(LeaveManagementLocator.dropdown_leaveHistoryFY)) {
                DriverAction.click(LeaveManagementLocator.dropdown_leaveHistoryFY, "date range");
            } else {
                GemTestReporter.addTestStep("Error Occur", "Fail to click Date Range",
                        STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
    }

    @And("Enter {string} date {string} in Date range field")
    public void enterDateInDateRangeField(String dateType, String date) {
        if (DriverAction.isExist(LeaveManagementLocator.input_dateRangeFY)) {
            DriverAction.typeText(LeaveManagementLocator.input_dateRangeFY, date, "date range");
            leaveHistoryDateRange = date;
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to type in Date Range",
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify {string} message {string} displays")
    public void verifyMessageDisplays(String dateType, String message) {
        String expectedResult = null;
        if (dateType.equals("Invalid")) {
            if (DriverAction.isExist(LeaveManagementLocator.result_dateRangeFY)) {
                expectedResult = DriverAction.getElementText(LeaveManagementLocator.result_dateRangeFY);
                assertEquals(message, expectedResult);
                GemTestReporter.addTestStep("Verifying Result", "Search Result matching passed." +
                                "\nExpected Result - " + expectedResult + "\nActual Result - " + message, STATUS.PASS,
                        DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verifying Result", "Search Result matching failed." +
                                "\nExpected Result - " + expectedResult + "\nActual Result - " + message,
                        STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } else {
            if (DriverAction.isExist(LeaveManagementLocator.result_dateRangeFY)) {
                expectedResult = DriverAction.getElementText(LeaveManagementLocator.result_dateRangeFY);
                assertEquals(leaveHistoryDateRange, expectedResult);
                GemTestReporter.addTestStep("Verifying Result", "Search Result matching passed." +
                                "\nExpected Result - " + expectedResult + "\nActual Result - " + leaveHistoryDateRange,
                        STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verifying Result", "Search Result matching failed." +
                                "\nExpected Result - " + expectedResult + "\nActual Result - " + leaveHistoryDateRange,
                        STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }

    }

    @And("Click on View Request Status export button for {string}")
    public void clickOnViewRequestStatusExportButtonFor(String tab) {
        DriverAction.waitSec(2);
        String id = switch (tab) {
            case "Leave" -> "tabApplyLeave";
            case "Work From Home" -> "tabApplyWFH";
            case "Comp Off" -> "tabApplyCompOff";
            case "Out Duty/Tour" -> "tabApplyOnDutyReq";
            case "Change Request" -> "tabLWPChangeRequest";
            default -> null;
        };

        DriverAction.click(LeaveManagementLocator.button_leaveExport(id), "export");
    }

    @And("Verify available export options {string}")
    public void verifyAvailableExportOptions(String options) {
        List<String> optList = Arrays.asList(options.split(","));
        optList.replaceAll(String::trim);
        List<String> actualOptions = DriverAction.getElementsText(LeaveManagementLocator.options_leaveExport);
        if (optList.equals(actualOptions)) {
            GemTestReporter.addTestStep("Verifying Options", "Export Options matching passed." +
                            "\nExpected Result - " + optList + "\nActual Result - " + actualOptions,
                    STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Options", "Export Options matching failed." +
                            "\nExpected Result - " + optList + "\nActual Result - " + actualOptions,
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Click on View Request Status {string} button")
    public void clickOnViewRequestStatusButton(String button) {
        if (DriverAction.isExist(LeaveManagementLocator.button_leaveExportOption(button))) {
            DriverAction.click(LeaveManagementLocator.button_leaveExportOption(button), button);
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click export button",
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify Print page appears")
    public void verifyPrintPageAppears() {
        List<String> windows = new ArrayList<>(DriverAction.getWindowHandles());
        if (windows.size() > 1) {
            GemTestReporter.addTestStep("Verifying Print Page", "Print page is available",
                    STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Error Occur", "Print page is not available",
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify Copy to clipboard message {string}")
    public void verifyCopyToClipboardMessage(String message) {
        String actualMessage = DriverAction.getElementText(LeaveManagementLocator.heading_copyToClipboard);
        if (actualMessage.equals(message)) {
            GemTestReporter.addTestStep("Verifying Message", "Header matching passed." +
                            "\nExpected Result - " + message + "\nActual Result - " + actualMessage,
                    STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Options", "Header matching failed." +
                            "\nExpected Result - " + message + "\nActual Result - " + actualMessage,
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify file {string} is downloaded in MIS")
    public void verifyFileIsDownloadedInMIS(String fileName) {
        // static wait to download the file.
        DriverAction.waitSec(5);
        String downloadPath = "C:\\Users\\" + System.getProperty("user.name") + "\\Downloads\\";
        boolean isDownloaded = isFileDownloaded(downloadPath, fileName);
        if (isDownloaded) {
            GemTestReporter.addTestStep("Verifying Downloaded File", "File downloaded successfully",
                    STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Error Occur", "File downloading failed",
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
        deleteDownloadedFile(downloadPath, fileName);
        DriverAction.waitSec(2);
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (int i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().equals(fileName)) {
                return flag = true;
            }
        }
        return flag;
    }

    public void deleteDownloadedFile(String downloadPath, String fileName) {
        File folder = new File(downloadPath);
        File tempFile = new File(folder + "/" + fileName);
        tempFile.delete();
    }

    @And("User enters {string} period in search box for {string}")
    public void userEntersPeriodInSearchBoxFor(String period, String tab) {
        String id = switch (tab) {
            case "Comp Off" -> "tblCompOffHistory_filter";
            case "Leave" -> "tblLeaveHistory_filter";
            case "Out Duty/Tour" -> "tblOnDutyReqHistory_filter";
            default -> null;
        };

        if (DriverAction.isExist(LeaveManagementLocator.input_viewRequestFilter(id))) {
            DriverAction.typeText(LeaveManagementLocator.input_viewRequestFilter(id), period, "period");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to type text in search",
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify {string} period as search result for {string}")
    public void verifyPeriodAsSearchResultFor(String period, String tab) {
        String id = switch (tab) {
            case "Leave" -> "tabApplyLeave";
            case "Work From Home" -> "tabApplyWFH";
            case "Comp Off" -> "tabApplyCompOff";
            case "Out Duty/Tour" -> "tabApplyOnDutyReq";
            case "Change Request" -> "tabLWPChangeRequest";
            default -> null;
        };

        if (DriverAction.isExist(LeaveManagementLocator.tableRowData_viewRequestStatus(id))) {
            List<WebElement> rows =
                    DriverAction.getElements(LeaveManagementLocator.tableRows_viewRequestStatus(id));
            for (WebElement row : rows) {
                String rowData = DriverAction.getElementText(row);
                if (rowData.contains(period)) {
                    GemTestReporter.addTestStep("Verifying Result", "Result matching passed." +
                                    "\nExpected Result - " + period + "\nActual Result - " + rowData,
                            STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Verifying Result", "Result matching failed." +
                                    "\nExpected Result - " + period + "\nActual Result - " + rowData,
                            STATUS.FAIL, DriverAction.takeSnapShot());
                }
            }
        }
    }


    @And("Sort column {string} for {string}")
    public void sortColumnFor(String column, String tab) {
        String id = switch (tab) {
            case "Leave" -> "tabApplyLeave";
            case "Work From Home" -> "tabApplyWFH";
            case "Comp Off" -> "tabApplyCompOff";
            case "Out Duty/Tour" -> "tabApplyOnDutyReq";
            case "Change Request" -> "tabLWPChangeRequest";
            default -> null;
        };

        List<WebElement> headers =
                DriverAction.getElements(LeaveManagementLocator.title_LeaveViewRequestHeaders(id));
        for (WebElement header : headers) {
            String headerText = DriverAction.getElementText(header);
            if (headerText.equals(column)) {
                DriverAction.click(header, "header");
                break;
            }
        }
    }

    @And("Verify sorted column {string} result for {string}")
    public void verifySortedColumnResultFor(String column, String tab) {
        String id = switch (tab) {
            case "Leave" -> "tabApplyLeave";
            case "Work From Home" -> "tabApplyWFH";
            case "Comp Off" -> "tabApplyCompOff";
            case "Out Duty/Tour" -> "tabApplyOnDutyReq";
            case "Change Request" -> "tabLWPChangeRequest";
            default -> null;
        };

        List<WebElement> headers =
                DriverAction.getElements(LeaveManagementLocator.title_LeaveViewRequestHeaders(id));
        for (WebElement header : headers) {
            String headerText = DriverAction.getElementText(header);
            if (headerText.equals(column)) {
                String sorting = DriverAction.getAttributeName(header, "aria-sort");
                if (sorting.equals("ascending")) {
                    GemTestReporter.addTestStep("Verifying Sorting", "Sorting completed successfully",
                            STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Verifying Sorting", "Sorting failed",
                            STATUS.FAIL, DriverAction.takeSnapShot());
                }
                break;
            }
        }

    }

    @And("Verify number of rows displayed for {string} tab")
    public void verifyNumberOfRowsDisplayedForTab(String tab) {
        String id = switch (tab) {
            case "Leave" -> "tabApplyLeave";
            case "Work From Home" -> "tabApplyWFH";
            case "Comp Off" -> "tabApplyCompOff";
            case "Out Duty/Tour" -> "tabApplyOnDutyReq";
            case "Change Request" -> "tabLWPChangeRequest";
            default -> null;
        };
        int rows = DriverAction.getElements(LeaveManagementLocator.tableRows_viewRequestStatus(id)).size();
        if (DriverAction.isExist(LeaveManagementLocator.label_leaveTableEntries)) {
            String entries = DriverAction.getElementText(LeaveManagementLocator.label_leaveTableEntries);
            if (entries.contains(rows + "")) {
                GemTestReporter.addTestStep("Verifying Entries", "Entries matching passed",
                        STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verifying Entries", "Entries matching failed",
                        STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
    }

    @And("Cancel the leave for given period")
    public void cancelTheLeaveForGivenPeriod() {
        String id = "tabApplyLeave";

        if (DriverAction.isExist(LeaveManagementLocator.button_leaveCancel(id))) {
            DriverAction.click(LeaveManagementLocator.button_leaveCancel(id), "cancel");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click cancel button",
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @And("User clicks on yes button to cancel the leave")
    public void userClicksOnYesButtonToCancelTheLeave() {
        DriverAction.waitUntilElementAppear(LeaveManagementLocator.button_leaveCancelYes, 10);
        if (DriverAction.isExist(LeaveManagementLocator.button_leaveCancelYes)) {
            DriverAction.click(LeaveManagementLocator.button_leaveCancelYes, "yes");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click yes button",
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Click on view button for Out Duty Tour searched result")
    public void clickOnViewButtonForOutDutyTourSearchedResult() {
        if (DriverAction.isExist(LeaveManagementLocator.button_outDutyView)) {
            DriverAction.click(LeaveManagementLocator.button_outDutyView, "view");
        } else {
            GemTestReporter.addTestStep("Error Occur", "Fail to click view button",
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify the detailed popup {string} for Out Duty Tour")
    public void verifyTheDetailedPopupForOutDutyTour(String header) {
        DriverAction.waitUntilElementAppear(LeaveManagementLocator.header_outDutyViewDetails, 10);
        if (DriverAction.getElementText(LeaveManagementLocator.header_outDutyViewDetails).equals(header)) {
            GemTestReporter.addTestStep("Verifying Header", "Header matching passed",
                    STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("Verifying Header", "Header matching failed",
                    STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
}
