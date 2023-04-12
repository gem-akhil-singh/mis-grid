package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.Login_Locators;
import com.qa.mis.locators.SideBar_Locators;
import com.qa.mis.utility.EventsUtils;
import com.qa.mis.utility.OtherPortalsUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

    public class ExtraSteps extends DriverAction {

        /**
         * @author Deeksha Singh
         */


        /**
         * @param credentialType Takes the string to choose between username or password field
         * @author Rahul tagra
         * @since 17th Feb,2023
         */
        @Then("User enters the {string}")
        public void enterCredentials(String credentialType) throws IOException {
            try {
                List<String> browserWindows = new ArrayList<>(getWindowHandles());
                System.out.println("Handles Numbers are : "+browserWindows.size());// Get all browser windows
                switchToWindow(browserWindows.get(0)); // Switch focus to 2nd browser window
                EventsUtils.waitForElement(Login_Locators.credentials(credentialType), 20);
                switch (credentialType) {
                    case "username":
                        typeText(Login_Locators.credentials(credentialType), readProperties(credentialType)); // Enter Username
                        break;
                    case "password":
                        typeText(Login_Locators.credentials(credentialType), "User enters the password", "Password Entered Successfully", readProperties(credentialType));
                        break;
                    default:
                        System.out.println("Please enter a valid Input");
                }
                EventsUtils.waitForElement(Login_Locators.nextBtn, 10);
                click(Login_Locators.nextBtn, "Next Button");
                waitSec(5);
            } catch (Exception e) {
                GemTestReporter.addTestStep("Verify if Login window appears on the screen", "Login window does not appear on the screen", STATUS.FAIL, takeSnapShot());
                throw e;
            }
        }

        /**
         * @author Deeksha Singh
         */
        @And("User logins into the application")
        public void login() {
            try {
                EventsUtils.waitForElement(Login_Locators.nextBtn, 10);
                getElement(Login_Locators.nextBtn).click(); // User clicks on yes Button
                List<String> browserWindows = new ArrayList<>(getWindowHandles());
                switchToWindow(browserWindows.get(0)); // Switch focus back to 1st window
                if (EventsUtils.isElementVisible(Login_Locators.loginError, 5)) {
                    waitSec(5); // Necessary hardcoded Wait to first let the Login failed popup go
                    click(Login_Locators.signInBtn, "Sign in Button");
                    if (EventsUtils.isElementVisible(Login_Locators.loginError, 10)) {
                        click(Login_Locators.signInBtn, "Sign in Button");
                    }
                }
            } catch (Exception e) {
                throw e;
            }
        }

        /**
         * @param property Takes the string to read the properties from Config File
         * @return returns String : Value of the fetched property
         * @author Rahul tagra
         * @since 17th Feb,2023
         */
        public static String readProperties(String property) throws IOException { // Function to read Data from Properties File
            FileReader read = new FileReader("src/main/resources/config.properties");
            Properties credential = new Properties();
            credential.load(read);
            return credential.getProperty(property);
        }

        /**
         * @author Deeksha Singh
         */
        @Then("Verify user is logged into the application or not")
        public void verifyLogin() {
            try {
                String expectedUrl = "https://gembook.geminisolutions.com/#/dashboard";
                EventsUtils.waitForElement(Login_Locators.Image("Logo"), 20);
                if (getCurrentURL().contains(expectedUrl) && isExist(Login_Locators.Image("Logo")) && isExist(Login_Locators.logoHeader) && isExist(Login_Locators.Image("Profile"))) {
                    GemTestReporter.addTestStep("Verify if User is logged into the application", "User logins into the Gembook application", STATUS.PASS, takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Verify if User is logged into the application", "User is unable to login into the Gembook application", STATUS.FAIL, takeSnapShot());
                }
            } catch (Exception e) {
                GemTestReporter.addTestStep("Verify if User is logged into the application", "User is unable to login into the Gembook application", STATUS.FAIL, takeSnapShot());
                throw e;
            }
        }

        /**
         * // Function to encrypt password, by assigning password value to originalPassword
         *
         * @author Siva Puja Pasupulati
         * @since 20th February 2023
         */

        public void encryptString() {
            String originalPassword = ""; //Replace empty string with your password value
            byte[] encodedString = Base64.encodeBase64(originalPassword.getBytes());
            System.out.println(new String(encodedString)); //Get your encrypted password value

        }

        /**
         * -- Function to decrypt encrypted password value --
         *
         * @param password contains the encrypted value of originalPassword
         * @return returns String : Decrypted value of encrypted password
         * @author Siva Puja Pasupulati
         * @since 20th February 2023
         */

        public static String decryptString(String password) {
            if (password.length() != 0) {
                byte[] decodedPassword = Base64.decodeBase64(password); //enter your encrypted password value
                return (new String(decodedPassword));
            } else {
                GemTestReporter.addTestStep("Verify if encrypted password value is entered", "Encrypted password value is not entered- " + password, STATUS.ERR);
                return password;
            }
        }


        /**
         * @author Karan Singh Thakur
         */
        public void clickElementWithJS(By locator) {
            try {
                click(locator);
            } catch (NullPointerException e) {
                if (isExist(locator)) {
                    JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getWebDriver();
                    executor.executeScript("arguments[0].click();", getElement(locator));
                    GemTestReporter.addTestStep("Verify click on element is performed", "Click performed successfully", STATUS.PASS, takeSnapShot());
                } else
                    GemTestReporter.addTestStep("Verify click on element is performed", "Click is not performed", STATUS.FAIL, takeSnapShot());
            }
        }

        /**
         * @author Karan Singh Thakur
         */
        public static boolean isElementClickable(By locator, int duration) {
            try {
                WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(duration));
                WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
                GemTestReporter.addTestStep("Verify element is clickable", "Validation passed. Element is clickable", STATUS.PASS, takeSnapShot());
                return true;
            } catch (Exception e) {
                GemTestReporter.addTestStep("Verify element is clickable", "Validation failed.", STATUS.FAIL, takeSnapShot());
                return false;
            }
        }

        /**
         * @author Kartikay
         */
        @When("User navigates to tab {string}")
        public void navigateToScreen(String tabName) {
            if (isExist(SideBar_Locators.navigationTab(tabName))) {
                click(SideBar_Locators.navigationTab(tabName));
                GemTestReporter.addTestStep("Validate click on " + tabName + " is performed", "Clicked performed successfully", STATUS.PASS, takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Validate " + tabName + " is visible", tabName + " is not visible on UI", STATUS.FAIL, takeSnapShot());
            }
        }

        /**
         * -- Function to fetch xpath of credentialType from credentials function and to enter GitHubUserName
         * fetched from readProperties file and GitHubPassword from decryptString function. --
         *
         * @param credentialType Takes the string to choose between GitHubUsername or GitHubPassword
         * @author Siva Puja Pasupulati
         * @since 17th February 2023
         */

        @Then("User enters GitHub {string}")
        public void userEntersGitHub(String credentialType) throws IOException {
            if (credentialType.contains("GitHubUserName")) {
                click(Login_Locators.credentials(credentialType));
                typeText(Login_Locators.credentials(credentialType), readProperties(credentialType)); //enter GitHub username
            }
            if (credentialType.contains("GitHubPassword")) {
                click(Login_Locators.credentials(credentialType));
                String password = decryptString("TGFrc2h5cHV1KjY="); // edit it with your encrypted password value
                typeText(Login_Locators.credentials(credentialType), "User enters the password", "Password Entered Successfully", password);
            }
        }

        @When("User Navigates to {string}")
        public void userNavigatesTo(String arg0) {
           // DriverManager.getWebDriver().navigate().to(arg0);
            DriverAction.waitSec(Long.parseLong("100"));
            DriverAction.launchUrl(arg0);
        }

        @Given("Check if Other Portals is present in side bar")
        public void isOtherPortalsPresent() {
            OtherPortalsUtils.isElementDisplayed("Verify presence of sidebar", "Sidebar is present", "Sidebar is not present", SideBar_Locators.sideBarIcon);
            OtherPortalsUtils.isElementDisplayed("Verify presence of Other Portals", "Other Portals is present in side bar", "Other Portals is not present in side bar", SideBar_Locators.otherPortals);
        }

        //---------Verify if all elements in OtherPortals are present-------
        @Then("Check if all sub items are present")
        public void checkIfAllSubItemsArePresent() {
            waitSec(3);
            String subItems = "";
            try {
                subItems = OtherPortalsUtils.getsubItemsList();//get list from config.properties
            } catch (Exception e) {
                GemTestReporter.addTestStep("Fetch list of items visible on screen", "Unable to fetch list", STATUS.FAIL, takeSnapShot());
            }
            String subItemsUI = OtherPortalsUtils.getsubItemsListUI();//get list from UI

            if (subItemsUI.equals(subItems)) { // check if elements in both array are equal
                GemTestReporter.addTestStep("Check for the elements of Other Portals", "All elements are present. List of elements present on ui contains " + subItems + " items.", STATUS.PASS, takeSnapShot());
            } else
                GemTestReporter.addTestStep("Check for the elements of Other Portals", "All elements are not present", STATUS.FAIL, takeSnapShot());
        }

        @Then("Check if sub menu items are hidden")
        public void checkIfSubMenuItemsAreGone() {
            OtherPortalsUtils.checkAllItems();//check for the presence of each sub menu item of Other Portals
        }

        //---------- click on given menu Item--------
        @Then("^User clicks on the \"([^\"]*)\" menu item$")
        public void userClicksOnTheMenuItem(String subItem) {
            OtherPortalsUtils.clickIfVisible(SideBar_Locators.navigationTab(subItem), "Click on " + subItem);
        }

        //----------Verify the position of arrow icon beside the OtherPortals----------
        @Then("^Verify the position of other Portals icon is \"([^\"]*)\"$")
        public void verifyThePositionOfOtherPortalsIconIs(String posOfIcon) {
            OtherPortalsUtils.verifyIconPosition(posOfIcon);//verify if arrow icon is pointing down or right
        }

        @Then("^Verify if user is navigated to \"([^\"]*)\" having \"([^\"]*)\" with \"([^\"]*)\"$")
        public void verifyIfUserIsNavigatedToWith(String page, String url, String title) {
            OtherPortalsUtils.verifyURL(url); // verify the url of navigated page
            OtherPortalsUtils.verifyTitle(page, title); //verify title of navigated page
            OtherPortalsUtils.verifyScreenItems(page);//verify items like header logged in credential
        }

        //-----------Verify the icon of given OtherPortalsItem-------
        @Then("^Check if \"([^\"]*)\" icon is present$")
        public void checkIfIconIsPresent(String sidebarItem) {
            if (OtherPortalsUtils.isElementVisible(SideBar_Locators.getIcon(sidebarItem))) {
                GemTestReporter.addTestStep("Verify the presence of " + sidebarItem + " icon", sidebarItem + " icon is present", STATUS.PASS, takeSnapShot());
            } else
                GemTestReporter.addTestStep("Verify the presence of " + sidebarItem + " icon", sidebarItem + " icon is not present", STATUS.FAIL, takeSnapShot());
        }

        //----------Hover over the given element in OtherPortals-------
        @Then("^Hover over the \"([^\"]*)\" in side bar$")
        public void hoverOverTheInSideBar(String subMenuItem) {
            if (OtherPortalsUtils.isElementVisible(SideBar_Locators.navigationTab(subMenuItem))) {
                hoverOver(SideBar_Locators.navigationTab(subMenuItem));
                GemTestReporter.addTestStep("Hover over the " + subMenuItem + " item", "Hover successfully", STATUS.PASS, takeSnapShot());
            } else
                GemTestReporter.addTestStep("Hover over the " + subMenuItem + " item", "Hover unsuccessful", STATUS.FAIL, takeSnapShot());
        }

        //----------Verify the url displayed at the bottom of the screen ----------
        @Then("^Verify the URL of \"([^\"]*)\" at the bottom of the screen \"([^\"]*)\"$")
        public void verifyTheURLOfAtTheBottomOfTheScreen(String subMenuItem, String urlOfItem) {
            String urlUI = getAttributeName(SideBar_Locators.navigationTabAnchor(subMenuItem), "href");
            if (urlUI.equalsIgnoreCase(urlOfItem)) {
                GemTestReporter.addTestStep("Verify the url displayed at the bottom of screen", "URL matched. Expected url: " + urlOfItem, STATUS.PASS, takeSnapShot());
            } else
                GemTestReporter.addTestStep("Verify the url displayed at the bottom of scree", "Url not match. Expected url :" + urlOfItem + " and observed:" + urlUI, STATUS.FAIL, takeSnapShot());
        }



        @Then("Verify Google is loaded")
        public void verifyGoogleIsLoaded() {

            String title= DriverManager.getWebDriver().getTitle();
            Assert.assertEquals(title,"Google");

            GemTestReporter.addTestStep("Verify Google is loaded","User Check the Title ",STATUS.PASS,takeSnapShot());

        }


        @And("User clicks on signIn Button GemBook")
        public void userClicksOnSignInButtonGemBook() {
            try {
                waitSec(200);
                EventsUtils.waitForElement(Login_Locators.signInBtn, 20);
                if (isElementClickable(Login_Locators.signInBtn, 20)) {
                    click(Login_Locators.signInBtn, "Click on Sign In Button", "Clicked Sign In Button"); // Click on Sign in Button
                }
            } catch (Exception exception) {
                GemTestReporter.addTestStep("Check visibility of Sigin Button", "Sign in button is not present", STATUS.FAIL, takeSnapShot());
                throw exception;
            }
            waitSec(3);
        }
    }



