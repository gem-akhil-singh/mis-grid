package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.FormsLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.channels.ScatteringByteChannel;
import java.time.Duration;

public class FormsSteps {
    public static String dirPath = System.getProperty("user.dir");

    @Given("User enters username as {string}")
    public void userEntersUsernameAs(String userName) {
        try {

            DriverAction.typeText(FormsLocator.userName, userName);
            GemTestReporter.addTestStep("User enters the  username", "Username is entered successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("User enters the  username", "Username is not entered successfully" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("User enters password as {string}")
    public void userEntersPasswordAs(String password) {
        try {
            DriverAction.isExist(FormsLocator.password);
            DriverAction.typeText(FormsLocator.password, password);
            GemTestReporter.addTestStep("User enters the password", "Password is  entered successfully" , STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User enters the password", "Password is not entered successfully" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("User clicks on sign in")
    public void userClicksOnSignIn() {
        try {
            DriverAction.click(FormsLocator.bttnSignUp);
            DriverAction.setImplicitTimeOut(4);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User Clicks on Sign in", "sign in unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @And("User verifies landing page")
    public void userVerifiesLandingPage() {
        try {
            if (DriverAction.isExist(FormsLocator.geminiLogo)) {
                DriverAction.setImplicitTimeOut(6);
                GemTestReporter.addTestStep("User Verifies Landing Page", "Logo is verified", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("User Verifies Landing Page", "Logo is not verified", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("User Verifies Landing Page", "Logo is not verified" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("^User clicks on pop up close button$")
    public void userClicksOnCloseButton() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.skillTypeBtn, 7);
            DriverAction.click(FormsLocator.closeBtn);
            GemTestReporter.addTestStep("User clicks on close button", "Click is successful on close button", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on close button", "Click is unsuccessful on close button", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Given("User clicks on tab {string} and {string}")
    public void userClicksOnTabAnd(String form, String viewForm) {
        try {
            if (DriverAction.isExist(FormsLocator.forms)) {
                DriverAction.waitSec(7);
                DriverAction.click(FormsLocator.forms);
                DriverAction.isExist(FormsLocator.viewForm);
                DriverAction.click(FormsLocator.viewForm);
                GemTestReporter.addTestStep("User Clicks on Form", "Click is successful on Forms", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("User Clicks on Form", "Click is unsuccessful on Forms", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("User Clicks on Form", "Click is unsuccessful on Forms" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("User verifies element {string}")
    public void userVerifiesElement(String viewForms) {
        try {
            if (DriverAction.isExist(FormsLocator.forms)) {
                DriverAction.isExist(FormsLocator.viewForm);
                GemTestReporter.addTestStep("User Verifies View Forms Page ", "Form Page is verified", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("User Clicks on View Form", "Click is unsuccessful on View Form", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("User Clicks on View Form", "Click is unsuccessful on View Form" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }


    @Then("User verifies the presence of {string} Button")
    public void userVerifiesThePresenceOfBtn(String button) {
        try {
            if (DriverAction.isExist(FormsLocator.previous)) {
                GemTestReporter.addTestStep("User Verifies Previous Button", "Previous Button is verified", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("User Verifies Previous Button", "Previous Button is not verified", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.isExist(FormsLocator.next)) {
                GemTestReporter.addTestStep("User Verifies Next Button", "Next Button is verified", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("User Verifies Next Button", "Next Button is not verified", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("User verifies the Next and Previous button", "User cannot verify the Next and Previous Button" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }


    @When("User clicks on department")
    public void userClicksOnDepartment() {
        try {
            DriverAction.waitSec(3);
            DriverAction.click(FormsLocator.department);
            GemTestReporter.addTestStep("User clicks on department", "Click on department is successful", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on department", "Click on department is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("User clicks on {string}")
    public void userClicksOn(String accounts) {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.accounts, 6);
            DriverAction.click(FormsLocator.accounts);
            GemTestReporter.addTestStep("User clicks on accounts", "Click is successful on Accounts", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on accounts", "Click is unsuccessful on Accounts", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User selects the entries as {string}")
    public void userSelectsTheEntriesAs(String element) {
        try {
            DriverAction.scrollIntoView(FormsLocator.selectEntriesValue(element));
            DriverAction.click(FormsLocator.selectEntriesValue(element));
            GemTestReporter.addTestStep("User clicks on the entries ", "Click is successful on entries", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on the entries ", "Click is unsuccessful on entries", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User search field and enters value {string}")
    public void userSearchFieldAndEntersValue(String value) {
        try {
            DriverAction.typeText(FormsLocator.searchBtn, value);
            GemTestReporter.addTestStep("User clicks on search field", "Click is successful on search field", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on search field", "Click is unsuccessful on search field", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User verifies the value {string}")
    public void userVerifiesTheValue(String element) {
        try {
            if (DriverAction.isExist(FormsLocator.accountsType(element))) {
                DriverAction.waitUntilElementAppear(FormsLocator.accountsType(element), 5);
                GemTestReporter.addTestStep("User verifies the account type value ", "Verification is successful for account value", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("User verifies the account type value ", "Verification is unsuccessful for account value", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("User verifies the account type value", "Verification is unsuccessful for account value" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("User search field and enters invalid value {string}")
    public void userSearchFieldAndEntersInvalidValue(String value) {
        try {
            if (DriverAction.isExist(FormsLocator.searchBtn)) {
                DriverAction.typeText(FormsLocator.searchBtn, value + Keys.ENTER);
                GemTestReporter.addTestStep("User enters the invalid value in search", "Invalid value is  entered", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("User enters the invalid value in search", "Invalid value is not entered", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("User enters the invalid value in search", "Invalid value is not entered" + e, STATUS.FAIL);
        }
    }

    @Then("User verifies the invalid value {string}")
    public void userVerifiesTheInvalidValue(String element) {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.noDataAvailable, 7);
            GemTestReporter.addTestStep("User verifies the invalid value ", "Verification is successful for invalid value", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User verifies the invalid value ", "Verification is unsuccessful for invalid value", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @When("User clicks on eye button")
    public void userClicksOnEyeButton() {
        try {
            DriverAction.click(FormsLocator.eyeBtn);
            GemTestReporter.addTestStep("User clicks on eye button ", "Click on eye button is successful", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on eye button ", "Click on eye button is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }


    @Then("User views policy")
    public void userViewsPolicy() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.policyCloseBtn, 7);
            DriverAction.click(FormsLocator.policyCloseBtn);
            GemTestReporter.addTestStep("User clicks on close button", "Click on policy close button is successful", STATUS.PASS, DriverAction.takeSnapShot(), DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on close button", "Click on policy close button is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot(), DriverAction.takeSnapShot());
        }
    }

    @Then("User click on download image")
    public void userClickOnDownloadImage() {

        try {
            if (DriverAction.isExist(FormsLocator.documentDownload)) {
                DriverAction.click(FormsLocator.documentDownload,"Download document button");
                GemTestReporter.addTestStep("User clicks on download image", "Document download is successful", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("User clicks on download image", "Document download is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on download image", "Document download is unsuccessful" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Given("User clicks on the {string} and {string}")
    public void userClicksOnTheAnd(String forms, String myForms) {
        try {
            if (DriverAction.isExist(FormsLocator.forms)) {
                DriverAction.waitSec(7);
                DriverAction.click(FormsLocator.forms);
                DriverAction.isExist(FormsLocator.myForms);
                DriverAction.click(FormsLocator.myForms);
                GemTestReporter.addTestStep("User clicks on forms button", "Click is successful on Forms button", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("User clicks on forms button", "Click is unsuccessful on Forms Button", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on forms button", "Click is unsuccessful on Forms Button" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("Verify the heading on the landing page")
    public void verifyTheHeadingOnTheLandingPage() {
        try {
            if (DriverAction.isExist(FormsLocator.myFormsHeading)) {
                GemTestReporter.addTestStep("User clicks on search field", "Click is Successful for search field", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("User clicks on search field", "Click is unsuccessful for search field", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on search field", "Unable to land on the landing page" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }


    @When("User clicks on upload button")
    public void userClicksOnUploadBtn() {
        try {
            DriverAction.waitSec(7);
            DriverAction.click(FormsLocator.uploadBtn);
            DriverAction.setImplicitTimeOut(7);
            GemTestReporter.addTestStep("User clicks on upload button", "Click on upload button is successful", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on upload button", "Click on upload button is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @When("User uploads the desired document {string} from {string}")
    public void userUploadTheDesiredDocument(String formType, String path) {
        try {
            DriverAction.waitSec(3);
            DriverAction.click(FormsLocator.formTypeDropDown);
            DriverAction.click(FormsLocator.formType(formType));
            DriverAction.waitSec(4);
            DriverAction.fileUpload(FormsLocator.chooseFile, dirPath + path);
            DriverAction.setImplicitTimeOut(7);
            GemTestReporter.addTestStep("User uploads the document", "Upload is successful", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User uploads the document", "Upload is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User clicks on save button")
    public void userClicksOnSaveBtn() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.saveBtn, 6);
            DriverAction.click(FormsLocator.saveBtn);
            DriverAction.waitSec(5);
            GemTestReporter.addTestStep("User clicks on save button", "Click is successful on save button", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on save button", "Click is unsuccessful on save button", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }


    @And("User uploads the undesired document {string} from {string}")
    public void userUploadTheUndesiredDocument(String formType, String path) {
        try {
            DriverAction.waitSec(2);
            DriverAction.click(FormsLocator.formTypeDropDown);
            DriverAction.waitUntilElementAppear(FormsLocator.formType(formType), 5);
            DriverAction.click(FormsLocator.formType(formType));
            DriverAction.fileUpload(FormsLocator.chooseFile, dirPath + path);
            DriverAction.setImplicitTimeOut(7);
            GemTestReporter.addTestStep("User uploads invalid document", "Upload is successful", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User uploads invalid document", "Upload is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("Verify the warning {string}")
    public void verifyThe(String warningMsg) {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.warningMsg, 5);
            GemTestReporter.addTestStep("User verifies the warning message", "Click is successful on warning message", STATUS.PASS, DriverAction.takeSnapShot());


        } catch (Exception e) {
            GemTestReporter.addTestStep("User verifies the warning message", "Click is unsuccessful on warning message", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @Then("User clicks on ok button")
    public void userClicksOnOkbtn() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.okBtn, 4);
            DriverAction.click(FormsLocator.okBtn);
            GemTestReporter.addTestStep("User clicks on ok button", "Click is successful on ok button", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on ok button", "Click is unsuccessful on ok button", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User enters valid value in my forms search field as {string}")
    public void userEntersValidValueInMyFormsSearchFieldAs(String Loyalty) {
        try {
            DriverAction.typeText(FormsLocator.searchBtn, Loyalty + Keys.ENTER);
            GemTestReporter.addTestStep("User enter text in search field", "Text is  entered in search field", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User enter text in search field", "Text is not entered in search field", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User enters invalid value in My forms search field as {string}")
    public void userEntersInvalidValueInMyFormsSearchFieldAs(String QA) {
        try {
            DriverAction.typeText(FormsLocator.searchBtn, QA + Keys.ENTER);
            DriverAction.setImplicitTimeOut(6);
            GemTestReporter.addTestStep("User enter text in search field", "Text is  entered in search field", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User enter text in search field", "Text is not entered in search field", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }


    @When("User clicks on active form")
    public void userClicksOnActiveForm() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.activeForm, 5);
            DriverAction.click(FormsLocator.activeForm);
            GemTestReporter.addTestStep("User  clicks on active form", "Click is successful for active forms", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User  clicks on active form", "Click is unsuccessful for active forms", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User hovers and clicks on deactivate button")
    public void userHoversAndClicksOnDeactivateBtn() {
        try {
            DriverAction.waitSec(7);
            DriverAction.click(FormsLocator.deactivateBtn,"Deactivate button");
            GemTestReporter.addTestStep("User  clicks on deactivate button", "Click is successful for deactivate button", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User  clicks on deactivate button", "Click is unsuccessful for deactivate button", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("User clicks on yes button")
    public void userClicksOnYesBtn() {
        try {
            if (DriverAction.isExist(FormsLocator.yesBtn)) {
                DriverAction.click(FormsLocator.yesBtn);
                GemTestReporter.addTestStep("User Clicks on Yes Button", "Click is successful", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("User Clicks on Yes Button", "Click is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "User is unable to click on yes button" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("User hovers and clicks on download button")
    public void userHoversAndClicksOnDownloadBtn() {
        try {
            DriverAction.waitSec(7);
            DriverAction.click(FormsLocator.downloadBtn,"Download button");

            GemTestReporter.addTestStep("User Clicks on Download Button", "Click is successful for download button", STATUS.PASS, DriverAction.takeSnapShot());


        } catch (Exception e) {
            GemTestReporter.addTestStep("User Clicks on Download Button", "Click is unsuccessful for download button", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @When("User validates the error message as {string}")
    public void userValidatesTheErrorMessageAs(String element) {
        DriverAction.waitUntilElementAppear(FormsLocator.errorMsg, 7);
        try {
            DriverAction.click(FormsLocator.errorMsg);
            GemTestReporter.addTestStep("User validates the error message", "Validation is successful for error message", STATUS.PASS, DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User validates the error message", "Validation is unsuccessful for error message", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
}
