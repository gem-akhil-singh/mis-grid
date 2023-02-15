package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.OtherportalnTimesheetLocator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OtherPortalsSteps {
    Logger logger = LoggerFactory.getLogger(OtherPortalsSteps.class);
    String dashboardURL = "https://mymis.geminisolutions.com/Dashboard/Index";

    @Given("^Login to MIS with Username (.+) and password (.+)")
    public void login_to_mis_with_username_and_password(String user, String pass) {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(OtherportalnTimesheetLocator.lgnusernm)) {
                DriverAction.typeText(OtherportalnTimesheetLocator.lgnusernm, user, "username");
            } else {
                GemTestReporter.addTestStep("Username", "Username field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.isExist(OtherportalnTimesheetLocator.lgnpwd)) {   
                byte[] decodingString = Base64.decodeBase64(pass);
                String passwordDecoded = new String(decodingString);
                DriverAction.typeText(OtherportalnTimesheetLocator.lgnpwd, passwordDecoded);
            } else {
                GemTestReporter.addTestStep("Password", "Password field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }

        } catch (Exception e) {
            logger.info("An exception occurred!", e);
            GemTestReporter.addTestStep("EXCEPTION ERROR", "Getting exception while entering credentials", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @When("Click on Signin button")
    public void click_on_signin_button() {
        if (DriverAction.isExist(OtherportalnTimesheetLocator.sgnupbtn)) {
            DriverAction.click(OtherportalnTimesheetLocator.sgnupbtn, "sign in");
        } else {
            GemTestReporter.addTestStep("SignIn", "SignIn button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Validate login successful")
    public void validate_login_successful() {
        WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), 20);
        wait.until(ExpectedConditions.presenceOfElementLocated(OtherportalnTimesheetLocator.Location));
        if (DriverAction.isExist(OtherportalnTimesheetLocator.Location) && DriverAction.isExist(OtherportalnTimesheetLocator.Dashboardheading)) {
            GemTestReporter.addTestStep("MIS Homepage", "User is on homepage of MIS", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("MIS Homepage", "User is not on homepage of MIS", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

//-----------------------------------------------------------------------------------------------------

    @Given("Click on Other Portals")
    public void clickOnOtherPortals() {
        DriverAction.click(OtherportalnTimesheetLocator.otherPortal);
    }

    @When("^Select portal (.+) from dropdown")
    public void selectPortalPortalFromDropdown(String portal) {
        int flag = 0;
       //DriverAction.scrollIntoView(By.xpath("//div[@class='jspPane']//child::span[text()='Service Desk']"));
        List<WebElement> portalList = DriverAction.getElements(OtherportalnTimesheetLocator.otherPortalList);
        DriverAction.waitSec(4);

        for (int i = 0; i < portalList.size(); i++) {
//            System.out.println(portalList.get(i).getText());
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

        }

        @Then("^Validate Navigation to portal URL (.+) (.+)")
        public void validateNavigationToPortalURLUrl (String expectedURL, String portal){
            try {
                // To handle parent window
                WebDriver driver = DriverManager.getWebDriver();
                String MainWindow = driver.getWindowHandle();
                // To handle child window
                Set<String> s1 = driver.getWindowHandles();

                Iterator<String> i1 = s1.iterator();
                int flag=0;
                while (i1.hasNext()) {
                    i1.next();
                    String ChildWindow = i1.next();
                    driver.switchTo().window(ChildWindow);
                    DriverAction.waitSec(4);
                    String actualURL = driver.getCurrentUrl();
                    if (actualURL.equals(expectedURL)) {
                        flag = 1;
                    }
                }

                if (flag==1) {
                    GemTestReporter.addTestStep("Navigater to " + portal + " portal", "Successfully Navigated", STATUS.PASS);
                } else
                    GemTestReporter.addTestStep("Navigation Failed", "URL Mismatched", STATUS.FAIL);
            } catch (Exception e) {
                logger.info("An exception occurred!", e);
                GemTestReporter.addTestStep("EXCEPTION ERROR", "Getting Exception ", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        }
    }

