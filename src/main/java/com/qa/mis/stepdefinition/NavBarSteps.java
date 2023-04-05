package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.DashboardLeaveBalanceLocator;
import com.qa.mis.locators.NavBarLocator;
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

import java.util.ArrayList;
import java.util.List;

public class NavBarSteps {

    static int cardnumber = 0;

    public void presenceOfElement(By elementXpath, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), time);

            wait.until(ExpectedConditions.presenceOfElementLocated(elementXpath));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Presence of Element ", "Element is not present", STATUS.FAIL);
        }
    }


    @When("Click on submit button")
    public void submitButton() {
        try {
            if (DriverAction.isExist(NavBarLocator.Signbutton)) {
                DriverAction.click(NavBarLocator.Signbutton, "sign in");
            } else {
                GemTestReporter.addTestStep("Click on SignIn Submit button", "SignIn button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Click on SignIn Submit button", "SignIn button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @Then("Verify a toggle button is present on Dashboard and clickable")
    public void toggleClickability() {
        try {
            String sidebarclass = "";

            DriverAction.waitSec(5);
            WebElement toggle = DriverAction.getElement(NavBarLocator.Togglebtn);
            WebElement menu = DriverAction.getElement(NavBarLocator.Sidebar);
            sidebarclass = menu.getAttribute("class");
            if (toggle.isDisplayed()) {

                if (sidebarclass.equalsIgnoreCase("side-menu jspScrollable") || sidebarclass.equalsIgnoreCase("side-menu")) {
                    DriverAction.click(toggle, "toggle");
                    DriverAction.waitSec(5);
                    sidebarclass = menu.getAttribute("class");

                    if (sidebarclass.equalsIgnoreCase("side-menu") || sidebarclass.equalsIgnoreCase("side-menu jspScrollable")) {
                        GemTestReporter.addTestStep("Toggle button clickability", "Toggle button is clickable", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("Toggle button clickability", "Toggle button is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                }

            } else {
                GemTestReporter.addTestStep("Toggle button", "Toggle button is not present", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Verify Toggle button", "Toggle button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on Profile menu")
    public void clickProfileMenu() {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(NavBarLocator.Profilemenu)) {
                DriverAction.click(NavBarLocator.Profilemenu, "ProfileMenu");
            } else {
                GemTestReporter.addTestStep("Click on Profilemenu", "Profilemenu button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            DriverAction.waitUntilElementAppear(NavBarLocator.UpdateProfileOption, 5);
            if (DriverAction.isExist(NavBarLocator.UpdateProfileOption)) {
                DriverAction.click(NavBarLocator.UpdateProfileOption, "UpdateProfile");
            } else {
                GemTestReporter.addTestStep("Click on Update Profile button ", "Update Profile button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            DriverAction.waitUntilElementAppear(NavBarLocator.UpdateProfileSection, 10);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Profile Menu ", "Profile is not updated ", STATUS.FAIL);
        }

    }

    @And("Click on Save button")
    public void clickSave() {
        try {
            if (DriverAction.isExist(NavBarLocator.skillSavebtn)) {
                DriverAction.click(NavBarLocator.skillSavebtn, "Save button");
            } else {
                GemTestReporter.addTestStep("Click on Skill Save button", "Save button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Click on Skill Save button", "Save button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("^Verify all the (.*) and (.*) are present")
    public void verifyFields(String Fields, String Buttons) {
        String[] Sections = Fields.split(";");
        String[] Tabs;
        int flag = 0;
        String Field = "";
        try {
            ArrayList<String> Tabname = new ArrayList<String>();
            for (int i = 0; i < Sections.length; i++) {
                Tabs = Sections[i].split(":");
                String tabname = Tabs[0];
                String[] fields = Tabs[1].split(",");

                if (!tabname.equals("Update Profile")) {
                    DriverAction.click(NavBarLocator.navigation_tabs(tabname), tabname);
                }
                DriverAction.waitSec(5);

                for (int j = 0; j < fields.length; j++) {

                    Field = fields[j];
                    WebElement field = DriverAction.getElement(NavBarLocator.fields(fields[j]));

                    if (field.isDisplayed()) {
                        flag = 1;
                    } else {
                        flag = 0;

                        break;
                    }
                }
                String[] buttons = Buttons.split(",");
                for (String button : buttons) {
                    Field = button;
                    WebElement btn = DriverAction.getElement(NavBarLocator.buttons(button));

                    if (btn.isDisplayed()) {
                        flag = 1;

                    } else {
                        flag = 0;

                        break;
                    }
                }
                if (flag == 1) {
                    GemTestReporter.addTestStep("Verify all the fields", "All fields are present", STATUS.PASS, DriverAction.takeSnapShot());
                } else {
                    GemTestReporter.addTestStep("Verify all the fields", Field + " Field " + "is not present", STATUS.FAIL, DriverAction.takeSnapShot());
                }

            }

        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify all the fields", Field + " Field " + "is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on Gemini logo")
    public void clickLogo() {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(NavBarLocator.SiteLogo)) {
                DriverAction.click(NavBarLocator.SiteLogo, "SiteLogo");
            } else {
                GemTestReporter.addTestStep("Click on GeminiSite Logo", "Site logo is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Click on GeminiSite Logo", "Site logo is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on Skills menu")
    public void clickSkill() {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(NavBarLocator.Profilemenu)) {
                DriverAction.click(NavBarLocator.Profilemenu, "ProfileMenu");
            } else {
                GemTestReporter.addTestStep(" Click on Profile Menu", "Profile Menu is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitUntilElementAppear(NavBarLocator.SkillsOption, 5);
            if (DriverAction.isExist(NavBarLocator.SkillsOption)) {
                DriverAction.click(NavBarLocator.SkillsOption, "Skills");
            } else {
                GemTestReporter.addTestStep("Click on Skills option", "Skills option is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitUntilElementAppear(NavBarLocator.SkillPopup, 10);
        } catch (Exception e) {
            GemTestReporter.addTestStep("Click on Skills option", "Skills option is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Enter all the details {string},{string},{string},{string},{string}")
    public void enterDetails(String Technology, String ProficiencyLevel, String SkillType, String TechExperience, String TotalWorkExp) {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(NavBarLocator.technologySelect)) {
                DriverAction.click(NavBarLocator.technologySelect, "Techology Select");
            } else {
                GemTestReporter.addTestStep(" Verify Technology Select", "Technology Select is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitUntilElementAppear(NavBarLocator.technologyOption(Technology), 5);
            WebElement option = DriverAction.getElement(NavBarLocator.technologyOption(Technology));
            if (DriverAction.isExist(NavBarLocator.technologyOption(Technology))) {
                DriverAction.click(option, "option");
            } else {
                GemTestReporter.addTestStep("Verify Technology option", Technology + " is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitUntilElementAppear(NavBarLocator.proficiencySelect, 5);
            if (DriverAction.isExist(NavBarLocator.proficiencySelect)) {
                DriverAction.dropDown(NavBarLocator.proficiencySelect, 1);
            } else {
                GemTestReporter.addTestStep("Verify Proficiency Select", "Proficiency Select is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitUntilElementAppear(NavBarLocator.skillSelect, 5);
            if (DriverAction.isExist(NavBarLocator.skillSelect)) {
                DriverAction.dropDown(NavBarLocator.skillSelect, 1);
            } else {
                GemTestReporter.addTestStep("Verify skill Select", "Skill Select is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitUntilElementAppear(NavBarLocator.techExperience, 5);
            if (DriverAction.isExist(NavBarLocator.techExperience)) {
                DriverAction.typeText(NavBarLocator.techExperience,"Tech Experience","Entered Tech Experience as "+TechExperience,TechExperience);
//
            } else {
                GemTestReporter.addTestStep("Verify Tech Experience", "Tech Experience field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            DriverAction.waitUntilElementAppear(NavBarLocator.totalExperience, 5);
            if (DriverAction.isExist(NavBarLocator.totalExperience)) {
                DriverAction.typeText(NavBarLocator.totalExperience,"Total Work Experience","Entered Total Work Experience as "+TotalWorkExp,TotalWorkExp);
                DriverAction.waitSec(2);
            } else {
                GemTestReporter.addTestStep("Verify Total Experience", "Total Experience field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify Fields", "fields are not present " + e, STATUS.FAIL);
        }

    }

    @And("Click on the close button")
    public void clickClose() {
        try {
            if (DriverAction.isExist(NavBarLocator.skillClosebtn)) {
                DriverAction.click(NavBarLocator.skillClosebtn, "Close button");
            } else {
                GemTestReporter.addTestStep("Click on skill Close button", "Skill Close button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            WebElement popup = DriverAction.getElement(NavBarLocator.SkillPopup);
            if (!popup.isDisplayed()) {
                GemTestReporter.addTestStep("Click on Close button", "After click on close button ,Skill popup is closed", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Click on Close button", "After click on close button ,Skill popup is not closed", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Click on Close button", "After click on close button ,Skill popup is not closed", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @And("Verify popup with message {string} and {string}")
    public void verifyMessage(String alertType, String alertMessage) {
        try {
            String expectedAlertType = DriverAction.getElementText(NavBarLocator.heading_alertType);
            String expectedAlertMessage = DriverAction.getElementText(NavBarLocator.text_alertMessage);
            if (expectedAlertType.equals(alertType)) {
                GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type matched.", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type not matched", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (expectedAlertMessage.equals(alertMessage)) {
                GemTestReporter.addTestStep("Verifying Alert Message", "Alert Message matched.", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verifying Alert Message", "Alert Message not matched.", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verifying Alert Type", "Alert Type not matched", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("User click on Change AD Password and Verify new tab should be open")
    public void clickADPassword() {
        try {
            int tabCount = DriverAction.getWindowHandles().size();
            DriverAction.waitSec(5);
            if (DriverAction.isExist(NavBarLocator.changeADPassword)) {
                DriverAction.click(NavBarLocator.changeADPassword, "AD Password");
            } else {
                GemTestReporter.addTestStep("Change ADPassword button", "Change ADPassword button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            DriverAction.waitSec(5);
            int newtabCount = DriverAction.getWindowHandles().size();
            if ((tabCount + 1) == newtabCount) {
                GemTestReporter.addTestStep("Verify new tab should be open after click on AD Password button", "new tab is open", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify new tab should be open after click on AD Password button", "new tab is not open", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify new tab should be open after click on AD Password button", "new tab is not open", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Click on Logout menu")
    public void clickOnLogoutMenu() {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(NavBarLocator.Profilemenu)) {
                DriverAction.click(NavBarLocator.Profilemenu, "AD Password");
            } else {
                GemTestReporter.addTestStep(" Click on Profile Menu", "Profile Menu is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }

            DriverAction.waitUntilElementAppear(NavBarLocator.Logout, 10);
            if (DriverAction.isExist(NavBarLocator.Logout)) {
                DriverAction.click(NavBarLocator.Logout, "LogOut");
            } else {
                GemTestReporter.addTestStep("Click on Logout", "Logout button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Click on Logout", "Logout button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @And("User navigate to login page")
    public void loginPageNavigation() {
        try {
            DriverAction.waitUntilElementAppear(NavBarLocator.loginForm, 10);
            if (DriverAction.isExist(NavBarLocator.loginForm)) {
                GemTestReporter.addTestStep("verify navigation to login page", "login page is open after click on logout", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("verify navigation to login page", "login page is not open after click on logout", STATUS.PASS, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("verify navigation to login page", "login page is not open after click on logout", STATUS.PASS, DriverAction.takeSnapShot());
        }
    }

    @And("Enter experience{string} in TechExperience")
    public void enterExperienceInTechExperience(String TechExperience) {
        try {
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(NavBarLocator.techExperience, 5);
            if (DriverAction.isExist(NavBarLocator.techExperience)) {
                DriverAction.typeText(NavBarLocator.techExperience,"Tech Experience","Entered Tech Experience as "+TechExperience,TechExperience);

            } else {
                GemTestReporter.addTestStep(" Verify Tech Experience", "Tech Experience field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep(" Verify Tech Experience", "Tech Experience field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @And("Verify experience{string} of TechExperience")
    public void verifyExperienceOfTechExperience(String TechExperience) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
            WebElement element = DriverAction.getElement(NavBarLocator.techExperience);
            String experience = js.executeScript("return arguments[0].value;", element).toString();

            if (experience.matches("[0-9]+") || experience.isEmpty()) {
                GemTestReporter.addTestStep("verify Tech Experience field", "Tech Experience is accepting Integer value only", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("verify Tech Experience field", "Tech Experience is accepting all type of value", STATUS.FAIL, DriverAction.takeSnapShot());

            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("verify Tech Experience field", "Tech Experience is accepting all type of value", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @Then("Enter workExperience {string} in workExpField")
    public void enterWorkExperienceInWorkExpField(String TotalWorkExp) {
        try {
            DriverAction.waitUntilElementAppear(NavBarLocator.totalExperience, 5);
            if (DriverAction.isExist(NavBarLocator.totalExperience)) {
                DriverAction.typeText(NavBarLocator.totalExperience,"Total Work Experience","Entered Total Work Experience as "+TotalWorkExp,TotalWorkExp);
                DriverAction.waitSec(2);
            } else {
                GemTestReporter.addTestStep("Enter Total Experience", "Total Experience field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Enter Total Experience", "Total Experience field is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify workExperience {string} of workExpField")
    public void verifyWorkExperienceOfWorkExpField(String TotalExperience) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
            WebElement element = DriverAction.getElement(NavBarLocator.totalExperience);
            String experience = js.executeScript("return arguments[0].value;", element).toString();


            if (experience.matches("[0-9]+") || experience.isEmpty()) {
                GemTestReporter.addTestStep("verify Total Experience field", "Total Experience is accepting Integer value only", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("verify Total Experience field", "Total Experience is accepting all type of value", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("verify Total Experience field", "Total Experience is accepting all type of value", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }


    @Then("Click on Dashboard setting")
    public void clickDashboard() {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(NavBarLocator.Profilemenu)) {
                DriverAction.click(NavBarLocator.Profilemenu, "ProfileMenu");
            } else {
                GemTestReporter.addTestStep("Profile Menu", "Profile Menu is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
            if (DriverAction.isExist(NavBarLocator.Setting)) {
                DriverAction.click(NavBarLocator.Setting, " Dashboard Setting");
                DriverAction.waitSec(2);
            } else {
                GemTestReporter.addTestStep("Dashboard Setting", "Dashboard Setting is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Dashboard Setting", "Dashboard Setting is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }

    @And("Verify Dashboard setting table is visible on the current screen")
    public void verifyDashboardSettingTable() {
        try {
            DriverAction.waitUntilElementAppear(NavBarLocator.DashboardPopup, 5);
            if (DriverAction.isExist(NavBarLocator.DashboardPopup)) {
                GemTestReporter.addTestStep("verify Dashboard Setting Table", "Dashboard table is visible after click on Dashboard Setting", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("verify Dashboard Setting Table", "Dashboard table is not visible after click on Dashboard Setting", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("verify Dashboard Setting Table", "Dashboard table is not visible after click on Dashboard Setting", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }


    @Then("Verify all check boxes are uncheck")
    public void verifyAllCheckBoxesAreUncheck() {
        try {
            DriverAction.waitUntilElementAppear(NavBarLocator.DashboardPopup, 10);
            if (DriverAction.isExist(NavBarLocator.DashboardPopup)) {
                List<WebElement> element = DriverAction.getElements(NavBarLocator.DashboardCheckbox);

                for (WebElement checkbox : element) {
                    if (checkbox.isSelected()) {

                        DriverAction.click(checkbox);
                    }
                }
                GemTestReporter.addTestStep("Verify all check boxes ", "All check boxes are unchecked ", STATUS.PASS, DriverAction.takeSnapShot());

            } else {
                GemTestReporter.addTestStep("Verify all check boxes ", "Dashboard table is not visible after click on Dashboard Setting", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify all check boxes ", "Dashboard table is not visible after click on Dashboard Setting", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Click on Update button")
    public void clickOnUpdateButton() {
        try {
            if (DriverAction.isExist(NavBarLocator.DashboardUpdatebtn)) {
                DriverAction.click(NavBarLocator.DashboardUpdatebtn, "Dashboard Update button");
            } else {
                GemTestReporter.addTestStep("Click on Dashboard Update button", "Dashboard Update button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Click on Dashboard Update button", "Dashboard Update button is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify {string} card is shown on the dashboard")
    public void verifyCardIsShownOnTheDashboard(String isCardPresent) {
        try {
            DriverAction.waitSec(5);
            List<WebElement> CardpanelList;

            switch (isCardPresent) {
                case "no":

                    try {
                        DriverManager.getWebDriver().findElement(NavBarLocator.Cardname);
                        GemTestReporter.addTestStep("Unchecked all the widget ", "Dashboard setting is not updated", STATUS.FAIL, DriverAction.takeSnapShot());
                    } catch (Exception e) {
                        GemTestReporter.addTestStep("Unchecked all the widget ", "Dashboard setting is updated", STATUS.PASS, DriverAction.takeSnapShot());

                    }

                    break;
                case "all":
                    CardpanelList = DriverAction.getElements(NavBarLocator.Cardname);

                    if (CardpanelList.size() == cardnumber - 1) {
                        GemTestReporter.addTestStep("checked all the widget ", "All the cards are reappear", STATUS.PASS, DriverAction.takeSnapShot());
                    } else {
                        GemTestReporter.addTestStep("checked all the widget ", "All the cards are not reappear", STATUS.FAIL, DriverAction.takeSnapShot());
                    }
                    break;
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify card is shown on the dashboard", "Cards are not present on Dashboard", STATUS.FAIL);
        }
    }

    @Then("Verify all check boxes are check")
    public void verifyAllCheckBoxesAreCheck() {
        try {
            DriverAction.waitUntilElementAppear(NavBarLocator.DashboardPopup, 10);
            if (DriverAction.isExist(NavBarLocator.DashboardPopup)) {
                List<WebElement> element = DriverAction.getElements(NavBarLocator.DashboardCheckbox);
                for (WebElement checkbox : element) {
                    if (!checkbox.isSelected()) {
                        DriverAction.click(checkbox);
                        cardnumber++;
                    } else {
                        cardnumber++;

                    }
                }
                GemTestReporter.addTestStep("Verify all check boxes ", "All check boxes are checked ", STATUS.PASS, DriverAction.takeSnapShot());


            } else {
                GemTestReporter.addTestStep("verify Dashboard Setting Table", "Dashboard table is not visible after click on Dashboard Setting", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("verify Dashboard Setting Table", "Dashboard table is not visible after click on Dashboard Setting", STATUS.FAIL, DriverAction.takeSnapShot());
        }

    }


    @Then("Click on EC DC Hierarchy link")
    public void clickOnECDCHierarchyLink() {
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(NavBarLocator.ECDCHierarchyLink)) {
                DriverAction.click(NavBarLocator.ECDCHierarchyLink, "ECDCHierarchy Link");
            } else {
                GemTestReporter.addTestStep("Click on ECDCHierarchy Link", "ECDCHierarchy Link is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Click on ECDCHierarchy Link", "ECDCHierarchy Link is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("Verify EC DC Hierarchy popup should be open")
    public void verifyECDCHierarchyPopupShouldBeOpen() {
        try {
            DriverAction.waitSec(5);

            if (DriverAction.isExist(NavBarLocator.ECDCHierarchyPopup)) {
                GemTestReporter.addTestStep("Verify ECDCHierarchyPopup", "EC DC Hierarchy Popup is present", STATUS.PASS, DriverAction.takeSnapShot());
            } else {
                GemTestReporter.addTestStep("Verify ECDCHierarchyPopup", "EC DC Hierarchy Popup is not present", STATUS.FAIL, DriverAction.takeSnapShot());
            }
        } catch (Exception e) {
            GemTestReporter.addTestStep("Verify ECDCHierarchyPopup", "EC DC Hierarchy Popup is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }
    }

    @And("^Verify tab (.+) with columns (.+)")
    public void verifyECDCColumns(String tab, String columns) {
        try{
        int Flag = 0;
        String Column = "";
        By locator = null;
        String[] tabColumns = columns.split(",");
        if (tab.equals("Delivery Council")) {
            DriverAction.click(NavBarLocator.ECDCHierarchyTab(tab), tab);
        }
        DriverAction.waitSec(5);
        for (int j = 0; j < tabColumns.length; j++) {
            Column = tabColumns[j];
            if (tab.equals("Delivery Council")) {
                locator = NavBarLocator.DCHierarchycolumns(Column);
            } else {
                locator = NavBarLocator.ECHierarchycolumns(Column);
            }
            WebElement TabColumns = DriverAction.getElement(locator);
            if (TabColumns.isDisplayed()) {
                Flag = 1;
            } else {
                Flag = 0;
                break;
            }
        }
        if (Flag == 1) {
            GemTestReporter.addTestStep("verify all the columns of EC CD Hierarchy table", "All columns are present", STATUS.PASS, DriverAction.takeSnapShot());
        } else {
            GemTestReporter.addTestStep("verify all the columns of EC CD Hierarchy table", Column + " Column " + "is not present", STATUS.FAIL, DriverAction.takeSnapShot());
        }}catch (Exception e){
            GemTestReporter.addTestStep("verify all the columns of EC CD Hierarchy table", " Columns are not present", STATUS.FAIL, DriverAction.takeSnapShot());

        }
    }
}

