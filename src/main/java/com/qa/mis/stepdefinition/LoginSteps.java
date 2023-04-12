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
        try {
            if (field.equals("username")) {
                DriverAction.typeText(LoginLocator.username,"Username entered","Username: "+text ,text);
            }
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Username", "User not able to enter username", STATUS.FAIL, DriverAction.takeSnapShot());
        }
        try {
            if (field.equals("password")) {
                byte[] decodingString = Base64.decodeBase64(text);
                String passwordDecoded = new String(decodingString);
                DriverAction.typeText(LoginLocator.password,"User enters the password","Password Entered Successfully", passwordDecoded);
            }
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Password", "User not able to enter password", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Click on Sign In Button")
    public void clickOnSignInButton() {
        try {
            DriverAction.waitSec(5);
            DriverAction.click(LoginLocator.signInButton,"SignIn Button");

        } catch (Exception exception) {
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
        try {
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
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Verify elements", "User not able to verify elements before Login", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on Login with SSO button")
    public void clickOnLoginWithSSOButton() {
        try {
            DriverAction.click(LoginLocator.loginWithSSOButton, "Login With SSo Button");
            GemTestReporter.addTestStep("Login with SSO", "User clicks on Login with SSO Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Login with SSO", "User not able to click on Login with SSO", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify User is on {string} Page")
    public void verifyUserIsOnPage(String page) {
        String expectedURL = null;
        switch (page) {
            case "MIS Home":
                expectedURL = "https://mymis.geminisolutions.com/Dashboard/Index";
                WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(LoginLocator.closeButton));
                DriverAction.click(LoginLocator.closeButton, "Close Button");
                break;
            case "Sign IN":
                expectedURL = "https://mymis.geminisolutions.com/";
                break;
            case "Login":
                expectedURL = "https://mymis.geminisolutions.com/Account/Login";
        }

        try {
            new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20))
                    .until(ExpectedConditions.urlToBe(expectedURL));
            if (DriverAction.getCurrentURL().equals(expectedURL))
                GemTestReporter.addTestStep("Verify page URL", "URL Matched.\n Expected URL-"
                        + expectedURL + "\nActual URL -" + DriverAction.getCurrentURL(), STATUS.PASS, DriverAction.takeSnapShot());
            else {
                GemTestReporter.addTestStep("Verify page URL", "URL doesn't Matched.\n Expected URL-"
                        + expectedURL + "\nActual URL -" + DriverAction.getCurrentURL(), STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Verify page URL", "URL doesn't Matched."
                    , STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Given("User Click on Forget Password link")
    public void userClickOnForgetPasswordLink() {
        try {
            DriverAction.waitSec(5);
            DriverAction.click(LoginLocator.forgotPasswordButton,"Forgot Password Button ");
            GemTestReporter.addTestStep("Forgot Password", "User clicks on Forgot Password Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Forgot Password", "User not able to click on ForgotPassword Password", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on Reset Password button")
    public void clickOnResetPasswordButton() {
        try {
            DriverAction.click(LoginLocator.signInButton,"SignIn Button");
            GemTestReporter.addTestStep("Reset Password", "User clicks on Reset Password Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
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
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Error message", "Error message: " + actualMsg, STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Verify the Success {string}")
    public void verifyTheSuccess(String expectedMsg) {
        DriverAction.waitSec(5);
        String actualMsg = DriverAction.getElement(LoginLocator.successMessage).getText();
        try {
            if (actualMsg.equals(expectedMsg))
                GemTestReporter.addTestStep("Success message", "Success message: " + actualMsg, STATUS.PASS, DriverAction.takeSnapShot());
            else
                GemTestReporter.addTestStep("Success message", "Actual message is not match to expected message ", STATUS.FAIL, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Success message","Actual message is not match to expected message ", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on Logout button")
    public void clickOnLogoutButton() {
        try {
            DriverAction.click(LoginLocator.profileOption,"Profile Option");
            DriverAction.click(LoginLocator.logOutButton,"Logout Button");
            GemTestReporter.addTestStep("Logout", "User Logout Successfully", STATUS.PASS, DriverAction.takeSnapShot());
        } catch (Exception exception) {
            GemTestReporter.addTestStep("Logout", "User not able to Logout", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

}

