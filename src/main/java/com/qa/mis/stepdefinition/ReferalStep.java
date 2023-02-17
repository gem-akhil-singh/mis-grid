package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;

import static com.qa.mis.locators.DashboardProfileLocator.*;
import static com.qa.mis.locators.ReferalLocator.*;

public class ReferalStep {


    @When("^user click on url referal$")
    public void userClickOnUrl() {
        DriverAction.launchUrl("https://mymis.geminisolutions.com/");
    }

    @When("^Enter username referal$")
    public void userName() {
        DriverAction.typeText(userName, "divya.madan");
    }

    @When("^Enter Password referal$")
    public void enterPassword() {
        DriverAction.typeText(password, "Gemini@123");
    }

    @And("^click on SignIn button referal$")
    public void signIn() {
        DriverAction.waitUntilElementAppear(signIn, 2);
        DriverAction.click(signIn);
        DriverAction.waitSec(10);
    }

    @Then("^click on close button referal$")
    public void clickOnCloseButton() {

        try {
            DriverAction.waitUntilElementAppear(popUpCloseButton, 7);
            DriverAction.click(popUpCloseButton, "close button");
            // DriverAction.click(clickOnChangeDetails,"change details button");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @When("^verify dashboard page is loaded properly$")
    public void dashboardPageIsLoadedProperly() {
        DriverAction.waitUntilElementAppear(dashboardVisible, 5);
        DriverAction.getElementText(dashboardVisible);
        String dashbrdPage = DriverAction.getElementText(dashboardVisible);
        if (dashbrdPage.equals("dashboardVisible")) {
            GemTestReporter.addTestStep("Dashboard Visible", "Dashboard page is loaded properly", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitSec(10);
        }
    }

    @Then("^verify JD window is visible$")
    public void VerifyJdWindow() {
        DriverAction.waitUntilElementAppear(verifyJdWindow, 3);
        DriverAction.getElementText(verifyJdWindow);
        String Vw = DriverAction.getElementText(verifyJdWindow);
        if (Vw.equals(verifyJdWindow)) {
            GemTestReporter.addTestStep("verifyJdWindow", "verify window is visible", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitUntilElementAppear(verifyJdWindow, 2);
        }
    }

    @And("^user click on referral action$")
    public void userClickOnReferralAction() {
        try {
            DriverAction.waitSec(5);
            //  DriverAction.scrollIntoView(referralAction);
            DriverAction.waitUntilElementAppear(referralAction, 7);
            DriverAction.click(referralAction, "referral action button");
            DriverAction.waitUntilElementAppear(referralAction, 7);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @And("^validate referral creation$")
    public void validateReferralCreation() {

        DriverAction.waitUntilElementAppear(referralAction, 3);

        if (DriverAction.isExist(referralAction))
            GemTestReporter.addTestStep("referral step", "referral exit is present", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("referral not clicked", "referral table not found", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("^click on name under referral$")
    public void clickOnNameUnderReferral() {
        try {
            DriverAction.waitUntilElementAppear(refName, 5);
            DriverAction.click(refName,"click on referal name");
            DriverAction.waitSec(3);
            DriverAction.typeText(refName, "Sahra");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("^referral window is visible$")
    public void referralWindowIsVisible() {
        DriverAction.getElementText(refName);
        String referanceName = DriverAction.getElementText(refName);
        if (referanceName.equals(refName)) {
            GemTestReporter.addTestStep("Referral Name", "verify referral name under referal is visible", STATUS.PASS, DriverAction.takeSnapShot());
        }

    }

    @When("^user checks referral section$")
    public void userChecksReferralSection() {
        DriverAction.getElementText(refSection);
        String refferalSection = DriverAction.getElementText(refSection);
        if (refferalSection.equals(refSection)) {
            GemTestReporter.addTestStep("verify ref section", "verify ref section found", STATUS.PASS, DriverAction.takeSnapShot());
        }


        String verWindow = DriverAction.getElementText(verifyJdWindow);
        if (verWindow.equals(verifyJdWindow)) {
            GemTestReporter.addTestStep("verifyJdWindow", "verify window is visible", STATUS.PASS, DriverAction.takeSnapShot());
            DriverAction.waitUntilElementAppear(verifyJdWindow, 2);
        }
    }

    @And("^click on email under referral$")
    public void clickOnEmailUnderReferral() {
        DriverAction.waitUntilElementAppear(refEmail, 3);
        DriverAction.click(refEmail, "referral email text");
    }

    @And("^enter the email address$")
    public void enterTheEmailAddress() {
        DriverAction.waitUntilElementAppear(refEmail, 2);
        DriverAction.typeText(refEmail, "abcde");
    }

    @And("^click on save$")
    public void clickOnSave() {
        DriverAction.waitUntilElementAppear(refSaveButton, 2);
        DriverAction.click(refSaveButton, "click on save button under referral");
    }

    @Then("^verify the warning message in ref section$")
    public void verifyTheWarningMessageInRefSection() {
        DriverAction.waitUntilElementAppear(refWarning, 2);
        DriverAction.getElementText(refWarning);
        String referralWarning = DriverAction.getElementText(refWarning);
        if (referralWarning.equals(refWarning)) {
            GemTestReporter.addTestStep("refWarning", "You have entered an invalid email address!", STATUS.PASS, DriverAction.takeSnapShot());

        }

    }

    @And("click on FAQ")
    public void clickOnFAQ() {
        DriverAction.waitUntilElementAppear(clickFAQ, 3);
        DriverAction.click(clickFAQ, "click on FAQ");

    }

    @Then("verify the pdf is visible")
    public void verifyThePdfIsVisible() {
        DriverAction.waitUntilElementAppear(pdfVisible, 10);
        DriverAction.isExist(pdfVisible);
        GemTestReporter.addTestStep("pdf visible", "pdf opens and visible", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @And("click on Manual")
    public void clickOnManual() {
        DriverAction.waitUntilElementAppear(manualVisible, 2);
        DriverAction.click(manualVisible, "click on manual");
    }

    @Then("verify the manual is visible")
    public void verifyTheManualIsVisible() {
        DriverAction.waitUntilElementAppear(manualVisible, 2);
        DriverAction.isExist(manualVisible);
        GemTestReporter.addTestStep("manual visible", "manual opens and visible", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @And("click on upload file")
    public void clickOnUploadFile() {
        DriverAction.waitUntilElementAppear(resumeUpload, 2);
        DriverAction.fileUpload(resumeUpload, "C:\\Users\\divya.madan");
    }

    @Then("^verify wrong format is uploaded$")
    public void verifyWrongFormatIsUploaded() {
        DriverAction.waitUntilElementAppear(resumeWarning, 2);
        DriverAction.isExist(resumeWarning);
        GemTestReporter.addTestStep("resume warning", "wrong format uploaded", STATUS.PASS, DriverAction.takeSnapShot());
    }

    @And("^enter the correct email$")
    public void enterTheCorrectEmail() {
       // DriverAction.waitSec(5);
        DriverAction.waitUntilElementAppear(enterCorrEmail,5);
        DriverAction.click(enterCorrEmail,"click on correct email");
        DriverAction.waitUntilElementAppear(enterCorrEmail,5);
        DriverAction.typeText(enterCorrEmail, "sarah.robert@gmail.com");

    }

    @And("enter the correct contact number")
    public void enterTheCorrectContactNumber() {
        DriverAction.waitUntilElementAppear(enterRefContNo,2);
        DriverAction.click(enterRefContNo,"click on ref contct no");
        DriverAction.waitUntilElementAppear(enterRefContNo,2);
        DriverAction.typeText(enterRefContNo,"1234567890");
    }


}





