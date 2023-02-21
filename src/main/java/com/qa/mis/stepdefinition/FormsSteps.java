package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.mis.locators.FormsLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.nio.channels.ScatteringByteChannel;

public class FormsSteps {
    public static String dirPath = System.getProperty("user.dir");

    @Given("User enters username as {string}")
    public void userEntersUsernameAs(String userName) {
        try {
            if (DriverAction.isExist(FormsLocator.userName)) {
                DriverAction.typeText(FormsLocator.userName, userName);
            } else {
                GemTestReporter.addTestStep("User Enters the Wrong Username", "Username is not Verified", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("User enters password as {string}")
    public void userEntersPasswordAs(String password) {
        try {
            if (DriverAction.isExist(FormsLocator.password)) {
                DriverAction.typeText(FormsLocator.password, password);
            } else {
                GemTestReporter.addTestStep("User Enters the Wrong Password", "Password is not Verified", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("User clicks on sign in")
    public void userClicksOnSignIn() {
        try {
            DriverAction.click(FormsLocator.bttnSignUp);
            DriverAction.setImplicitTimeOut(4);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User Clicks on SignIn", "sign in Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

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
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("^User clicks on pop up close button$")
    public void userClicksOnCloseButton() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.skillTypeBtn, 7);
            DriverAction.click(FormsLocator.closeBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on close button", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

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
            } else {
                GemTestReporter.addTestStep("User Clicks on Form", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("User verifies element {string}")
    public void userVerifiesElement(String viewForms) {
        try {
            if (DriverAction.isExist(FormsLocator.forms)) {
                DriverAction.isExist(FormsLocator.viewForm);
                GemTestReporter.addTestStep("User Verifies View Forms Page ", "Form Page is verified", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("User Clicks on View Form", "Click is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
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
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }


    @When("User clicks on department")
    public void userClicksOnDepartment() {
        try {
            DriverAction.click(FormsLocator.department);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on department", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("User clicks on {string}")
    public void userClicksOn(String accounts) {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.accounts, 6);
            DriverAction.click(FormsLocator.accounts);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on accounts", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User selects the entries as {string}")
    public void userSelectsTheEntriesAs(String element) {
        try {
            DriverAction.scrollIntoView(FormsLocator.selectEntriesValue(element));
            DriverAction.click(FormsLocator.selectEntriesValue(element));
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on the entries ", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User search field and enters value {string}")
    public void userSearchFieldAndEntersValue(String value) {
        try {
            DriverAction.typeText(FormsLocator.searchBtn, value);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on search field", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User verifies the value {string}")
    public void userVerifiesTheValue(String element) {
        try {
            if (DriverAction.isExist(FormsLocator.accountsType(element))) {
                DriverAction.waitUntilElementAppear(FormsLocator.accountsType(element), 5);

            } else {
                GemTestReporter.addTestStep("User verifies the value ", "Verification is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("User search field and enters invalid value {string}")
    public void userSearchFieldAndEntersInvalidValue(String value) {
        try {
            if (DriverAction.isExist(FormsLocator.searchBtn)) {
                DriverAction.typeText(FormsLocator.searchBtn, value + Keys.ENTER);
            } else {
                GemTestReporter.addTestStep("User enters the text", "Value is not Entered", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("User verifies the invalid value {string}")
    public void userVerifiesTheInvalidValue(String element) {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.noDataAvailable, 7);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User verifies the invalid value", "Verification is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @When("User clicks on eye button")
    public void userClicksOnEyeButton() {
        try {
            DriverAction.click(FormsLocator.eyeBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on eye button ", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }


    @Then("User views policy")
    public void userViewsPolicy() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.policyCloseBtn, 7);
            DriverAction.click(FormsLocator.policyCloseBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on close button", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot(), DriverAction.takeSnapShot());
        }
    }

    @Then("User click on download image")
    public void userClickOnDownloadImage() {

        try {
            if (DriverAction.isExist(FormsLocator.documentDownload)) {
                DriverAction.click(FormsLocator.documentDownload);
            } else {
                GemTestReporter.addTestStep("User clicks on download image", "Download is not Entered", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
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
            } else {
                GemTestReporter.addTestStep("User clicks on forms button", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("Verify the heading on the landing page")
    public void verifyTheHeadingOnTheLandingPage() {
        try {
            if (DriverAction.isExist(FormsLocator.myFormsHeading)) {
                GemTestReporter.addTestStep("User clicks on search field", "Click is Successful", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("User clicks on search field", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }


    @When("User clicks on upload button")
    public void userClicksOnUploadBtn() {
        try {
            DriverAction.waitSec(7);
            DriverAction.click(FormsLocator.uploadBtn);
            DriverAction.setImplicitTimeOut(7);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on upload button", "Upload is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

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
        } catch (Exception e) {
            GemTestReporter.addTestStep("User uploads the document", "Upload is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User clicks on save button")
    public void userClicksOnSaveBtn() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.saveBtn, 6);
            DriverAction.click(FormsLocator.saveBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on save button", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

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
        } catch (Exception e) {
            GemTestReporter.addTestStep("User uploads invalid document", "Upload is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("Verify the warning {string}")
    public void verifyThe(String warningMsg) {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.warningMsg, 5);

        } catch (Exception e) {
            GemTestReporter.addTestStep("User verifies the warning message", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("User clicks on ok button")
    public void userClicksOnOkbtn() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.okBtn, 4);
            DriverAction.click(FormsLocator.okBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on ok button", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User enters valid value in my forms search field as {string}")
    public void userEntersValidValueInMyFormsSearchFieldAs(String Loyalty) {
        try {
            DriverAction.typeText(FormsLocator.searchBtn, Loyalty + Keys.ENTER);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User enter text in search field", "Text is not Entered", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User enters invalid value in My forms search field as {string}")
    public void userEntersInvalidValueInMyFormsSearchFieldAs(String QA) {
        try {
            DriverAction.typeText(FormsLocator.searchBtn, QA + Keys.ENTER);
            DriverAction.setImplicitTimeOut(6);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User enter text in search field", "Text is not Entered", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }


    @When("User clicks on active form")
    public void userClicksOnActiveForm() {
        try {
            DriverAction.waitUntilElementAppear(FormsLocator.activeForm, 5);
            DriverAction.click(FormsLocator.activeForm);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User  clicks on active form", "Click is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }

    @Then("User hovers and clicks on deactivate button")
    public void userHoversAndClicksOnDeactivateBtn() {
        try {
            DriverAction.waitSec(7);
            DriverAction.click(FormsLocator.deactivateBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User  clicks on deactivate button", "Click is unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("User clicks on yes button")
    public void userClicksOnYesBtn() {
        try {
            if (DriverAction.isExist(FormsLocator.yesBtn)) {
                DriverAction.click(FormsLocator.yesBtn);
            } else {
                GemTestReporter.addTestStep("User Clicks on Yes Button", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }

    }

    @And("User hovers and clicks on download button")
    public void userHoversAndClicksOnDownloadBtn() {
        try {
            DriverAction.waitSec(7);
            DriverAction.click(FormsLocator.downloadBtn);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User Clicks on Download Button", "Click is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @When("User validates the error message as {string}")
    public void userValidatesTheErrorMessageAs(String element) {
        DriverAction.waitUntilElementAppear(FormsLocator.errorMsg, 7);
        try {
            DriverAction.click(FormsLocator.errorMsg);
        } catch (Exception e) {
            GemTestReporter.addTestStep("User validates the error message", "Validation is Unsuccessful", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }


}
