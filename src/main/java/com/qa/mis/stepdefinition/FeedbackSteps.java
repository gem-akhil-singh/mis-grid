package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.LNSA_FeedbackLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

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
    public void userTriesToNavigateOnFeedbackPage(String stepName) {
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

    @Then("^User enters \"(.*?)\" in the search box$")
    public void userEntersValidText(String sampleText) {
        if (DriverAction.isExist(LNSA_FeedbackLocator.feedbackSearchFeedback)) {
            DriverAction.click(LNSA_FeedbackLocator.feedbackSearchFeedback, "Clicking on Search text box to place cursor and focus on it",
                    "Clicked on the Search text box");
            DriverAction.typeText(LNSA_FeedbackLocator.feedbackSearchFeedback, sampleText);
        }
        else {
            logger.info("Unable to click on the Search text box of the Feedback page");
            GemTestReporter.addTestStep("Clicking on Search text box",
                    "Unable to click and enter text in the Search text box of the Feedback page",
                    STATUS.FAIL);
            Assert.fail("Unable to click and type in the Search text box of the Feedback page");
        }
    }

    @And("^User checks if \"(.*?)\" is in search result$")
    public void userChecksIfIsInSearchResult(String expectedText) {
        String numOfRows = DriverManager.getWebDriver().findElement(LNSA_FeedbackLocator.feedbackSearchResultsTotal).getText().split(" ")[5];
        try {
            int rowCount = Integer.parseInt(numOfRows);
            if (rowCount == 0){
                Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.feedbackSearchResultsEmpty),"Row Count is 0 but some data was still found" );
                logger.info("No results were found, skipping the rest of the validations");
            }
            else {
                List<WebElement> searchResults = DriverManager.getWebDriver().findElements(LNSA_FeedbackLocator.feedbackSearchResultsRow);
                for (int i = 0; i<searchResults.size(); i++){
                    String results = searchResults.get(i).getText();
                    System.out.println(results);
                    if (results.contains(expectedText))
                        logger.info(expectedText + "was found in the search results");

                    else {
                        logger.info(expectedText + "was invalid entry and was not found in the search results");
                        GemTestReporter.addReasonOfFailure(expectedText + "was invalid entry and was not found in the search results " + STATUS.FAIL);
                    }
                }
            }
        }catch (Exception e){
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
            DriverAction.click(LNSA_FeedbackLocator.exportButton, "Click on the Export Button",
                    "Export button was clicked successfully");
        } catch (Exception e){
            logger.info("Could not click on the button due to exception: "+ e);
            Assert.fail("Could not click on the button due to exception: "+ e);
        }
        Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.exportOptionCopy), "No copy button was found");
        Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.exportOptionExcel), "No Excel button was found");
        Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.exportOptionPDF), "No PDF button was found");
        Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.exportOptionPrint), "No print button was found");
    }

    @Then("^User clicks on the View icon of the Feedback page$")
    public void userClicksOnTheViewIconOfTheFeedbackPage() {
        if(DriverAction.isExist(LNSA_FeedbackLocator.viewFeedbackIcon))
            DriverAction.click(LNSA_FeedbackLocator.viewFeedbackIcon,"Trying to click on View Icon", "View Icon clicked");
        else{
            logger.info("View icon not found and unable to click on it");
            Assert.fail("View icon not found and unable to click on it");
        }
    }

    @And("^User verifies that the View Feedback pop-up appears$")
    public void userVerifiesThatTheViewFeedbackPopUpAppears() {
        DriverAction.waitSec(5);
        if(DriverAction.isExist(LNSA_FeedbackLocator.headingOfViewFeedback)){
            logger.info("View Feedback pop-up verified successfully");
            DriverAction.click(LNSA_FeedbackLocator.closeButtonOfViewFeedback, "Clicking on Close button of View Feedback",
                    "Close button clicked");
        }
        else {
            logger.info("View Feedback popup was not found");
            Assert.fail("View Feedback popup was not found");
        }
    }
}
