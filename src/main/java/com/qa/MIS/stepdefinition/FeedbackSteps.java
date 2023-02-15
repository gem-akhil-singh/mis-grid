package com.qa.MIS.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.MIS.locators.LNSA_FeedbackLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class FeedbackSteps {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackSteps.class);

    @Then("^User clicks on Feedback from left menu panel$")
    public void clickOnFeedback() {
        DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.feedbackHome, 10);
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackHome))
            DriverAction.click(LNSA_FeedbackLocator.feedbackHome);
        else {
            logger.info("Unable to find/click Feedback from the Left Menu Panel");
            GemTestReporter.addReasonOfFailure("Unable to find/click Feedback from the Left Menu Panel");
            Assert.fail("Unable to find/click Feedback from the Left Menu Panel");
        }
    }

    @When("^User clicks on Submit Feedback from the sub-menu option of Feedback$")
    public void userClicksOnSubmitFeedback() {
        DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.feedbackSubmit, 10);
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackSubmit))
            DriverAction.click(LNSA_FeedbackLocator.feedbackSubmit);
        else {
            logger.info("Unable to find/click Submit Feedback from the Left Menu Panel");
            GemTestReporter.addReasonOfFailure("Unable to find/click Submit Feedback from the Left Menu Panel");
            Assert.fail("Unable to find/click Submit Feedback from the Left Menu Panel");
        }
        DriverAction.waitSec(5);
    }

    @When("^User clicks on Provide Feedback button$")
    public void userClicksOnProvideFeedbackButton() {
        DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.feedbackProvideFeedbackButton, 10);
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackProvideFeedbackButton)) {
            DriverAction.click(LNSA_FeedbackLocator.feedbackProvideFeedbackButton);
        } else {
            logger.info("Unable to find/click Provide Feedback button");
            GemTestReporter.addReasonOfFailure("Unable to find/click Provide Feedback button");
            Assert.fail("Unable to find/click Provide Feedback button");
        }

    }

    @Then("^User enters the required comments$")
    public void userEntersTheRequiredComments() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackSubmitFeedbackTextbox)) {
            DriverAction.click(LNSA_FeedbackLocator.feedbackSubmitFeedbackTextbox,
                    "Clicking on the text box",
                    "Clicked on the text box to make sure that the cursor and focus is on the text box");

            DriverAction.typeText(LNSA_FeedbackLocator.feedbackSubmitFeedbackTextbox, "This is a sample feedback");
        } else {
            logger.info("Unable to find and type text into the required text-box");
            GemTestReporter.addReasonOfFailure("Unable to find and type text into the required text-box");
            Assert.fail("Unable to find and type text into the required text-box");
        }
    }

    @And("^User clicks on Submit button$")
    public void userClicksOnSubmitButton() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackSubmitFeedbackButton))
            DriverAction.click(LNSA_FeedbackLocator.feedbackSubmitFeedbackButton);
        else {
            logger.info("Unable to click on the Submit button of the Provide Feedback pop-up");
            GemTestReporter.addReasonOfFailure("Unable to click on the Submit button of the Provide Feedback pop-up");
            Assert.fail("Unable to click on the Submit button of the Provide Feedback pop-up");
        }
        DriverAction.waitSec(5);
    }

    @Then("^User verifies the Success message and click on the OK button$")
    public void userVerifiesTheSuccessMessageAndClickOnTheOKButton() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackSuccessMsg)) {
            logger.info("Success Message pop-up appeared successfully");
            DriverAction.click(LNSA_FeedbackLocator.feedbackSuccessButton,
                    "Clicking on the Submit button of Success Message pop-up",
                    "Clicked on the Submit button");
        } else {
            logger.info("Unable to click on the Submit button of the Provide Feedback pop-up");
            GemTestReporter.addTestStep("Clicking on OK button",
                    "Unable to click on the Submit button of the Provide Feedback pop-up",
                    STATUS.FAIL);
            Assert.fail("Unable to click on the Submit button of the Provide Feedback pop-up");
        }
    }

    @And("^User checks if the Next button is active$")
    public void checkIfNextButtonIsActive() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackNextButton)) {
            if (DriverManager.getWebDriver().findElement(LNSA_FeedbackLocator.feedbackNextButton).isEnabled())
                logger.info("Next Button is available and is ready to be clicked");
            else {
                logger.info("Next button of the Feedback page is disabled");
                GemTestReporter.addTestStep("Finding the Next button",
                        "Next button of the Feedback page isn not enabled",
                        STATUS.FAIL);
                Assert.fail("Next button of the Feedback page isn not enabled");
            }

        }
    }

    @Then("^User clicks on the \"(.*?)\" button of Feedback page$")
    public void userClicksOnTheButtonOfFeedbackPage(String stepName) {
        DriverAction.waitSec(3);
        switch (stepName) {

            case "Next":
                if (DriverManager.getWebDriver().findElement(LNSA_FeedbackLocator.feedbackNextButton).isEnabled()) {
                    DriverAction.click(LNSA_FeedbackLocator.feedbackNextButton, "Click on the Next button of Feedback page",
                            "Clicked on the Next button successfully");
                    DriverAction.waitSec(3);
                }
                else {
                logger.info("Unable to click on the Next button of the Feedback page");
                GemTestReporter.addTestStep("Clicking on Next button",
                        "Unable to click on the Next button of the Feedback page",
                        STATUS.FAIL);
                Assert.fail("Unable to click on the Next button of the Feedback page");
            }
            case "Previous":
                if (DriverManager.getWebDriver().findElement(LNSA_FeedbackLocator.feedbackPreviousButton).isEnabled()) {
                    DriverAction.click(LNSA_FeedbackLocator.feedbackPreviousButton, "Click on the Previous button of Feedback page",
                            "Clicked on the Previous button successfully");
                }
                else {
                logger.info("Unable to click on the Next button of the Feedback page");
                GemTestReporter.addTestStep("Clicking on Previous button",
                        "Unable to click on the Previous button of the Feedback page",
                        STATUS.FAIL);
                Assert.fail("Unable to click on the Previous button of the Feedback page");
            }

        }

    }
}
