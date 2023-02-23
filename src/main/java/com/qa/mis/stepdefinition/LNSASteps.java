package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.LNSA_FeedbackLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LNSASteps {
    private static final Logger logger = LoggerFactory.getLogger(LNSASteps.class);

    @Given("^User is on the MIS Login Page$")
    public void userIsOnTheMISLoginPage() {
        if (!DriverAction.isExist(LNSA_FeedbackLocator.geminiLogo)) {
            logger.info("Gemini Logo not Present and User is not on MIS Homepage");
            Assert.fail("Gemini Logo not Present and User is not on MIS Homepage");
        }
    }

    @When("^User enters their login details \"(.*?)\" and \"(.*?)\" and logs in$")
    public void userEntersLoginDetails(String username, String password) {
        DriverAction.typeText(LNSA_FeedbackLocator.txtUserName, username);

        byte[] decodedPassword = Base64.decodeBase64(password);
        DriverAction.typeText(LNSA_FeedbackLocator.txtPassword, new String(decodedPassword));
        DriverAction.click(LNSA_FeedbackLocator.buttonLogin, "User clicks on Sign-in button", "Click on Sign-in button was a success");
        DriverAction.waitSec(10);
    }

    @Then("^User clicks on LNSA from left menu panel$")
    public void userClicksOnLNSA() {
        try {
            DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.LNSA_HOME, 10);
            DriverAction.click(LNSA_FeedbackLocator.LNSA_HOME);
        } catch (Exception e) {
            Assert.fail("Unable to find LNSA Home and unable to click on it");
        }
    }

    @And("^User selects Apply LNSA from menu panel$")
    public void userSelectsFromMenuPanel() {
        try {
            DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.LNSA_APPLY_LNSA, 5);
            DriverAction.click(LNSA_FeedbackLocator.LNSA_APPLY_LNSA);
            DriverAction.waitSec(3);
        } catch (Exception e) {
            logger.info("Unable to find LNSA Home and unable to click on it");
            Assert.fail("Unable to find LNSA Home and unable to click on it");
        }

    }

    @Then("^User tries to move to the previous date$")
    public void userTriesToMoveToThePreviousDate() throws ParseException, InterruptedException {
        try {
            DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.LNSA_START_DATE, 5);
        } catch (Exception e) {
            logger.info("Couldn't load Apply LNSA page");
            Assert.fail("Couldn't load Apply LNSA page");
        }
        if (DriverAction.isExist(LNSA_FeedbackLocator.LNSA_PREVIOUS_BUTTON)) {
            String startDate = DriverAction.getElementText(LNSA_FeedbackLocator.LNSA_START_DATE);
            Date startDate1 = new Date();
            try {
                startDate1 = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(startDate);
            } catch (Exception e) {
                logger.info("Invalid format for start date found, could not parse the date. Date found: " + startDate);
                Assert.fail("Invalid format for start date found, could not parse the date. Date found: " + startDate);
            }
            DriverAction.click(LNSA_FeedbackLocator.LNSA_PREVIOUS_BUTTON, "User clicks on Previous button", "Click on Previous button was a success");
            while (!DriverAction.getElement(LNSA_FeedbackLocator.LNSA_NEXT_BUTTON).isEnabled()) {
                Thread.sleep(500);
            }

            String endDate = DriverAction.getElementText(LNSA_FeedbackLocator.LNSA_END_DATE);
            Date endDate1 = new Date();

            try {
                endDate1 = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH).parse(endDate);
            } catch (Exception e) {
                logger.info("Invalid format for date found, could not parse the date. Date found: " + endDate);
                Assert.fail("Invalid format for date found, could not parse the date. Date found: " + endDate);
            }
            long diff = (startDate1.getTime() - endDate1.getTime()) / (1000 * 3600 * 24);
            if (diff != 1) {
                logger.info("User is not on the correct calendar page. The difference in dates is of " + diff + " days");
                Assert.fail("User is not on the correct calendar page. The difference in dates is of " + diff + " days");
            }

        }
    }

    @Then("^User tries to move to the next date$")
    public void userMovesToNextDate() {
        try {
            DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.LNSA_NEXT_BUTTON, 5);
            DriverAction.click(LNSA_FeedbackLocator.LNSA_NEXT_BUTTON, "User clicks on Next button", "Click on Next button was a success");
            Thread.sleep(1000);
        } catch (Exception e) {
            logger.info("Unable to click on Next button");
            Assert.fail("Unable to click on Next button");
        }
    }

    @Then("^User checks and unchecks a checkbox of any week present on the page$")
    public void userSelectsDeselectsCheckbox() {
        try {
            DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.LNSA_WEEK_SELECT, 5);
            DriverAction.click(LNSA_FeedbackLocator.LNSA_WEEK_SELECT, "User clicks on Week Checkbox", "Click and check of Week Checkbox was a success");
        } catch (Exception e) {
            logger.info("Unable to click on Week Checkbox");
            Assert.fail("Unable to click on Week Checkbox");
        }
        DriverAction.click(LNSA_FeedbackLocator.LNSA_WEEK_SELECT, "User clicks on Week Checkbox again to uncheck", "Click and uncheck of Week Checkbox was a success");
    }

    @And("User tries to Submit the LNSA without selecting date")
    public void userTriesToSubmitLNSA() {
        try {
            DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.LNSA_SUBMIT_BUTTON, 5);
            DriverAction.click(LNSA_FeedbackLocator.LNSA_SUBMIT_BUTTON, "User clicks on Submit button to Submit a blank LNSA", "Click on Submit button was a success");
            DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.LNSA_WARNING_POP, 5);
            if (!DriverAction.isExist(LNSA_FeedbackLocator.LNSA_WARNING_POP))
                Assert.fail("Warning pop-up did not appear after submitting an empty LNSA");
        } catch (Exception e) {
            logger.info("Unable to click on Submit button");
            Assert.fail("Unable to click on Submit button");
        }
        DriverAction.click(LNSA_FeedbackLocator.LNSA_OK_BUTTON, "Click on the OK Button to disappear the pop-up", "Click on OK Button was a success");
    }

    @Then("^User selects a day for which LNSA has not been applied$")
    public void userSelectsDay() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.LNSA_ANY_DAY_SELECT))
            DriverAction.click(LNSA_FeedbackLocator.LNSA_ANY_DAY_SELECT, "User clicks on any day that has not been selected",
                    "Selection of a day was a success");
        else {
            logger.info("Unable to find the week-select checkbox and unable to click on it");
            Assert.fail("Unable to find the week-select checkbox and unable to click on it");
        }
        DriverAction.click(LNSA_FeedbackLocator.LNSA_SUBMIT_BUTTON,
                "User clicks on Submit button",
                "Click on Submit button was a success");
    }

    @Then("^User submits the LNSA with selected day")
    public void userSubmitsTheLNSAWeek() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.LNSA_SUBMIT_BUTTON))
            DriverAction.click(LNSA_FeedbackLocator.LNSA_SUBMIT_BUTTON,
                    "User clicks on Submit button",
                    "Click on Submit button was a success");
        else {
            logger.info("Unable to find the Submit button and unable to click on it");
            Assert.fail("Unable to find the Submit button and unable to click on it");
        }
    }

    @And("^User enters the reason for LNSA submission$")
    public void userEntersTheReasonForLNSASubmission() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.LNSA_REASON_TXTBOX)) {
            logger.info("Pop-up to enter reason for LNSA is available");
            DriverAction.waitUntilElementAppear(LNSA_FeedbackLocator.LNSA_REASON_TXTBOX,3);
            FeedbackSteps.userClicks("lnsareasontextbox");
            DriverAction.typeText(LNSA_FeedbackLocator.LNSA_REASON_TXTBOX, "This is a reason entered by test-automation");
        } else {
            logger.info("Unable to find Reson pop up.");
            Assert.fail("Unable to find Reson pop up.");
        }
    }

    @Then("^User clicks on the \"(.*?)\" of Reason pop-up$")
    public void userClicksOnTheSubmitOfReasonPopUp(String buttonsOfReason) {
        switch (buttonsOfReason) {
            case "Submit":
                DriverAction.click(LNSA_FeedbackLocator.LNSA_REASON_SUBMIT_BTN,
                        "User clicks on the submit button of Reason popup",
                        "Click on the button was a success");
                break;
            case "Cancel":
                DriverAction.click(LNSA_FeedbackLocator.LNSA_REASON_CANCEL_BTN,
                        "User clicks on the submit button of Reason popup",
                        "Click on the button was a success");
                break;
            default:
                logger.info("Unable to find the required button");
                Assert.fail("Unable to find the required button");
                break;
        }

    }

    @Then("^User verifies the success message and clicks on OK$")
    public void userVerfiesTheSuccessMessgaeAndClicksOnOK() {
        if (DriverAction.isExist(LNSA_FeedbackLocator.successMsg)) {
            logger.info("Submission of LNSA was a success");
            DriverAction.click(LNSA_FeedbackLocator.successButton,
                    "User click on the OK button of success message",
                    "Click was a success");
        } else {
            logger.info("Success message popup did not appear");
            Assert.fail("Success message popup did not appear");
        }
    }

    @And("^User selects \"(.*?)\" from menu panel$")
    public void userSelectsStatusFromMenuPanel(String subMenuOptions) {
        switch (subMenuOptions) {
            case "View Request Status":
                if (DriverAction.isExist(LNSA_FeedbackLocator.LNSA_VIEW_REQUEST_STATUS)) {
                    DriverAction.click(LNSA_FeedbackLocator.LNSA_VIEW_REQUEST_STATUS,
                            "User clicks on the View Request Status from LNSA sub-menu",
                            "Click on the sub-menu label was successful");
                    Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.LNSA_REQUEST_TAB), "Unable to locate the LNSA Resquets Tab");
                } else {
                    logger.info("View Request Status sub-menu option not found");
                    Assert.fail("View Request Status sub-menu option not found");
                }
                break;

            case "Apply LNSA":
                if (DriverAction.isExist(LNSA_FeedbackLocator.LNSA_APPLY_LNSA))
                    DriverAction.click(LNSA_FeedbackLocator.LNSA_APPLY_LNSA,
                            "User clicks on the View Request Status from LNSA sub-menu",
                            "Click on the sub-menu label was successful");
                else {
                    logger.info("Apply LNSA sub-menu option not found");
                    Assert.fail("Apply LNSA sub-menu option not found");
                }
                break;

            default:
                logger.info("Sub-menu options " + subMenuOptions + " not found");
                Assert.fail("Sub-menu options " + subMenuOptions + " not found");
                break;

        }
    }

    @And("^User checks if \"(.*?)\" is in search result of LNSA applied$")
    public void userChecksSearchResultOfLNSA(String expectedText) {
        String numOfRows = DriverManager.getWebDriver().findElement(LNSA_FeedbackLocator.searchResultsTotal).getText().split(" ")[5];
        try {
            int rowCount = Integer.parseInt(numOfRows);
            if (rowCount == 0) {
                Assert.assertTrue(DriverAction.isExist(LNSA_FeedbackLocator.searchResultsEmpty), "Row Count is 0 but some data was still found");
                logger.info("No results were found, skipping the rest of the validations");
            } else {
                List<WebElement> searchResults = DriverManager.getWebDriver().findElements(LNSA_FeedbackLocator.LNSA_SEARCH_RESULTS);
                for (WebElement searchResult : searchResults) {
                    String results = searchResult.getText();
                    if (results.contains(expectedText))
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

}
