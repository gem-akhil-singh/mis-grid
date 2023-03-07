package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.visitor.ExceptionTableSensitiveMethodVisitor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import static com.qa.mis.locators.DashboardProfileLocator.*;

public class DashboardProfileSteps {


    @When("^user click on url$")
    public void userClickOnUrl() {
        DriverAction.launchUrl("https://mymis.geminisolutions.com/");
    }

    @When("^Enter username$")
    public void userName() {
        DriverAction.typeText(userName, "divya.madan");
    }

    @When("^Enter Password$")
    public void enterPassword() {
        DriverAction.typeText(password, "Gemini@123");
    }

    @And("^click on SignIn button$")
    public void signIn() {
       try{
        DriverAction.waitSec(5);
        DriverAction.click(signIn);

    }catch (Exception e){
           GemTestReporter.addTestStep("ERROR", "SignIn Button Not Found" + e, STATUS.FAIL,DriverAction.takeSnapShot());
       }
       }

    @When("^user update mobile and extension number$")
    public void clickOnMobile() {
        try{
        DriverAction.waitSec(5);
        DriverAction.click(clickOnChangeDetails, "change details button");

    }catch (Exception e){
            GemTestReporter.addTestStep("ERROR", "Phone number and extension number is invalid" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
        }

    @When("^Enter mobile number and ext number$")
    public void enterMobileNoAndExtNo() {
  try{
        DriverAction.waitSec(5);
        DriverAction.typeText(contactNo, "1234567890");
        DriverAction.waitUntilElementAppear(enterExtNo, 2);
        DriverAction.typeText(enterExtNo, "111");
    }catch (Exception e){
      GemTestReporter.addTestStep("ERROR", "Phone number verification is invalid" + e, STATUS.FAIL,DriverAction.takeSnapShot());
  }
  }

    @When("^click on update$")
    public void clickOnUpdate() {
     try{
        DriverAction.waitSec(5);
        DriverAction.click(clickOnUpdate);

    }catch (Exception e){
         GemTestReporter.addTestStep("ERROR", "Update Verification is Failed" + e, STATUS.FAIL,DriverAction.takeSnapShot());
     }
     }

    @And("^click on update address$")
    public void clickOnUpdateAdd() {

        try {

            DriverAction.waitSec(5);
            DriverAction.click(clickOnUpdateAdd, "update address button");

        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", "Update consist of error" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @When("^enter pinCode$")
    public void clickOnPinCode() {
        try {
            DriverAction.waitUntilElementAppear(enterPincode, 2);
            DriverAction.typeText(enterPincode, "121");

            DriverAction.waitUntilElementAppear(updateButtonAdd, 3);
            DriverAction.click(updateButtonAdd, "update button in add tab");

        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error occured in Pincode" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^verify invalid pincode$")
    public void enterInvalidPincode() {
        try {
            DriverAction.waitUntilElementAppear(invalidPincode, 1);
            DriverAction.getElementText(invalidPincode);
            String wrng1 = DriverAction.getElementText(warning);
            if (wrng1.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "warningText", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error Occured in Pincode Validation" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^click on change password$")
    public void clickOnChangePassword() {


        try {
            DriverAction.waitSec(3);

            DriverAction.click(changePassword, "change password");

        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", "Error Occurred In Change Password " + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }

    }

    @And("^enter old password$")
    public void enterOldPassword() {

        try {
            DriverAction.typeText(enterOldPassword, "12345");
            DriverAction.waitUntilElementAppear(newPassword, 3);
            DriverAction.typeText(newPassword, "Gemini123");
            DriverAction.typeText(confirmPassword, "Gemini123");
            DriverAction.waitUntilElementAppear(updatePassword, 3);
            DriverAction.click(updatePassword, "update password");

        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error Occurred in Old Password" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("^verify the the password is incorrect$")
    public void verifyPasswordIncorrect() {
        try {
            DriverAction.waitSec(5);
            DriverAction.getElementText(warning);
            String warng = DriverAction.getElementText(warning);
            if (warng.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "The old password you entered is not valid. Please try again with correct password.", STATUS.PASS, DriverAction.takeSnapShot());
            }
            DriverAction.click(okButton);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Password Is Incorrect Error Occured" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }


    @When("^enter new password and confirm password$")
    public void enterNewPasswordAndConfirmPassword() {

        try {

            DriverAction.waitSec(5);
            DriverAction.click(clickOnChangeDetails, "change details button");

            DriverAction.waitSec(5); //(using this wait is mandatory step gets failed without this wait)

            DriverAction.click(changePassword, "chg passwrd button");


            DriverAction.waitSec(5);
            DriverAction.typeText(newPassword, "Gemini");

            DriverAction.waitSec(5);
            DriverAction.typeText(confirmPassword, "Gemini123");

            DriverAction.waitSec(5);
            DriverAction.click(updatePassword, "update button");

        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", " Error Occured In New And Confirm Password" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^click on update password$")
    public void clickOnUpdatePassword() {
        try {

            DriverAction.waitSec(5);
            DriverAction.click(updatePassword, "update password button");
        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", "Error Occurred In Update Password" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }

    }

    @Then("^verify password not match$")
    public void verifyPasswordNotMatch() {

        try {
            String pswrdNotmatch = DriverAction.getElementText(passwordNotMatch);
            if (pswrdNotmatch.equals("Password and confirm password does not match")) ;
            GemTestReporter.addTestStep("Password and confirm password does not match", "Password and confirm password does not match", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error Occurred In Password Verification" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("^click on close button$")
    public void clickOnCloseButton() {

        try {
            DriverAction.waitSec(10);

            DriverAction.click(popUpCloseButton, "close button");

        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", " Error In Close Button" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }

    }

    @When("^user click on apply lunch$")
    public void userClickOnApplyLunch() {

        try {

            DriverAction.waitSec(5);
            DriverAction.click(applyLunch, "apply lunch");
        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", "Error In Apply Lunch" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }

    }

    @And("^user click on from date and click on select from date$")
    public void userClickOnFromDate() {
        try {
            DriverAction.waitSec(5);
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(),
                    Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(fromDate));
            DriverAction.waitSec(7);
            DriverAction.click(fromDate,"click on from date");
            DriverAction.waitSec(7);
            DriverAction.click(selectNextArrow,"click on next arrow");
            DriverAction.waitSec(7);

        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", "Error Occurred In Selecting From And Select Date Tab" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
        try {

            DriverAction.waitSec(7);
            DriverAction.click(selectFromDate, "select from date");
        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", "Error In From Date And Select Date" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^user click on till date and select till date$")
    public void userClickOnTillDate() {
        try {

            DriverAction.waitSec(7);
            DriverAction.click(tillDate, "till date");
            DriverAction.click(selectNextArrow,"click on next arrow");
            DriverAction.waitSec(7);
        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", "Error Occured In Till Date" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
        try {
            DriverAction.waitUntilElementAppear(selectTillDate, 3);
            DriverAction.click(selectTillDate, "select till date");
        } catch (Exception e) {

            GemTestReporter.addTestStep("ERROR", "Error Found While Clicking On Till Date Tab" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^click on location container$")
    public void clickOnLocationContainer() {

        try {
            DriverAction.waitSec(5);
            DriverAction.click(locationContainer, "location container");
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", " Error Occurred In Location Tab" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^select the location from the list$")
    public void selectTheLocationFromTheList() {

        try {
            DriverAction.waitSec(5);
            DriverAction.click(selectLocation, "select location");

        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error Occurred In Select Location" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("^click on add lunch button$")
    public void clickOnAddLunchButton() {
        try{
        DriverAction.waitSec(5);
        DriverAction.click(addLunchButton, "add lunch button");
    }catch (Exception e){
            GemTestReporter.addTestStep("ERROR", "Phone Number Verification Is Invalid" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
        }

    @Then("^verify the warning message$")
    public void verifyTheWarningMessage() {

        try {
            DriverAction.getElementText(warning);
            String s = DriverAction.getElementText(warning);
            if (s.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "You have already applied for these dates.", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error In Verify Warning Message " + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }


    @Then("^verify select is blank$")
    public void verifySelectIsBlank() {
        DriverAction.getElementText(locationContainer);
        String s = DriverAction.getElementText(locationContainer);
        if (s.equals("Select")) {
            GemTestReporter.addTestStep("Select is blank", "Error Occurred In Select Blank", STATUS.PASS, DriverAction.takeSnapShot());
        }

    }

    @Then("^verify the old password is blank$")
    public void verifyTheOldPasswordIsBlank() {
        DriverAction.getElementText(enterOldPassword);
        String sb = DriverAction.getElementText(enterOldPassword);
        if (sb.equals("old password")) {
            GemTestReporter.addTestStep("old password is blank", "Error occurred in old password blank", STATUS.PASS, DriverAction.takeSnapShot());
        }

    }

    @When("^enter address in the update address tab$")
    public void enterAddressInTheUpdateAddressTab() {
        DriverAction.waitSec(5);
        try {
            DriverAction.click(clickOnChangeDetails, "change details button");
            DriverAction.click(clickOnUpdateAdd, "update add button");
            DriverAction.waitSec(3);
            DriverAction.typeText(enterPincode, "121");
            DriverAction.click(updateButtonAdd);

        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error Occurres In Address Update" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("^click on pincode$")
    public void clickOnPincode() {
        DriverAction.getElementText(enterPincode);
    }

    @Then("^verify pincode is blank$")
    public void verifyPinCode() {
        String sb = DriverAction.getElementText(enterPincode);
        if (sb.equals("Pincode")) {
            GemTestReporter.addTestStep("Pincode", "Pincode Verification is Failed", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }

    @Then("^verify password is blank$")
    public void verifyPasswordIsBlank() {
        DriverAction.waitSec(5);
        try {
            DriverAction.getElementText(enterOldPassword);
            String op = DriverAction.getElementText(enterOldPassword);
            if (op.equals("Old Password")) {
                GemTestReporter.addTestStep("Old Password", "Old Password", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error Occurred in Password Verification" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @When("click on edit details button")
    public void clickOnEditDetailsButton() {
      try{
        DriverAction.waitSec(5);
        DriverAction.click(clickOnChangeDetails, "click on edit details button");
    }catch (Exception e){
          GemTestReporter.addTestStep("ERROR", "Error Ocurred while Editing Details" + e, STATUS.FAIL,DriverAction.takeSnapShot());
      }
      }

    @When("click on change details button")
    public void clickOnChangeDetailsButton() {
try{
        DriverAction.waitSec(5);
        DriverAction.click(clickOnChangeDetails, "click on edit details button");
    }catch (Exception e){
    GemTestReporter.addTestStep("ERROR", "Error Ocurred While Change Details" + e, STATUS.FAIL,DriverAction.takeSnapShot());
}
    }

    @And("enter mobile number")
    public void enterMobileNumber() {
        try{
        DriverAction.waitSec(5);
        DriverAction.typeText(enterMobileNo, "123456789");
    }catch(Exception e){
            GemTestReporter.addTestStep("ERROR", "Error Ocurred in Enter Phone Number" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
        }

    @And("click on update mobile number")
    public void clickOnUpdateMobileNumber() {

        try {
            DriverAction.waitSec(5);
            DriverAction.click(updateMobileNo, "click on update mobile no. button");
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Error Occurred In Phone Number Update" + e, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }


    @Then("verify invalid phone number")
    public void verifyInvalidPhoneNumber() {

        DriverAction.waitSec(5);
        try {
            DriverAction.getElementText(invalidPhNumber);
            String invalidNo = DriverAction.getElementText(warning);
            if (invalidNo.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "Please put 10 digit mobile number.", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "Verify Invalid Phone Number Error" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("enter extension number")
    public void enterExtensionNumber() {

        DriverAction.waitSec(5);
        DriverAction.waitUntilElementAppear(enterExtNo,3);
        DriverAction.typeText(enterExtNo, "11");
    }

    @Then("verify invalid ext number")
    public void verifyInvalidExtNumber() {

        DriverAction.waitSec(5);
        try {
            DriverAction.getElementText(invalidPhNumber);
            String invalidNo = DriverAction.getElementText(warning);
            if (invalidNo.equals("Warning")) {
                GemTestReporter.addTestStep("warning", "Extension number should only be 3 digits.", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", " Verify Invalid Extension Number Error" + e, STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }
}
