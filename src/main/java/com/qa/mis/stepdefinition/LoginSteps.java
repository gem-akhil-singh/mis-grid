package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.LoginLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {
    @When("User enters {string} as {string}")
    public void userEntersAs(String field, String text) {
        if(field.equals("username")){
            DriverAction.typeText(LoginLocator.username, text);
        }
        if(field.equals("password"))
        {
            byte[] decodingString = Base64.decodeBase64(text);
            String passwordDecoded = new String(decodingString);
            DriverAction.typeText(LoginLocator.password, passwordDecoded);
        }
    }

    @And("Click on Sign In Button")
    public void clickOnSignInButton() {
        try {
            DriverAction.click(LoginLocator.signInButton);
            //DriverAction.waitUntilElementAppear(LoginLocator.closeButton,5);
            GemTestReporter.addTestStep("Sign In", "User click on Sign In button", STATUS.PASS, DriverAction.takeSnapShot());
        }
        catch (Exception exception) {
            GemTestReporter.addTestStep("Sign In", "User not able to click on Sign In button", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify error message {string}")
    public void verifyErrorMessage(String errorMsg) {
        DriverAction.waitSec(2);
        String actualErrorMsg = DriverAction.getElement(LoginLocator.loginErrorMessage).getText();
        try {
            if (actualErrorMsg.equals(errorMsg))
                GemTestReporter.addTestStep("Error message", "Error message: " + actualErrorMsg, STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Error message", "Error message: " + actualErrorMsg, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify all the elements present on Login Page")
    public void verifyAllTheElementsPresentOnLoginPage() {

        WebElement uname = DriverAction.getElement(LoginLocator.username);
        if (uname.isDisplayed())
            GemTestReporter.addTestStep("Username", "Verify Username field visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Username", "User not able to see Username field on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement password = DriverAction.getElement(LoginLocator.password);
        if (password.isDisplayed())
            GemTestReporter.addTestStep("Password", "Verify Password field visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Password", "User not able to see Password field on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement signInButton = DriverAction.getElement(LoginLocator.signInButton);
        if (signInButton.isDisplayed())
            GemTestReporter.addTestStep("Sign in", "Verify Sign in button visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Sign in", "User not able to see Sign in button on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement forgotPasswordButton = DriverAction.getElement(LoginLocator.forgotPasswordButton);
        if (forgotPasswordButton.isDisplayed())
            GemTestReporter.addTestStep("ForgotPassword", "Verify ForgotPassword link visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("ForgotPassword", "User not able to see ForgotPassword link on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement loginWithSSOButton = DriverAction.getElement(LoginLocator.loginWithSSOButton);
        if (loginWithSSOButton.isDisplayed())
            GemTestReporter.addTestStep("Login with SS0", "Verify Login with SS0 button visible on Login Page", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Login with SS0", "User not able to see Login with SS0 button on Login Page", STATUS.FAIL, DriverAction.takeSnapShot());

        WebElement loginMsg = DriverAction.getElement(LoginLocator.loginMsg);
        if (loginMsg.isDisplayed())
            GemTestReporter.addTestStep("LoginPage message", "Verify LoginPage message visible to user", STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("LoginPage message", "User not able to see LoginPage message", STATUS.FAIL, DriverAction.takeSnapShot());

    }
    @Then("Click on Login with SSO button")
    public void clickOnLoginWithSSOButton() {
        try
        {
        DriverAction.click(LoginLocator.loginWithSSOButton);
        GemTestReporter.addTestStep("Login with SSO", "User clicks on Login with SSO Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }
        catch (Exception exception) {
        GemTestReporter.addTestStep("Login with SSO", "User not able to click on Login with SSO", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify User is on {string} Page")
    public void verifyUserIsOnPage(String page) {
        String expectedURL = null;
        switch (page) {
            case "MIS Home":
                expectedURL = "https://mymis.geminisolutions.com/Dashboard/Index";
                new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20))
                        .until(ExpectedConditions.presenceOfElementLocated(LoginLocator.closeButton));
                DriverAction.click(LoginLocator.closeButton);
                break;
            case "Sign IN":
                expectedURL = "https://mymis.geminisolutions.com/";
                break;
            case "Login":
                expectedURL = "https://mymis.geminisolutions.com/Account/Login";
        }
        new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.urlToBe(expectedURL));
        try {
            if (DriverAction.getCurrentURL().equals(expectedURL))
                GemTestReporter.addTestStep("Verify page URL", "URL Matched.\n Expected URL-"
                        + expectedURL + "\nActual URL -" + DriverAction.getCurrentURL(), STATUS.PASS, DriverAction.takeSnapShot());
        }
        catch (Exception exception)
        {
            GemTestReporter.addTestStep("Verify page URL", "URL doesn't Matched.\n Expected URL-"
                    + expectedURL + "\nActual URL -" + DriverAction.getCurrentURL(), STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }
    @Given("User Click on Forget Password link")
    public void userClickOnForgetPasswordLink() {
        try {
            DriverAction.click(LoginLocator.forgotPasswordButton);
            GemTestReporter.addTestStep("Forgot Password", "User clicks on Forgot Password Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        }
        catch (Exception exception) {
        GemTestReporter.addTestStep("Forgot Password", "User not able to click on ForgotPassword Password", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on Reset Password button")
    public void clickOnResetPasswordButton() {
        try
        {
        DriverAction.click(LoginLocator.signInButton);
        GemTestReporter.addTestStep("Reset Password", "User clicks on Reset Password Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        DriverAction.waitSec(2);
        }
        catch (Exception exception) {
        GemTestReporter.addTestStep("Reset Password", "User not able to click on Reset Password", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify the {string} on the screen")
    public void verifyTheOnTheScreen(String expectedMsg) {
        DriverAction.waitSec(2);
        String actualMsg = DriverAction.getElement(LoginLocator.forgotPasswordMessage).getText();
        try {
            if (actualMsg.equals(expectedMsg))
                GemTestReporter.addTestStep("Error message", "Error message: " + actualMsg, STATUS.PASS, DriverAction.takeSnapShot());
        }
        catch (Exception exception) {
            GemTestReporter.addTestStep("Error message", "Error message: " + actualMsg, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify the Success {string}")
    public void verifyTheSuccess(String expectedMsg) {
        String actualMsg = DriverAction.getElement(LoginLocator.successMessage).getText();
        try {
            if (actualMsg.equals(expectedMsg))
                GemTestReporter.addTestStep("Success message", "Success message: " + actualMsg, STATUS.PASS, DriverAction.takeSnapShot());
        }
         catch (Exception exception)
         {
             GemTestReporter.addTestStep("Success message", "Success message: " + actualMsg, STATUS.FAIL, DriverAction.takeSnapShot());
         }
    }

    @Then("Click on Logout button")
    public void clickOnLogoutButton() {
        try {
            DriverAction.click(LoginLocator.profileOption);
            DriverAction.click(LoginLocator.logOutButton);
            GemTestReporter.addTestStep("Logout", "User Logout Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Logout", "User not able to Logout", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

}

