package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.mis.locators.ApplyToAnyCardLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ApplyToAnyCardSteps {

    @When("Check {string} card is present in dashboard")
    public void checkCardIsPresentInDashboard(String cardName) {
        try {
            WebElement card = DriverAction.getElement(ApplyToAnyCardLocator.cardNameBeta(cardName));
            if (card.isDisplayed())
                GemTestReporter.addTestStep(cardName, "Verify " + cardName + "is present on dashboard", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep(cardName, "User not able to see cardName on the dashboard", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("User clicks on {string} button on {string} card on dashboard")
    public void userClicksOnButtonOnCardOnDashboard(String btn, String cardName) {
        try {
            DriverAction.click(ApplyToAnyCardLocator.minimiseMaximizeButton(btn, cardName));
            //DriverAction.waitUntilElementAppear(ApplyToAnyCardLocator.closeButton,5);
            GemTestReporter.addTestStep("Sign In", "User click on Sign In button", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Sign In", "User not able to click on Sign In button", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify that {string} card is minimized on dashboard")
    public void verifyThatCardIsMinimizedOnDashboard(String cardName) {
        try {
            int flag = 0;
            List<WebElement> cards = DriverAction.getElements(ApplyToAnyCardLocator.collapsedCard(cardName));
            for (WebElement card : cards)
                if (card.getText().equalsIgnoreCase(cardName))
                    flag = 1;
            if (flag == 1)
                GemTestReporter.addTestStep(cardName, "Verify cardName is displayed on Dashboard", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep(cardName, "User not able to see cardName on Dashboard", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify that {string} card is maximized on dashboard")
    public void verifyThatCardIsMaximizedOnDashboard(String cardName) {
        try {
            int flag = 0;
            List<WebElement> cards = DriverAction.getElements(ApplyToAnyCardLocator.expandedCard(cardName));
            for (WebElement card : cards)
                if (card.getText().equalsIgnoreCase(cardName))
                    flag = 1;
            if (flag == 1)
                GemTestReporter.addTestStep(cardName, "Verify card is expanded on Dashboard", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep(cardName, "User not able to expand the card on Dashboard", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

}
