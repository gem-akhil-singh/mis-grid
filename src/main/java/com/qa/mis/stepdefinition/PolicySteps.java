package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.mis.locators.LoginLocator;
import com.qa.mis.locators.PolicyLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PolicySteps {
    @When("User clicks on Policy")
    public void userClicksOnPolicy() {
        try {
            DriverAction.click(PolicyLocator.policyButton);
            GemTestReporter.addTestStep("Policy", "User clicks on Policy Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Policy", "User not able to click on Policy", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on View Policies")
    public void clickOnViewPolicies() {
        try {
            DriverAction.click(PolicyLocator.viewPolicyButton);
            GemTestReporter.addTestStep("View Policies", "User clicks on ViewPolicies Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("View Policies", "User not able to click on ViewPolicies", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @Then("Verify Data is present in Policies tab")
    public void verifyDataIsPresentInPoliciesTab() {
        try {
            List<WebElement> policyData = DriverAction.getElements(PolicyLocator.policyTableData);
            if (policyData.size() > 0)
                GemTestReporter.addTestStep("Policy Data", "Verified Data is present in Policies tab", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Policy Data", "User not able to see the data is present in Policies tab", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("Check the {string} of policy tab")
    public void checkTheHeadingOfPolicyTab(String expectedMsg) {
        String actualMsg = DriverAction.getElement(PolicyLocator.policyTabTitle).getText();
        try {
            if (actualMsg.equals(expectedMsg))
                GemTestReporter.addTestStep("Title", "Verify Title: " + actualMsg, STATUS.PASS, DriverAction.takeSnapShot());
        }
        catch (Exception exception) {
            GemTestReporter.addTestStep("Title", "User not able to verify the Title: " + actualMsg, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @Then("Verify number of records displayed by default")
    public void verifyNumberOfRecordsDisplayedByDefault() {
        String actualRecords = DriverAction.getElement(PolicyLocator.defaultNoOfRecordsPolicy).getText();
        try {
            if (actualRecords.equals("10"))
                GemTestReporter.addTestStep("NumberOfRecords", "NumberOfRecords: " + actualRecords, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("NumberOfRecords", "NumberOfRecords: " + actualRecords, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Select {string} as number of entries")
    public void selectAsNumberOfEntries(String expectedRecords) {
        DriverAction.click(PolicyLocator.NoOfPolicyRecords);
        String actualNoOfRecords = DriverAction.getElement(PolicyLocator.NoOfPolicyRecords).getText();
        try {
            if (actualNoOfRecords.equals(expectedRecords))
                GemTestReporter.addTestStep("NumberOfRecords Selected", "NumberOfRecords Selected: " + actualNoOfRecords, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("NumberOfRecords Selected", "NumberOfRecords Selected: " + actualNoOfRecords, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @Then("Verify number of records displayed changes")
    public void verifyNumberOfRecordsDisplayedChanges() {
        DriverAction.click(PolicyLocator.NoOfPolicyRecords);
        String actualNoOfRecords = DriverAction.getElement(PolicyLocator.NoOfPolicyRecords).getText();
        try {
            if (actualNoOfRecords.equals("25"))
                GemTestReporter.addTestStep("NumberOfRecords", "NumberOfRecords: " + actualNoOfRecords, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("NumberOfRecords", "NumberOfRecords: " + actualNoOfRecords, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @Then("Enter {string} in Search Box")
    public void enterInSearchBox(String policyName) {
        try {
            DriverAction.typeText(PolicyLocator.searchPolicy, policyName);
            GemTestReporter.addTestStep("Search PolicyName", "User searched the " + policyName + " in Search Box", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Search PolicyName", "User not able to search the " + policyName + " in Search Box", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @Then("Verify the {string} on the dashboard")
    public void verifyTheOnTheDashboard(String expectedMsg) {
        DriverAction.waitSec(2);
        String actualMsg = DriverAction.getElement(PolicyLocator.policyMessage).getText();
        try {
            if (actualMsg.equals(expectedMsg))
                GemTestReporter.addTestStep("Error message", "Error message: " + actualMsg, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Error message", "Error message: " + actualMsg, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @Then("Verify the {string}")
    public void verifyThe(String expectedPolicy) {
        DriverAction.waitUntilElementAppear(PolicyLocator.policyName(expectedPolicy), 5);
        String actualPolicy = DriverAction.getElement(PolicyLocator.policyName(expectedPolicy)).getText();
        try {
            if (actualPolicy.equals(expectedPolicy))
                GemTestReporter.addTestStep("Policy", "Verified the Policy: " + actualPolicy, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Policy", "User not able to verify the policy: " + actualPolicy, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @And("Click on view policy")
    public void clickOnViewPolicy() {
        try {
            DriverAction.click(PolicyLocator.viewPolicy);
            GemTestReporter.addTestStep("Policy", "Verify user clicks on view policy", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Policy", "User not able to click on view policy", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }
    @Then("Click on {string} Button")
    public void clickOnButton(String btn) {
        try {
            if (btn.contains("Next")) {
                DriverAction.click(PolicyLocator.navigateButton(btn));
                GemTestReporter.addTestStep("Next", "Verify user clicks on Next button", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Next", "User not able to click on Next button", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        try {
            if (btn.contains("Previous")) {
                DriverAction.click(PolicyLocator.navigateButton(btn));
                GemTestReporter.addTestStep("Previous", "Verify user clicks on Previous button", STATUS.PASS, DriverAction.takeSnapShot());
            }
        }
        catch(Exception exception)
        {
            GemTestReporter.addTestStep("Previous", "User not able to click on Previous button", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
}

