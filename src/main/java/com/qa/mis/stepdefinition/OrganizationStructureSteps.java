package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.OrgStructureLocator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrganizationStructureSteps {
    @Given("Navigate to Organization Structure")
    public void Navigate_to_Organization_Structure() {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(OrgStructureLocator.orbbtn));

            DriverAction.click(OrgStructureLocator.orbbtn,"Organization Structure");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Organization Structure", "User not able to navigate to Organization Structure", STATUS.FAIL);
        }
    }

    @When("^Entered employee name (.+) in search field")
    public void Entered_employee_name_in_search_field(String empname) {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(OrgStructureLocator.searchtab)) {
                DriverAction.typeText(OrgStructureLocator.searchtab,"Search tab is displayed","Entering employee name as "+empname+ " in search field", empname);
            } else
                GemTestReporter.addTestStep("Element not found", "Search field not found", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Element not found", "Search field not found", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^Validate availability of Employee (.+) and Designation (.+)")
    public void Validate_availability_of_Employee_and_Designation(String empname, String designation) {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(OrgStructureLocator.getemp(empname))) {
                if (designation.equals(DriverAction.getElementText(OrgStructureLocator.getemp(empname)))) {
                    GemTestReporter.addTestStep("Employee " + empname + " is present", "Designation is " + designation + ".", STATUS.PASS);
                } else
                    GemTestReporter.addTestStep("Employee designation does not match", "Designtion incorrect", STATUS.FAIL, DriverAction.takeSnapShot());
            } else
                GemTestReporter.addTestStep("Employee " + empname + " is present", "Employee is not present in Organization", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Employee " + empname + " is present", "Employee is not present in Organization", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Count number of senior visible")
    public void Count_number_of_senior_visible() {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(OrgStructureLocator.visibleEmp)) {
                int visibleemp = DriverAction.getElements(OrgStructureLocator.visibleEmp).size();
                if (visibleemp > 0)
                    GemTestReporter.addTestStep("Total Employee by default is " + visibleemp + "", "Employee Visible", STATUS.PASS, DriverAction.takeSnapShot());
                else
                    GemTestReporter.addTestStep("Employees are not visible", "Null Employee List", STATUS.FAIL, DriverAction.takeSnapShot());

            } else
                GemTestReporter.addTestStep("Page not loaded ", "Error Occured", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Page not loaded ", "Error Occured", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^Double click on employeecard (.+)")
    public void doubleClickOnEmployeecard(String empname) {
        try {
            DriverAction.waitSec(3);
            if (DriverAction.isExist(OrgStructureLocator.getemp(empname))) {
                DriverAction.doubleClick(OrgStructureLocator.getemp(empname),"Employee Card.");
            } else
                GemTestReporter.addTestStep("Employee card is not visible", "Unable to double click as employee card is not present", STATUS.FAIL);

        } catch (Exception e) {
            GemTestReporter.addTestStep("Employee card is not visible", "Unable to double click as employee card is not present", STATUS.FAIL);
        }
    }

    @Then("^Validate unavailability of Employee (.+) and Designation (.+)")
    public void validateUnavailabilityOfEmployeeEmpnameAndDesignationDesignation(String empname, String designation) {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(OrgStructureLocator.getemp(empname))) {
                if (!designation.equals(DriverAction.getElementText(OrgStructureLocator.getemp(empname)))) {
                    GemTestReporter.addTestStep("Employee designation does not match", "Designtion incorrect", STATUS.PASS);
                } else
                    GemTestReporter.addTestStep("Employee designation match", "Cahnge input Designation", STATUS.FAIL, DriverAction.takeSnapShot());
            } else
                GemTestReporter.addTestStep("Employee " + empname + " is present", "Employee is not present in Organization", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("Employee " + empname + " is present", "Employee is not present in Organization", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
}
