package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.AccountsPortalLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

public class AccountsPortalSteps {
    public void checkElement(WebElement element) {
        try {
            //It's Mandatory
            DriverAction.waitSec(5);
            if (element.isDisplayed()) {
                GemTestReporter.addTestStep("element visibility", element.getText() + " is present", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("element visibility", element.getText() + " is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("Click {string} sub-tab inside {string} tab")
    public void clickSubTabInsideTab(String subtab, String tab) {
        try {
            DriverAction.waitSec(5);
            DriverAction.click(AccountsPortalLocator.sideTab(tab));
            DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            if (DriverAction.isExist(AccountsPortalLocator.sideTab(subtab))) {
                DriverAction.click(AccountsPortalLocator.sideTab(subtab), subtab);
            } else {
                GemTestReporter.addTestStep("Click on SubTab", "Subtab is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("Verify new tab is open {string}")
    public void verifyNewTabIsOpen(String title) {
        try {
            DriverAction.waitSec(5);
            String parentWindow = DriverAction.getWindowHandle();
            Set<String> S = DriverAction.getWindowHandles();
            Iterator<String> I1 = S.iterator();
            while (I1.hasNext()) {
                String child_window = I1.next();
                if (!parentWindow.equals(child_window)) {
                    DriverAction.switchToWindow(child_window);
                    String Title = DriverAction.getTitle(child_window);
                    if (Title.equalsIgnoreCase(title)) {
                        GemTestReporter.addTestStep("New Tab ", "Right tab is open", STATUS.PASS, DriverAction.takeSnapShot());

                    } else {
                        GemTestReporter.addTestStep("New Tab ", "Wrong tab is open", STATUS.FAIL, DriverAction.takeSnapShot());

                    }
                }
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }

    }

    @Then("Verify greytHR logo is present on the current page")
    public void verifyGreytHRLogoIsPresentOnTheCurrentPage() {
        //It's Mandatory
        try {
            DriverAction.waitSec(5);

            WebElement greytHRLogo = DriverAction.getElement(AccountsPortalLocator.greytHRLogo);
            checkElement(greytHRLogo);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("Verify Gemini logo is present on the current page")
    public void verifyGeminiLogoIsPresentOnTheCurrentPage() {
        try {
            WebElement GeminiLogo = DriverAction.getElement(AccountsPortalLocator.greytHRLogo);
            checkElement(GeminiLogo);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @Then("Verify {string} field is present on the current page")
    public void verifyFieldIsPresentOnTheCurrentPage(String field) {
        try {
            WebElement textField = DriverAction.getElement(AccountsPortalLocator.textField(field));
            checkElement(textField);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("Verify Hello there! text is present on the current page")
    public void verifyHelloThereTextIsPresentOnTheCurrentPage() {
        try {
            WebElement helloText = DriverAction.getElement(AccountsPortalLocator.header);
            checkElement(helloText);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("Verify login button is present on current page")
    public void verifyLoginButton() {
        try {
            WebElement loginButton = DriverAction.getElement(AccountsPortalLocator.loginButton);
            checkElement(loginButton);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }

    @And("Verify forget password link is present on current page")
    public void verifyForgetPasswordLink() {
        try {
            WebElement forgetPassword = DriverAction.getElement(AccountsPortalLocator.forgetpasswordLink);
            checkElement(forgetPassword);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }


    @Then("Click on login button without entering username and password")
    public void clickOnLoginButtonWithoutEnteringUsernameAndPassword() {
        try {
            verifyLoginButton();
            DriverAction.waitSec(5);
//        DriverAction.click(AccountsPortalLocator.loginButton);
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
            js.executeScript("arguments[0].click()", AccountsPortalLocator.loginButton);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }

    }

    @And("Verify {string} text is present on the current page")
    public void verifyTextIsPresentOnTheCurrentPage(String message) {
        try {
            WebElement messageText = DriverAction.getElement(AccountsPortalLocator.message(message));
            checkElement(messageText);
        } catch (Exception e) {
            GemTestReporter.addTestStep("ERROR", "SOME ERROR OCCURRED" + e, STATUS.FAIL);
        }
    }


}