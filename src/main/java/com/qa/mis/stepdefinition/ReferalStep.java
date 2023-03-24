package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.an.E;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.qa.mis.locators.DashboardProfileLocator.*;
import static com.qa.mis.locators.ReferalLocator.*;
import static com.qa.mis.locators.ReferalLocator.invalidUpload;

public class ReferalStep {

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
        try {
            //DriverAction.waitUntilElementAppear(signIn, 2);
            DriverAction.waitSec(5);
            DriverAction.click(signIn);
            DriverAction.waitSec(10);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SignIn error", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^click on close button referal$")
    public void clickOnCloseButton() {

        try {
            DriverAction.waitSec(7);
            DriverAction.click(popUpCloseButton, "close button");
        } catch (Exception e) {
            GemTestReporter.addTestStep("Close button", "User not able to click on Close Button", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @When("^Verify dashboard page is loaded properly$")
    public void dashboardPageIsLoadedProperly() {
        try {

            DriverAction.waitSec(5);
            String dashbrdPage = DriverAction.getElementText(dashboardVisible);
            if (dashbrdPage.equals("dashboardVisible")) {
                GemTestReporter.addTestStep("Dashboard Visible", "Dashboard page is loaded properly", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.waitSec(10);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Dashboard Visible", "Dashboard page is not loaded properly", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^Verify JD window is visible$")
    public void VerifyJdWindow() {
        try {

            DriverAction.waitSec(5);

            String VerfyWndw = DriverAction.getElementText(verifyJdWindow);

            if (VerfyWndw.contains("Referrals")) {
                GemTestReporter.addTestStep("verifyJdWindow", "verify window is visible", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.waitUntilElementAppear(verifyJdWindow, 2);
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("VerifyJdWindow", "Job Description Window is not visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("^User click on referral action$")
    public void userClickOnReferralAction() {
        try {
            DriverAction.waitSec(5);

            DriverAction.waitUntilElementAppear(referralAction, 7);
            DriverAction.click(referralAction, "referral action button");
            DriverAction.waitUntilElementAppear(referralAction, 7);
        } catch (Exception e) {

            GemTestReporter.addTestStep("Referral action button", "Referral Action Button is not clickable", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }


    @And("^Validate referral creation$")
    public void validateReferralCreation() {
        try {
            DriverAction.waitUntilElementAppear(referralAction, 3);

            if (DriverAction.isExist(referralAction))
                GemTestReporter.addTestStep("referral step", "referral exit is present", STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("referral not clicked", "referral table not found", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("referral not clicked", "referral table not found", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("^Click on name under referral$")
    public void clickOnNameUnderReferral() {
        try {

            DriverAction.waitSec(5);
            DriverAction.click(refName, "click on referral name");
            DriverAction.waitSec(3);
            DriverAction.typeText(refName, "Sahra");
        } catch (Exception e) {

            GemTestReporter.addTestStep("Referal name", "User not able to click on referal name ", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("^Referral window is visible$")
    public void referralWindowIsVisible() {
        DriverAction.getElementText(refName);
        String referanceName = DriverAction.getElementText(refName);
        if (referanceName.equals(refName)) {
            GemTestReporter.addTestStep("Referral Name", "Verify Referral Name Under Referal Is Visible", STATUS.PASS, DriverAction.takeSnapShot());
        }

    }

    @When("^User checks referral section$")
    public void userChecksReferralSection() {
        try{
            DriverAction.getElementText(refSection);
            DriverAction.waitSec(5);
            String refferalSection = DriverAction.getElementText(refSection);
            if (refferalSection.contains("Referral"))
                GemTestReporter.addTestStep("verify ref section", "verify ref section found", STATUS.PASS, DriverAction.takeSnapShot());

            else
                GemTestReporter.addTestStep("verify ref section", "verify ref section found", STATUS.FAIL, DriverAction.takeSnapShot());


            String verWindow = DriverAction.getElementText(verifyJdWindow);
            if (verWindow.contains("Referral")) {
                GemTestReporter.addTestStep("verifyJdWindow", "verify window is visible", STATUS.PASS, DriverAction.takeSnapShot());
                DriverAction.waitSec(7);

            }
            else

                GemTestReporter.addTestStep("verifyJdWindow", "verify window is visible", STATUS.FAIL, DriverAction.takeSnapShot());

        }catch(Exception e) {
            GemTestReporter.addTestStep("verifyJdWindow", "verify window is visible", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("^Click on email under referral$")
    public void clickOnEmailUnderReferral() {
        try{
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(refEmail,5);
            DriverAction.click(refEmail, "referral email text");
        }catch(Exception e){
            GemTestReporter.addTestStep("ERROR", "Error Ocuurred In Email Under Referral", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^Enter the email address$")
    public void enterTheEmailAddress() {
        try {
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(refEmail,5);
            DriverAction.typeText(refEmail, "abcde");
        }catch (Exception e){
            GemTestReporter.addTestStep("ERROR", "Error Occurred In Email Address", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^Click on save$")
    public void clickOnSave() {
        try{
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(refSaveButton,3);
            DriverAction.click(refSaveButton, "click on save button under referral");
        }catch (Exception e){
            GemTestReporter.addTestStep("ERROR", "Error Occurred While click On Save Button", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("^Verify the warning message in ref section$")
    public void verifyTheWarningMessageInRefSection() {
        try {

            DriverAction.waitSec(5);
            DriverAction.getElementText(refWarning);
            String referralWarning = DriverAction.getElementText(refWarning);
            if (referralWarning.contains("Warning")) {
                GemTestReporter.addTestStep("refWarning", "You have entered an invalid email address!", STATUS.PASS, DriverAction.takeSnapShot());

            }

        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", " Verification Of Warning message error", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("Click on FAQ")
    public void clickOnFAQ() {
        try {

            DriverAction.waitSec(5);
            DriverAction.click(clickFAQ, "click on FAQ");

        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error Occured In FAQ", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("Verify the pdf is visible")
    public void verifyThePdfIsVisible() {
        try{
            DriverAction.waitSec(5);
            DriverAction.isExist(pdfVisible);
            GemTestReporter.addTestStep("pdf visible", "pdf opens and visible", STATUS.PASS, DriverAction.takeSnapShot());
        }catch (Exception e){
            GemTestReporter.addTestStep("ERROR", "Verification Of The Pdf Is Visible", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("Click on Manual")
    public void clickOnManual() {
        try {


            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                    Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(manualVisible));
            DriverAction.click(manualVisible, "click on manual");
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error While Clicking On Manuel", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify the manual is visible")
    public void verifyTheManualIsVisible() {
        try {
            DriverAction.waitUntilElementAppear(manualVisible, 2);
            DriverAction.isExist(manualVisible);
            GemTestReporter.addTestStep("manual visible", "manual opens and visible", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "verification of manual visible error", STATUS.FAIL);
        }
    }

    @And("User enter details and upload file")
    public void clickOnUploadFile() {
        try{
            DriverAction.waitSec(10);
            String dirPath = System.getProperty("user.dir");
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                    Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(refName));
            DriverAction.click(refName, "Name");
            DriverAction.typeText(refName,"Sarah");
            wait.until(ExpectedConditions.elementToBeClickable(refEmail));
            DriverAction.click(refEmail, "Email");
            DriverAction.typeText(refEmail, "abcde@gmail.com");
            wait.until(ExpectedConditions.elementToBeClickable(enterRefContNo));
            DriverAction.click(enterRefContNo," Contact number");
            DriverAction.typeText(enterRefContNo, "1234567890");
            WebElement relationDropDown = DriverAction.getElement(selectHimOrHer);
            Select dropDown = new Select(relationDropDown);
            dropDown.selectByIndex(2);
            DriverAction.waitSec(5);
            //  wait.until(ExpectedConditions.elementToBeClickable(resumeUpload));
            //DriverAction.waitUntilElementAppear(resumeUpload,7);
            // DriverAction.click(resumeUpload);
            // DriverAction.fileUpload(resumeUpload, dirPath+"\\src\\main\\resources\\testdocument.xlsx");
            //  DriverAction.waitSec(10);
            DriverAction.waitUntilElementAppear(refSaveButton,2);
            DriverAction.click(refSaveButton,"Save button");
            DriverAction.waitSec(3);


        }catch (Exception e){
            GemTestReporter.addTestStep("ERROR", "Error While Entering Details And File Upload", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("^Verify wrong format is uploaded$")
    public void verifyWrongFormatIsUploaded() {
        try {
            DriverAction.waitUntilElementAppear(invalidUpload,5);
            DriverAction.isExist(invalidUpload);
            GemTestReporter.addTestStep("resume upload","Note: Selected file format should be .doc, .docx or .pdf",STATUS.PASS,DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error Occurred While Uploading", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^Enter the correct email$")
    public void enterTheCorrectEmail() {

        try {
            DriverAction.waitUntilElementAppear(enterCorrEmail, 5);
            DriverAction.click(enterCorrEmail, "click on correct email");
            DriverAction.waitUntilElementAppear(enterCorrEmail, 5);
            DriverAction.typeText(enterCorrEmail, "sarah.robert@gmail.com");

        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error While Entering Email", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("Enter the correct contact number")
    public void enterTheCorrectContactNumber() {
        try {
            DriverAction.waitUntilElementAppear(enterRefContNo, 2);
            DriverAction.click(enterRefContNo, "click on ref contact no");
            DriverAction.waitUntilElementAppear(enterRefContNo, 2);
            DriverAction.typeText(enterRefContNo, "1234567890");
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", " Error Occurred While Entering Correct contact Number" , STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }
}