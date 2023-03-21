package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OtherPortalsSteps {
    Logger logger = LoggerFactory.getLogger(OtherPortalsSteps.class);
    String dashboardURL = "https://mymis.geminisolutions.com/Dashboard/Index";

    public void presenceOfElement(By elementXpath, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), time);

            wait.until(ExpectedConditions.presenceOfElementLocated(elementXpath));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Presence of Element ", "Element is not present", STATUS.FAIL);
        }
    }

    @Given("^Login to MIS with Username (.+) and password (.+)")
    public void login_to_mis_with_username_and_password(String user, String pass) {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(OtherportalnTimesheetLocator.lgnusernm)) {
                DriverAction.typeText(OtherportalnTimesheetLocator.lgnusernm, "Enter Username", "Username : " + user, user);
            } else {
                GemTestReporter.addTestStep("Username", "Username field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.isExist(OtherportalnTimesheetLocator.lgnpwd)) {
                byte[] decodingString = Base64.decodeBase64(pass);
                String passwordDecoded = new String(decodingString);
                DriverAction.typeText(OtherportalnTimesheetLocator.lgnpwd, "Enter Password", "Password Entered successfully", passwordDecoded);
            } else {
                GemTestReporter.addTestStep("Password", "Password field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("Password", "Password field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @When("Click on Signin button")
    public void click_on_signin_button() {
        try {
            if (DriverAction.isExist(OtherportalnTimesheetLocator.sgnupbtn)) {
                DriverAction.click(OtherportalnTimesheetLocator.sgnupbtn, "Sign in");
            } else {
                GemTestReporter.addTestStep("SignIn", "SignIn button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("SignIn", "SighIn button is not clicked", STATUS.FAIL);
        }
    }

    @Then("User should be navigated to MIS homepage")
    public void navigateMisHomepage() {
        try {
            DriverAction.waitSec(8);
            String hidden = DriverAction.getAttributeName(NavBarLocator.SkillPopup, "class");
            if (hidden.equalsIgnoreCase("modal fade in")) {
                if (DriverAction.isExist(NavBarLocator.skillClosebtn)) {
                    DriverAction.click(NavBarLocator.skillClosebtn, "Skills close button clicked");
                } else {
                    GemTestReporter.addTestStep("Skill Close button", "Skill Close button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
                }

            }
            presenceOfElement(NavBarLocator.Location, 20);

            if (DriverAction.isExist(NavBarLocator.Location) && DriverAction.isExist(NavBarLocator.Dashboardheading)) {
                GemTestReporter.addTestStep("MIS Homepage", "User is on homepage of MIS", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("MIS Homepage", "User is not on homepage of MIS", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("MIS Homepage", "User is not on homepage of MIS", STATUS.FAIL);
        }
    }

    @Given("Click on Other Portals")
    public void clickOnOtherPortals() {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(OtherportalnTimesheetLocator.otherPortal));

            DriverAction.click(OtherportalnTimesheetLocator.otherPortal);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Other Portals", "Other Portal is not clicked ", STATUS.FAIL);
        }
    }

    @When("^Select portal (.+) from dropdown")
    public void selectPortalPortalFromDropdown(String portal) {
        try {
            int flag = 0;
            List<WebElement> portalList = DriverAction.getElements(OtherportalnTimesheetLocator.otherPortalList);
            DriverAction.waitSec(4);

            for (int i = 0; i < portalList.size(); i++) {
                if (portalList.get(i).getText().equals(portal)) {
                    portalList.get(i).click();
                    DriverAction.waitSec(10);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                GemTestReporter.addTestStep("Portal found", "Portal value is " + portal + ".", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Portal not found", "Portal value is invalid. Kindly check", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            GemTestReporter.addTestStep("Portal not found", "Portal value is invalid. Kindly check", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("^Validate Navigation to portal URL (.+) and (.+)")
    public void validateNavigationToPortalURLUrl(String expectedURL, String port) {
        try {
            // To handle parent window
            WebDriver driver = DriverManager.getWebDriver();
            String MainWindow = driver.getWindowHandle();
            // To handle child window
            Set<String> s1 = driver.getWindowHandles();
            String actualURL = "";
            Iterator<String> i1 = s1.iterator();
            int flag = 0;
            while (i1.hasNext()) {
                i1.next();
                String ChildWindow = i1.next();
                driver.switchTo().window(ChildWindow);
                DriverAction.waitSec(4);
                actualURL = driver.getCurrentUrl();
                if (actualURL.equals(expectedURL)) {
                    flag = 1;
                }
            }

            if (flag == 1) {
                GemTestReporter.addTestStep("Navigater to " + port + " portal", "Successfully Navigated", STATUS.PASS);
            } else
                GemTestReporter.addTestStep("Navigation Failed as expected URL is " + expectedURL + ".", "URL Mismatched as actual URL is " + actualURL + "", STATUS.FAIL);
        } catch (Exception e) {

            GemTestReporter.addTestStep("Navigation Failed as expected URL is " + expectedURL + ".", "URL is not matched", STATUS.FAIL);
        }
    }
}

