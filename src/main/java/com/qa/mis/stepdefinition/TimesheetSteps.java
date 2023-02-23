package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.mis.locators.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimesheetSteps {

    //    Logger logger = LoggerFactory.getLogger(OtherPortalsSteps.class);
    String dashboardURL = "https://mymis.geminisolutions.com/Dashboard/Index";
    String configureTimesheetURL = "https://mymis.geminisolutions.com/Timesheet/ConfigureTimesheet";
    String createTimesheetURL = "https://mymis.geminisolutions.com/Timesheet/CreateTimesheet";
    String manageTemplateURL = "https://mymis.geminisolutions.com/Timesheet/ManageTaskTemplates";

    @Given("Click on Timesheet")
    public void Click_on_Timesheet() {

        try {
            DriverAction.click(OtherportalnTimesheetLocator.timesheetbtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @When("^Click on Timesheet option as (.+)")
    public void click_on_timesheet_option_as_(String timesheet) {
        String url = "";
        try {
            if (timesheet.equals("Configure Timesheet")) {
                DriverAction.click(OtherportalnTimesheetLocator.configutetimesheet);
                DriverAction.waitSec(2);
                url = DriverAction.getCurrentURL();
                if (url.equals(configureTimesheetURL)) {
                    GemTestReporter.addTestStep("Navigation Successful", "Clicked on Configure Timesheet", STATUS.PASS, DriverAction.takeSnapShot());
                } else
                    GemTestReporter.addTestStep("Navigation Unsuccessful", "Navigation to Configure Timesheet tab failed", STATUS.PASS, DriverAction.takeSnapShot());

            } else if (timesheet.equals("Create Timesheet")) {
                DriverAction.click(OtherportalnTimesheetLocator.createtimesheet);
                DriverAction.waitSec(2);
                url = DriverAction.getCurrentURL();
                if (url.equals(createTimesheetURL)) {
                    GemTestReporter.addTestStep("Navigation Successful", "Clicked on Create Timesheet", STATUS.PASS, DriverAction.takeSnapShot());
                } else
                    GemTestReporter.addTestStep("Navigation Unsuccessful", "Navigation to Create Timesheet tab failed", STATUS.PASS, DriverAction.takeSnapShot());


            } else if (timesheet.equals("Manage Task Template")) {
                DriverAction.click(OtherportalnTimesheetLocator.managetaskTemplate);
                DriverAction.waitSec(2);
                url = DriverAction.getCurrentURL();
                if (url.equals(manageTemplateURL)) {
                    GemTestReporter.addTestStep("Navigation Successful", "Clicked on Manage Task Template", STATUS.PASS, DriverAction.takeSnapShot());
                } else
                    GemTestReporter.addTestStep("Navigation Unsuccessful", "Navigation to Manage Task Template tab failed", STATUS.PASS, DriverAction.takeSnapShot());


            } else
                GemTestReporter.addTestStep("Invalid Input value for " + timesheet, "Kindly enter a valid dropdown value", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @When("^Fail click on Timesheet option as (.+)")
    public void failClickOnTimesheetOptionAsTimesheet(String timesheet ) {
        try {
            if (!timesheet.equals("Configure Timesheet") && !timesheet.equals("Create Timesheet") && !timesheet.equals("Manage Task Template")) {
                GemTestReporter.addTestStep("Invalid Input value for timesheet as " +timesheet, "Validation successful", STATUS.PASS, DriverAction.takeSnapShot());

            } else
                GemTestReporter.addTestStep("Invalid check scenario failed", "Entered value should be invalid for timesheet", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }
}
