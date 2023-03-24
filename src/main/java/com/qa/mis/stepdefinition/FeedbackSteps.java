package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.LNSA_FeedbackLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

public class FeedbackSteps {
    private static final Logger logger = LoggerFactory.getLogger(FeedbackSteps.class);

    public static void userClicks(String buttonName) {
        try {
            By elementClicked = null;
            switch (buttonName.toLowerCase().trim()) {
                case "feedback home":
                    elementClicked = LNSA_FeedbackLocator.feedbackHome;
                    break;
                case "feedback submit":
                    elementClicked = LNSA_FeedbackLocator.feedbackSubmit;
                    break;
                case "feedback provide feedback button":
                    elementClicked = LNSA_FeedbackLocator.feedbackProvideFeedbackButton;
                    break;
                case "feedback submit feedback textbox":
                    elementClicked = LNSA_FeedbackLocator.feedbackSubmitFeedbackTextbox;
                    break;
                case "feedback submit feedback button":
                    elementClicked = LNSA_FeedbackLocator.feedbackSubmitFeedbackButton;
                    break;
                case "success button":
                    elementClicked = LNSA_FeedbackLocator.successButton;
                    break;
                case "feedback next button":
                    elementClicked = LNSA_FeedbackLocator.nextButton;
                    break;
                case "feedback previous button":
                    elementClicked = LNSA_FeedbackLocator.previousButton;
                    break;
                case "search textbox":
                    elementClicked = LNSA_FeedbackLocator.searchTextbox;
                    break;
                case "export button":
                    elementClicked = LNSA_FeedbackLocator.exportButton;
                    break;
                case "view icon":
                    elementClicked = LNSA_FeedbackLocator.viewIcon;
                    break;
                case "close button of view feedback":
                    elementClicked = LNSA_FeedbackLocator.closeButtonOfViewFeedback;
                    break;
                case "lnsa reason textbox":
                    elementClicked = LNSA_FeedbackLocator.LNSA_REASON_TXTBOX;
                    break;
                case "next button":
                    elementClicked = LNSA_FeedbackLocator.nextButton;
                    break;
                case "previous button":
                    elementClicked = LNSA_FeedbackLocator.previousButton;
                    break;
                case "close button of view lnsa":
                    elementClicked = LNSA_FeedbackLocator.closeButtonOfViewLNSA;
                    break;
                default:
                    Assert.fail("No such button in code");
            }
            DriverAction.click(elementClicked, "User clicks on "+buttonName, "Clicked on "+buttonName);
        } catch (Exception ex) {
            logger.info("Tried to click on "+buttonName+" but failed to do so!!");
            Assert.fail("Tried to click on "+buttonName+" but unable to do so!!");
        }
    }

    @Then("^User clicks on Feedback from left menu panel$")
    public void clickOnFeedback() {
        DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.feedbackHome, 10);
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackHome))
            userClicks("Feedback Home");
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
            userClicks("Feedback Submit");
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
            userClicks("Feedback Provide Feedback Button");
        } else {
            logger.info("Unable to find/click Provide Feedback button");
            GemTestReporter.addReasonOfFailure("Unable to find/click Provide Feedback button");
            Assert.fail("Unable to find/click Provide Feedback button");
        }

    }

    @Then("^User enters the required comments$")
    public void userEntersTheRequiredComments() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackSubmitFeedbackTextbox)) {
            userClicks("Feedback Submit Feedback Textbox");

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
            userClicks("Feedback Submit Feedback Button");
        else {
            logger.info("Unable to click on the Submit button of the Provide Feedback pop-up");
            GemTestReporter.addReasonOfFailure("Unable to click on the Submit button of the Provide Feedback pop-up");
            Assert.fail("Unable to click on the Submit button of the Provide Feedback pop-up");
        }
        DriverAction.waitSec(5);
    }

    @Then("^User verifies the Success message and click on the OK button$")
    public void userVerifiesTheSuccessMessageAndClickOnTheOKButton() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.successMsg)) {
            logger.info("Success Message pop-up appeared successfully");
            userClicks("Success Button");
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
        if (DriverAction.isExist(LNSA_FeedbackLocator.nextButton)) {
            if (DriverManager.getWebDriver().findElement(LNSA_FeedbackLocator.nextButton).isEnabled())
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
    public void userTriesToNavigateOnFeedbackPage(String stepName) {
        DriverAction.waitSec(3);
        switch (stepName) {

            case "Next":
                if (DriverManager.getWebDriver().findElement(LNSA_FeedbackLocator.nextButton).isEnabled()) {
                    userClicks("Feedback Next Button");
                    DriverAction.waitSec(3);
                } else {
                    logger.info("Unable to click on the Next button of the Feedback page");
                    GemTestReporter.addTestStep("Clicking on Next button",
                            "Unable to click on the Next button of the Feedback page",
                            STATUS.FAIL);
                    Assert.fail("Unable to click on the Next button of the Feedback page");
                }
            case "Previous":
                if (DriverManager.getWebDriver().findElement(LNSA_FeedbackLocator.previousButton).isEnabled()) {
                    userClicks("Feedback Previous Button");
                } else {
                    logger.info("Unable to click on the Next button of the Feedback page");
                    GemTestReporter.addTestStep("Clicking on Previous button",
                            "Unable to click on the Previous button of the Feedback page",
                            STATUS.FAIL);
                    Assert.fail("Unable to click on the Previous button of the Feedback page");
                }

        }

    }

    @Then("^User enters \"(.*?)\" in the search box$")
    public void userEntersValidText(String expectedText) {
        if (DriverAction.isExist(LNSA_FeedbackLocator.searchTextbox)) {
            userClicks("Search Textbox");
            DriverAction.typeText(LNSA_FeedbackLocator.searchTextbox, expectedText);
        } else {
            logger.info("Unable to click on the Search text box of the Feedback page");
            GemTestReporter.addTestStep("Clicking on Search text box",
                    "Unable to click and enter text in the Search text box of the Feedback page", STATUS.FAIL);
            Assert.fail("Unable to click and type in the Search text box of the Feedback page");
        }
    }

    @And("^User checks if \"(.*?)\" is in search result$")
    public void userChecksIfIsInSearchResult(String expectedText) {
        String numOfRows = DriverManager.getWebDriver().findElement(LNSA_FeedbackLocator.searchResultsTotal).getText().split(" ")[5];
        List<WebElement> searchResults = DriverManager.getWebDriver().findElements(LNSA_FeedbackLocator.feedbackSearchResultsRow);
        try {
            int rowCount = Integer.parseInt(numOfRows);
            if (rowCount == 0) {
                Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.searchResultsEmpty), "Row Count is 0 but some data was still found");
                logger.info("No results were found, skipping the rest of the validations");
            } else {
                for (WebElement searchResult : searchResults) {
                    String results = searchResult.getText();
                    if (results.toLowerCase().contains(expectedText))
                        logger.info(expectedText + " was found in the search results");

                    else {
                        logger.info(expectedText + " was invalid entry and was not found in the search results");
                        Assert.fail(expectedText + " was invalid entry and was not found in the search results");
                        GemTestReporter.addReasonOfFailure(expectedText + " was invalid entry and was not found in the search results " + STATUS.FAIL);
                    }
                }
            }
        } catch (Exception e) {
            logger.info("Expected a numeric row count, instead found " + numOfRows);
            Assert.fail("Expected a numeric row count, instead found " + numOfRows);
        }

    }

    @Then("^User checks if the Export button is available$")
    public void userChecksIfTheExportButtonIsAvailable() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.exportButton))
            logger.info("Export button is present on the Feedback Page");
        else {
            logger.info("Export button is present on the Feedback Page");
            Assert.fail("Export button is present on the Feedback Page");

        }
    }

    @And("^User clicks on the Export button$")
    public void userClicksOnTheExportButton() {
        try {
            userClicks("Export Button");
        } catch (Exception e) {
            logger.info("Could not click on the button due to exception: " + e);
            Assert.fail("Could not click on the button due to exception: " + e);
        }
        Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.exportOptionCopy), "No copy button was found");
        Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.exportOptionExcel), "No Excel button was found");
        Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.exportOptionPDF), "No PDF button was found");
        Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.exportOptionPrint), "No print button was found");
    }

    @Then("^User clicks on the View icon$")
    public void userClicksOnTheViewIcon() {
        DriverAction.waitSec(3);
        if (DriverAction.isExist(LNSA_FeedbackLocator.viewIcon))
            userClicks("View Icon");
        else {
            logger.info("View icon not found and unable to click on it");
            Assert.fail("View icon not found and unable to click on it");
        }
    }



    @And("^User verifies that the \"(.*?)\" pop-up appears$")
    public void userVerifiesThatTheViewPopUpAppears(String headerText) {
        DriverAction.waitSec(5);
        if (DriverAction.isExist(LNSA_FeedbackLocator.popupHeader(headerText))) {
            logger.info("View Feedback pop-up verified successfully");
            if(StringUtils.equals(headerText,"View Feedback"))
            userClicks("Close Button Of View Feedback");
            else
                userClicks("Close Button of View LNSA");
        } else {
            logger.info("View Feedback popup was not found");
            Assert.fail("View Feedback popup was not found");
        }
    }
}
