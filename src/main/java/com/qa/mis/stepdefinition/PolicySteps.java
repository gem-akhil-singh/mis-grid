package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.mis.locators.LoginLocator;
import com.qa.mis.locators.PolicyLocator;
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
}
