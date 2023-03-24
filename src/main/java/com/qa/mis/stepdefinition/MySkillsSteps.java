package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.mis.locators.MySkillsLocator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MySkillsSteps {


    @Then("Skills are updated with {string}")
    public void verifyTheSkillsAreUpdatedWith(String mySkills) {
        try {
            DriverAction.waitSec(5);
            DriverAction.click(MySkillsLocator.mySkill(mySkills));
            GemTestReporter.addTestStep("Skills are updated with valid data", "Skills are updated", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("Skills are updated with valid data", "Skills not updated", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }

    @Given("User scrolls to skills view")
    public void userScrollsToSkills() {
        try {
            DriverAction.waitSec(7);
            DriverAction.scrollIntoView(MySkillsLocator.skillsUpdated);
            GemTestReporter.addTestStep("User scrolls to skills view area", "Scrolling is successful for skill view area", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User scrolls to skills view area", "Scrolling is unsuccessful for skill view area", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @Then("^User clicks on close button$")
    public void userClicksOnCloseButton() {
        try {
            DriverAction.waitSec(5);
            DriverAction.click(MySkillsLocator.closeBtn);
            GemTestReporter.addTestStep("User clicks on close button", "Click is successful for close button", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on close button", "Click is unsuccessful for close button", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }


    @Given("User clicks on user image button")
    public void userClicksOnUserImgButton() {
        try {
            DriverAction.waitSec(7);
            DriverAction.click(MySkillsLocator.userImg,"User image");
            GemTestReporter.addTestStep("User clicks on user image", "Click is successful user image", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on user image", "Click is unsuccessful user image", STATUS.FAIL,DriverAction.takeSnapShot());
        }
    }

    @And("User clicks on skills button")
    public void userClicksOnSkillsButton() {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.skillsBtn, 3);
            DriverAction.click(MySkillsLocator.skillsBtn);
            GemTestReporter.addTestStep("User clicks on skills button", "Click is successful for skills button", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on skills button", "Click is unsuccessful for skills button", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }

    @When("User clicks on technology dropdown")
    public void userClicksOnTechnologyDropdown() {
        try {
            DriverAction.waitSec(3);
            DriverAction.click(MySkillsLocator.technologyDropDown);
            GemTestReporter.addTestStep("User clicks on technology dropdown", "Click is successful for technology dropdown", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on technology dropdown", "Click is unsuccessful for technology dropdown", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }

    @And("User selects the {string}")
    public void userSelectsThe(String technology) {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.selectTechnology(technology), 6);
            DriverAction.click(MySkillsLocator.selectTechnology(technology));
            GemTestReporter.addTestStep("User selects the technology", "Technology selection is successful", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User selects the technology", "Technology selection is unsuccessful", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }


    @When("User clicks on professional dropdown")
    public void userClicksOnProfessionalDropdown() {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.professionalDropDown, 7);
            DriverAction.click(MySkillsLocator.professionalDropDown);
            GemTestReporter.addTestStep("User clicks on professional dropdown", "Click is successful for professional dropdown", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on professional dropdown", "Click is unsuccessful for professional dropdown", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }

    @And("User selects the professional level as {string}")
    public void userSelectsTheProfessionalLevelAs(String professionalLevel) {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.selectProfessional(professionalLevel), 4);
            DriverAction.click(MySkillsLocator.selectProfessional(professionalLevel));
            GemTestReporter.addTestStep("User selects professional level", "Professional level selection is successful", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User selects professional level", "Professional level selection is unsuccessful", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }

    @When("User enters the tech experience {string}")
    public void userEntersTheTechExperience(String techExperience) {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.techExperience, 4);
            DriverAction.typeText(MySkillsLocator.techExperience, techExperience);
            GemTestReporter.addTestStep("User enters the tech experience", "Tech experience is entered", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User enters the tech experience", "Tech experience can not be entered", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }

    @When("User enters the total experience {string}")
    public void userEntersTheTotalExperience(String totalExperience) {
        try {
            DriverAction.waitUntilElementAppear(MySkillsLocator.totalExperience, 4);
            DriverAction.typeText(MySkillsLocator.totalExperience, totalExperience);
            GemTestReporter.addTestStep("User enters the total experience", "Total experience is entered", STATUS.PASS,DriverAction.takeSnapShot());


        } catch (Exception e) {
            GemTestReporter.addTestStep("User enters the total experience", "Total experience can not be entered", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }

    @Then("User clicks on skill ok button")
    public void userClicksOnSkillOkButton() {
        try {
            DriverAction.isExist(MySkillsLocator.skillOkBtn);
            DriverAction.click(MySkillsLocator.skillOkBtn);
            GemTestReporter.addTestStep("User clicks on ok button", "Click is successful for ok button", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on ok button", "Click is unsuccessful for ok button", STATUS.FAIL,DriverAction.takeSnapShot());

        }


    }

    @And("User clicks on skill save button")
    public void userClicksOnSkillSaveButton() {
        try {
            DriverAction.isExist(MySkillsLocator.skillSaveBtn);
            DriverAction.click(MySkillsLocator.skillSaveBtn,"Skill save button");
            GemTestReporter.addTestStep("User clicks on save button", "Click is successful for save button", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on save button", "Click is unsuccessful for save button", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }

    @And("User clicks on skill close button")
    public void userClicksOnSkillCloseButton() {
        try {
            DriverAction.isExist(MySkillsLocator.skillCloseBtn);
            DriverAction.click(MySkillsLocator.skillCloseBtn);
            GemTestReporter.addTestStep("User clicks on skills close button", "Click is successful for skills close button", STATUS.PASS,DriverAction.takeSnapShot());

        } catch (Exception e) {
            GemTestReporter.addTestStep("User clicks on skills close button", "Click is unsuccessful for skills close button", STATUS.FAIL,DriverAction.takeSnapShot());

        }
    }
}

