package com.qa.mis.stepdefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.mis.locators.KnowledgeBaseLocator;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.Random;


public class KnowledgeBaseSteps {

    public void presenceOfElement(By elementXpath, int time) {
        try {
            WebDriverWait wait = new WebDriverWait(DriverManager.getWebDriver(), time);

            wait.until(ExpectedConditions.presenceOfElementLocated(elementXpath));
        } catch (Exception e) {
            GemTestReporter.addTestStep("Presence of Element ", "Element is not present", STATUS.FAIL);
        }
    }
    public int randomNumber(){
        Random random = new Random();
        int num = random.nextInt();
        return num;
    }

    @When("Navigating to view documents page")
    public void navigatingToViewDocumentsPage() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base clicked successfully");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents clicked successfully");
            DriverAction.waitSec(5);
            GemTestReporter.addTestStep("Navigated to View Document", "User is on view Document", STATUS.PASS, DriverAction.takeSnapShot());

        }catch (Exception e){
            GemTestReporter.addTestStep("user clicks on View Documents", "View Document is not clicked successfully", STATUS.FAIL);
        }}
    @Then("Verifying add new document tags icon is present and functional")
    public void addNewDocumentTagsIconIsPresentAndFunctional() {
        try {
            DriverAction.click(KnowledgeBaseLocator.addDocumentTag, "Add document Tag");
            DriverAction.waitSec(3);
            DriverAction.typeText(KnowledgeBaseLocator.inputDocumentTag, "Test"+ randomNumber());
            DriverAction.click(KnowledgeBaseLocator.saveDocumentTag, "Document Tag saved");
            presenceOfElement(KnowledgeBaseLocator.documentTagSuccessfullyAdded,20);
            String successMessage = DriverAction.getElementText(KnowledgeBaseLocator.documentTagSuccessfullyAdded);

            if (!successMessage.equalsIgnoreCase("Document tag Added Sucessfully")) {
                GemTestReporter.addTestStep("User adds Document Tag", "Document Tag not added successfully", STATUS.FAIL);

                Assert.fail();
            }

            DriverAction.click(KnowledgeBaseLocator.okButton, "Ok button");
            GemTestReporter.addTestStep("Adds new Document tag in view Document", "New document tag added", STATUS.PASS, DriverAction.takeSnapShot());


        } catch (Exception e)
        {
            GemTestReporter.addTestStep("User enters the new document tag", "document tag not added successfully ", STATUS.FAIL);

        }
    }

    @When("Navigating to view documents page adding empty document tag")
    public void navigatingToViewDocumentsPageAddingEmptyDocumentTag() throws InterruptedException {
        try {

            DriverAction.click(KnowledgeBaseLocator.knowledgeBase, "Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments, "View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.addDocumentTag, "Add document Tag");
            DriverAction.typeText(KnowledgeBaseLocator.inputDocumentTag, "");
            DriverAction.click(KnowledgeBaseLocator.saveDocumentTag, "Document Tag saved");
            GemTestReporter.addTestStep("Empty Document tag in View Document", "User adds empty document tag", STATUS.PASS, DriverAction.takeSnapShot());

        }catch (Exception e){
            GemTestReporter.addTestStep("Adding empty document tag", "Empty document tag not addedd successfully", STATUS.FAIL);
        }


    }
    @Then("Verifying it throws warning message")
    public void throwsWarningMessage() {
        try {
            presenceOfElement(KnowledgeBaseLocator.documentTagWarningMessage,20);
            String warningMessage = DriverAction.getElementText(KnowledgeBaseLocator.documentTagWarningMessage);
            System.out.println(warningMessage);
            if (!warningMessage.equalsIgnoreCase("Please fill required field")) {
                GemTestReporter.addTestStep("user gets warning message", "User does not gets warning message", STATUS.FAIL);

                Assert.fail();

            }
        }catch (Exception e){
            GemTestReporter.addTestStep("User sees the warning message", "Warning message not displayed successfully", STATUS.FAIL);

        }





    }

    @When("Navigating to my attendance")
    public void navigatingToMyAttendance() {
        try {
            DriverAction.click(KnowledgeBaseLocator.attendanceMonth, "Attendance Month Selection");
        }
        catch(Exception e){
            GemTestReporter.addTestStep("User clicks on attendance", "Clicking on attendance not successful", STATUS.FAIL);
        }
    }
    @Then("Verifying it is selecting {string} and verifying the attendance")
    public void selectingAndVerifyingTheAttendance(String month) throws InterruptedException {
        try{
            DriverAction.click(By.xpath("//li[text()='"+month+"'"+"]"));


        }catch (Exception e){
            GemTestReporter.addTestStep("User verifies the attendance", "attendance not verified successfully", STATUS.FAIL);

        }}

    @Then("Verifying right click functionality is working")
    public void rightClickFunctionalityIsWorking() throws InterruptedException {
        try{
            DriverAction.waitSec(5);
            DriverAction.rightClick(KnowledgeBaseLocator.folder,"Right clicking on folder");
            if(!DriverAction.isExist(KnowledgeBaseLocator.deleteFolder)){
                GemTestReporter.addTestStep("user clicks on Delete folder", "Delete folder not visible", STATUS.FAIL);

                Assert.fail();
            }

        }catch (Exception e){
            GemTestReporter.addTestStep("User right clicks on a folder", "User right clicking on folder not successful ", STATUS.FAIL);
        }}

    @When("Navigating to view documents page and adding an invalid document type")
    public void navigatingToViewDocumentsPageAndAddingAnInvalidDocumentType() throws InterruptedException {
        try{
            System.out.println(System.getProperty("user.dir"));
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);
            DriverAction.rightClick(KnowledgeBaseLocator.folder);
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.addDocument,"Add Document");
            DriverAction.waitSec(5);
            DriverAction.fileUpload(KnowledgeBaseLocator.upload,System.getProperty("user.dir")+"\\src\\main\\resources\\testdocument2.txt");
            DriverAction.waitSec(5);






        }catch (Exception e){
            GemTestReporter.addTestStep("User uploads an invalid document", "Invalid document upload not successful", STATUS.FAIL);
        }}
    @Then("Verifying invalid document type warning should be displayed")
    public void invalidDocumentTypeWarningShouldBeDisplayed() {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.invalidDoc).equalsIgnoreCase("Invalid file selected. supported extensions are .xlsx,.xls,.pdf")){
                GemTestReporter.addTestStep("User gets warning message for invalid document", "User does not get any warning", STATUS.FAIL);

                Assert.fail();
            }


        }catch(Exception e){
            GemTestReporter.addTestStep("User gets a warning message after uploading invalid file", "Not getting a warning message", STATUS.FAIL);
        }}

    @When("Navigating to view documents page and page is refreshed")
    public void navigatingToViewDocumentsPageAndPageIsRefreshed() {

        try{
            DriverAction.waitSec(3);
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.waitSec(3);
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(3);
            DriverAction.click(KnowledgeBaseLocator.refresh,"clicked on refresh button for view document");

        }catch (Exception e){
            GemTestReporter.addTestStep("User refreshes the view document page", "View document page refresh not successful", STATUS.FAIL);
        }}
    @Then("Verifying page is refreshed")
    public void pageIsRefreshed() {
        try{
            if(!DriverAction.isExist(KnowledgeBaseLocator.folder)){
                GemTestReporter.addTestStep("User finds folder after refresh", "User not able to find folder after refresh", STATUS.FAIL);

                Assert.fail();
            }

        }catch (Exception e){
            GemTestReporter.addTestStep("User refreshed the page", "view document page not refreshed successfully", STATUS.FAIL);
        }}

    @When("Navigating to view documents page and searched")
    public void navigatingToViewDocumentsPageAndSearched() throws InterruptedException {

        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);

        }catch (Exception e){
            GemTestReporter.addTestStep("User navigates to view document", "user not able to navigate to view document", STATUS.FAIL);

        }}
    @Then("Verify search is functional")
    public void searchIsFunctional() {
        try{
            DriverAction.typeText(KnowledgeBaseLocator.search,"xyz");
            String documentName = DriverAction.getElementText(KnowledgeBaseLocator.searchDocument);
            if(!documentName.equalsIgnoreCase("xyz")){
                GemTestReporter.addTestStep("User matches the document name", "Document name not matched", STATUS.FAIL);

                Assert.fail();
            }




        }catch (Exception e){
            GemTestReporter.addTestStep("User searches for a document", "User not able to search a document successfully", STATUS.FAIL);

        }}


    @When("Navigating to view documents page and searched document not present")
    public void navigatingToViewDocumentsPageAndSearchedDocumentNotPresent() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);

        }catch (Exception e){
            GemTestReporter.addTestStep("User navigates to view document", "user not able to navigate to view document", STATUS.FAIL);
        }}
    @Then("Verify search with {string} is functional and nothing is shown with {string}")
    public void searchIsFunctionalAndNothingIsShown(String search, String mssg) {
        try{
            DriverAction.typeText(KnowledgeBaseLocator.search,search);
            String mismatch = DriverAction.getElementText(KnowledgeBaseLocator.documentSearch);
            if(!mismatch.equalsIgnoreCase(mssg)){
                GemTestReporter.addTestStep("User should not get any matches ", "User finds the matching record", STATUS.FAIL);

                Assert.fail();
            }


        }catch (Exception e){
            GemTestReporter.addTestStep("User searches for an invalid document", "Search mismatch unsuccessful", STATUS.FAIL);
        }}

    @When("Navigating to view documents page and renaming the {string}")
    public void navigatingToViewDocumentsPageAndRenamingThe(String folderRename) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);
            DriverAction.rightClick(By.xpath("//a[text()='"+folderRename+"']"));






        }catch(Exception e){
            GemTestReporter.addTestStep("User renames the folder", "user not able to rename the folder", STATUS.FAIL);
        }}
    @Then("Verify folder name should be renamed")
    public void theFolderNameShouldBeRenamed() {
        try{
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.rename,"Clicked on rename folder");
            DriverAction.waitSec(5);

        }catch(Exception e){
            GemTestReporter.addTestStep("User renames the folder", "user not able to rename the folder", STATUS.FAIL);

        }}

    @When("Navigating to view documents page and selecting from dropdown")
    public void navigatingToViewDocumentsPageAndSelectingFromDropdown() throws InterruptedException {

        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);






        }catch(Exception e){
            GemTestReporter.addTestStep("User selects a document from dropdown", "user not able select from the dropdown and is not functional ", STATUS.FAIL);
        }}
    @Then("Verify dropdown is functional with {string}")
    public void dropdownIsFunctional(String val) throws InterruptedException {
        WebElement el = DriverAction.getElement(KnowledgeBaseLocator.dropdown);
        Select list = new Select(el);
        list.selectByValue(val);
        DriverAction.waitSec(5);
    }

    @When("Navigating to view document and {string} is selected")
    public void navigatingToViewDocumentAndIsSelected(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            presenceOfElement(KnowledgeBaseLocator.folder,20);
            DriverAction.waitSec(5);
            DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"));
            DriverAction.waitSec(5);



        }catch(Exception e){
            GemTestReporter.addTestStep("User right clicks to delete  the folder", "user not able to delete the folder", STATUS.FAIL);
        }}
    @Then("Verify folder is deleted")
    public void folderIsDeleted() {
        try{
            presenceOfElement(KnowledgeBaseLocator.delete,10);
            DriverAction.click(KnowledgeBaseLocator.delete,"Clicked on delete folder");

        }catch(Exception e){
            GemTestReporter.addTestStep("User right clicks to delete  the folder", "user not able to delete the folder", STATUS.FAIL);

        }}


    @When("Navigating to view document and {string} is selected and {string} is selected")
    public void navigatingToViewDocumentAndIsSelectedAndIsSelected(String fol1, String fol2) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);
            DriverAction.click(By.xpath("//a[text()='"+fol1+"']"));
            DriverAction.waitSec(5);
            DriverAction.rightClick(By.xpath("//a[text()='"+fol2+"']"));
            DriverAction.waitSec(5);
        }catch(Exception e){
            GemTestReporter.addTestStep("User deletes the subfolder in view document", "user not able to delete the subfolder in view document", STATUS.FAIL);

        }}
    @Then("Verify sub folder is deleted")
    public void subFolderIsDeleted() {
        try{
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.delete,"Successfully clicked on delete");

        }catch(Exception e){
            GemTestReporter.addTestStep("User right clicks to delete  the folder", "user not able to delete the folder", STATUS.FAIL);

        }}



    @When("Navigating to view document and title sort applied")
    public void navigatingToViewDocumentAndTitleSortApplied() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.titleSort,"title sort");
            DriverAction.waitSec(2);



        }catch(Exception e){
            GemTestReporter.addTestStep("User applies the title sort", "title sort applied in view document not successful", STATUS.FAIL);
        }}
    @Then("Verify list is sorted according to title")
    public void listIsSortedAccordingToTitle() {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.sortValue).equalsIgnoreCase("abxy")){
                GemTestReporter.addTestStep("User clicks on title sort", "Title sort not clicked successfully", STATUS.FAIL);

                Assert.fail();
            }
        }catch(Exception e){
            GemTestReporter.addTestStep("User applies the title sort", "title sort applied in view document not successful", STATUS.FAIL);

        }
    }

    @When("Navigating to view document and date sort applied")
    public void navigatingToViewDocumentAndDateSortApplied() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);


        }catch(Exception e){
            GemTestReporter.addTestStep("User applies the date sort", "date sort applied in view document not successful", STATUS.FAIL);

        }}
    @Then("Verify list is sorted according to date")
    public void listIsSortedAccordingToDate() {
        try{
            DriverAction.click(KnowledgeBaseLocator.titleSort,"Clicked on title sort");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.titleSort,"Clicked on title sort");
            DriverAction.waitSec(5);

        }catch(Exception e){
            GemTestReporter.addTestStep("User applies the date sort", "date sort applied in view document not successful", STATUS.FAIL);

        }
    }

    @When("Navigating to view document and adding folder")
    public void navigatingToViewDocumentAndAddingFolder() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);




        }catch(Exception e){
            GemTestReporter.addTestStep("User add the folder in view document", "adding the folder in view document not successful", STATUS.FAIL);

        }}
    @Then("Verify folder is added successfully")
    public void folderIsAddedSuccessfully() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.addFolder,"Clicked on add folder");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.saveFolder,"Clicked on save folder");
        }
        catch(Exception e){
            GemTestReporter.addTestStep("User add the folder in view document", "adding the folder in view document not successful", STATUS.FAIL);

        }

    }

    @When("Navigating to view document and adding subfolder to {string}")
    public void navigatingToViewDocumentAndAddingSubfolderTo(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);
            DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"));
            DriverAction.waitSec(5);




        }catch(Exception e){
            GemTestReporter.addTestStep("User add the sub folder in view document", "adding the sub folder in view document not successful", STATUS.FAIL);

        }}
    @Then("Verify sub folder is added successfully")
    public void subFolderIsAddedSuccessfully() {
        try{
            DriverAction.click(By.xpath("//*[@id=\"myMenu\"]/li[1]/a"),"Clicking on menu");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.saveFolder,"Saving sub folder");
        }catch(Exception e){
            GemTestReporter.addTestStep("User add the sub folder in view document", "adding the sub folder in view document not successful", STATUS.FAIL);

        }

    }

    @When("Navigating to view document and adding folder with duplicate name")
    public void navigatingToViewDocumentAndAddingFolderWithDuplicateName() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);



        }catch (Exception e){
            GemTestReporter.addTestStep("User add the folder with duplicate name in view document", "adding the folder with duplicate name in view document not successful", STATUS.FAIL);

        }}
    @Then("Verify warning is given for duplicate name")
    public void warningIsGivenForDuplicateName() {
        try{
            DriverAction.click(KnowledgeBaseLocator.addFolder,"Adding folder");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.saveFolder,"Saving folder");
        }
        catch(Exception e){
            GemTestReporter.addTestStep("User add the folder with duplicate name in view document", "adding the folder with duplicate name in view document not successful", STATUS.FAIL);


        }
    }

    @When("Navigating to view document and adding subfolder with duplicate name to {string}")
    public void navigatingToViewDocumentAndAddingSubfolderWithDuplicateNameTo(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);
            DriverAction.rightClick(By.xpath("//a[text()='"+string+"']"),"Right clicking the sub folder");

        }catch(Exception e){
            GemTestReporter.addTestStep("User add the subfolder folder with duplicate name in view document", "adding the subfolder with duplicate name in view document not successful", STATUS.FAIL);

        }}
    @Then("Verify warning is given for duplicate subfolder")
    public void warningIsGivenForDuplicateSubfolder() {
        try{
            DriverAction.waitSec(5);
            DriverAction.click(By.xpath("//*[@id=\"myMenu\"]/li[1]/a"),"Clicked successfully on menu");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.saveFolder,"Saving folder");
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User add the subfolder folder with duplicate name in view document", "adding the subfolder with duplicate name in view document not successful", STATUS.FAIL);

        }

    }

    @When("Navigating to view documents page and adding an valid document type")
    public void navigatingToViewDocumentsPageAndAddingAnValidDocumentType() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewDocuments,"View Documents");
            DriverAction.waitUntilElementAppear(KnowledgeBaseLocator.folder,5);
            DriverAction.waitSec(5);
            DriverAction.rightClick(KnowledgeBaseLocator.folder);
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.addDocument,"Adding Document");
            DriverAction.waitSec(5);




        }catch(Exception e){
            GemTestReporter.addTestStep("User adds a valid document in view document", "adding the valid document in view document not successful", STATUS.FAIL);

        }}
    @Then("Verify document is added successfully")
    public void documentIsAddedSuccessfully() throws InterruptedException {
        try{
            DriverAction.fileUpload(KnowledgeBaseLocator.upload,System.getProperty("user.dir")+"\\src\\main\\resources\\testdocument1.xlsx");
            DriverAction.waitSec(5);
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User adds a valid document in view document", "adding the valid document in view document not successful", STATUS.FAIL);

        }

    }

    @When("Navigating to view shared documents page and selecting from dropdown")
    public void navigatingToViewSharedDocumentsPageAndSelectingFromDropdown() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);

        }catch(Exception e){
            GemTestReporter.addTestStep("User selects from a dropdown in view shared document", "Selecting dropdown in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verify dropdown is functional in view shared with {string}")
    public void dropdownIsFunctionalInViewShared(String val1) {
        try{
            WebElement el1 = DriverAction.getElement(KnowledgeBaseLocator.dropdownSharedDocument);
            Select list = new Select(el1);
            list.selectByValue(val1);
            DriverAction.waitSec(5);
            if(!DriverAction.getElementText(KnowledgeBaseLocator.listInfo).contains(val1)){
                GemTestReporter.addTestStep("User clicks on dropdown in View Documents", "Dropdown in View Document is not clicked successfully", STATUS.FAIL);

                Assert.fail();

            }
        }catch(Exception e){
            GemTestReporter.addTestStep("User selects from a dropdown in view shared document", "Selecting dropdown in view shared document not successful", STATUS.FAIL);

        }}


    @When("Navigating to view shared documents page and searching a document")
    public void navigatingToViewSharedDocumentsPageAndSearchingADocument() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);


        }catch(Exception e){
            GemTestReporter.addTestStep("User searches for a document in view shared document", "Searching document in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verify search functionlity is working with {string}")
    public void searchFunctionlityIsWorking(String docName) {
        DriverAction.typeText(KnowledgeBaseLocator.search,docName);
        DriverAction.waitSec(2);
        String documentName = DriverAction.getElementText(KnowledgeBaseLocator.searchDocumentShared);
        if(!documentName.equalsIgnoreCase(docName)){
            GemTestReporter.addTestStep("User finds a document on View Shared Documents", "User not able to find the document successfully", STATUS.FAIL);

            Assert.fail();
        }

    }

    @When("Navigating to view shared documents page and searching an absent  {string}")
    public void navigatingToViewSharedDocumentsPageAndSearchingAnAbsent(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.typeText(KnowledgeBaseLocator.search,string);
            DriverAction.waitSec(2);


        }catch(Exception e){
            GemTestReporter.addTestStep("User makes an empty search in view shared document", "Empty search in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verify search functionlity is working by displaying no document")
    public void searchFunctionlityIsWorkingByDisplayingNoDocument() {
        try{
            String documentName = DriverAction.getElementText(KnowledgeBaseLocator.noMatchFound);
            if(!documentName.equalsIgnoreCase("No matching records found")){
                GemTestReporter.addTestStep("User verifies no document by searching in View Document", "View Document search verification not successful", STATUS.FAIL);

                Assert.fail();
            }
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User makes an empty search in view shared document", "Empty search in view shared document not successful", STATUS.FAIL);

        }
    }

    @When("Navigating to view shared documents page and applying ascending title sort")
    public void navigatingToViewSharedDocumentsPageAndApplyingAscendingTitleSort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.titleAsc,"Successfully applied title sort");


        }catch (Exception e){
            GemTestReporter.addTestStep("User applies title sort in view shared document", "Tile sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verify list is sorted ascendingly with {string}")
    public void listIsSortedAscendingly(String name) {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.titleAscEl).equalsIgnoreCase(name)){
                GemTestReporter.addTestStep("User clicks on ascending sort in View Documents", "Ascending sort in View Document is not clicked successfully", STATUS.FAIL);

                Assert.fail();

            }
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User applies title sort in view shared document", "Tile sort in view shared document not successful", STATUS.FAIL);

        }
    }

    @When("Navigating to view shared documents page and applying descending title sort")
    public void navigatingToViewSharedDocumentsPageAndApplyingDescendingTitleSort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.titleAsc,"Successfully applied title sort");
            DriverAction.waitSec(2);
            DriverAction.click(KnowledgeBaseLocator.titleAsc,"Successfully applied title sort");

        }catch(Exception e){
            GemTestReporter.addTestStep("User applies title sort in view shared document", "Tile sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verify list is sorted descendingly with {string}")
    public void listIsSortedDescendingly(String name) {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.titleAscEl).equalsIgnoreCase(name)){
                GemTestReporter.addTestStep("User clicks on descending sort in View Documents", "Descending sort in View Document is not clicked successfully", STATUS.FAIL);

                Assert.fail();

            }
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User applies title sort in view shared document", "Tile sort in view shared document not successful", STATUS.FAIL);

        }
    }

    @When("Navigating to view shared documents page and clicking on next button")
    public void navigatingToViewSharedDocumentsPageAndClickingOnNextButton() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.nextList,"Navigating to next list");



        }catch(Exception e){
            GemTestReporter.addTestStep("User clicks on next button in view shared document", "Clicking on next button in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verify next page of list is displayed with {string}")
    public void nextPageOfListIsDisplayed(String next) {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.listInfo).contains(next)){
                GemTestReporter.addTestStep("User clicks next page in View Shared Documents", "Next page in View Shared Document is not clicked successfully", STATUS.FAIL);

                Assert.fail();

            }
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User clicks on next button in view shared document", "Clicking on next button in view shared document not successful", STATUS.FAIL);

        }

    }

    @When("Navigating to view shared documents page and clicking on previous button")
    public void navigatingToViewSharedDocumentsPageAndClickingOnPreviousButton() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.nextList,"Navigating to next list");


        }catch (Exception e){
            GemTestReporter.addTestStep("User clicks on previous button in view shared document", "Clicking on previous button in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verify previous page of list is displayed with {string} after diplaying the next list with {string}")
    public void previousPageOfListIsDisplayed(String prev, String next) {
        try{
            if(DriverAction.getElementText(KnowledgeBaseLocator.listInfo).contains(next)){
                DriverAction.waitSec(2);
                DriverAction.click(KnowledgeBaseLocator.previousList,"Navigating to previous list");
                if(!DriverAction.getElementText(KnowledgeBaseLocator.listInfo).contains(prev)){
                    GemTestReporter.addTestStep("User verifies previous list in View Shared Documents", "Previous list verification in View Shared Document not successful", STATUS.FAIL);

                    Assert.fail();
                }


            }else{
                GemTestReporter.addTestStep("User clicks on previous list in View Shared Documents", "Click on previous list in View Shared Document is not clicked successfully", STATUS.FAIL);

                Assert.fail();
            }
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User clicks on previous button in view shared document", "Clicking on previous button in view shared document not successful", STATUS.FAIL);

        }

    }

    @When("Navigating to view shared documents page and viewing the {string}")
    public void navigatingToViewSharedDocumentsPageAndViewingThe(String string) throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.typeText(KnowledgeBaseLocator.search,string);
            DriverAction.waitSec(2);


        }catch(Exception e){
            GemTestReporter.addTestStep("User opens a document in view shared document", "Opening a document in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verify document is opened")
    public void documentIsOpened() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.viewDocument,"View Document");
            DriverAction.waitSec(5);
            if(!DriverAction.isExist(KnowledgeBaseLocator.verifyDocument)){
                GemTestReporter.addTestStep("User verifies docuement in View Shared Documents", "Document in View shared Document is not clicked successfully", STATUS.FAIL);

                Assert.fail();
            }

        }catch(Exception e){
            GemTestReporter.addTestStep("Document opens in view shared document", "Document opened in view shared document not successful", STATUS.FAIL);

        }}

    @When("Navigating to view shared documents page and applying ascending shared by sort")
    public void navigatingToViewSharedDocumentsPageAndApplyingAscendingSharedBySort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.sharedAsc,"Clicked successfully on shared filter");



        }catch(Exception e){
            GemTestReporter.addTestStep("User applies shared sort in view shared document", "Shared sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verifying list is sorted by shared ascendingly with {string}")
    public void listIsSortedBySharedAscendingly(String sharedName) {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.sharedAscEl).equalsIgnoreCase(sharedName)){
                GemTestReporter.addTestStep("User verifies ascending sort in View Shared Documents", "Ascending sort in View Shared Document not successful", STATUS.FAIL);

                Assert.fail();
            }
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User applies shared sort in view shared document", "Shared sort in view shared document not successful", STATUS.FAIL);

        }

    }

    @When("Navigating to view shared documents page and applying descending shared by sort")
    public void navigatingToViewSharedDocumentsPageAndApplyingDescendingSharedBySort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.sharedAsc,"Clicked successfully on shared filter");
            DriverAction.waitSec(2);
            DriverAction.click(KnowledgeBaseLocator.sharedAsc,"Clicked successfully on shared filter");

        }catch(Exception e){
            GemTestReporter.addTestStep("User applies shared sort in view shared document", "Shared sort in view shared document not successful", STATUS.FAIL);


        }}
    @Then("Verifying list is sorted by shared descendingly with {string}")
    public void listIsSortedBySharedDescendingly(String sharedName) {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.sharedAscEl).equalsIgnoreCase(sharedName)){
                GemTestReporter.addTestStep("User verifies descending sort in View Shared Documents", "Descending sort in View Shared Document not successful", STATUS.FAIL);

                Assert.fail();

            }
        }
        catch(Exception e){
            GemTestReporter.addTestStep("User applies shared sort in view shared document", "Shared sort in view shared document not successful", STATUS.FAIL);


        }
    }




    @When("Navigating to view shared documents page and applying ascending tag  sort")
    public void navigatingToViewSharedDocumentsPageAndApplyingAscendingTagSort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.tagAsc,"Clicked successfully on tag filter");



        }catch (Exception e){
            GemTestReporter.addTestStep("User applies tag sort in view shared document", "Tag sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verifying list is sorted by tag ascendingly with {string}")
    public void listIsSortedByTagAscendingly(String tag) {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.tagAscEl).equalsIgnoreCase(tag)){
                GemTestReporter.addTestStep("User verifies tag ascending sort in View Shared Documents", "Tag Ascending sort in View Shared Document not successful", STATUS.FAIL);

                Assert.fail();
            }

        }
        catch(Exception e){
            GemTestReporter.addTestStep("User applies tag sort in view shared document", "Tag sort in view shared document not successful", STATUS.FAIL);

        }

    }

    @When("Navigating to view shared documents page and applying descending tag  sort")
    public void navigatingToViewSharedDocumentsPageAndApplyingDescendingTagSort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.tagAsc,"Clicked successfully on tag filter");
            DriverAction.waitSec(2);
            DriverAction.click(KnowledgeBaseLocator.tagAsc,"Clicked successfully on tag filter");


        }catch(Exception e){
            GemTestReporter.addTestStep("User applies tag sort in view shared document", "Tag sort in view shared document not successful", STATUS.FAIL);

        }}
    @Then("Verifying list is sorted by tag descendingly with {string}")
    public void listIsSortedByTagDescendingly(String tag) {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.tagAscEl).equalsIgnoreCase(tag)){
                GemTestReporter.addTestStep("User verifies tag descending sort in View Shared Documents", "Tag descending sort in View Shared Document not successful", STATUS.FAIL);

                Assert.fail();

            }
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User applies tag sort in view shared document", "Tag sort in view shared document not successful", STATUS.FAIL);

        }
    }


    @When("Navigating to view shared documents page and applying ascending date sort")
    public void navigatingToViewSharedDocumentsPageAndApplyingAscendingDateSort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.dateAsc,"Clicked successfully on date filter");



        }catch(Exception e){
            GemTestReporter.addTestStep("User applies date sort in view shared document", "Date sort in view shared document not successful", STATUS.FAIL);

        }}

    @When("Navigating to view shared documents page and applying descending date sort")
    public void navigatingToViewSharedDocumentsPageAndApplyingDescendingDateSort() throws InterruptedException {
        try{
            DriverAction.click(KnowledgeBaseLocator.knowledgeBase,"Knowledge Base");
            DriverAction.click(KnowledgeBaseLocator.viewSharedDocument,"View Documents");
            DriverAction.waitSec(5);
            DriverAction.click(KnowledgeBaseLocator.dateAsc,"Clicked successfully on date filter");
            DriverAction.waitSec(2);
            DriverAction.click(KnowledgeBaseLocator.dateAsc,"Clicked successfully on date filter");


        }catch(Exception e){
            GemTestReporter.addTestStep("User applies date sort in view shared document", "Date sort in view shared document not successful", STATUS.FAIL);

        }}

    @Then("Verifying list is sorted by date descendingly with {string}")
    public void verifyingListIsSortedByDateDescendingly(String date) {
        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.dateAscEl).equalsIgnoreCase(date)){
                GemTestReporter.addTestStep("User verifies date descending sort in View Shared Documents", "Date descending sort in View Shared Document not successful", STATUS.FAIL);

                Assert.fail();

            }
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User applies date sort in view shared document", "Date sort in view shared document not successful", STATUS.FAIL);

        }
    }

    @Then("Verifying list is sorted by date ascendingly with {string}")
    public void verifyingListIsSortedByDateAscendingly(String date) {

        try{
            if(!DriverAction.getElementText(KnowledgeBaseLocator.dateAscEl).equalsIgnoreCase(date)){
                GemTestReporter.addTestStep("User verifies date ascending sort in View Shared Documents", "Date ascending sort in View Shared Document not successful", STATUS.FAIL);

                Assert.fail();
            }
        }
        catch (Exception e){
            GemTestReporter.addTestStep("User applies date sort in view shared document", "Date sort in view shared document not successful", STATUS.FAIL);

        }
    }
}
